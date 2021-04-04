angular
    .module('MusicUserApp')
    .config(config);

function config($routeProvider) {
    $routeProvider
        .when('/explore', {
            templateUrl: 'app/explore/explore.template.html',
            controller: 'ExploreController',
            controllerAs: 'vm'
        }).otherwise({
            templateUrl: 'app/explore/explore.template.html',
            controller: 'ExploreController',
            controllerAs: 'vm'
        })
}