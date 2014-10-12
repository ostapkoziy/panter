define [
    "jquery"
    "backbone"
    "./settings"
], ( $, Backbone, Storage ) ->

    manager =
        getLocale: ->
            langKey = window.localStorage.getItem( "langKey" )
            return JSON.parse( window.localStorage.getItem( langKey ) )
