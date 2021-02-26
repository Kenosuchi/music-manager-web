angular
    .module('ArtistModule')
    .service('ArtistService', ArtistService);

function ArtistService($http) {
    var API = {
        Url: '/artists/',
        UrlSong: '/songs/'
    };
    var service = {
        getArtists: getArtists,
        getSongs: getSongs,
        parseData: parseData,
    }

    //==========Internal function==============
    function parseData(res) {
        var result = [];
        for (data of res.data.data) {
            result.push({
                data: data
            })
        };
        return result;
    }

    function getSongs(artistId) {
        return $http.get(API.UrlSong + "artist/" + artistId)
    }

    function getArtists() {
        return $http.get(API.Url);
    }

    return service;
}