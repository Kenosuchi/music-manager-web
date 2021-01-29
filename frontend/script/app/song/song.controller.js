angular
    .module('SongModule')
    .controller('SongController', SongController);

function SongController(SongService) {
    vm = this;
    vm.songs = getSongs();
    vm.songData = defaultSongDataValues();
    vm.dataMode = onDataMode("");
    vm.isCheckAll = false;

    vm.submitSong = submitSong;
    vm.clickTable = clickTable;
    vm.addNewSong = addNewSong;
    vm.changeSongStatus = changeSongStatus;
    vm.deleteSong = deleteSong;
    vm.checkAnyDelete = checkAnyDelete;
    vm.onDeleteAll = onDeleteAll;
    vm.checkValidSongList = checkValidSongList;

    function checkValidSongList() {
        return vm.songs === undefined || vm.songs.length == 0
    }

    function onDeleteAll() {
        if (vm.songs !== undefined) {
            for (song of vm.songs) {
                if (vm.isCheckAll) {
                    song.status = "GET";
                } else
                    song.status = "DELETE";
            }
        }
    }

    function checkAnyDelete() {
        if (vm.songs !== undefined) {
            for (song of vm.songs) {
                if (song.status == "DELETE") {
                    return false;
                }
            }
        }
        return true;
    }

    function deleteSong() {
        var idArr = [];
        for (song of vm.songs) {
            if (song.status == "DELETE") {
                idArr.push(song.data.songId);

            }
        }
        SongService.deleteMultipleSong(idArr).then(
            function(res) {
                vm.isCheckAll = false;
                SongService.success("Delete Success");
                getSongs();
            },
            function(res) {
                SongService.success("Delete Fail");
            }
        )
    }

    function changeSongStatus(song) {
        if (song.status != "DELETE")
            song.status = "DELETE";
        else
            song.status = "GET";
    }

    function addNewSong() {
        vm.songData = defaultSongDataValues();
        vm.dataMode = onDataMode("insert");
    }

    function clickTable(song) {
        vm.songData = {...song.data };
        vm.songData.songReleaseDate = new Date(vm.songData.songReleaseDate.toString())
        vm.dataMode = onDataMode("update");
    }

    function submitSong() {
        if (vm.dataMode == onDataMode("insert")) {
            SongService.addSong(vm.songData).then(
                success, error
            )
        } else if (vm.dataMode == onDataMode("update")) {
            SongService.updateSong(vm.songData).then(
                success, error
            )
        }
    }

    function success() {
        SongService.success(vm.dataMode == "insert" ? "Create Success" : "Update Success");
        getSongs();
    }

    function error() {
        SongService.error(vm.dataMode == "insert" ? "Create Success" : "Update Success");
    }

    function getSongs() {
        SongService.getSongs().then(
            function(res) {
                vm.songs = SongService.parseData(res);
            },
            function(res) {
                console.log("Cannot get songs")
            }
        )
    }

    function defaultSongDataValues() {
        return {
            songId: "",
            songTitle: "",
            songArtistName: "",
            songGenreName: "",
            songReleaseDate: new Date(),
            songPlayTime: 0
        }
    }

    function onDataMode(method) {
        switch (method) {
            case "insert":
                return 1;
            case "update":
                return 2;
            default:
                return 0;
        }
    }

    $('#submitSongModalForm').click(function() {
        $('#ModalSong').modal('hide');
    });

    $("#checkBoxDeleteAll").click(function() {
        $(".checkBoxDeleteData").prop('checked', $(this).prop('checked'));
    });
}