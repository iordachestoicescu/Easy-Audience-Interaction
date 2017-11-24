'use strict'

questionsApp.controller('LoginController',
    function LoginController($scope, $log, $window, loginData) {
        $scope.title = "Login page";

        $scope.adminLogin = function (username, password) {
            $log.info("Login request.")
            loginData.login(username, password)
                .then(onLoginSucceeded, onLoginFailed);
        }

        var onLoginSucceeded = function (data) {
            $scope.loginMessage = data;
            $window.location.href = '#/adminPage';
        }

        var onLoginFailed = function (data) {
            $scope.loginMessage = "Incorrect user or password";
        }
    }
);