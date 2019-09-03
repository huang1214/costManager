layui.define([ 'layer',  'table','common'], function (exports) {
    var $ = layui.jquery,
        layer = layui.layer,
        common = layui.common,
        table  = layui.table ;
    table.render({
        elem: '#allot'
        ,height: 'full-200'
        ,method:'GET'
        ,url: '/admin/allot/list' //数据接口
        ,page: true //开启分页
        ,cols: [[ //表头
            {field: 'pname', align:'center', title: '审核的项目名',unresize:true,templet: '<div>{{d.project.name}}</div>'}
            ,{field: 'ename', title: '审核员',unresize:true,templet: '<div>{{d.expert.name}}</div>'}
            ,{field: 'content', align:'center', title: '审核内容',unresize:true}
            ,{field: 'start', align:'center', title: '开始',unresize:true}
            ,{field: 'end', align:'center', title: '结束',unresize:true}
            ,{fixed: 'right',  title:'操作',align:'center', toolbar: '#operator',unresize:true}
        ]]
    });

    //监听工具条
    table.on('tool(table)', function(obj){
        var data = obj.data;
        if(obj.event === 'del'){
            del(data.id);
        } else if(obj.event === 'edit'){
            common.frame_show('编辑','/admin/allot/form?id='+data.id);
        }
    });

    //添加数据
    $('#addAllot').click(function () {
        var index = layer.load(1);
        setTimeout(function () {
            layer.close(index);
            common.frame_show('分类添加','/admin/allot/form');
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
            common.frame_show('分类编辑','/admin/allot/form?id='+id);
        }
    };
    function del(id) {
        layer.confirm('真的删除行么', function (index) {
            $.ajax({
                type: "DELETE",
                dataType: "json",
                url: "/admin/allot/" + id + "/del",
                success: function (ret) {
                    if (ret.isOk) {
                        layer.msg("操作成功", {time: 2000}, function () {
                            layer.close(index);
                            window.location.href = "/admin/allot/index";
                        });
                    } else {
                        layer.msg(ret.msg, {time: 2000});
                    }
                }
            });
        });
    }
    exports('admin/allot/index', datalist);
});