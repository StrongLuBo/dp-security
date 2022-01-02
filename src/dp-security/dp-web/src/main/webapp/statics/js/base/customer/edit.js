/**
 * 编辑-客户管理js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
		customer: {}
	},
	methods : {
		setForm: function() {
			$.SetForm({
				url: '/base/customer/findCustomerById?_' + $.now(),
		    	param: vm.customer.customerId,
		    	success: function(data) {
		    		vm.customer = data;
		    	}
			});
		},
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.ConfirmForm({
		    	url: '/base/customer/update?_' + $.now(),
		    	param: vm.customer,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	}
})