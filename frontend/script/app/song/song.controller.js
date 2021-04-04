angular
    .module('SongModule')
    .controller('SongController', SongController);

function SongController(SongService, $scope) {
    var vm = this;
    vm.songs;
    vm.songData = {
        songId: "",
        songTitle: "",
        songArtistName: "",
        songGenreName: "",
        songReleaseDate: new Date(),
        songPlayTime: 0
    }
    vm.dataMode = onDataMode("");
    vm.isCheckAll = false;
    vm.searchInput = "";
    vm.maxSize = 5;
    vm.totalItem = 0;
    vm.query = {
        offset: 1, //current page
        pageSize: 10, //item per page
        sortOrder: "asc", //sort order
        orderBy: "songPlayTime", // column order
        searchValue: "", // search input
        searchType: ""
    }

    vm.submitSong = submitSong;
    vm.clickTable = clickTable;
    vm.addNewSong = addNewSong;
    vm.changeSongStatus = changeSongStatus;
    vm.deleteSong = deleteSong;
    vm.checkAnyDelete = checkAnyDelete;
    vm.onDeleteAll = onDeleteAll;
    vm.checkValidSongList = checkValidSongList;
    vm.searchSongs = searchSongs;
    vm.orderSongs = orderSongs;

    $scope.$watch('vm.query.offset', function() {
        vm.songs = [];
        getSongs();
    })

    function orderSongs(tableName) {
        if (!changeQueryOrderBy(tableName)) {
            if (vm.query.sortOrder == "asc")
                vm.query.sortOrder = "desc";
            else if (vm.query.sortOrder == "desc")
                vm.query.sortOrder = "asc";
        } else {
            vm.query.sortOrder = "desc";
        }
        getSongs();
    }

    function searchSongs() {
        vm.query.searchValue = vm.searchInput;
        getSongs();
    }

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
        SongService.success(vm.dataMode == onDataMode("insert") ? "Create Success" : "Update Success");
        getSongs();
    }

    function error() {
        SongService.error(vm.dataMode == onDataMode("insert") ? "Create Failed" : "Success Failed");
    }

    function getSongs() {
        SongService.getSongs(vm.query).then(
            function(res) {
                vm.songs = SongService.parseData(res);
                var totalItem = res.data.data.size;
                if (vm.totalItem !== totalItem) {
                    vm.totalItem = totalItem;
                    vm.query.offset = 1;
                }
            },
            function(res) {
                console.log("Cannot get songs")
            }
        )
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

    function changeQueryOrderBy(tableName) {
        var currentOrderBy = vm.query.orderBy;
        switch (tableName) {
            case "Playtime":
                vm.query.orderBy = "songPlayTime";
                break;
            case "Release Date":
                vm.query.orderBy = "songReleaseDate";
                break;
            case "Song Title":
                vm.query.orderBy = "songTitle";
                break;
        }
        if (currentOrderBy !== vm.query.orderBy)
            return true;
        return false;
    }

    $('#submitSongModalForm').click(function() {
        $('#ModalSong').modal('hide');
    });

    $("#checkBoxDeleteAll").click(function() {
        $(".checkBoxDeleteData").prop('checked', $(this).prop('checked'));
    });
}