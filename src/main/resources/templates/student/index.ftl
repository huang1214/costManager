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
        .star-so{
             text-align: center;
             margin-bottom: 10px;
             margin-top: 40px;
        }
        .star-so input.layui-input{
            width: 200px;
            display: inline-block;
        }
    </style>
</head>
<body>

<fieldset id="dataList" class="layui-elem-field layui-field-title sys-list-field">
    <legend style="text-align:center;">我的项目</legend>

    <button class="layui-btn" style="position: relative;float: right;right: 100px;" onclick="javascript:location.replace(location.href)">
        <i class="layui-icon">&#x1002;</i>
    </button>
    <#--<div class="layui-row">-->
        <#--<div class="layui-form layui-col-md12 star-so">-->
            <#--<input class="layui-input" placeholder="请输入关键字" name="keyword">-->

            <#--<button class="layui-btn" id="search" "><i class="layui-icon">&#xe615;</i></button>-->
        <#--</div>-->
    <#--</div>-->
    <div style="padding: 40px 0px 0px 80px;">
        <div class="layui-inline">
            <div class="layui-input-inline" style="width:auto">
                <#--<a id="addProject" class="layui-btn layui-btn-normal">添加</a>-->
            </div>
        </div>
    </div>


    <div class="layui-field-box">
        <div id="dataContent" class="">
            <table class="layui-hide" id="student" lay-filter="table"></table>
            <script type="text/html" id="operator">
                <a class="layui-btn layui-btn-normal" lay-event="detail">查看</a>
                <a class="layui-btn" lay-event="edit">编辑</a>
                <a class="layui-btn layui-btn-danger " lay-event="del">删除</a>
            </script>
            <script type="text/html" id="status">
                <form class="layui-form" action="">
                    <div class="layui-form-item" style="margin:0;">
                        {{#  if(d.tstatus == 1){ }}
                        <input type="checkbox" name="tstatus" title="老师审核" value="{{d.id}}" lay-skin="primary" lay-filter="tstatus" checked disabled/>
                        {{#  } else if (d.tstatus == 2 ){ }}
                        <input type="checkbox" name="tstatus" title="老师拒绝" value="{{d.id}}" lay-filter="tstatus" lay-skin="primary" checked disabled/>
                        {{# }else { }}
                        <input type="checkbox" name="tstatus" title="老师审核" value="{{d.id}}" lay-filter="tstatus" lay-skin="primary" disabled/>
                        {{#  } }}
                        {{#  if(d.estatus == 1){ }}
                        <input type="checkbox" name="estatus" title="专家审核" value="{{d.id}}" lay-skin="primary" lay-filter="estatus" checked disabled/>
                        {{#  } else if(d.estatus == 2) { }}
                        <input type="checkbox" name="estatus" title="专家拒绝" value="{{d.id}}" lay-filter="estatus" lay-skin="primary" checked disabled/>
                        {{#  } else { }}
                        <input type="checkbox" name="estatus" title="专家审核" value="{{d.id}}" lay-filter="estatus" lay-skin="primary" disabled/>
                        {{#  } }}
                    </div>
                </form>
                <#--<button class="layui-btn layui-btn-small layui-btn-normal" onclick="layui.datalist.editData({{d.id}})"><i class="layui-icon">&#xe642;</i></button>-->
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
    }).use('student/index');
</script>
</body>
</html>