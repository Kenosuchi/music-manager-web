angular
    .module('ArtistModule')
    .controller('ArtistController', ArtistController);

function ArtistController(ArtistService) {
    vm = this;
    vm.artists = getArtists();
    vm.songs = [];
    vm.show = {
        artist: true,
        song: false
    }

    vm.showSong = showSong;
    vm.showArtist = showArtist;
    vm.getSongs = getSongs;

    function getSongs(artistId) {
        ArtistService.getSongs(artistId).then(
            function(res) {
                console.log("get artist song Success");
                showSong();
                vm.songs = ArtistService.parseData(res);
            },
            function(res) {
                console.log("Cannot get artist songs");
            }
        )
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