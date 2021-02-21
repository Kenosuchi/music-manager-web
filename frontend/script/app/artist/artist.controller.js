angular
    .module('ArtistModule')
    .controller('ArtistController', ArtistController);

function ArtistController(ArtistService) {
    vm = this;
    vm.artists = getArtists();

    function getArtists() {
        ArtistService.getArtists().then(
            _success,_error
        );
    }

    function _success(res) {
        vm.artists = ArtistService.parseData(res);
        console.log(vm.artists);
    }
    function _error(res) {
        console.log("Cannot get artists");
    }
}