define [
    "backbone.controller"
    "./view"
    "Mem"
    "modules/profile"
], ( Controller, View, Mem, ProfileModule ) ->
    class ProfileScreenController extends Controller
        routes:
            "profile": "profile"
            "profile/edit": "edit"

        onBeforeRoute: ->
            @profileModule = Mem.set( "profileModule", ProfileModule )

            Mem.manage()

            return if @container

            @container = new View().render()

        profile: ->
            @profileModule.preflight().then(
                ( data ) =>
                    @profileModule.show( @container.getContainer() )
                ( error ) =>
                    @profileModule.create( @container.getContainer() )
            )

        edit: ->
            @profileModule.edit( @container.getContainer() )

        remove: ->
            @container = null