angular
    .module('ArtistModule')
    .controller('ArtistController', ArtistController)

function ArtistController($http) {
    var vm = this;
    vm.artists = [];
    getArtists();

    function getArtists() {
        $http.get('/artists').then(
            function(res) {
                vm.artists = res.data.data;
                console.log(vm.artists);
            },
            function(res) {
                console.log("Cannot get artists")
            }
        )
    }
}