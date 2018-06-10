<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<script type="text/javascript">
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('main'));
    var tableDate;
    $.ajax({
        url:"/user/userCount",
        type:"post",
        success:function (date) {
            // 指定图表的配置项和数据
            var option = {
                title: {
                    text: '各月份用户注册统计'
                },
                tooltip: {},
                legend: {
                    data:['人数']
                },
                xAxis: {
                    data: date.month,
                },
                yAxis: {},
                series: [{
                    name: '人数',
                    type: 'bar',
                    data: date.count,
                }]
            };

            // 使用刚指定的配置项和数据显示图表。
            myChart.setOption(option);
        }
    });




</script>












<!-- 为 ECharts 准备一个具备大小（宽高）的 DOM -->
<div id="main" style="width: 200px;height:400px;"></div>
