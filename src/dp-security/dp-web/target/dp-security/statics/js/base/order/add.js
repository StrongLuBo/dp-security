/**
 * 新增-订单管理js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
		order: {}
	},
	methods : {
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.SaveForm({
		    	url: '/base/order/save?_' + $.now(),
		    	param: vm.order,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	}
})
