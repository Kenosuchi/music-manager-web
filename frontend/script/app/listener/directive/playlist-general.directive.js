angular
    .module("ListenerModule")
    .directive("playlistGeneralDirective", PlaylistGeneralDirective);

function PlaylistGeneralDirective() {
    var directive = {
        templateUrl: "./app/listener/directive/playlist-general.template.html"
    }

    return directive;
}