angular
    .module("ListenerModule")
    .directive("listenerGeneralDirective", ListenerGeneralDirective);

function ListenerGeneralDirective() {
    var directive = {
        templateUrl: "./app/listener/directive/listener-general.template.html"
    }

    return directive;
}