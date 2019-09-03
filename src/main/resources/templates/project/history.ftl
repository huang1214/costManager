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
    <legend style="text-align:center;">历史项目</legend>

    <button class="layui-btn" style="position: relative;float: right;right: 100px;" onclick="javascript:location.replace(location.href)">
        <i class="layui-icon">&#x1002;</i>
    </button>
    <div class="layui-row">
        <div class="layui-form layui-col-md12 star-so">
            <input class="layui-input" placeholder="请输入关键字" name="keyword" id="keyword">

            <button class="layui-btn" id="search" "><i class="layui-icon">&#xe615;</i></button>
        </div>
    </div>
    <div class="layui-field-box">
        <div id="dataContent">
            <table class="layui-hide" id="history" lay-filter="table"></table>
            <script type="text/html" id="status">
                <form class="layui-form">
                    <div class="layui-form-item" style="margin:0;">
                        {{#  if(d.tstatus == 1){ }}
                        <input type="checkbox" name="tstatus" title="备案审核" value="{{d.id}}" lay-skin="primary" lay-filter="tstatus" checked disabled/>
                        {{#  } else { }}
                        <input type="checkbox" name="tstatus" title="备案审核" value="{{d.id}}" lay-filter="tstatus" lay-skin="primary" disabled/>
                        {{#  } }}
                        {{#  if(d.estatus == 1){ }}
                        <input type="checkbox" name="estatus" title="报销审核" value="{{d.id}}" lay-skin="primary" lay-filter="estatus" checked disabled/>
                        {{#  } else { }}
                        <input type="checkbox" name="estatus" title="报销审核" value="{{d.id}}" lay-filter="estatus" lay-skin="primary" disabled/>
                        {{#  } }}
                    </div>
                </form>
            </script>
            <script type="text/html" id="operator">
                <a class="layui-btn layui-btn-normal" lay-event="detail">查看详情</a>
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
                table  = layui.table ;
        table.render({
            elem: '#history'
            ,height: 'full-200'
            ,method:'GET'
            ,url: '/project/all' //数据接口
            ,page: true //开启分页
            ,cols: [[ //表头
                {field: 'name', align:'center', title: '项目名',unresize:true}
                ,{field: 'genre', align:'center', title: '团队性质'}
                ,{field: 'type', align:'center', title: '项目类别',unresize:true,templet: '<div>{{d.type.name}}</div>'}
                ,{field: 'proResource', align:'center', title: '经费预算',unresize:true}
                ,{field: 'moneyResource', align:'center', title: '申请报销',unresize:true}
                ,{title: '项目状态',templet: '#status',unresize:true,width:250}
                ,{fixed: 'right',  title:'操作',align:'center', toolbar: '#operator',unresize:true}
            ]]
        });

        //监听工具条
        table.on('tool(table)', function(obj){
            var data = obj.data;
            if(obj.event === 'detail'){
                if($("#detail-view-"+data.id).length > 0){
                    $("#detail-view-"+data.id).hide();
                    $("#detail-view-"+data.id).remove();
                }else{
                    createHtml(obj);
                    $("#detail-view-"+data.id).show();
                }
            }
        });

        function createHtml(obj) {
            var data = obj.data;
            var expert = data.expert;
            var groups = data.groups;
            var ereason,treason,group;
            if(expert == null){
                ereason = '此项目还未分配专家审核';
            }else{
                ereason = data.ereason;
            }
            if(groups ==="个人赛无团队"){
                group = "此项目为个人赛";
            }else{
                group ="组员学号："+groups;
            }
            if(data.treason === null){
                treason = "教师还未审核";
            }else{
                treason = data.treason;
            }
            var detailHtml = '';
            detailHtml += '<tr class="detail-view" style="display: none" id="detail-view-'+data.id+'">';
            detailHtml += '<td colspan="10"><blockquote class="layui-elem-quote" style="line-height: 30px;text-align:left;padding-left: 30px;">';
            detailHtml += '<div class="layui-inline layui-word-aux" style="width: 150px">项目描述:</div>'+data.desc+'</br>';
            detailHtml += '<div class="layui-inline layui-word-aux" style="width: 150px">团队性质：</div>'+group+'</br>';
            detailHtml += '<div class="layui-inline layui-word-aux" style="width: 150px">项目任务书下载地址:</div><a href="'+data.book.downloadUrl+'">'+data.book.downloadUrl+'</a></br>';
            //detailHtml += '<div class="layui-inline layui-word-aux" style="width: 150px">展示视频下载地址:</div><a href="'+data.video.downloadUrl+'">'+data.video.downloadUrl+'</a></br>';
            detailHtml += '<div class="layui-inline layui-word-aux" style="width: 150px">指导教师工号:</div>'+data.teacher.num+'</br>';
            detailHtml += '<div class="layui-inline layui-word-aux" style="width: 150px">指导教师姓名:</div>'+data.teacher.name+'</br>';
            detailHtml += '<div class="layui-inline layui-word-aux" style="width: 150px">指导教师意见:</div>'+treason+'</br>';
            detailHtml += '<div class="layui-inline layui-word-aux" style="width: 150px">专家意见:</div>'+ereason+'</br>';
            detailHtml += '</blockquote></td></tr>';
            obj.tr.after(detailHtml);
        }
        //搜索
        $('#search').click(function () {
            var keyword = $("#keyword").val();
            table.reload('history', {
                url: "/search/project"
                ,where: {keyword:keyword} //设定异步数据接口的额外参数
                //,height: 300
            });
        });

    });
</script>
</body>
</html>