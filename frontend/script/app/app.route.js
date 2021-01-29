angular
    .module('MusicManagerApp')
    .config(config);

function config($routeProvider) {
    $routeProvider.
    when('/song', {
        templateUrl: 'app/song/song.template.html',
        controller: 'SongController',
        controllerAs: 'vm'
    }).
    when('/playlist', {
        templateUrl: 'app/playlist/playlist.template.html',
        controller: 'PlaylistController',
        controllerAs: 'vm'
    }).
    when('/artist', {
        templateUrl: 'app/artist/artist.template.html',
        controller: 'ArtistController',
        controllerAs: 'vm'
    }).
    otherwise({
        templateUrl: 'app/app.template.html',
        controller: 'AppController',
        controllerAs: 'vm'
    });
}