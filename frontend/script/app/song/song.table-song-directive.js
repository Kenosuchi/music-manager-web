angular
    .module('SongModule')
    .directive('tableSongDirective', tableSongDirective);

function tableSongDirective() {
    var directive = {
        templateUrl: "./app/song/song.data-table.html"
    };
    return directive;
}