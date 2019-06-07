mui.plusReady(function() {

	new Vue({
		el: "#container-header",
		data: {
			url: "http://www.baidu.com"
		},
		methods: {
			open_url: function() {
				var browser = plus.webview.getWebviewById("browser");
				if (this.url != "" && this.url.trim() != "") {
					browser.loadURL(this.url);
					console.log("open_url:" + this.url);
				}
			}
		}
	});

	var self = plus.webview.currentWebview(),
		leftPos = Math.ceil((window.innerWidth - 60) / 2); // 设置凸起大图标为水平居中

	// browser
	var browser = plus.webview.create("https://www.baidu.com", "browser", {
		top: "45px",// mui标题栏默认高度为45px；
		bottom: "0px"// 默认为0px，可不定义；
	});
	self.append(browser);
	// 显示
	browser.show();

	/**	
	 * drawNativeIcon 绘制带边框的半圆，
	 * 实现原理：
	 *   id为bg的tag 创建带边框的圆
	 *   id为bg2的tag 创建白色矩形遮住圆下半部分，只显示凸起带边框部分
	 * 	 id为iconBg的红色背景图
	 *   id为icon的字体图标
	 *   注意创建先后顺序，创建越晚的层级越高
	 */
	var drawNativeIcon = util.drawNative('icon', {
		bottom: '5px',
		left: leftPos + 'px',
		width: '60px',
		height: '60px'
	}, [{
		tag: 'rect',
		id: 'bg',
		position: {
			top: '1px',
			left: '0px',
			width: '100%',
			height: '100%'
		},
		rectStyles: {
			color: '#fff',
			radius: '50%',
			borderColor: '#ccc',
			borderWidth: '1px'
		}
	}, {
		tag: 'rect',
		id: 'bg2',
		position: {
			bottom: '-0.5px',
			left: '0px',
			width: '100%',
			height: '45px'
		},
		rectStyles: {
			color: '#fff'
		}
	}, {
		tag: 'rect',
		id: 'iconBg',
		position: {
			top: '5px',
			left: '5px',
			width: '50px',
			height: '50px'
		},
		rectStyles: {
			color: '#d74b28',
			radius: '50%'
		}
	}, {
		tag: 'font',
		id: 'icon',
		text: '\ue600', //此为字体图标Unicode码'\e600'转换为'\ue600'
		position: {
			top: '0px',
			left: '5px',
			width: '50px',
			height: '100%'
		},
		textStyles: {
			fontSrc: '_www/fonts/iconfont.ttf',
			align: 'center',
			color: '#fff',
			size: '30px'
		}
	}]);
	// append 到父webview中
	self.append(drawNativeIcon);

	//自定义监听图标点击事件
	var active_color = '#fff';
	drawNativeIcon.addEventListener('click', function(e) {
		mui.alert('你点击了图标，你在此可以打开摄像头或者新窗口等自定义点击事件。', '悬浮球点击事件');
		// 重绘字体颜色
		if (active_color == '#fff') {
			drawNativeIcon.drawText('\ue600', {}, {
				fontSrc: '_www/fonts/iconfont.ttf',
				align: 'center',
				color: '#000',
				size: '30px'
			}, 'icon');
			active_color = '#000';
		} else {
			drawNativeIcon.drawText('\ue600', {}, {
				fontSrc: '_www/fonts/iconfont.ttf',
				align: 'center',
				color: '#fff',
				size: '30px'
			}, 'icon');
			active_color = '#fff';
		}

	});
	// 中间凸起图标绘制及监听点击完毕

	// 创建子webview窗口 并初始化
	var aniShow = {};
	util.initSubpage(aniShow);

	var nview = plus.nativeObj.View.getViewById('tabBar'),
		activePage = plus.webview.currentWebview(),
		targetPage,
		subpages = util.options.subpages,
		pageW = window.innerWidth,
		currIndex = 0;


	/**
	 * 根据判断view控件点击位置判断切换的tab
	 */
	nview.addEventListener('click', function(e) {
		var clientX = e.clientX;
		if (clientX > 0 && clientX <= parseInt(pageW * 0.25)) {
			currIndex = 0;
		} else if (clientX > parseInt(pageW * 0.25) && clientX <= parseInt(pageW * 0.45)) {
			currIndex = 1;
		} else if (clientX > parseInt(pageW * 0.45) && clientX <= parseInt(pageW * 0.8)) {
			currIndex = 2;
		} else {
			currIndex = 3;
		}
		// 匹配对应tab窗口	
		if (currIndex > 0) {
			targetPage = plus.webview.getWebviewById(subpages[currIndex - 1]);
		} else {
			targetPage = plus.webview.currentWebview();
		}

		if (targetPage == activePage) {
			return;
		}

		if (currIndex !== 3) {
			//底部选项卡切换
			util.toggleNview(currIndex);
			// 子页面切换
			util.changeSubpage(targetPage, activePage, aniShow);
			//更新当前活跃的页面
			activePage = targetPage;
		} else {
			//第四个tab 打开新窗口
			plus.webview.open('html/new-webview.html', 'new', {}, 'slide-in-right', 200);
		}
	});
});
