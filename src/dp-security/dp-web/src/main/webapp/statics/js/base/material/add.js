/**
 * 新增-客户管理js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
		material: {}
	},
	methods : {
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.SaveForm({
		    	url: '/base/material/save?_' + $.now(),
		    	param: vm.material,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	}
})
