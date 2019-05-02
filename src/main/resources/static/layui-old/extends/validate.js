layui.define(function(exports) {

	var obj = {
		isNullOrEmpty: function(value) {
			return value == "" || value == null;
		},
		notNullAndEmpty: function(value) {
			return value != "" && value != null;
		},
		isPhone: function(value) {
			return /^1[34578]\d{9}$/.test(value);
		},
		length: function(value, val1, val2) {
			if (undefined === val2) {
				return value.length >= val1;
			} else {
				return value.length >= val1 && value.length < val2;
			}
		}
	};
	
	
	exports("validate", obj);
});