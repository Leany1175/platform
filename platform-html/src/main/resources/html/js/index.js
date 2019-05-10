layui.use(["jquery", "element", "colorpicker", "upload", "slider"], function() {
	var $ = layui.jquery,
		element = layui.element,
		colorpicker = layui.colorpicker,
		upload = layui.upload,
		slider = layui.slider;
	
// 	// 开始拖动元素时触发
// 	document.addEventListener("dragstart", function(
// 		console.log(event.target);
// 		event.dataTransfer.effectAllowed = "all";
// 		// console.log("dragstart");
// 	}, false);
// 	
// 	// 用户完成元素拖动后触发
// 	document.addEventListener("dragend", function() {
// 		// console.log("dragend");
// 	}, false);
// 	
// 	// 拖动时
// 	document.addEventListener("drag", function(event) {
// 		// event.preventDefault();
// 		event.dataTransfer.dropEffect = "none";
// 		// console.log(event);
// 		event.dataTransfer.effectAllowed = "none";
// 	}, false);
// 
// 	// 当被鼠标拖动的对象进入其容器范围内时触发此事件
// 	document.addEventListener("dragenter", function(event) {
// 		// console.log("dragenter");
// 		console.log(event);
// 		if ("canvas" == event.target.id) {
// 			event.dataTransfer.dropEffect = "none";
// 			// event.dataTransfer.effectAllowed = "copy";
// 			console.log("canvas")
// 		} else {
// 			event.dataTransfer.dropEffect = "none";
// 		}
// 	}, false);
// 	
// 	// 当某被拖动的对象在另一对象容器范围内拖动时触发此事件
// 	document.addEventListener("dragover", function(event) {
// 		event.preventDefault();
// 		// console.log("dragover");
// 	}, false);
// 	
// 	//  当被鼠标拖动的对象离开其容器范围内时触发此事件
// 	document.addEventListener("dragleave", function() {
// 		// console.log("dragleave");
// 		if ("canvas" == event.target.id) {
// 			event.dataTransfer.dropEffect = "none";
// 			event.dataTransfer.effectAllowed = "none";
// 		}
// 	}, false);

// 	var charts = document.getElementsByClassName("chart");
// 	for (var i = 0; i < charts.length; i++) {
// 		
// 		charts[i].ondragstart = function(event) {
// 			event.dataTransfer.effectAllowed = "copy";
// 			event.dataTransfer.dropEffect = "copy";
// 			console.log(event.target)
// 			console.log("dragstart");
// 		}
// 	}
// 	
// 	// 目标容器
// 	var canvas = document.getElementById("canvas");
// 	
// 	canvas.ondragenter = function(event) {
// 		event.dataTransfer.dropEffect = "copy";
// 		event.dataTransfer.effectAllowed = "copy";
// 		console.log("ondragenter");
// 	}


	// 目标容器
	var target = document.getElementById("target-canvas");
	// 源容器
	var sources = document.getElementsByClassName("chart");
	
	for (var i = 0; i < sources.length; i++) {
		// 开始
		sources[i].ondragstart = function(event) {
			console.log("ondragstart");
		}
		// 结束
		sources[i].ondragend = function() {
			console.log("dragend");
		}
	}
	
	// 在目标容器上拖动
	target.ondragover = function(event) {
		console.log("ondragover");
		event.preventDefault();
	}
	
	// 进入目标容器
	target.ondragenter = function(event) {
		// 复制
		event.dataTransfer.dropEffect = "copy";
		
		console.log(event.dataTransfer.getData("text"));
	}
	
	// 基础组件
	var bases = document.getElementsByClassName("dom-base-component");
	for (var i = 0; i < bases.length; i++) {
		
		// 开始
		bases[i].ondragstart = function(event) {
			event.dataTransfer.setData("text/plain", event.target.id);
		}
		
	}
	
// 	target.ondragleave = function() {
// 		console.log("ondragleave")
// 	}
// 	target.ondrop = function(event) {
// 		console.log("ondrop");
// 	}

	
	// console.log(charts.length);

	
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
	upload.render();

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
	
	// 点击事件
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
	

});