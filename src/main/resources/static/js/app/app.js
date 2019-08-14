'use strict'

var demoApp = angular.module('demo', [ 'ui.bootstrap', 'demo.controllers',
		'demo.services' ]);
demoApp.constant("CONSTANTS", {
	getWeatherForeCast :"/weather/forecast/",
	getWeatherCondition :"/weather/condition/"
});