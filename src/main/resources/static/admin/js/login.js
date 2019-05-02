layui.config({
	base: "/layui-v2.4.5/plugins/" //静态资源所在路径
}).use(["form", "validate", "ajax"], function() {
	var form = layui.form,
		validate = layui.validate,
		ajax = layui.ajax;


	form.render();

	// 表单验证
	form.verify({
		phone: function(value, item) {
			if (validate.isNullOrEmpty(value)) {
				return "账号不能为空";
			}
			if (!validate.isPhone(value)) {
				return "手机号格式错误";
			}
		},
		password: function(value, item) {
			if (validate.isNullOrEmpty(value)) {
				return "密码不能为空";
			}
			if (!validate.length(value, 6, 32)) {
				return "密码长应在6-32位之间";
			}
		}
	});

	// 提交
	form.on("submit(login-submit)", function(obj) {
		ajax.post("/administrator/login", obj.field);
	});

});
