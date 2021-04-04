angular
    .module("ListenerModule")
    .config(ListenerConfig);

function ListenerConfig($httpProvider) {
    $httpProvider.interceptors.push('ListenerInterceptor');
}