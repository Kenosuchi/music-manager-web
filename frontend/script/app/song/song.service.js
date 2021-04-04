angular
    .module('SongModule')
    .factory('SongService', SongService);

function SongService($http) {

    var API = {
        urls: '/songs/',
    }
    var service = {
        getSongs: getSongs,
        parseData: parseData,
        addSong: addSong,
        updateSong: updateSong,
        deleteSong: deleteSong,
        deleteMultipleSong: deleteMultipleSong,
        success: success,
        error: error
    }

    // ====================== INTERBAL==================

    function deleteMultipleSong(idArr) {
        return $http.put(API.urls + "delete-multiple", idArr);
    }

    function deleteSong(song) {
        return $http.delete(API.urls + song.data.songId.toString());
    }

    function updateSong(data) {
        return $http.put(API.urls + "update/", data);
    }

    function getSongs(query) {
        return $http.put(API.urls, query);
    }

    function parseData(res) {
        var result = [];
        for (data of res.data.data.dtos) {
            result.push({
                status: "GET",
                data: data,
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