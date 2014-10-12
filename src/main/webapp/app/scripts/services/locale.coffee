define [
    "jquery"
    "core/hostMapping"
], ( $, hostMapping ) ->

    class Locale

        call: ( params ) ->

            $.ajax(
                url:            hostMapping.getHostName( "api" ) + "/messages"
                method:         "GET"
            )