'use strict'

angular.module('demo.services', []).factory('WeatherService',
		[ "$http", "CONSTANTS", function($http, CONSTANTS) {
			var service = {};
			service.getUserById = function(userId) {
				var url = CONSTANTS.getUserByIdUrl + userId;
				return $http.get(url);
			}
			service.getAllUsers = function() {
				return $http.get(CONSTANTS.getAllUsers);
			}
			service.saveUser = function(userDto) {
				return $http.post(CONSTANTS.saveUser, userDto);
			}
			
			service.getWeatherForeCastByCityId = function(cityId) {
				var url = CONSTANTS.getWeatherForeCast + cityId;
				return $http.get(url);
			}
			
			service.getWeatherConditionByCityId = function(cityId) {
				var url = CONSTANTS.getWeatherCondition + cityId;
				return $http.get(url);
			}
			return service;
		} ]);