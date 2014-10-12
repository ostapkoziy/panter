define [
    "jquery"
    "core/hostMapping"
], ( $, hostMapping ) ->

    class Language

        call: ( params ) ->

            $.ajax(
                url:            hostMapping.getHostName( "api" ) + "/messages/locale"
                method:         "GET"
            )