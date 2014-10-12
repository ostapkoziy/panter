define [
    "jquery"
    "underscore"
    "backbone"
    "core/lang"
    "templates"
    "core/utils"
    "../collections/cities"
], ( $, _, Backbone, Lang, JST, utils, CityCollection ) ->
    class CreateProfile extends Backbone.View
        className: "profile-view edit-profile-view"
        template: JST[ "app/scripts/modules/profile/views/templates/create.hbs" ]
        countryTpl: JST[ "app/scripts/modules/profile/views/templates/country-item.hbs" ]
        cityTpl: JST[ "app/scripts/modules/profile/views/templates/city-item.hbs" ]

        events:
            "submit #edit-user": "saveProfile"
            "click .upload-avatar": "uploadImage"

        initialize: ( params )->
            @model = params.model
            @countries = params.countries

            @locale = Lang.getLocale()

            @listenTo( @countries, "sync", @renderCountries )

            # Bind backbone.validation to our view
            #
            Backbone.Validation.bind( this )

        render: ->
            @$el.html( @template() )

            return this

        renderCountries: ->
            _.each( @countries.models, ( model ) =>
                model.set( "name", @locale[ "country." + model.get( "key" ) ] )
                @$( "select#country" ).append( @countryTpl( model.toJSON() ) )
            )
            @fetchCities()

        fetchCities: ->
            @cities = new CityCollection( countryId: @$( "select#country" ).val() )
            @listenTo( @cities, "sync", @renderCities )
            @cities.fetch()

        renderCities: ->
            _.each( @cities.models, ( model ) =>
                model.set( "name", @locale[ "city." + model.get( "key" ) ] )
                @$( "select#city" ).append( @cityTpl( model.toJSON() ) )
            )

        saveProfile: ( e ) ->
            e.preventDefault()

            @model.set( $( e.target ).trimInputs().serializeObject() )

            # Save this to backend
            #
            if @model.isValid( true )
                @model.save().then(
                    ( data ) =>
                        Backbone.history.navigate( "#profile", trigger: true )
                        utils.alert( @locale[ "message.profile.was.created" ] )

                ,   ( error ) =>
                        errorStatus = $.parseJSON( error.responseText ).message
                        utils.alert( errorStatus, "warning" )

                ).done()