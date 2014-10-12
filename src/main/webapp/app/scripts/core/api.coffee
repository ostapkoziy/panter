define [
    "jquery"
    "backbone"
    "services/login"
    "services/logout"
    "services/activation"
    "services/locale"
    "services/language"
], ( $, Backbone, Login, Logout, Activate, Locale, Language ) ->

    # Service mapping
    #
    serviceMapping =

        # Generic services
        #
        "login":    Login
        "logout":   Logout
        "activate": Activate
        "locale": Locale
        "language": Language

    # Will containt service instances once they are created
    #
    services = {}

    # Create and return the api object
    #
    {
        call: ( serviceName, params ) ->

            # Check if we know this service using the service mapping
            #
            if( serviceMapping[ serviceName ] )

                # If service object is not instantiated yet do so
                #
                if services[ serviceName ] is undefined
                    services[ serviceName ] = new serviceMapping[ serviceName ]()

                console.log( "[InterestinAPI] Calling service", serviceName, params )

                return services[ serviceName ].call( params );

            else
                console.warn( "[InterestinAPI] Unknown service called", serviceName, params )

                deferred = $.promise()

                deferred.reject(
                    request:    null
                    response:   "Not found"
                    status:     404
                    statusText: "Not found"
                );

                return deferred.promise;
    }