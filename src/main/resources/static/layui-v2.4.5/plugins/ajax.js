layui.define(function(exports) {
	
	var $ = layui.$,
		layer = layui.layer;
	
	var obj = {
		send: function(method, url, data, succ) {
			if (succ === undefined) {
				succ = function(result) {
					if (result.code == 500) {
						if (result.message != "") {
							layer.msg(result.message, {icon: 5});
						}
					} else if (result.code == 200) {
						// 消息提示
						if (result.message != "") {
							layer.msg(result.message, {icon: 1});
						}
						// 跳转
						if (result.url != null && result.url != "") {
							setTimeout(function() {
								location = result.url;
							}, 500);
						}
					}
				}
			}
			var index;
			$.ajax({
				type: method,
				url: url,
				data: data,
				beforeSend: function() {
					index = layer.load();
				},
				success: function(result) {
					succ(result);
				},
				error: function() {
					layer.msg("服务器繁忙", {icon: 5});
				},
				complete: function() {
					layer.close(index);
				}
			});
		},
		get: function(url, data, succ) {
			obj.send("get", url, data, succ);
		},
		post: function(url, data, succ) {
			obj.send("post", url, data, succ);
		},
		put: function(url, data, succ) {
			obj.send("put", url, data, succ);
		},
		delete: function(url, data, succ) {
			obj.send("delete", url, data, succ);
		}
	};
	
	exports("ajax", obj);
});