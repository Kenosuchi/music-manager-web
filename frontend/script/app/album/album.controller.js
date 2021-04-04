angular
    .module('AlbumModule')
    .controller('AlbumController', AlbumController);

function AlbumController(AlbumService) {
    var vm = this;
    vm.albums = getAlbums();
    vm.selectedAlbumSongs = [];
    vm.showSongs = false;

    vm.showAlbumSongs = showAlbumSongs;
    vm.backToAlbumList = backToAlbumList;


    function backToAlbumList() {
        vm.showSongs = false;
    }

    function showAlbumSongs(albumId) {
        AlbumService.getAlbumSongsById(albumId).then(
            function(res) {
                console.log("Get Album " + albumId + " Success");
                vm.selectedAlbumSongs = AlbumService.parseData(res);
                vm.showSongs = true;
            }, error
        )
    }

    function getAlbums() {
        AlbumService.getAlbums().then(
            success, error
        )
    }

    function success(res) {
        console.log("Get Album Success");
        vm.albums = AlbumService.parseData(res);
    }

    function error() {
        console.log("error: cannot get album");
    }
}