<%@page pageEncoding="UTF-8" %>
<script type="text/javascript">
    $(function () {
        var myChart = echarts.init(document.getElementById('tj1'));
        // 指定图表的配置项和数据
        var option = {
            title: {
                text: '持名法州App注册用户'
            },
            tooltip: {},
            legend: {
                data:['用户数量']
            },
            xAxis: {
                data: ['近一周','近两周','近三周','近四周','近五周']
            },
            yAxis: {},
            series: [{
                name: '用户数量',
                type: 'bar',
                data: []
            }]
        };
        myChart.setOption(option);
        $.post("${pageContext.request.contextPath }/number/getNumber",
            function(data){
            console.log(data)
            myChart.setOption({
                series: [{
                    name: '用户数量',
                    data: data.data
                }]
            });
        },"json");
    });
</script>

<div id="tj1" style="width: 600px;height: 400px;;margin-top: 30px;margin-left: 30px"></div>
