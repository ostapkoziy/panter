define [
    "core/presenter"
    "core/logged-user"
    "./collections/countries"
    "./models/profile"
    "./views/profile"
    "./views/edit"
    "./views/create"
], ( Presenter, AccountModel, CountryCollection, ProfileModel, ProfileView, EditProfileView, CreateProfileView ) ->
    # This is main module file, it should bring together views and models, and expose API for using
    #
    class ProfileModule

        show: ( $container ) ->
            profile =  new ProfileModel()

            Presenter.show( $container, new ProfileView( model: profile ).el )

            profile.fetch()

        create: ( $container ) ->
            profile = new ProfileModel()
            countries = new CountryCollection()

            Presenter.show( $container, new CreateProfileView( model: profile, countries: countries ).render().el )

            countries.fetch()

        edit: ( $container ) ->
            profile =  new ProfileModel()

            Presenter.show( $container, new EditProfileView( model: profile ).el )

            profile.fetch()

        preflight: () ->
            profile = new ProfileModel()

            @isExisitingProfile = false

            return profile.fetch()

