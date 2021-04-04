angular
    .module('ListenerModule')
    .factory('ListenerInterceptor', ListenerInterceptor);

function ListenerInterceptor() {
    var service = this;

    service.request = request;

    function request(config) {
        // var token = localStorage.getItem("bearer");
        var token = sessionStorage.getItem("bearer");
        if (token != null) {
            config.headers['Authorization'] = 'Bearer ' + token;
        }
        return config;
    }

    return service;
}