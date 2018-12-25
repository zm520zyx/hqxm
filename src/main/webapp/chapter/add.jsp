<%@page pageEncoding="UTF-8"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/func.js"></script>
<script type="text/javascript">
//表单的初始化
$(function(){

   $("#title").textbox({
       required:true
   });
$("#uploadDate").datebox({
		required:true,
		editable:false,
   });
    $("#addFormSaveBtn2").linkbutton({
        iconCls:"icon-save",
        onClick:function(){
            $("#addForm2").form("submit", {
                url:"${pageContext.request.contextPath }/chapter/add?aid="+data.id,
                onSubmit:function(){
                    return $("#addForm2").form("validate");
                },
                success:function(){
                    $.messager.show({
                        title:"系统提示",
                        msg:"添加成功！"
                    });
                    $("#album").treegrid("load");
                    $("#Dialog4").dialog("close");
                },
            });
        }
    });

});
</script>
  	<h3>添加</h3>
  	<form id="addForm2" method="post" enctype="multipart/form-data">
  		标&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;题：<input id="title" name="title"/><br/>
  		音&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;频：<input type="file" id="file" name="file"/><br/>
		上传日期：<input id="uploadDate"  name="uploadDate"/><br/>
	</form>





