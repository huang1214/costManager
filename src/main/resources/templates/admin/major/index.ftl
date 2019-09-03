<!DOCTYPE html>

<html>
<head>
    <meta charset="utf-8" />
    <title>数据列表页面</title>
    <!-- layui.css -->
    <link href="${ctx!}/js/plugins/layui/css/layui.css" rel="stylesheet" />
    <style>

        tr td:not(:nth-child(0)),
        tr th:not(:nth-child(0)) {
            text-align: center;
        }

        /*可选*/
        .layui-laypage > * {
            float: left;
        }
        .layui-field-title .layui-field-box{
            padding: 10px 0px 10px 30px;
        }
        .layui-table-cell{
            padding-top: 4px;
            height: 45px;
        }

    </style>
</head>
<body>

<fieldset id="dataList" class="layui-elem-field layui-field-title sys-list-field">
    <legend style="text-align:center;">专业列表</legend>

    <div style="padding: 40px 0px 0px 80px;">
        <div class="layui-inline">
            <div class="layui-input-inline" style="width:auto">
                <a id="addMajor" class="layui-btn layui-btn-normal">添加专业</a>
            </div>
        </div>

        <#--<div class="layui-inline">-->
            <#--<div class="layui-input-inline" style="width:auto">-->
                <#--<a id="deleteAll" class="layui-btn layui-btn-normal">批量删除</a>-->
            <#--</div>-->
        <#--</div>-->
    </div>


    <div class="layui-field-box">
        <div id="dataContent" class="">
            <table class="layui-hide" id="major" lay-filter="table"></table>
            <script type="text/html" id="operator">
                <a class="layui-btn" lay-event="edit">编辑</a>
                <a class="layui-btn layui-btn-danger " lay-event="del">删除</a>
            </script>

            <#--<script type="text/html" id="choicesTpl">-->

                <#--<form class="layui-form" action="">-->
                    <#--<div class="layui-form-item" style="margin:0;">-->
                        <#--{{#  if(d.status == 1){ }}-->
                        <#--<input type="checkbox" name="status" title="是" value="{{d.id}}" lay-filter="status"  checked  />-->
                        <#--{{#  } else { }}-->
                        <#--<input type="checkbox" name="status" title="否" value="{{d.id}}" lay-filter="status" />-->
                        <#--{{#  } }}-->
                    <#--</div>-->
                <#--</form>-->
                <#--&lt;#&ndash;<button class="layui-btn layui-btn-small layui-btn-normal" onclick="layui.datalist.editData({{d.id}})"><i class="layui-icon">&#xe642;</i></button>&ndash;&gt;-->
            <#--</script>-->
        </div>
    </div>
</fieldset>

<!-- layui.js -->
<script src="${ctx!}/js/plugins/layui/layui.js"></script>

<!-- layui规范化用法 -->
<script type="text/javascript">
    layui.config({
        base: '${ctx}/js/admin/'
    }).use('major/index');
</script>
</body>
</html>