(function() {
    'use strict';

    angular
        .module('MusicManagerApp', [
            "ngRoute",
            "SongModule",
            "PlaylistModule",
            "ArtistModule"
        ]);
})();