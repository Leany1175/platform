layui
	.extend({
		dtree: "/layui-v2.4.5/plugins/dtree",
		ajax: "/layui-v2.4.5/plugins/ajax",
		validate: "/layui-v2.4.5/plugins/validate"
	})
	.use(
		["layer", "dtree", "jquery", "table", "form", "upload", "ajax"],
		function() {
			var layer = layui.layer,
				dtree = layui.dtree,
				$ = layui.jquery,
				table = layui.table,
				form = layui.form,
				upload = layui.upload,
				ajax = layui.ajax;

			// 表格
//			var dataTable = table.render({
//				id: "data-table",
//				elem: "#data-table",
//				url: "json/table.json?page=1&limit=10",
//				toolbar: "#tools",
//				cols: [
//					[{
//						field: "id",
//						title: "ID",
//						type: "checkbox"
//					}, {
//						field: "promission",
//						title: "Promission"
//					}, {
//						field: "owner",
//						title: "Owner"
//					}, {
//						field: "group",
//						title: "Group"
//					}, {
//						field: "size",
//						title: "Size"
//					}, {
//						field: "lastModified",
//						title: "Last Modified"
//					}, {
//						field: "replication",
//						title: "Replication"
//					}, {
//						field: "blockSize",
//						title: "Block Size"
//					}, {
//						field: "name",
//						title: "Name"
//					}, {
//						field: "",
//						title: "operation",
//						toolbar: "#toolbar"
//					}]
//				]
//			});

			// 树
			var Dtree = dtree
				.render({
					elem: "#tree",
					initLevel: "2",
					url: "/admin/tree/root",
					type: "all",
					toolbar: true,
					toolbarLoad: "node",
					toolbarShow: [],
					toolbarFun: {
						loadToolbarBefore: function(buttons,
							param, $div) {
							if (param.isLeaf) { // 如果是叶子节点
								buttons.add = ""; // 取消新增功能
							}
							return buttons; // 将按钮对象返回
						}
					},
					toolbarExt: [{
							toolbarId: "add",
							icon: "dtree-icon-jia1",
							title: "新增",
							handler: function(node) {
								// 默认目录
								$("#catalog").val(node.context);

								var add = layer.open({
									type: 1,
									title: "添加",
									content: $("#save-node"),
									area: "600px",
									btn: ["保存", "取消"],
									yes: function(index) {
										saveNode("POST", add,
											node);
									}
								});
							}
						},
						{
							toolbarId: "edit",
							icon: "dtree-icon-bianji",
							title: "编辑",
							handler: function(node) {
								$
									.ajax({
										type: "get",
										url: "json/edit-tree.json?nodeId=" +
											node.nodeId,
										dataType: "json",
										success: function(
											result) {
											// 表单默认值
											form
												.val(
													"form-node",
													result.data);

											// 显示或隐藏
											isShow(result.data.isCatalog);

											// 弹窗
											var openLayer = layer
												.open({
													type: 1,
													title: "更新",
													content: $("#save-node"),
													area: "600px",
													btn: [
														"保存",
														"取消"
													],
													yes: function(
														index) {
														saveNode(
															"PUT",
															openLayer,
															node);
													}
												});
										},
										error: function() {
											layer
												.msg(
													"服务器繁忙", {
														icon: 5
													});
										}
									});
								console.log("编辑");
							}
						}, {
							toolbarId: "delete",
							icon: "dtree-icon-delete1",
							title: "删除",
							handler: function(node) {
								layer.confirm("是否删除", {
									icon: 3,
									title: "提示"
								}, function(index) {
									// $.ajax({
									// type: "delete",
									// url: "?nodeId=" +
									// node.nodeId,
									// dataType: "json",
									// success: function(result)
									// {
									// // TODO 删除操作
									// 											
									// },
									// error: function() {
									// layer.msg("服务器繁忙", {
									// icon: 5 });
									// }
									// });

									layer.close(index);
								});
							}
						}
					]
				});

			// 树双击事件
			dtree.on("nodedblclick('tree')", function(obj) {
				if (obj.param.isLeaf) {
					// TODO 数据绑定
					console.log("数据绑定");
				} else {
					// TODO 展开或收缩节点
				}
			});

			// 开关
			form.on("switch(node-status)", function(data) {
				isShow(data.elem.checked);
			});

			// 显示或隐藏
			function isShow(show) {
				$(".node-or-leaf").css("display",
					show ? "block" : "none");
			}

			/**
			 * 保存树
			 * 
			 * @param type
			 *            POST:添加,PUT:更新
			 * @param openLayer
			 *            弹窗对象
			 * @param 节点
			 */
			function saveNode(type, openLayer, node) {
				// id
				var catalogId = $("#catalogId").val();

				// 开关状态
				var isCatalog = $("#isCatalog").next().attr("class")
					.indexOf("layui-form-onswitch") == -1;

				var name = $("#name").val();
				var ip = $("#ip").val();
				var port = $("#port").val();
				var username = $("#username").val();

				var data = {
					catalogId: catalogId,
					isCatalog: isCatalog,
					parentId: node.nodeId,
					level: node.level,
					name: name,
					ip: ip,
					port: port,
					username: username
				};

				
				
				// Dtree.changeTreeNodeAdd("refresh");
				ajax.post("/admin/hdfs/save", data, function(result) {
					// console.log(result);
					
					// 重置表单
					$("#form-node")[0].reset();
					// 关闭窗体
					layer.close(openLayer);
					// 重新加载树
					dtree.reload(Dtree);
					// 隐藏
					$(".node-or-leaf").css("display", "none");
				});

				// TODO 提交表单
				// $.ajax({
				// type: type,
				// url: "",
				// dataType: "json",
				// success: function(result) {
				// console.log(result);
				// // // 重置表单
				// // $("#form-node")[0].reset();
				// // // 关闭窗体
				// // layer.close(openLayer);
				// // // 重新加载树
				// // dtree.reload(Dtree);
				// // 隐藏
				// $(".node-or-leaf").css("display", "none");
				// },
				// error: function() {
				// layer.msg("服务器繁忙", { icon: 5 });
				// }
				// });
			}

			// 搜索
			$(".btn-search").click(function() {
				dataTable.reload({
					where: {
						filepath: $("#filepath").val(),
						pattern: $("#pattern").val()
					}
				});
			});

			// 新建文件夹
			$(".btn-mkdir").click(function() {
				var openLayer = layer.open({
					type: 1,
					title: "新建文件夹",
					content: $("#form-mkdir"),
					area: "400px",
					btn: ["保存", "取消"],
					yes: function(index) {
						var dir = $("#dir").val();
						var filepath = $("#filepath").val();
						// TODO 创建文件夹
						console.log(dir);
						layer.close(openLayer);
					}
				});
			});

			// 文件删除
			$(".btn-delete").click(function() {
				// 文件路径
				var filepath = $("#filepath").val();
				var statuses = table.checkStatus("data-table");
				console.log(statuses);
			});

			// 文件上传
			$(".btn-upload").click(function() {
				console.log("上传");
			});

			// 文件上传
			upload.render({
				elem: ".btn-upload",
				url: "",
				data: {
					filepath: function() {
						return $("#filepath").val();
					}
				},
				accept: "file",
				done: function(result) {

				},
				error: function() {
					layer.msg("服务器繁忙", {
						icon: 5
					});
				}
			});

			// 文件下载
			$(".btn-download").click(function() {
				console.log("下载");
			});

			// tool
			table.on("tool(data-table)", function(obj) {
				if (obj.event = "del") {
					console.log(obj);
					// TODO 
					console.log("删除");
				}
			});

		})
