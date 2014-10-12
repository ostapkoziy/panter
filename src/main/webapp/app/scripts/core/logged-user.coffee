define [
    "underscore"
    "backbone"
    "core/hostMapping"
], ( _, Backbone, hostMapping ) ->
    'use strict';

    class LoggedUser extends Backbone.Model
        urlRoot: hostMapping.getHostName( "api" ) + "/users"

        validation:
            email:
                required: true
                minLength: 6
                maxLength: 255
            password:
                required: true
                minLength: 6
                maxLength: 255
            confirm_password:
                equalTo: "password"

        _loggedIn: false

        isLogged: -> @_loggedIn


    # Singleton model
    #
    user = new LoggedUser()

    user.on( "change:email", ( model, value, options ) ->
        if value is "" or value is undefined
            user._loggedIn = false
        else
            user._loggedIn = true
    )
