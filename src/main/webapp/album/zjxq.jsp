<%@page pageEncoding="UTF-8" %>
<script type="text/javascript">

    $(function(){
        $("#updateform").form("load",data);

        $("#covreImg").prop("src","${pageContext.request.contextPath}"+data.covreImg);
    })

</script>

<h3>专辑详情</h3>
<form  id="updateform" method="post">
    编&nbsp;&nbsp;号：<input id="id"   name="id"  readonly="readonly"/><br/>
    姓&nbsp;&nbsp;名：<input id="title" name="title" readonly="readonly"/><br/>
    章节数：<input id="count" name="count" readonly="readonly"/><br/>
    图&nbsp;&nbsp;片 ：<img id="covreImg"  src="" readonly="readonly"/> <br/>
    评&nbsp;&nbsp;分：<input id="score"  name="score" readonly="readonly"/> <br/>
    作&nbsp;&nbsp;者：<input id="author"  name="author" readonly="readonly"/> <br/>
    波&nbsp;&nbsp;音：<input id="broadcast"  name="broadcast" readonly="readonly"/> <br/>
    描&nbsp;&nbsp;述：<input id="brief"  name="brief" readonly="readonly"/> <br/>
    日&nbsp;&nbsp;期：<input id="pubDate"  name="pubDate" readonly="readonly"/> <br/>
</form>

