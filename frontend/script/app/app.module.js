(function() {
    'use strict';

    angular
        .module('MusicManagerApp', [
            "ngRoute",
            "SongModule",
            "ArtistModule",
            "AlbumModule",
            "ListenerModule",
        ]);
})();