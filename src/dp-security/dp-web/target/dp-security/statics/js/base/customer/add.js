/**
 * 新增-客户管理js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
		customer: {}
	},
	methods : {
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.SaveForm({
		    	url: '/base/customer/save?_' + $.now(),
		    	param: vm.customer,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	}
})
