layui.define(['laypage', 'layer', 'table','form','laytpl','common','util'], function (exports) {
    var $ = layui.jquery,
        layer = layui.layer,
        form = layui.form,
        util = layui.util,
        laytpl = layui.laytpl,
        table = layui.table,
        common = layui.common;

    table.render({
        elem: '#student'
        ,height: 'full-200'
        ,method:'GET'
        ,url: '/admin/student/list' //数据接口
        ,page: true //开启分页
        ,cols: [[ //表头
            {type: 'checkbox', align:'center',unresize:true}
            ,{field: 'num', align:'center', title: '学号',unresize:true}
            ,{field: 'name', align:'center', title: '姓名',unresize:true}
            ,{field: 'sex', align:'center', title: '性别',unresize:true}
            ,{field: 'phone', align:'center', title: '电话',unresize:true}
            ,{field: 'major', title: '专业',unresize:true,templet: '<div>{{d.major.name}}</div>'}
            ,{field: 'sclass', title: '班级',unresize:true}
            ,{fixed: 'right',  title:'操作',align:'center', toolbar: '#operator',unresize:true}
        ]]
    });

    table.on('tool(table)', function(obj){
        var data = obj.data;
        if(obj.event === 'del'){
            del(data.id);
        } else if(obj.event === 'edit'){
            common.frame_show('编辑','/admin/student/form?id='+data.id,$(window).width(),$(window).height());
        }
    });

    //添加数据
    $('#addStudent').click(function () {
        var index = layer.load(1);
        setTimeout(function () {
            layer.close(index);
            common.frame_show('添加','/admin/student/form',$(window).width(),$(window).height());
            // layer.msg('打开添加窗口');
        }, 500);
    });

    //输出接口，主要是两个函数，一个删除一个编辑
    var datalist = {
        deleteData: function (id) {
            layer.confirm('确定删除？', {
                btn: ['确定', '取消'] //按钮
            }, function () {
                del(id);
                // layer.msg('删除Id为【' + id + '】的数据');
            }, function () {

            });
        },
        editData: function (id) {
            common.frame_show('编辑','/admin/student/form?id='+id,$(window).width(),$(window).height());
            // layer.msg('编辑Id为【' + id + '】的数据');
        }
    };

    function del(id) {
        $.ajax({
            method:"DELETE",
            dataType:"JSON",
            url:"/admin/student/"+id+"/del",
            success:function (ret) {
                if (ret.isOk) {
                    layer.msg("操作成功", {time: 2000}, function () {
                        layer.close(index);
                        window.location.href = "/admin/student/index";
                    });
                } else {
                    layer.msg(ret.msg, {time: 2000});
                }
            }
        })
    }
    exports('admin/student/index', datalist);
});