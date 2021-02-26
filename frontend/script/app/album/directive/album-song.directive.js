angular
    .module("AlbumModule")
    .directive("albumSongDirective", AlbumSongDirective);

function AlbumSongDirective() {
    var directive = {
        templateUrl: "./app/album/directive/album-song.template.html"
    };
    return directive;
}