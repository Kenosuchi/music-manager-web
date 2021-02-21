angular
    .module('ArtistModule')
    .service('ArtistService',ArtistService);

function ArtistService($http){
    var API={
        Url: '/artists/'
    };
    var service = {
        getArtists: getArtists,
        parseData: parseData,
    }

    //==========Internal function==============
    function parseData(res){
        var result = [];
        for (data of res.data.data) {
            result.push({
                data: data
            })
        };
        return result;
    }
    function getArtists(){
        return $http.get(API.Url);
    }

    return service;
}