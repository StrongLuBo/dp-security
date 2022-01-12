/**
 * 编辑-订单管理js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
		order: {}
	},
	mounted:function(){
		// $("#orderList  option[value='0'] ").attr("selected",true)
		this.editCustomerList();
	},
	methods : {
		setForm: function() {
			$.SetForm({
				url: '/base/order/findOrderById?_' + $.now(),
		    	param: vm.order.orderId,
		    	success: function(data) {
		    		vm.order = data;
					vm.order.customerName=data.customerId+'-'+data.customerName;
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
		},
		editCustomerList: function (){
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