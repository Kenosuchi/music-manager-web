angular
    .module("ListenerModule")
    .directive("playlistSongDirective", PlaylistSongDirective);

function PlaylistSongDirective() {
    var directive = {
        templateUrl: "./app/listener/directive/playlist-song.template.html"
    }

    return directive;
}