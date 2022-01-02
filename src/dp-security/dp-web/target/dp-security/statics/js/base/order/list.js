/**
 * 订单管理js
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
		url: '/base/order/list?_' + $.now(),
		height: $(window).height()-54,
		queryParams: function(params){
			params.orderNo = vm.orderNo;
			params.customerName = vm.customerName;
			return params;
		},
		columns: [{
			checkbox: true
		}, {
			field : "orderId",
			title : "订单ID",
			width : "50px"
		}, {
			field : "orderNo",
			title : "订单编号",
			width : "200px"
		}, {
			field : "customerName",
			title : "客户名称",
			width : "200px"
		},{
			field : "orderStatus",
			title : "订单状态",
			width : "200px"
		},{
			field : "payMoneySum",
			title : "已支付金额",
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
		orderNo: null,
		customerName: null
	},
	methods : {
		load: function() {
			$('#dataGrid').bootstrapTable('refresh');
		},
		save: function() {
			dialogOpen({
				title: '新增角色',
				url: 'base/order/add.html?_' + $.now(),
				width: '420px',
				height: '320px',
				yes : function(iframeId) {
					top.frames[iframeId].vm.acceptClick();
				},
			});
		},
		edit: function() {
			var ck = $('#dataGrid').bootstrapTable('getSelections');
			if(checkedRow(ck)){
				dialogOpen({
					title: '编辑角色',
					url: 'base/order/edit.html?_' + $.now(),
					width: '420px',
					height: '320px',
					success: function(iframeId){
						top.frames[iframeId].vm.order.orderId = ck[0].orderId;
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
					ids[idx] = item.orderId;
				});
				$.RemoveForm({
					url: '/base/order/remove?_' + $.now(),
			    	param: ids,
			    	success: function(data) {
			    		vm.load();
			    	}
				});
			}
		},
	}
})