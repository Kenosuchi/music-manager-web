angular
    .module("ArtistModule")
    .directive("artistGeneralDirective", ArtistGeneralDirective);

function ArtistGeneralDirective() {

    var directive = {
        templateUrl: "./app/artist/directive/artist-general.template.html"
    }
    return directive;
}