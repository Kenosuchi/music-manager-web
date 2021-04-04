angular
    .module("PaginationModule")
    .controller("PaginationController", PaginationController)

function PaginationController($scope) {
    var vm = this;
    vm.currentPage = 1;
    vm.totalItem = 0;
    vm.itemPerPage;
    vm.maxSize;
    vm.totalPages;
    vm.pageList = [];

    vm.setPage = setPage;

    function setupPageList() {
        vm.totalPages = Math.ceil(vm.totalItem / vm.itemPerPage);
        setPage(1);
    }

    function setPage(page) {
        if (page < 1 || page > vm.totalPages)
            return;
        vm.currentPage = page;
        var startPage, endPage;

        if (vm.totalPages < vm.maxSize) {
            startPage = 1;
            endPage = vm.totalPages;
        } else {
            if (vm.currentPage + 1 >= vm.totalPages) {
                startPage = vm.totalPages - vm.maxSize + 1;
                endPage = vm.totalPages;
            } else {
                startPage = vm.currentPage - Math.floor(vm.maxSize / 2);
                if (startPage < 1)
                    startPage = 1;
                endPage = startPage + vm.maxSize - 1;
                if (endPage > vm.totalPages)
                    endPage = vm.totalPages;
            }
        }
        vm.pageList = [];
        for (var i = startPage; i <= endPage; ++i) {
            vm.pageList.push(i);
            if (vm.pageList.length >= vm.maxSize)
                break;
        }
    }
    $scope.$watch('vm.totalItem', setupPageList);
}