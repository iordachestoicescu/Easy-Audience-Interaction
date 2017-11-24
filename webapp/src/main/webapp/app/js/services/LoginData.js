'use strict'

questionsApp.factory('loginData',
    function ($http) {

        return {
            login: function (username, password) {
                var credentialsJSON = {
                    username: username,
                    password: password
                };
                return $http.post("http://localhost:9092/api/login/admin", credentialsJSON)
                    .then(function (response) {
                        return response.data;
                    });
            }
        };
    }
);