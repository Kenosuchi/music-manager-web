angular
    .module("PaginationModule")
    .directive('pagination', PaginationDirective);

function PaginationDirective() {
    return {
        restrict: 'E',
        templateUrl: './app/pagination/pagination.template.html',
        controller: 'PaginationController',
        controllerAs: 'vm',
        require: "ngModel",
        link: function(scope, element, attrs, ngModel) {
            element.on("click", function() {
                ngModel.$setViewValue(scope.vm.currentPage);
                scope.$apply();
            })
        },
        scope: {
            totalItem: "=",
            itemPerPage: "=",
            maxSize: "=",
        },
        bindToController: true
    }
}