<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>AdminLTE 2 | Morris.js Charts</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <!-- Bootstrap 3.3.7 -->
    <link rel="stylesheet" href="${ctx!}/css/bootstrap.min.css">
    <link href="${ctx!}/js/plugins/layui/css/layui.css" rel="stylesheet" />
    <!-- font-awesome.css -->
    <link href="${ctx!}/css/font-awesome.css" rel="stylesheet" />
    <!-- animate.css -->
    <link href="${ctx!}/css/animate.min.css" rel="stylesheet" />
    <!-- 本页样式 -->
    <link href="${ctx!}/css/main.css" rel="stylesheet" />
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
</head>
<body class="hold-transition skin-blue sidebar-mini">
<section class="row">
    <div class="col-md-6">
        <!-- DONUT CHART -->
        <div class="box box-info">
            <div class="box-header with-border">
                <h3 class="box-title">类别统计</h3>
            </div>

            <div class="box-body chart-responsive">
                <div class="chart" id="sales-chart1" style="height: 300px; position: relative;"></div>
            </div>
            <!-- /.box-body -->
        </div>
    </div>

    <div class="col-md-6">
        <!--  DONUT CHART -->
        <div class="box box-info">
            <div class="box-header with-border">
                <h3 class="box-title">学院统计</h3>
            </div>
            <div class="box-body chart-responsive">
                <div class="chart" id="sales-chart2" style="height: 300px; position: relative;"></div>
            </div>
            <!-- /.box-body -->
        </div>
    </div>

</section>

<section class="row">
    <div class="col-md-6">
        <!-- <!-- DONUT CHART -->
        <div class="box box-info">
            <div class="box-header with-border">
                <h3 class="box-title">年份统计</h3>
            </div>

            <div class="box-body chart-responsive">
                <div class="chart" id="sales-chart3" style="height: 300px; position: relative;"></div>
            </div>
            <!-- /.box-body -->
        </div>
    </div>

    <#--<div class="col-md-6">-->
        <#--<!-- <!-- DONUT CHART &ndash;&gt;-->
        <#--<div class="box box-info">-->
            <#--<div class="box-header with-border">-->
                <#--<h3 class="box-title">Donut Chart</h3>-->
            <#--</div>-->
            <#--<div class="box-body chart-responsive">-->
                <#--<div class="chart" id="sales-chart2" style="height: 300px; position: relative;"></div>-->
            <#--</div>-->
            <#--<!-- /.box-body &ndash;&gt;-->
        <#--</div>-->
    <#--</div>-->

</section>
<div class="control-sidebar-bg"></div>
</div>
<!-- ./wrapper -->

<!-- jQuery 3 -->
<script src="${ctx!}/js/jquery.js"></script>
<!-- Bootstrap 3.3.7 -->
<script src="${ctx!}/js/bootstrap.min.js"></script>
<!-- Morris.js charts -->
<script src="${ctx!}/js/raphael.min.js"></script>
<script src="${ctx!}/js/morris.min.js"></script>
<script src="${ctx!}/js/plugins/layui/layui.js"></script>


<!-- page script -->
<script>
    $(document).ready(function(){
       getData();
    });

    function initChart(data) {
        console.log(data);
        var chart1 = data.type;
        var chart2 = data.deptMap;
        var chart3 = data.year;
        console.log(chart1);
        console.log(chart2);
        console.log(chart3);
        //DONUT CHART
        var donut = new Morris.Donut({
            element: 'sales-chart1',
            resize: true,
            colors: ["#3c8dbc", "#f56954", "#00a65a"],
            data:chart1,
            hideHover: 'auto'
        });

        //DONUT CHART
        var donut = new Morris.Donut({
            element: 'sales-chart2',
            resize: true,
            colors: ["#3c8dbc", "#f56954", "#00a65a"],
            data: chart2,
            hideHover: 'auto'
        });

        var donut = new Morris.Donut({
            element: 'sales-chart3',
            resize: true,
            colors: ["#3c8dbc", "#f56954", "#00a65a"],
            data: chart3,
            hideHover: 'auto'
        });
    }

   function getData() {
        layui.define([ 'layer'], function (exports) {
            var $ = layui.jquery;
            $.ajax({
                type: "POST",
                dataType: "json",
                url: "/graph/type",
                success: function(ret){
                    if(ret.isOk){
                        console.log(ret.msg);
                        // layer.msg("操作成功", {time: 2000},function(){
                        //     return ret.msg;
                        // });
                        initChart(ret.msg);
                    }else{
                        layer.msg(ret.msg, {time: 2000});
                    }
                }
            });
        });
    }
</script>
</body>
</html>
