define [
    "backbone"
    "core/hostMapping"
], ( Backbone, hostMapping ) ->
    "use strict";

    class Profile extends Backbone.Model
        urlRoot: hostMapping.getHostName( "api" ) + "/user/profile"

        validation:
            firstName:
                required: true
                minLength: 3
                maxLength: 255
            lastName:
                required: true
                minLength: 3
                maxLength: 255
            # email:
            #     required: true
            #     maxLength: 128
            #     pattern: "email"
            phoneNumber:
                required: true
                maxLength:20
                minLength: 10
