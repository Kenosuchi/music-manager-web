angular
    .module('ArtistModule')
    .controller('ArtistController', ArtistController);

function ArtistController(ArtistService) {
    var vm = this;
    vm.artists = getArtists();
    vm.songs = [];
    vm.show = {
        artist: true,
        song: false
    }

    vm.showSong = showSong;
    vm.showArtist = showArtist;
    vm.getSongs = getSongs;

    function getSongs(artistIndex) {
        vm.songs = vm.artists[artistIndex].data.artistSongs;
        showSong();
    }

    function showSong() {
        vm.show = {
            artist: false,
            song: true
        }
    }

    function showArtist() {
        vm.show = {
            artist: true,
            song: false
        }
    }

    function getArtists() {
        ArtistService.getArtists().then(
            _success, _error
        );
    }

    function _success(res) {
        console.log("get artist Success");
        vm.artists = ArtistService.parseData(res);
        showArtist();
    }

    function _error(res) {
        console.log("Cannot get artists");
    }
}