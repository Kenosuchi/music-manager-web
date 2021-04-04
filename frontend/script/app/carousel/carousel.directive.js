angular
    .module("CarouselModule")
    .directive('carouselSong', CarouselDirective);

function CarouselDirective() {
    return {
        restrict: 'E',
        templateUrl: './app/carousel/carousel.template.html',
        controller: 'CarouselController',
        controllerAs: 'vm',
        scope: {
            carouselTraits: "=",
            index: "="
        },
        bindToController: true
    }
}