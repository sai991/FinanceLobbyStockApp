console.log("Screen1.js Loaded");

const stockUrl = "http://localhost:40109/backendServlet";


// AngularJS Module & Controller
angular.module("stockApp", []).controller("stockController", function ($scope, $http) {
    $scope.stocks = [];

    // Fetch stocks from the server on page load
    $http.get(stockUrl).then(
        function (response) {
            $scope.stocks = response.data; // Populate the stocks array
            console.log("Stock Data Loaded:", $scope.stocks);
        },
        function (error) {
            console.error("Error fetching stock data:", error);
        }
    );

    // Search Stock Function
    $scope.searchStock = function () {
        const query = document.getElementById("searchBar").value.trim();
        console.log("Searching stock with query:", query);

        if (!query) return; // Avoid empty searches

        const requestData = {
            action: "searchStock",
            searchTerm: query,
        };

        fetch(stockUrl, {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(requestData),
        })
        .then(response => response.json())
        .then(data => {
            if (data.status === "success") {
                $scope.$apply(() => {
                    $scope.stocks = data.stocks;
                });
            } else {
                console.error("Error searching stock:", data.message);
            }
        })
        .catch(error => console.error("Fetch error:", error));
    };
});
