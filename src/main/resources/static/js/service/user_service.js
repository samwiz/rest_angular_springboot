'use strict';

angular.module('myApp').factory('UserService', ['$http', '$q', function ($http, $q) {

    var REST_SERVICE_URI = 'http://localhost:8080/linearmotion/process';

    var factory = {
    		calculateOutput: calculateOutput
    };

    return factory;

   

    function calculateOutput(user) {
    	console.log('inside service js acceleration', user.acceleration);
        var deferred = $q.defer();
        $http.post(REST_SERVICE_URI, user)
            .then(
                function (response) {
                	console.log('response recieved');
                    deferred.resolve(response.data);
                },
                function (errResponse) {
                    console.error('Erro in executing rest service');
                    console.log('error message in serv js'+ errResponse.data.message)
                    deferred.reject(errResponse);
                }
            );
        return deferred.promise;
    }


}]);