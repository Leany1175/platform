layui.config({
	base: "/layui/extends/"
}).use(["jquery", "form", "laydate"], function(){
	var $ = layui.jquery
		form = layui.form,
		laydate = layui.laydate;
	
	laydate.render({
		elem: "#time",
		type: "time"
	});
	
	form.on("submit(save)", function(data) {
		console.log(data);
		return false;
	});
	
});
