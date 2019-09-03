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
    <legend style="text-align:center;">学生信息</legend>

    <button class="layui-btn" style="position: relative;float: right;right: 100px;" onclick="javascript:location.replace(location.href)">
        <i class="layui-icon">&#x1002;</i>
    </button>
    <div class="layui-row">
        <div class="layui-form layui-col-md12 star-so">
            <input class="layui-input" placeholder="请输入姓名或者工号" name="keyword" id="keyword">
            <button class="layui-btn" id="search" "><i class="layui-icon">&#xe615;</i></button>

        </div>
    </div>
    <div class="layui-field-box">
        <div id="dataContent">
            <table class="layui-hide" id="studentinfo" lay-filter="table"></table>
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

        var dept,keyword,major='';

        table.render({
            elem: '#studentinfo'
            ,height: 'full-200'
            ,method:'GET'
            ,url: '/student/list' //数据接口
            ,page: true //开启分页
            ,cols: [[ //表头
                {type: 'checkbox', align:'center',unresize:true}
                ,{field: 'num', align:'center', title: '学生编号',unresize:true}
                ,{field: 'name', align:'center', title: '学生姓名',unresize:true}
                ,{field: 'sex', align:'center', title: '性别',unresize:true}
                ,{field: 'phone', align:'center', title: '电话',unresize:true}
                ,{field: 'dept', align:'center', title: '所属院系',unresize:true,templet: '<div>{{d.major.dept.name}}</div>'}
                ,{field: 'major', align:'center', title: '所属专业',unresize:true,templet: '<div>{{d.major.name}}</div>'}
                ,{field: 'sclass', align:'center', title: '班级',unresize:true}
                ,{field: 'chairman', align:'center', title: '辅导员',unresize:true,templet: '<div>{{d.major.dept.chairman}}</div>'}
            ]]
        });

        // form.on('select(depts)', function(data) {
        //     var select = $("[name='major']");
        //     dept = data.value;
        //     select.empty();
        //     $.ajax({
        //         type: "GET",
        //         data: {"id": data.value},
        //         url: "/major/dept",
        //         async: false,
        //         success: function (ret) {
        //             var option = '';
        //             var data = ret.majors;
        //             for (var i = 0; i < data.length; i++) {
        //                 option += '<option value="' + data[i].name + '">' + data[i].name + '</option></br>';
        //             }
        //             select.append(option);
        //             form.render('select', 'form');
        //         }
        //     });
        //
        // });
        //搜索
        $('#search').click(function () {
            keyword = $("#keyword").val();
            table.reload('studentinfo', {
                url: "/student/search"
                ,where: {keyword:keyword} //设定异步数据接口的额外参数
                // ,where: {keyword:keyword,dept:dept,major:major} //设定异步数据接口的额外参数
                //,height: 300
            });
        });

        // form.on('select(majors)', function(data){
        //     major = data.value;
        // });
    });
</script>
</body>
</html>