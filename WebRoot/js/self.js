$(document).ready(function() {

	
 $("#deleteAll").click(function(){
	$("input[name='allDel']:checked").each(function() { // 遍历选中的checkbox
		 var id=$(this).parent().parent().children("td:eq(1)").html();
		 alert(id);
		 $.ajax({
		        url: "Schedule_deleteAll.action?id="+id,
		        // 数据发送方式
		        type: "post",
		        // 接受数据格式
		        dataType : "json",
		        // 要传递的数据
		        // data :params ,
		        // 回调函数，接受服务器端返回给客户端的值，即result值
		         success:function(data){  
		        	   window.location.reload();			          
		         }	
		       });	
    });
	 alert("删除成功！");
 })

})	
}
