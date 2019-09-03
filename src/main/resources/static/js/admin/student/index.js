layui.define([ 'layer',  'table','common'], function (exports) {
    var $ = layui.jquery,
        layer = layui.layer,
        common = layui.common,
        table  = layui.table ;
    table.render({
        elem: '#student'
        ,height: 'full-200'
        ,method:'GET'
        ,url: '/admin/student/list' //数据接口
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
            ,{field: 'chairman', align:'center', title: '系主任',unresize:true,templet: '<div>{{d.major.dept.chairman}}</div>'}
            ,{fixed: 'right',  title:'操作',align:'center', toolbar: '#operator',unresize:true}
        ]]
    });

    //监听工具条
    table.on('tool(table)', function(obj){
        var data = obj.data;
        if(obj.event === 'del'){
            del(data.id);
        } else if(obj.event === 'edit'){
            common.frame_show('编辑','/admin/student/form?id='+data.id);
        }
    });

    //添加数据
    $('#addStudent').click(function () {
        var index = layer.load(1);
        setTimeout(function () {
            layer.close(index);
            common.frame_show('分类添加','/admin/student/form');
            // layer.msg('打开添加窗口');
        }, 500);
    });

    //批量删除数据
    $('#deleteAll').click(function () {
        var index = layer.load(1);

    });

    var dept,keyword,major='';
    $('#search').click(function () {
        keyword = $("#keyword").val();
        table.reload('student', {
            url: "/student/search"
            ,where: {keyword:keyword} //设定异步数据接口的额外参数
            // ,where: {keyword:keyword,dept:dept,major:major} //设定异步数据接口的额外参数
            //,height: 300
        });
    });

    //输出接口，主要是两个函数，一个删除一个编辑
    var datalist = {
        deleteData: function (id) {
            layer.confirm('确定删除？', {
                btn: ['确定', '取消'] //按钮
            }, function () {
                del(id);
            }, function () {

            });
        },
        editData: function (id) {
            common.frame_show('分类编辑','/admin/student/form?id='+id);
        }
    };
    function del(id) {
        layer.confirm('真的删除行么', function (index) {
            $.ajax({
                type: "DELETE",
                dataType: "json",
                url: "/admin/student/" + id + "/del",
                success: function (ret) {
                    if (ret.isOk) {
                        layer.msg("操作成功", {time: 2000}, function () {
                            layer.close(index);
                            window.location.href = "/admin/student/index";
                        });
                    } else {
                        layer.msg(ret.msg, {time: 2000});
                    }
                }
            });
        });
    }
    exports('admin/student/index', datalist);
});