<%@page pageEncoding="UTF-8" %>
<script type="text/javascript">

    $(function(){
        $("#title").textbox({
            required:true
        });

        $("#count").textbox({
            required:true,
        });

        $("#covreImg").validatebox({
            required:true,
        });

        $("#saleCount").textbox({
            required:true
        });

        $("#score").textbox({
            required:true,
        });
        $("#author").textbox({
            required:true,
        });
        $("#broadcast").textbox({
            required:true,
        });
        $("#brief").textbox({
            required:true,
        });
        $("#pubDate").datebox({
            required:true,
            editable:false,
        });


    })

</script>

<h3>更新联系人</h3>
<form  id="addform" method="post" enctype="multipart/form-data" >

    标&nbsp;&nbsp;题：<input id="title" name="title"/><br/>
    章节数：<input id="count" name="count" /><br/>
    图&nbsp;&nbsp;片 ：<input type="file" id="covreImg" name="file"/> <br/>
    评&nbsp;&nbsp;分：<input id="score"  name="score" /> <br/>
    作&nbsp;&nbsp;者：<input id="author"  name="author" /> <br/>
    波&nbsp;&nbsp;音：<input id="broadcast"  name="broadcast" /> <br/>
    描&nbsp;&nbsp;述：<input id="brief"  name="brief" /> <br/>
    日&nbsp;&nbsp;期：<input id="pubDate"  name="pubDate" /> <br/>
</form>

