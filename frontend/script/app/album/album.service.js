angular
    .module("AlbumModule")
    .service("AlbumService", AlbumService);

function AlbumService($http) {
    var API = {
        Url: '/albums/'
    }

    var service = {
        //service declaration
        getAlbums: getAlbums,
        getAlbumSongsById: getAlbumSongsById,
        parseData: parseData,
        parseDataWithId: parseDataWithId
    };

    //internal function
    function getAlbumSongsById(albumId) {
        return $http.get(API.Url + "song-detail/" + albumId);
    }

    function parseDataWithId(res) {
        var result = res.data.data
        return result;
    }

    function parseData(res) {
        var result = [];
        for (data of res.data.data) {
            result.push({
                data: data
            })
        };
        return result;
    }

    function getAlbums() {
        return $http.get(API.Url);
    }
    return service;
}