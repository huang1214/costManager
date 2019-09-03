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
    <legend style="text-align:center;">老师信息</legend>

    <button class="layui-btn" style="position: relative;float: right;right: 100px;" onclick="javascript:location.replace(location.href)">
        <i class="layui-icon">&#x1002;</i>
    </button>
    <div class="layui-row">
        <div class="layui-form layui-col-md12 star-so">


            <input class="layui-input" placeholder="请输入姓名或者工号" name="keyword" id="keyword">

            <div class="layui-input-inline">
                <select name="displayName" id="dept" lay-filter="dept" placeholder="请选择院系">
                    <option value="">请选择院系</option>
                <#list depts as x>
                    <option >${x.name}</option>
                </#list>
                </select>
            </div>

            <button class="layui-btn" id="search" "><i class="layui-icon">&#xe615;</i></button>
        </div>
    </div>
    <div class="layui-field-box">
        <div id="dataContent">
            <table class="layui-hide" id="teacherinfo" lay-filter="table"></table>
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
    layui.define([ 'layer',  'table','form'], function (exports) {
        var $ = layui.jquery,
                form = layui.form,
                table  = layui.table ;

        var dept,keyword='';

        table.render({
            elem: '#teacherinfo'
            ,height: 'full-200'
            ,method:'GET'
            ,url: '/teacher/list' //数据接口
            ,page: true //开启分页
            ,cols: [[ //表头
                {type: 'checkbox', align:'center',unresize:true}
                ,{field: 'num', align:'center', title: '老师编号',unresize:true}
                ,{field: 'name', align:'center', title: '老师姓名',unresize:true}
                ,{field: 'sex', align:'center', title: '性别',unresize:true}
                ,{field: 'phone', align:'center', title: '电话',unresize:true}
                ,{field: 'dept', align:'center', title: '所属院系',unresize:true,templet: '<div>{{d.dept.name}}</div>'}
                ,{field: 'title', align:'center', title: '职位',unresize:true}
                ,{field: 'address', align:'center', title: '地址',unresize:true}
            ]]
        });
        // function createHtml(obj) {
        //     var packageType;
        //     var data = obj.data;
        //     var expert = data.expert;
        //     var ephone,eaddress,eresume,ereason,areason;
        //     if(expert == null){
        //         ephone ='此项目还未分配专家审核';
        //         eaddress = '此项目还未分配专家审核';
        //         eresume ='此项目还未分配专家审核';
        //         ereason = '此项目还未分配专家审核';
        //         areason = '此项目还未通过专家审核';
        //     }else{
        //         ephone = data.expert.phone;
        //         eaddress = data.expert.address;
        //         eresume = data.expert.resume;
        //         ereason = data.ereason;
        //         areason = data.areason;
        //     }
        //     var detailHtml = '';
        //     detailHtml += '<tr class="detail-view" style="display: none" id="detail-view-'+data.id+'">';
        //     detailHtml += '<td colspan="10"><blockquote class="layui-elem-quote" style="line-height: 30px;text-align:left;padding-left: 30px;">';
        //     detailHtml += '<div class="layui-inline layui-word-aux" style="width: 150px">指导老师工号:</div>'+data.teacher.num+'</br>';
        //     detailHtml += '<div class="layui-inline layui-word-aux" style="width: 150px">指导老师姓名:</div>'+data.teacher.name+'</br>';
        //     detailHtml += '<div class="layui-inline layui-word-aux" style="width: 150px">评审专家工号:</div>'+expert.num+'</br>';
        //     detailHtml += '<div class="layui-inline layui-word-aux" style="width: 150px">评审专家姓名:</div>'+expert.name+'</br>';
        //     detailHtml += '<div class="layui-inline layui-word-aux" style="width: 150px">项目描述:</div>'+data.desc+'</br>';
        //     detailHtml += '<div class="layui-inline layui-word-aux" style="width: 150px">创意说明书下载地址:</div><a href="'+data.book.downloadUrl+'">'+data.book.downloadUrl+'</a></br>';
        //     detailHtml += '<div class="layui-inline layui-word-aux" style="width: 150px">展示视频下载地址:</div><a href="'+data.video.downloadUrl+'">'+data.video.downloadUrl+'</a></br>';
        //     detailHtml += '</blockquote></td></tr>';
        //     obj.tr.after(detailHtml);
        // }
        //搜索
        $('#search').click(function () {
            keyword = $("#keyword").val();
            table.reload('teacherinfo', {
                url: "/teacher/search"
                ,where: {keyword:keyword,dept:dept} //设定异步数据接口的额外参数
                //,height: 300
            });
        });

        form.on('select(dept)', function(data){
            dept = data.value;
        });

    });
</script>
</body>
</html>