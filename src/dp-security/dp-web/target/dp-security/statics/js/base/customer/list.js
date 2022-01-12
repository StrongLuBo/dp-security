/**
 * 客户管理js
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
		url: '/base/customer/listPage?_' + $.now(),
		height: $(window).height()-54,
		queryParams: function(params){
			params.cName = vm.cName;
			params.cMobile = vm.cMobile;
			params.cStatus = vm.cStatus;
			return params;
		},
		columns: [{
			checkbox: true
		}, {
			field : "customerId",
			title : "客户ID",
			width : "50px"
		}, {
			field : "cName",
			title : "客户名称",
			width : "200px"
		}, {
			field : "cMobile",
			title : "联系电话",
			width : "200px"
		},{
			field : "cAddress",
			title : "家庭地址",
			width : "200px"
		},{
			field : "cStatus",
			title : "客户状态",
			width : "200px",
		 formatter: function(value,row,index){
				if(value === 0){
					return '启用';
				}
				if(value === 1){
					return '禁用';
				}
			}
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
		cName: null,
		cMobile: null,
		cStatus: null
	},
	methods : {
		load: function() {
			$('#dataGrid').bootstrapTable('refresh');
		},
		save: function() {
			dialogOpen({
				title: '新增客户',
				url: 'base/customer/add.html?_' + $.now(),
				width: '620px',
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
					title: '编辑客户',
					url: 'base/customer/edit.html?_' + $.now(),
					width: '620px',
					height: '420px',
					success: function(iframeId){
						top.frames[iframeId].vm.customer.customerId = ck[0].customerId;
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
					ids[idx] = item.customerId;
				});
				$.RemoveForm({
					url: '/base/customer/remove?_' + $.now(),
			    	param: ids,
			    	success: function(data) {
			    		vm.load();
			    	}
				});
			}
		},
	}
})