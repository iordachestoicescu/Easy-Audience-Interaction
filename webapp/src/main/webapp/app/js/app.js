'use strict';

var questionsApp = angular.module('questionsApp', ['ngRoute'])
    .config(function ($routeProvider) {
        $routeProvider.when('/newQuestion',
            {
                templateUrl: 'templates/guest/SubmitQuestion.html',
                controller: 'QuestionController'
            });
        $routeProvider.when('/questions',
            {
                templateUrl: 'templates/guest/GuestPage.html',
                controller: 'QuestionController'
            });
        $routeProvider.when('/login',
            {
                templateUrl: 'templates/Login.html',
                controller: 'LoginController'
            })
        $routeProvider.when('/adminPage',
            {
                templateUrl: 'templates/admin/AdminPage.html',
                controller: 'QuestionController'
            })
        $routeProvider.otherwise({redirectTo: '/questions'});
    });
