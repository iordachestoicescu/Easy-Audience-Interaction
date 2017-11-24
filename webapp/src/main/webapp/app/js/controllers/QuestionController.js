'use strict';

questionsApp.controller('QuestionController',
    function QuestionController($scope, $http, $log, questionData, mailData) {
        var voted = false;

        $scope.getQuestions = function () {
            questionData.getQuestions()
                .then(getQuestionsSucceeded)
                .catch(getQuestionsFailed);
        };

        $scope.addQuestion = function (subject, name, email, content) {
            questionData.postQuestion(subject, name, email, content)
                .then(addQuestionSucceeded)
                .catch(addQuestionFailed());
            $scope.subject = null;
            $scope.name = null;
            $scope.email = null;
            $scope.content = null;
        };

        $scope.deleteQuestion = function (question) {
            var r = confirm("Are you sure you want to delete this question?");
            if (r == true) {
                questionData.deleteQuestion(question)
                    .then(deleteQuestionSucceeded)
                    .catch(deleteQuestionFailed);
            }

        };

        $scope.voteQuestion = function (question) {
            if (voted) {
                downVoteQuestion(question)
                voted = false;
            } else {
                upVoteQuestion(question);
                voted = true;
            }
        }

        $scope.sendResponse = function (username, password, receiver, subject, content) {
            mailData.postQuestion(username, password, receiver, subject, content)
                .then(sendMailSucceeded)
                .catch(sendMailFailed);
        }

        $scope.prepareResponseForm = function (question) {
            var modal = document.getElementById('modalSubmitForm');
            var span = document.getElementById('closeSubmitForm');

            $scope.sendMailStat = "";
            $scope.receiver = question.email;
            $scope.subject = "Response to " + question.subject;
            $scope.content = "Question : \"" + question.content + "\"" + "\n";

            modal.style.display = "block";

            span.onclick = function () {
                modal.style.display = "none";
            }

            window.onclick = function (event) {
                if (event.target == modal) {
                    modal.style.display = "none";
                }
            }
        }

        $scope.prepareSubmitQuestionForm = function () {
            var modal = document.getElementById('modalQuestionForm');
            var span = document.getElementById('closeQuestionForm');

            modal.style.display = "block";

            span.onclick = function () {
                modal.style.display = "none";
            }

            window.onclick = function (event) {
                if (event.target == modal) {
                    modal.style.display = "none";
                }
            }
        }

        $scope.showReadMoreMessage = function () {
            var modal = document.getElementById('modalReadMore');
            var span = document.getElementById('closeReadMore');

            modal.style.display = "block";

            span.onclick = function () {
                modal.style.display = "none";
            }

            window.onclick = function (event) {
                if (event.target == modal) {
                    modal.style.display = "none";
                }
            }
        }

        var upVoteQuestion = function (question) {
            question.votes++;
            questionData.putQuestion(question)
                .then(putQuestionSucceeded)
                .catch(putQuestionFailed);
        };

        var downVoteQuestion = function (question) {
            question.votes--;
            questionData.putQuestion(question)
                .then(putQuestionSucceeded)
                .catch(putQuestionFailed);
        };

        var getQuestionsSucceeded = function (data) {
            $scope.questions = data;
        };

        var getQuestionsFailed = function (error) {
            $scope.error = "Could not fetch the data.";
        };

        var addQuestionSucceeded = function (data) {
            var modal = document.getElementById('modalQuestionForm');
            modal.style.display = "none";

            $scope.addQuestionStat = data;
            $scope.getQuestions();
        };

        var addQuestionFailed = function (data) {
            $scope.addQuestionStat = "Failed to submit question.";
        };

        var putQuestionSucceeded = function (data) {
            $scope.putQuestionStat = data;
        }

        var putQuestionFailed = function (data) {
            $scope.putQuestionStat = data;
        }

        var deleteQuestionSucceeded = function (data) {
            $scope.deleteQuestionStat = data;
            $scope.getQuestions();
        };

        var deleteQuestionFailed = function (data) {
            $scope.deleteQuestionStat = data;
        }

        var sendMailSucceeded = function (data) {
            var modal = document.getElementById('modalSubmitForm');
            modal.style.display = "none";
            $scope.sendMailStat = data;
        };

        var sendMailFailed = function (data) {
            $scope.sendMailStat = "Failed to send mail, check user and password!";
        };
    }
);