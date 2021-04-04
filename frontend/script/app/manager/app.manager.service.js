angular
    .module("MusicManagerApp")
    .service("AppService", AppService);

function AppService($http) {

    var Api = {
        Url: "/authenticate/"
    }

    var service = {
        login: login,
    }

    function login(account) {
        return $http.post(Api.Url, account);
    }

    return service;
}