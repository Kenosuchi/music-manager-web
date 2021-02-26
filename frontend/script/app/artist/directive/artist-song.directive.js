angular
    .module("ArtistModule")
    .directive("artistSongDirective", ArtistSongDirective);

function ArtistSongDirective() {

    var directive = {
        templateUrl: "./app/artist/directive/artist-song.template.html"
    }
    return directive;
}