'use strict';

questionsApp.factory('questionData', function ($http) {
    return {
        getQuestions: function () {
            return $http.get("http://localhost:9091/api/question/findAll")
                .then(function (response) {
                    return response.data;
                })
        },

        postQuestion: function (subject, name, email, content) {
            var questionJSON = {
                subject: subject,
                name: name,
                email: email,
                content: content
            };

            return $http.post("http://localhost:9091/api/question/create", questionJSON)
                .then(function (response) {
                    return response.data;
                });
        },

        putQuestion: function (question) {
            return $http.put("http://localhost:9091/api/question/update", question)
                .then(function (response) {
                    return response;
                })
        },

        deleteQuestion: function (question) {
            return $http.delete("http://localhost:9091/api/question/delete?id=" + question.id)
                .then(function (response) {
                    return response.data;
                });
        }
    };
})