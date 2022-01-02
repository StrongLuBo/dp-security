/**
 * 入库记录js
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
		url: '/base/repertory/listPage?_' + $.now(),
		height: $(window).height()-54,
		queryParams: function(params){
			params.status = vm.status;
			params.materialName = vm.materialName;
			return params;
		},
		columns: [{
			checkbox: true
		}, {
			field : "id",
			title : "入库记录ID",
			width : "50px"
		}, {
			field : "status",
			title : "状态",
			width : "200px",
			formatter: function(value,row,index){
				if(value === 0){
					return '入库';
				}
				if(value === 1){
					return '出库';
				}
			}
		}, {
			field : "num",
			title : "数量",
			width : "200px"
		},{
			field : "tmMaterialId",
			title : "材料ID",
			width : "200px"
		},{
			field : "materialName",
			title : "材料名称",
			width : "200px"
		},{
			field : "remarks",
			title : "备注",
			width : "250px"
		},{
			field : "createTime",
			title : "创建时间",
			width : "200px"
		},{
			field : "createUser",
			title : "创建用户",
			width : "200px"
		},{
			field : "updateTime",
			title : "更新时间",
			width : "200px"
		},{
			field : "updateUser",
			title : "更新用户",
			width : "200px"
		}]
	})
}

var vm = new Vue({
	el:'#dpLTE',
	data: {
		status: null,
		materialName: null
	},
	methods : {
		load: function() {
			$('#dataGrid').bootstrapTable('refresh');
		},
		save: function() {
			dialogOpen({
				title: '新增入库记录',
				url: 'base/repertory/add.html?_' + $.now(),
				width: '420px',
				height: '420px',
				yes : function(iframeId) {
					top.frames[iframeId].vm.acceptClick();
				},
			});
		},
		edit: function() {
			var ck = $('#dataGrid').bootstrapTable('getSelections');
			if(checkedRow(ck)){
				dialogOpen({
					title: '编辑入库记录',
					url: 'base/repertory/edit.html?_' + $.now(),
					width: '420px',
					height: '420px',
					success: function(iframeId){
						top.frames[iframeId].vm.repertory.id = ck[0].id;
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
					url: '/base/repertory/remove?_' + $.now(),
			    	param: ids,
			    	success: function(data) {
			    		vm.load();
			    	}
				});
			}
		},
	}
})