<%@page pageEncoding="UTF-8" %>
<script type="text/javascript">
        var data;
        var toolbar = [{
            iconCls: 'icon-tip',
            text: "专辑详情",
            handler: function () {
                 data = $("#album").treegrid("getSelected");

                if (data.children!= null) {
                    $("#Dialog").dialog("open");
                } else {
                    alert("请先选要查看的专辑")
                }

            }
        }, '-', {
            text: "添加专辑",
            iconCls: 'icon-edit',
            handler: function () {
                $("#Dialog3").dialog("open");

            }
        }, '-', {
            text: "添加音频",
            iconCls: 'icon-remove',
            handler: function () {
                data = $("#album").treegrid("getSelected");

                if (data != null) {
                    $("#Dialog4").dialog("open");
                } else {
                    alert("请先选择专辑")
                }

            }
        }, '-', {
            text: "音频下载",
            iconCls: 'icon-save',
            href: "",
            onClick: function () {
                data = $("#album").treegrid("getSelected");
                if (data.url!= null) {

                    $(this).prop("href","${pageContext.request.contextPath}/chapter/download?name="+data.url);
                } else {
                    alert("请先选择要下载的音频")
                }
            }
        },'-', {
            text: "文件导出",
            iconCls: 'icon-tip',
            handler: function () {
                $.get("${pageContext.request.contextPath}/album/outport",
                    function(){
                        $.messager.show({
                            title:"系统提示",
                            msg:"导入成功"
                        });
                    },"");
            }
            }]

    $(function () {
        $('#album').treegrid({
            url:'${pageContext.request.contextPath}/album/getAll',
            idField:'id',
            treeField:'title',
            columns:[[
                {field:'title',title:'名字',width:60},
                {field:'size',title:'大小',width:60},
                {field:'duration',title:'时长',width:60},
                {field:'url',title:'下载路径',width:60},
                {field:'uploadDate',title:'上传时间',width:60},
            ]],

            fitColumns:true,
            toolbar:toolbar,
            pagination: true,
            pageList: [1, 2, 3, 4, 5],
            pageSize: 5,
            onDblClickRow: function(index,row){
                $("#guGe").prop("src","${pageContext.request.contextPath}"+index.url);
            }

        });

        $("#Dialog").dialog({

            title: "专辑详情",
            width:400,
            height:600,
            closed:true,
            modal:true,
            cache:false,
            href:"${pageContext.request.contextPath}/album/zjxq.jsp"
        });

        $("#Dialog3").dialog({
            title: "添加商品",
            width:300,
            height:400,
            toolbar:"#hehe",
            closed:true,
            modal:true,
            cache:false,
            href:"${pageContext.request.contextPath}/album/add.jsp"
        });

        $("#Dialog4").dialog({
            title: "音频添加",
            width:300,
            height:300,
            toolbar:"#xixi",
            closed:true,
            modal:true,
            cache:false,
            href:"${pageContext.request.contextPath}/chapter/add.jsp"
        });

        $("#addFormSaveBtn").linkbutton({
            iconCls:"icon-save",
            onClick:function(){
                $("#addform").form("submit", {
                    url:"${pageContext.request.contextPath }/album/add",
                    onSubmit:function(){
                        return $("#addform2").form("validate");
                    },
                    success:function(){
                        $.messager.show({
                            title:"系统提示",
                            msg:"添加成功！"
                        });
                        $("#album").treegrid("load");
                        $("#Dialog3").dialog("close");
                    },
                });
            }
        });
    });
</script>


<table id="album">
    <audio id="guGe" controls="controls" width="50px" src="">
    </audio>
</table>



<div id="Dialog"></div>
<div id="Dialog3"></div>
<div id="Dialog4"></div>

<div id="hehe">
    <a  id="addFormSaveBtn">确认添加</a>
</div>

<div id="xixi">
    <a  id="addFormSaveBtn2">确认添加</a>
</div>


