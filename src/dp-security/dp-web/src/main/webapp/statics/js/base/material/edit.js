/**
 * 编辑-客户管理js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
		material: {}
	},
	methods : {
		setForm: function() {
			$.SetForm({
				url: '/base/material/findById?_' + $.now(),
		    	param: vm.material.id,
		    	success: function(data) {
		    		vm.material = data;
		    	}
			});
		},
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.ConfirmForm({
		    	url: '/base/material/update?_' + $.now(),
		    	param: vm.material,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	}
})