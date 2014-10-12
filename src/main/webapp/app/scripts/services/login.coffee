define [
    "jquery"
    "core/hostMapping"
], ( $, hostMapping ) ->

    class Login

        call: ( params ) ->

            $.ajax(
                url:            hostMapping.getHostName( "spring" ) + "/j_spring_security_check?j_username=" + params.email + "&j_password=" + params.password
                method:         "POST"
            )