angular
    .module('ListenerModule')
    .factory('ListenerService', ListenerService)

function ListenerService($http) {
    var API = {
        ListenerUrl: "/listeners/",
        PlaylistUrl: "/playlists/"
    }
    var service = {
        getListeners: getListeners,
        getPlaylists: getPlaylists,
        getSongs: getSongs,
        parseData: parseData
    }

    function getSongs(playlistId) {
        return $http.get(API.PlaylistUrl + playlistId + "/songs");
    }

    function getPlaylists(listenerId) {

        return $http.get(API.PlaylistUrl + "listener/" + listenerId);
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

    function getListeners() {
        return $http.get(API.ListenerUrl);
    }
    return service;
}