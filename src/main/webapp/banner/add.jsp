<%@page pageEncoding="UTF-8"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/func.js"></script>
<script type="text/javascript">
//表单的初始化
   $("#title").textbox({
		required:true
   });
   $("#imgPath").validatebox({
		required:true
   });
   $("#status").validatebox({
    required:true
});
  $("#description").validatebox({
    required:true
  });
$("#pubDate").datebox({
		required:true,
		editable:false,
   });    
</script>
  	<h3>添加</h3>
  	<form id="addBannerForm" method="post" enctype="multipart/form-data">
  		标&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;题：<input id="title" name="title"/><br/>
  		图片上传：<input type="file" id="imgPath" name="file"/><br/>
		状&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;态：<input id="status" name="status"/><br/>
		上传日期：<input id="pubDate"  name="pubDate"/><br/>
		描&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;述：<input id="description" name="description"/><br/>
	</form>

