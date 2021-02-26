angular
    .module("AlbumModule")
    .directive("albumListDirective", AlbumListDirective);

function AlbumListDirective() {
    var directive = {
        templateUrl: "./app/album/directive/album-list.template.html"
    };
    return directive;
}