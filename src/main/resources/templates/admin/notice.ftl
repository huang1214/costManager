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
    <legend style="text-align:center;">我的消息</legend>

    <div class="layui-row">
        <div class="layui-form layui-col-md12 star-so">
            <button class="layui-btn" style="position: relative;float: right;right: 100px;" onclick="javascript:location.replace(location.href)">
                <i class="layui-icon">&#x1002;</i>
            </button>
        </div>
    </div>

    <div class="layui-field-box">
        <div id="dataContent" class="">

            <table class="layui-hide" id="notice" lay-filter="table"></table>
            <script type="text/html" id="operator">
                <a class="layui-btn layui-btn-danger " lay-event="del">删除</a>
            </script>
        </div>
    </div>
</fieldset>

<!-- layui.js -->
<script src="${ctx!}/js/plugins/layui/layui.js"></script>
<!-- layui规范化用法 -->
<script type="text/javascript">
    layui.define([ 'layer',  'table'], function (exports) {
        var $ = layui.jquery,
                table = layui.table;
        table.render({
            elem: '#notice'
            , height: 'full-200'
            , method: 'GET'
            , url: '/notice/2' //数据接口
            , page: true //开启分页
            , cols: [[ //表头
                {field: 'projectName', align: 'center', title: '项目名', unresize: true}
                , {field: 'operation', align: 'center', title: '操作', unresize: true}
                , {field: 'status', align: 'center', title: '状态', unresize: true}
                , {field: 'content', align: 'center', title: '内容', unresize: true}
                , {field: 'date', align: 'center', title: '日期', unresize: true}
                ,{fixed: 'right',  title:'操作',align:'center', toolbar: '#operator',unresize:true}
            ]]
        });

        //监听工具条
        table.on('tool(table)', function (obj) {
            var data = obj.data;
            if (obj.event === 'del') {
                del(data.id);
            }
        });

        function del(id) {
            layer.confirm('真的删除行么', function (index) {
                $.ajax({
                    type: "DELETE",
                    dataType: "json",
                    url: "/student/notice/" + id + "/del",
                    success: function (ret) {
                        if (ret.isOk) {
                            layer.msg("操作成功", {time: 2000}, function () {
                                layer.close(index);
                                window.location.href = "/student/notice";
                            });
                        } else {
                            layer.msg(ret.msg, {time: 2000});
                        }
                    }
                });
            });
        }
    });
</script>
</body>
</html>