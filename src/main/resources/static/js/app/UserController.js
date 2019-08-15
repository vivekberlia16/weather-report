'use strict'

var module = angular.module('demo.controllers', []);
module
		.controller(
				"UserController",
				[
						"$scope",
						"WeatherService",
						function($scope, WeatherService) {
							$scope.currentCityForeCast = null;
							$scope.currentCityConditions = null;

							$scope.cities = [ {
								Name : "New Delhi",
								id : "1273294"
							}, {
								Name : "Mumbai",
								id : "1275339"
							}, {
								Name : "Kolkata",
								id : "1275004",
							}, {
								Name : "Bangalore",
								id : "1277333"
							} ];

							$scope.init = function() {
								$scope.selectedCity = $scope.cities[0];
								$scope.loadData($scope.cities[0]);

							}
							
							console.log("cities are" + $scope.cities);
							$scope.skills = [];

							$scope.loadData = function(city) {
								WeatherService
										.getWeatherForeCastByCityId(city.id)
										.then(
												function(value) {
													$scope.currentCityForeCast = value;

													$scope.weatherForeCastGroups = {};
													angular
															.copy(
																	$scope.currentCityForeCast,
																	$scope.weatherForeCastGroups);

													$scope.weatherForeCastGroups.data.list = $scope
															.convertTo(
																	$scope.weatherForeCastGroups.data.list,
																	'dt_txt',
																	true);
													console
															.log("retured value is+"
																	+ $scope.weatherForeCastGroups.data.list);

												},
												function(reason) {
													console
															.log("error occured");
												}, function(value) {
													console.log("no callback");
												});

								WeatherService
										.getWeatherConditionByCityId(city.id)
										.then(
												function(value) {
													
													$scope.currentWeatherConditions = value;

												},
												function(reason) {
													console
															.log("error occured");
												}, function(value) {
													console.log("no callback");
												});
							}

							$scope.updateWeatherData = function($event, city) {
								console.log("clicked city" + city.Name);
								$scope.selectedCity = city;
								$scope.loadData(city);
							}

							$scope.convertTo = function(arr, key, dayWise) {
								var groups = {};
								var l = arr.length;
								for (var i = 0; i < l; i++) {
									if (dayWise) {
										// arr[i][key] =
										// arr[i][key].toLocaleDateString();
										var original = arr[i][key];
										var str = arr[i][key];
										str = str
												.substring(0, str.indexOf(" "));
										var time_str = original
												.substring(original
														.indexOf(" ") + 1);
										time_str = time_str.substring(0,
												time_str.lastIndexOf(":"));
										arr[i][key] = str;
										arr[i]["time"] = time_str;
									} else {
										arr[i][key] = arr[i][key]
												.toTimeString();
									}
									groups[arr[i][key]] = groups[arr[i][key]]
											|| [];
									// groups[arr[i][key]] = groups[arr[i][key]]
									// || [];
									groups[arr[i][key]].push(arr[i]);
								}
								return groups;
							};

							$scope.convertToCelsius =function(val)
							{
								var value = parseFloat(val-273).toFixed(2);
							//	console.log("val"+value);
								return value;
							}
							
							$scope.expandDiv = function($event, key) {
								console.log("called expand div");
								// key.isExpanded =!key.isExpanded;
								var e1 = $event.currentTarget.nextElementSibling;
								var e = angular.element(e1);
								var symbolEle = $event.currentTarget.children;
								var symEle = angular.element(symbolEle);
								var classList = $event.currentTarget.nextElementSibling.classList;
								if (classList.contains("ng-hide")) {

									e.removeClass("ng-hide");
									e.addClass("ng-show");

								} else  {
									e.removeClass("ng-show");
									e.addClass("ng-hide");

								}

								var symClass = $event.currentTarget.children[0].classList;
								if (symClass.contains("glyphicon-minus")) {
									symEle.removeClass("glyphicon-minus");
									symEle.addClass("glyphicon-plus")
								} else if (symClass.contains("glyphicon-plus")) {
									symEle.removeClass("glyphicon-plus");
									symEle.addClass("glyphicon-minus")
								}

							};
						
						} ]);