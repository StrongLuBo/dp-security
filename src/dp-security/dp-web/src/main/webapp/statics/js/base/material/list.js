/**
 * 建材管理js
 */

$(function () {
	initialPage();
	getGrid();
});

function initialPage() {
	$(window).resize(function() {
		$('#dataGrid').bootstrapTable('resetView', {height: $(window).height()-54});
	});
}

function getGrid() {
	$('#dataGrid').bootstrapTableEx({
		url: '/base/material/listPage?_' + $.now(),
		height: $(window).height()-54,
		queryParams: function(params){
			params.name = vm.name;
			params.model = vm.model;
			return params;
		},
		columns: [{
			checkbox: true
		}, {
			field : "id",
			title : "材料ID",
			width : "50px"
		}, {
			field : "name",
			title : "材料名称",
			width : "200px"
		}, {
			field : "model",
			title : "材料型号",
			width : "200px"
		},{
			field : "specification",
			title : "材料规格",
			width : "100px"
		},{
			field : "unit",
			title : "单位",
			width : "100px",
		},{
			field : "price",
			title : "单价/(元)",
			width : "100px"
		},{
			field : "stocks",
			title : "库存量",
			width : "100px"
		},{
			field : "total",
			title : "总数量",
			width : "100px"
		},{
			field : "description",
			title : "描述",
			width : "400px"
		},{
			field : "cost",
			title : "赔偿金/(元)",
			width : "100px"
		},{
			field : "createTime",
			title : "创建时间",
			width : "350px"
		},{
			field : "createUser",
			title : "创建用户",
			width : "100px"
		},{
			field : "updateTime",
			title : "更新时间",
			width : "350px"
		},{
			field : "updateUser",
			title : "更新用户",
			width : "100px"
		}]
	})
}

var vm = new Vue({
	el:'#dpLTE',
	data: {
		name: null,
		model: null
	},
	methods : {
		load: function() {
			$('#dataGrid').bootstrapTable('refresh');
		},
		save: function() {
			dialogOpen({
				title: '新增建材',
				url: 'base/material/add.html?_' + $.now(),
				width: '500px',
				height: '600px',
				yes : function(iframeId) {
					top.frames[iframeId].vm.acceptClick();
				},
			});
		},
		edit: function() {
			var ck = $('#dataGrid').bootstrapTable('getSelections');
			if(checkedRow(ck)){
				dialogOpen({
					title: '编辑建材',
					url: 'base/material/edit.html?_' + $.now(),
					width: '500px',
					height: '600px',
					success: function(iframeId){
						top.frames[iframeId].vm.material.id = ck[0].id;
						top.frames[iframeId].vm.setForm();
					},
					yes: function(iframeId){
						top.frames[iframeId].vm.acceptClick();
					}
				});
			}
		},
		remove: function() {
			var ck = $('#dataGrid').bootstrapTable('getSelections'), ids = [];	
			if(checkedArray(ck)){
				$.each(ck, function(idx, item){
					ids[idx] = item.id;
				});
				$.RemoveForm({
					url: '/base/material/remove?_' + $.now(),
			    	param: ids,
			    	success: function(data) {
			    		vm.load();
			    	}
				});
			}
		},
	}
})