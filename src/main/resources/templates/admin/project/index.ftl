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
            padding: 10px 20px 10px 30px;
        }
        .layui-table-cell{
            padding-top: 4px;
            height: 45px;
        }

    </style>
</head>
<body>

<fieldset id="dataList" class="layui-elem-field layui-field-title sys-list-field">
    <legend style="text-align:center;">我的项目列表</legend>

    <div class="layui-row">
        <button class="layui-btn" style="position: relative;float: right;right: 100px;" onclick="javascript:location.replace(location.href)">
            <i class="layui-icon">&#x1002;</i>
        </button>
    </div>

    <div class="layui-field-box">
        <div id="dataContent" class="">

            <table class="layui-hide" id="project" lay-filter="table"></table>
            <script type="text/html" id="status">
                <form class="layui-form" action="">
                    <div class="layui-form-item" style="margin:0;">
                        {{#  if(d.tstatus == 1){ }}
                        <input type="checkbox" name="tstatus" title="老师审核" value="{{d.id}}" lay-skin="primary" lay-filter="tstatus" checked disabled/>
                        {{#  } else { }}
                        <input type="checkbox" name="tstatus" title="老师审核" value="{{d.id}}" lay-filter="tstatus" lay-skin="primary" disabled/>
                        {{#  } }}
                        {{#  if(d.estatus == 1){ }}
                        <input type="checkbox" name="estatus" title="审核员审核" value="{{d.id}}" lay-skin="primary" lay-filter="estatus" checked disabled/>
                        {{#  } else { }}
                        <input type="checkbox" name="estatus" title="审核员审核" value="{{d.id}}" lay-filter="estatus" lay-skin="primary" disabled/>
                        {{#  } }}
                    </div>
                </form>
                <#--<button class="layui-btn layui-btn-small layui-btn-normal" onclick="layui.datalist.editData({{d.id}})"><i class="layui-icon">&#xe642;</i></button>-->
            </script>

            <script type="text/html" id="operator">
                {{#  if(d.tstatus == 1 && d.estatus == 1){ }}
                <a class="layui-btn layui-btn-normal" lay-event="detail">查看</a>
                <a class="layui-btn layui-btn-danger " lay-event="del">删除</a>
<#--                {{#  }else if(d.tstatus == 1 && d.estatus == 1 && d.asatus != 1 ) { }}-->
<#--                <a class="layui-btn layui-btn-normal" lay-event="detail">查看</a>-->
<#--                <a class="layui-btn layui-btn-danger " lay-event="del">删除</a>-->
                {{#  }else{ }}
                <a class="layui-btn layui-btn-normal" lay-event="detail">查看</a>
                {{# } }}
            </script>
        </div>
    </div>
</fieldset>

<!-- layui.js -->
<script src="${ctx!}/js/plugins/layui/layui.js"></script>
<!-- layui规范化用法 -->
<script type="text/javascript">
    layui.config({
        base: '${ctx}/js/'
    }).use('admin/project/index');
</script>
</body>
</html>