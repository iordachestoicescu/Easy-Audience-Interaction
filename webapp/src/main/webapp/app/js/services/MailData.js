'use strict';

questionsApp.factory('mailData', function ($http) {
    return {

        postQuestion: function (username, password, receiver, subject, content) {
            var questionJSON = {
                username: username,
                password: password,
                receiver: receiver,
                subject: subject,
                content: content
            };

            return $http.post("http://localhost:9093/api/mail/send", questionJSON)
                .then(function (response) {
                    return response.data;
                });
        }
    };
})