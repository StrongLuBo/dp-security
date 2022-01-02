/**
 * 编辑-订单管理js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
		repertory: {}
	},
	beforeMount: function (){
		this.editSelect();
	},
	mounted:function(){
		// $("#checkbox01").prop("checked",true);
		// this.editSelect();
	},
	methods : {
		setForm: function() {
			$.SetForm({
				url: '/base/repertory/findById?_' + $.now(),
		    	param: vm.repertory.id,
		    	success: function(data) {
					vm.repertory = data;
					vm.repertory.materialName=data.tmMaterialId+'-'+data.materialName;
					// $("#materialList  option[value='"+data.tmMaterialId+"-"+data.materialName+"'] ").attr("selected",true)

		    	}
			});
		},
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.ConfirmForm({
		    	url: '/base/repertory/update?_' + $.now(),
		    	param: vm.repertory,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		},
		editSelect: function (){
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