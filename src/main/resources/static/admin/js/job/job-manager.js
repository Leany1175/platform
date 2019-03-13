layui.config({
	base: "/layui/extends/"
}).use(["table", "jquery", "ajax"], function(){
	var table = layui.table,
		$ = layui.jquery,
		ajax = layui.ajax;
	
	var tableIns = table.render({
		elem: "#datalist",
		url: "/admin/job/datalist",
		page: true,
		limit: 10,
		limits: [5, 10, 20, 50, 100],
		loading: true,
		cols: [
			[
				{
					field: "noticeId",
					type: "checkbox"
				},
				{
					field: "title",
					title: "公告标题"
				},
				{
					field: "content",
					title: "公告内容"
				},
				{
					field: "createTime",
					title: "创建时间"
				},
				{
					field: "lastUpdate",
					title: "上次更新"
				},
				{
					field: "",
					title: "操作",
					toolbar: "#toolbar"
				}
			]
		]
	});
	
	table.on("tool(*)", function(obj){
		var event = obj.event,
		    data = obj.data;
		
		if (event == "detail") {
			location = "/admin/notice/queryDetail/" + data.noticeId;
		}
		
		if (event == "edit") {
			location = "/admin/notice/updatePage/" + data.noticeId;
		}
		
		if (event == "del") {
			layer.confirm("确认删除", {icon: 3, title:'删除'}, function(index){
				var url = "/admin/notice/deleteNotice/" + data.noticeId;
				ajax.formDelete(url);
				layer.close(index);
			});
		}
	});
	
	$(".btn-add").click(function(){
		location = "/admin/notice/addPage";
	});
	
	$(".btn-query").click(function(){
		tableIns.reload({
			where: {
				title: $("#title").val(),
				content: $("#content").val()
			}
		});
	});
	
	$(".btn-edit").click(function(){
		var checkStatus = table.checkStatus('datalist');
		var data = checkStatus.data;
		if (data.length > 0) {
			location = "/admin/notice/updatePage/" + data[0].noticeId;
		} else {
			layer.msg("请选择修改的行", {icon: 5});
		}
	});
	
	$(".btn-delete").click(function(){
		var checkStatus = table.checkStatus('datalist');
		var data = checkStatus.data;
		
		var ids = new Array();
		$.each(data, function(i, notice){
			ids[i] = notice.noticeId;
		});
		
		if (ids.length > 0) {
			layer.confirm("确认删除", {icon: 3, title:'删除'}, function(index){
				ajax.formDelete("/admin/notice/deleteByIds?ids=" + ids);
				layer.close(index);
			});
		} else {
			layer.msg("请选择删除的行", {icon: 5});
		}
		
	});
	
	$("#title,#content").keydown(function(e){
		if(e.keyCode == 13){
			$(".btn-query").click();
		}
	});
	
});
