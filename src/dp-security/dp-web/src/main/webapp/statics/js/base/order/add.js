/**
 * 新增-订单管理js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
		order: {}
	},
	mounted:function(){
		$("#orderList  option[value='0'] ").attr("selected",true)
		this.findCustomerList();
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
		},
		findCustomerList: function (){
			$.ajax({
				type:'get',
				url: '/base/customer/findCustomerAll',
				datatype:'json',
				success:function (data){
					for (var i = 0; i < data.length; i++) {
						$("#customerList").append('<option value='+data[i].customerId+'-'+data[i].cName+'>'+data[i].cName+'</option>')
					}
				}
			})
		}
	}
})
