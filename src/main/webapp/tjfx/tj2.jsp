<%@page pageEncoding="UTF-8" %>
<script type="text/javascript">
    $(function () {
        var myChart = echarts.init(document.getElementById('china'));
        option = {
            title : {
                text: '持名法洲APP用户分布图',
                subtext: '2018年12月25日 最新数据',
                left: 'center'
            },
            tooltip : {
                trigger: 'item'
            },
            legend: {
                orient: 'vertical',
                left: 'left',
                data:['总数量','男','女']
            },
            visualMap: {
                min: 0,
                max: 2500,
                left: 'left',
                top: 'bottom',
                text:['高','低'],           // 文本，默认为数值文本
                calculable : true
            },
            toolbox: {
                show: true,
                orient : 'vertical',
                left: 'right',
                top: 'center',
                feature : {
                    mark : {show: true},
                    dataView : {show: true, readOnly: false},
                    restore : {show: true},
                    saveAsImage : {show: true}
                }
            },
            series : [
                {
                    name: '总数量',
                    type: 'map',
                    mapType: 'china',
                    roam: false,
                    label: {
                        normal: {
                            show: false
                        },
                        emphasis: {
                            show: true
                        }
                    },
                    data:[]
                },
                {
                    name: '男',
                    type: 'map',
                    mapType: 'china',
                    roam: false,
                    label: {
                        normal: {
                            show: true
                        },
                        emphasis: {
                            show: true
                        }
                    },
                    data: []
                },
                {
                    name: '女',
                    type: 'map',
                    mapType: 'china',
                    roam: false,
                    label: {
                        normal: {
                            show: true
                        },
                        emphasis: {
                            show: true
                        }
                    },
                    data: []
                }
            ]
        };
        myChart.setOption(option)

        $.post("${pageContext.request.contextPath }/number/getNumber2",
            function(data){
                myChart.setOption({
                    series: [{
                        name: '总数量',
                        data: data
                    }]
                });
            },"json");

        $.post("${pageContext.request.contextPath }/number/getNumber3",
            function(data){
                myChart.setOption({
                    series: [{
                        name: '男',
                        data: data
                    }]
                });
            },"json");

        $.post("${pageContext.request.contextPath}/number/getNumber4",
            function(data){
                myChart.setOption({
                    series: [{
                        name: '女',
                        data: data
                    }]
                });
            },"json");
    });
</script>
<div id="china" style="width: 100%;height: 100%;margin-top: 30px;margin-left: 30px">

</div>