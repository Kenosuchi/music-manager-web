angular
    .module("ListenerModule")
    .controller("ListenerController", ListenerController);

function ListenerController(ListenerService) {
    var vm = this;
    vm.listeners = getListeners();
    vm.playlists = [];
    vm.songs = [];
    vm.token = "";
    vm.isAuthenticate = true;

    vm.show = {
        listener: true,
        playlist: false,
        song: false
    };

    vm.showPlaylist = showPlaylist;
    vm.showSongs = showSongs;
    vm.backToListener = backToListener;
    vm.backToPlayList = backToPlayList;

    function backToListener() {
        vm.show = {
            listener: true,
            playlist: false,
            song: false
        };
    }

    function backToPlayList() {
        vm.show = {
            listener: false,
            playlist: true,
            song: false
        };
    }

    function getListeners() {
        ListenerService.getListeners().then(
            success, error
        )
    }

    function showSongs(playlistId) {
        ListenerService.getSongs(playlistId).then(
            function(res) {
                console.log("get song success");
                vm.songs = ListenerService.parseData(res);
                vm.show = {
                    listener: false,
                    playlist: false,
                    song: true
                };
            },
            function(res) {
                console.log("Error: cannot get playlist");
            }
        )
    }

    function showPlaylist(listenerId) {
        ListenerService.getPlaylists(listenerId).then(
            function(res) {
                console.log("get playlist success");
                vm.playlists = ListenerService.parseData(res);
                vm.show = {
                    listener: false,
                    playlist: true,
                    song: false
                };
            },
            function(res) {
                console.log("Error: cannot get playlist");
            }
        )
    }

    function success(res) {
        if (res.data.status != "SUCCESS") {
            console.log("Cannot get data");
            return;
        }
        console.log("get listener success");
        vm.isAuthenticate = true;
        vm.listeners = ListenerService.parseData(res);
        vm.show = {
            listener: true,
            playlist: false,
            song: false
        };
    }

    function error(res) {
        if (res.status === 403 || res.status === 401)
            vm.isAuthenticate = false;
        else
            console.log("Error: cannot get listener");
    }
}