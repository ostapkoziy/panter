define [
    "backbone"
    "core/hostMapping"
], ( Backbone, hostMapping ) ->
    "use strict";

    class Cities extends Backbone.Collection
        initialize: ( options = {} ) ->
            @countryId = options.countryId

        url: ->
            hostMapping.getHostName( "api" ) + "/countries/" +  @countryId + "/cities"