define [
    "backbone"
    "core/hostMapping"
], ( Backbone, hostMapping ) ->
    "use strict";

    class Countries extends Backbone.Collection
        url: hostMapping.getHostName( "api" ) + "/countries"
