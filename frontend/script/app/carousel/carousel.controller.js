angular
    .module("CarouselModule")
    .controller("CarouselController", CarouselController);

function CarouselController() {
    var vm = this;
    vm.carouselTraits;
    vm.index;
}