/**
 * 新增-订单管理js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
		repertory: {status: 0}
	},
	mounted:function(){
		$("#checkbox01").prop("checked",true);
		this.createMaterialList();
	},
	methods : {
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.SaveForm({
		    	url: '/base/repertory/save?_' + $.now(),
		    	param: vm.repertory,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	},
				error: function (data){
					dialogAlert(data);
				}
		    });
		},
		createMaterialList: function (){
			$.ajax({
				type:'get',
				url: '/base/material/findSelectAll',
				datatype:'json',
				success:function (data){
					for (var i = 0; i < data.length; i++) {
						$("#materialList").append('<option value='+data[i].id+'-'+data[i].materialName+'>'+data[i].materialName+'</option>')
					}
				}
			})

		}
	}
})
