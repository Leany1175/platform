/** layuiAdmin.std-v1.2.1 LPPL License By http://www.layui.com/admin/ */ ;
layui.define(function(e) {
	var i = (layui.$, layui.layer, layui.laytpl, layui.view, layui.admin);
	i.events.logout = function() {
		layui.$.ajax({
			url: "/administrator/loginOut",
			type: "get",
			success: function(result) {
				layer.msg(result.message, {icon: 1});
				setTimeout(function() {
					location = result.url;
				}, 500);
			}
		});
	}, e("common", {});
});
