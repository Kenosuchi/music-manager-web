angular
    .module('MusicManagerApp')
    .config(config);

function config($routeProvider) {
    $routeProvider
        .when('/song', {
            templateUrl: 'app/song/song.template.html',
            controller: 'SongController',
            controllerAs: 'vm'
        })
        .when('/listener', {
            templateUrl: 'app/listener/listener.template.html',
            controller: 'ListenerController',
            controllerAs: 'vm'
        })
        .when('/artist', {
            templateUrl: 'app/artist/artist.template.html',
            controller: 'ArtistController',
            controllerAs: 'vm'
        })
        .when('/album', {
            templateUrl: 'app/album/album.template.html',
            controller: 'AlbumController',
            controllerAs: 'vm'
        })
        .when('/album-detail', {
            templateUrl: 'app/album/album-detail.template.html',
            controller: 'AlbumController',
            controllerAs: 'vm'
        })
        .otherwise({
            templateUrl: 'app/default/default.html',
        });
}