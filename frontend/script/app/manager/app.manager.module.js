(function() {
    'use strict';

    angular
        .module('MusicManagerApp', [
            "ngRoute",
            "ngCookies",
            "SongModule",
            "ArtistModule",
            "AlbumModule",
            "ListenerModule",
            "PaginationModule",
        ]);
})();