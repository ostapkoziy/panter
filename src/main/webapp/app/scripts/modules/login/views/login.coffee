define [
    "jquery"
    "underscore"
    "backbone"
    "core/lang"
    "templates"
    "core/api"
    "core/utils"
    "core/logged-user"
], ( $, _, Backbone, Lang, JST, api, utils, LoggedUser ) ->
    class Login extends Backbone.View
        template: JST[ "app/scripts/modules/login/views/templates/login.hbs" ]

        initialize: ->
            @model = LoggedUser
            @locale = Lang.getLocale()

            # Bind backbone.validation to our view
            #
            Backbone.Validation.bind(@)

        events: ->
            "submit #login": "login"


        render: ->
            @$el.html( @template() )

            return this

        login: ( e ) ->
            e.preventDefault()

            data =
                email:      @$el.find( "[name=email]"    ).val()
                password:   @$el.find( "[name=password]" ).val()

            @model.set( data )

            if @model.isValid( [ "email", "password" ] )
                @$( ".loader" ).show()

                api.call( "login", data ).then(
                    ( data ) =>
                        @model.set( data )
                        Backbone.history.navigate( "profile", trigger: true )
                    ( error ) ->
                        utils.alert( @locale[ "message.username.or.password.incorrect" ], "warning" )
                ).always( =>
                    @$( ".loader" ).hide()
                ).done()


