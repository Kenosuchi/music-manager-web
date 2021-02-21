angular
    .module('SongModule')
    .factory('SongService', SongService);

function SongService($http) {

    var API = {
        urls: '/songs/',
    }
    var service = {
        getSongs: getSongs,
        getSongsByTitle: getSongsByTitle,
        parseData: parseData,
        addSong: addSong,
        updateSong: updateSong,
        deleteSong: deleteSong,
        deleteMultipleSong: deleteMultipleSong,
        orderSongs: orderSongs,
        success: success,
        error: error
    }

    // ====================== INTERBAL==================

    function orderSongs(currentOrder){
        return $http.get(API.urls+"order/"+currentOrder);
    }

    function getSongsByTitle(title) {
        return $http.get(API.urls + "title/" + title);
    }

    function deleteMultipleSong(idArr) {
        return $http.put(API.urls + "delete-multiple", idArr);
    }

    function deleteSong(song) {
        return $http.delete(API.urls + song.data.songId.toString());
    }

    function updateSong(data) {
        return $http.put(API.urls, data);
    }

    function getSongs() {
        return $http.get(API.urls);
    }

    function parseData(res) {
        var result = [];
        for (data of res.data.data) {
            result.push({
                status: "GET",
                data: data
            })
        };
        return result
    }

    function addSong(data) {
        return $http.post(API.urls, data);
    }

    function success(msg) {
        console.log(msg);
    }

    function error(msg) {
        console.log(msg);
    }

    return service;

}