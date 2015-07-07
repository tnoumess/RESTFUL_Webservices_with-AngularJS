/**
 * 
 */

var module = angular.module('myApp.services', []);

module.factory('VaderService', function() {
    var VaderClass = function(padawan) {
        this.name = padawan;
        this.speak = function () {
        	alert("ppp");
            return 'Join the dark side ' + this.name;
        }
    }

    return VaderClass;
});