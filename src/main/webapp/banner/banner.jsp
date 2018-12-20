<%@page pageEncoding="UTF-8" %>
<script type="text/javascript">
    $(function () {
        var toolbar = [{
            iconCls: 'icon-add',
            text: "添加",
            handler: function () {
                $("#Dialog2").dialog("open");
            }
        }, '-', {
            text: "修改",
            iconCls: 'icon-edit',
            handler: function () {
                //获取选中行
                var row = $("#dg").edatagrid("getSelected");
                if (row != null) {
                    //编辑指定行
                    var index = $("#dg").edatagrid("getRowIndex", row);
                    $("#dg").edatagrid("editRow", index);
                } else {
                    alert("请先选中行")
                }
            }
        }, '-', {
            text: "删除",
            iconCls: 'icon-remove',
            handler: function () {
                //获取选中行
                var row = $("#dg").edatagrid("getSelected");
                if (row != null) {
                    var  id=row.id;
                    $.messager.confirm("删除对话框","确定删除？",
                        function(r){
                            if(r){
                                $.ajax({
                                    type:"GET",
                                    data:"id="+id,
                                    url:"${pageContext.request.contextPath}/banner/delete",
                                    success:function(result){
                                        $.messager.show({
                                            title:"系统提示",
                                            msg:"删除成功"
                                        });
                                        $("#dg").edatagrid("reload");
                                    }
                                });
                            }
                        });
                } else {
                    alert("请先选中行")
                }
            }
        }, '-', {
            text: "保存",
            iconCls: 'icon-save',
            handler: function () {
                $("#dg").edatagrid("saveRow")
            }
        }]

        $('#dg').edatagrid({
            method: "GET",
            updateUrl: "${pageContext.request.contextPath}/banner/update",
            url: '${pageContext.request.contextPath}/banner/getAll',
            fitColumns: true,
            fit: true,
            pagination: true,
            pageList: [1, 3, 5, 7, 9],
            pageSize: 5,
            toolbar: toolbar,
            view: detailview,
            detailFormatter: function (rowIndex, rowData) {
                return '<table><tr>' +
                    '<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}'+rowData.imgPath+'" style="height:50px;"></td>' +
                    '<td style="border:0">' +
                    '<p>描述: ' + rowData.description+'</p>' +
                    '<p>日期: ' + rowData.pubDate + '</p>' +
                    '</td>' +
                    '</tr></table>';
            }
        });

        $("#Dialog2").dialog({

            title: "添加分类",
            width:400,
            height:300,
            toolbar:"#save2",
            closed:true,
            modal:true,
            cache:false,
            href:"${pageContext.request.contextPath}/banner/add.jsp"
        });

        $("#savebut").linkbutton({
            iconCls:"icon-save",
            onClick:function(){
                $("#addBannerForm").form("submit", {
                    url:"${pageContext.request.contextPath }/banner/add",
                    onSubmit:function(){
                        return $("#addBannerForm").form("validate");
                    },
                    success:function(){
                        $.messager.show({
                            title:"系统提示",
                            msg:"添加成功！"
                        });
                        $("#dg").datagrid("load");
                        $("#Dialog2").dialog("close");
                    },
                });
            }
        });
    })



</script>

<table id="dg">
    <thead>
    <tr>
        <th data-options="field:'title', width:1">标题</th>
        <th data-options="field:'imgPath', width:1">图片路径</th>
        <th data-options="field:'status',width:1,editor:{type: 'text',options: {required:true}}">状态</th>
        <th data-options="field:'pubDate',width:1" >上传时间</th>
        <th data-options="field:'description',width:1" >描述</th>
    </tr>
</table>

<div id="Dialog2"></div>

<div id="save2">
    <a  id="savebut">点击添加</a>
</div>