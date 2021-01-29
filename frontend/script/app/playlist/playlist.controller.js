angular
    .module('PlaylistModule')
    .controller('PlaylistController', PlaylistController);

function PlaylistController() {
    vm = this;
    vm.playlists = [{
        song: [{
                name: 'aaa',
                playtime: 120
            },
            {
                name: 'bbb',
                playtime: 120
            }
        ]
    }, {
        song: [{
                name: 'ccc',
                playtime: 120
            },
            {
                name: 'ddd',
                playtime: 120
            }
        ]
    }]


}