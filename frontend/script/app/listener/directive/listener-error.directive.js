angular
    .module("ListenerModule")
    .directive("listenerErrorDirective", ListenerErrorDirective);

function ListenerErrorDirective() {
    var directive = {
        templateUrl: "./app/listener/directive/listener-error.template.html"
    }

    return directive;
}