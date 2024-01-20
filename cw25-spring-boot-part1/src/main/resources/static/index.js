angular.module('app', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8189/app';

    $scope.fillTable = function () {
        $http.get(contextPath + '/api/v1/items')
            .then(function (response) {
                $scope.ItemsList = response.data;
            });
    };

    $scope.fillTable();
});