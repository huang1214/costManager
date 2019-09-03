layui.define([ 'layer',  'table','common','form'], function (exports) {
    var $ = layui.jquery,
        layer = layui.layer,
        common = layui.common,
        form = layui.form,
        table  = layui.table ;
    table.render({
        elem: '#teacher'
        ,height: 'full-200'
        ,method:'GET'
        ,url: '/admin/teacher/list' //数据接口
        ,page: true //开启分页
        ,cols: [[ //表头
            {field: 'num', align:'center', title: '老师编号',unresize:true}
            ,{field: 'name', align:'center', title: '老师姓名',unresize:true}
            ,{field: 'sex', align:'center', title: '性别',unresize:true}
            ,{field: 'phone', align:'center', title: '电话',unresize:true}
            ,{field: 'dept', align:'center', title: '所属院系',unresize:true,templet: '<div>{{d.dept.name}}</div>'}
            ,{field: 'title', align:'center', title: '职位',unresize:true}
            ,{field: 'address', align:'center', title: '地址',unresize:true}
            ,{fixed: 'right',  title:'操作',align:'center', toolbar: '#operator',unresize:true}
        ]]
    });

    //监听工具条
    table.on('tool(table)', function(obj){
        var data = obj.data;
        if(obj.event === 'del'){
            del(data.id);
        } else if(obj.event === 'edit'){
            common.frame_show('编辑','/admin/teacher/form?id='+data.id);
        }
    });

    //添加数据
    $('#addTeacher').click(function () {
        var index = layer.load(1);
        setTimeout(function () {
            layer.close(index);
            common.frame_show('分类添加','/admin/teacher/form');
            // layer.msg('打开添加窗口');
        }, 500);
    });

    //批量删除数据
    $('#deleteAll').click(function () {
        var index = layer.load(1);

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
            common.frame_show('分类编辑','/admin/teacher/form?id='+id);
        }
    };
    function del(id) {
        layer.confirm('真的删除行么', function (index) {
            $.ajax({
                type: "DELETE",
                dataType: "json",
                url: "/admin/teacher/" + id + "/del",
                success: function (ret) {
                    if (ret.isOk) {
                        layer.msg("操作成功", {time: 2000}, function () {
                            layer.close(index);
                            window.location.href = "/admin/teacher/index";
                        });
                    } else {
                        layer.msg(ret.msg, {time: 2000});
                    }
                }
            });
        });
    }
    var dept,keyword='';
    $('#search').click(function () {
        keyword = $("#keyword").val();
        table.reload('teacher', {
            url: "/teacher/search"
            ,where: {keyword:keyword,dept:dept} //设定异步数据接口的额外参数
            //,height: 300
        });
    });

    form.on('select(dept)', function(data){
        dept = data.value;
    });

    exports('admin/teacher/index', datalist);
});