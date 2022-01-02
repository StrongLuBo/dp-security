/**
 * 编辑-订单管理js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
		order: {}
	},
	methods : {
		setForm: function() {
			$.SetForm({
				url: '/base/order/findOrderById?_' + $.now(),
		    	param: vm.order.orderId,
		    	success: function(data) {
		    		vm.order = data;
		    	}
			});
		},
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.ConfirmForm({
		    	url: '/base/order/update?_' + $.now(),
		    	param: vm.order,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	}
})