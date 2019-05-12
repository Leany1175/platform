layui.use(["jquery", "element", "colorpicker", "upload", "slider"], function() {
	var $ = layui.jquery,
		element = layui.element,
		colorpicker = layui.colorpicker,
		upload = layui.upload,
		slider = layui.slider;
	
	// 背景颜色选择器
	colorpicker.render({
		elem: "#color-choose",
		change: function(color) { //选择
			console.log("change:" + color);
		},
		done: function(color) {
			console.log("done:" + color);
		}
	});
	
	// TODO 背景图片选择
	// upload.render();

	// TODO 放大与缩小
	slider.render({
		elem: "#slider",
		min: 50,
		max: 150,
		value: 100,
		setTips: function(value) {
			return value + "%";
		},
		change: function(value) {
			console.log(value);
		}
	});
	
	// 选项卡切换
	$(".div-base").click(function() {
		// 先隐藏
		$(this).parent().find(".div-base").each(function(e, elem) {
			$(this).removeClass("active");
		});
		
		var bind = $(this).attr("data-bind");
		var divs = $(this).parent().parent().find(".content-container");
		
		for (var i = 0; i < divs.length; i++) {
			if ($(divs[i]).attr("data-bind") == bind) {
				$(divs[i]).show();
				// active
				$(this).addClass("active");
			} else {
				$(divs[i]).hide();
			}
		}
	});
	
	// canvas
	var canvas = document.getElementById("target-container");
	var context = canvas.getContext("2d");
	
	// 初始化宽高
	resizeCanvas();

	// 目标容器
	var target = document.getElementById("target-container");
	// 在目标容器上拖动
	target.ondragover = function(event) {
		event.preventDefault();
		
		// 清空画布
		context.clearRect(0, 0, $(target).attr("width"), $(target).attr("height"));
		
		// console.log(context);
		// console.log(event);
		// console.log("dragover");
		context.beginPath();
		context.strokeStyle = "gray";
		// 虚线
		context.setLineDash([5]);
		context.moveTo(event.layerX, 0);
		context.lineTo(event.layerX, event.layerY);
		context.stroke();
		
		context.beginPath();
		context.moveTo(0, event.layerY);
		context.lineTo(event.layerX, event.layerY);
		context.stroke();
		
		// console.log(event.dataTransfer.getData("id"));
	}
	// 拖动
	target.ondrop = function(event) {
		console.log("drop");
		event.preventDefault();
		console.log("id:" + event.dataTransfer.getData("id"));
	}
	
	// 标题
	var title = document.getElementById("title");
	title.ondragstart = function(event) {
		console.log("title - event");
		event.dataTransfer.setData("Text", "null");
		event.dataTransfer.setData("width", "300");
		event.dataTransfer.setData("height", "200");
	}
	
	// 进入目标容器
	target.ondragenter = function(event) {
		// 复制
		event.dataTransfer.dropEffect = "copy";
		// console.log(event);
	}
	
// 	// 基础组件
// 	var bases = document.getElementsByClassName("dom-base-component");
// 	for (var i = 0; i < bases.length; i++) {
// 		// 开始
// 		bases[i].ondragstart = function(event) {
// 			console.log("dragstart");
// 		}
// 	}
	
	
// 	// 源容器
// 	var sources = document.getElementsByClassName("chart");
// 	
// 	for (var i = 0; i < sources.length; i++) {
// 		// 开始
// 		sources[i].ondragstart = function(event) {
// 			console.log("ondragstart");
// 		}
// 		// 结束
// 		sources[i].ondragend = function() {
// 			console.log("dragend");
// 		}
// 	}
// 		
// 	
// 	
// 	// 进入目标容器
// 	target.ondragenter = function(event) {
// 		// 复制
// 		event.dataTransfer.dropEffect = "copy";
// 		
// 		console.log(event.dataTransfer.getData("text"));
// 	}
		
	
		
	// 	target.ondragleave = function() {
	// 		console.log("ondragleave")
	// 	}
	// 	target.ondrop = function(event) {
	// 		console.log("ondrop");
	// 	}
	
		
		// console.log(charts.length);

	function resizeCanvas() {
		// 初始化canvas宽高
		var canvas = document.getElementById("target-container");
		$(canvas).attr("width", $(canvas).width());
		$(canvas).attr("height", $(canvas).height());
	}

});