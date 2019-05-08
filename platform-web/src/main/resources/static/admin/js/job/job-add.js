layui.config({
	base: "/layui/extends/"
}).use(["jquery", "form", "laydate"], function(){
	var $ = layui.jquery
		form = layui.form,
		laydate = layui.laydate;
	
	// 触发器类型
	form.on("select(trigger-type)", function(data) {
		var parent = $(data.elem).parent().parent();
		var clazz = parent.next().attr("class");
		
		if (clazz.indexOf("hidden") >= 0) {
			// 移除
			parent.next().remove();
		}
		
		if (data.value == 1) {
			var dom = $(".fixed-time").clone(true);
			dom.css("display", "block");
			parent.after(dom);
		} else if (data.value == 2) {
			var dom = $(".fixed-point").clone(true);
			dom.css("display", "block");
			parent.after(dom);
		} else if (data.value == 3) {
			var dom = $(".cron").clone(true);
			dom.css("display", "block");
			parent.after(dom);
		}
		form.render();
	});
	
	// 表单提交
	form.on("submit(save)", function(data) {
		console.log(data);
		return false;
	});
	
	// 日历
	form.on("select(choose-calendar)", function(data) {
		laydate.render({
			elem: "#time",
			type: "datetime"
		});
	});
	
});

Date.prototype.Format = function (fmt) { //author: meizz
    var o = {
        "M+": this.getMonth() + 1, //月份
        "d+": this.getDate(), //日
        "h+": this.getHours(), //小时
        "m+": this.getMinutes(), //分
        "s+": this.getSeconds(), //秒
        "q+": Math.floor((this.getMonth() + 3) / 3), //季度
        "S": this.getMilliseconds() //毫秒
    };
    if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o)
        if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
    return fmt;
}
