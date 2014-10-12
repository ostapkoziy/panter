define [
    "core/lang"
    "core/logged-user"
    "./views/login"
    "./views/register"
    "core/api"
    "core/utils"
], ( Lang, UserModel, LoginView, RegisterView, api, utils ) ->
    class LoginModule

        showLoginForm: ( $container ) ->
            $container.html( new LoginView().render().el )

        showRegisterForm: ( $container ) ->
            $container.html( new RegisterView( model: UserModel ).render().el )

        activation: ( key ) ->
            locale = Lang.getLocale()

            api.call( "activate", key ).then(
                    ( data ) =>
                        Backbone.history.navigate( "login", trigger: true )
                        utils.alert( locale[ "message.account.activated" ] )
                    ( error ) ->
                        utils.alert( locale[ "message.activation.key.invalid" ] , "warning" )
                ).done()