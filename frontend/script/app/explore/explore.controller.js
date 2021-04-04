angular
    .module('ExploreModule')
    .controller('ExploreController', ExploreController);

function ExploreController() {
    var vm = this;

    vm.data = [];

    vm.carouselTraits = {
        Title: "Title",
        Items: [],
    }
    vm.index = ["one", "two"];


    vm.sources = [
        "https://mdbootstrap.com/img/Photos/Horizontal/Nature/4-col/img%20(34).jpg",
        "https://mdbootstrap.com/img/Photos/Horizontal/Nature/4-col/img%20(18).jpg",
        "https://mdbootstrap.com/img/Photos/Horizontal/Nature/4-col/img%20(35).jpg",
        "https://mdbootstrap.com/img/Photos/Horizontal/Nature/4-col/img%20(34).jpg",
        "https://mdbootstrap.com/img/Photos/Horizontal/Nature/4-col/img%20(60).jpg",
        "https://mdbootstrap.com/img/Photos/Horizontal/Nature/4-col/img%20(47).jpg",
        "https://mdbootstrap.com/img/Photos/Horizontal/Nature/4-col/img%20(48).jpg",
        "https://mdbootstrap.com/img/Photos/Horizontal/Nature/4-col/img%20(34).jpg",
        "https://mdbootstrap.com/img/Photos/Horizontal/Nature/4-col/img%20(53).jpg",
        "https://mdbootstrap.com/img/Photos/Horizontal/Nature/4-col/img%20(45).jpg",
        "https://mdbootstrap.com/img/Photos/Horizontal/Nature/4-col/img%20(51).jpg",
        "https://mdbootstrap.com/img/Photos/Horizontal/Nature/4-col/img%20(34).jpg"
    ]

    initialization(vm.sources);

    function initialization(sources) {
        var itemArr = [];
        for (var i = 0; i < sources.length; ++i) {
            itemArr.push({
                Name: "Name",
                Source: sources[i]
            })
            if (i === 3 || i === 7 || i === 11) {
                vm.carouselTraits.Items.push(itemArr);
                itemArr = [];
            }
        }
    }
}