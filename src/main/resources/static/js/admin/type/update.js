layui.define(['laypage', 'layer','table','common','util','form'], function (exports) {
    var $ = layui.jquery,
        layer = layui.layer,
        laypage = layui.laypage,
        common = layui.common,
        util = layui.util,
        form = layui.form,
        table  = layui.table ;
    table.render({
        elem: '#type'
        ,height: 'full-200'
        ,method:'GET'
        ,url: '/admin/type/list' //数据接口
        ,page: true //开启分页
        ,cols: [[ //表头
            {type: 'checkbox', align:'center',unresize:true}
            ,{field: 'id', align:'center', title: 'ID', sort: true,unresize:true}
            ,{field: 'num', align:'center', title: '编号',unresize:true}
            ,{field: 'name', align:'center', title: '名称',unresize:true}
            ,{field: 'number', align:'center', title: '数量',sort: true,unresize:true}
            // ,{field: 'type', align:'center', title: '类型',sort: true,unresize:true,templet: '<div>{{d.type.name}}</div>'}
            // ,{field: 'status', align:'center', title: '是否可见',unresize:true,templet: '#choicesTpl'}
            ,{field: 'createDate', title: '创建日期',unresize:true}
            ,{fixed: 'right',  title:'操作',align:'center', toolbar: '#operator',unresize:true}
        ]]
    });

    //监听工具条
    table.on('tool(table)', function(obj){
        var data = obj.data;
        if(obj.event === 'del'){
            del(data.id);
        } else if(obj.event === 'edit'){
            common.frame_show('分类编辑','/admin/type/form?id='+data.id,'720','430');
        }
    });
    //监听状态
    form.on('checkbox(status)', function(data){
        $.ajax({
            type: "GET",
            dataType: "json",
            data: {"type":"status"},
            url: "/admin/type/" + data.value + "/change",
            success: function (ret) {
                if (ret.isOk) {
                    layer.msg("操作成功", {time: 2000}, function () {
                        window.location.href = "/admin/type/index";
                    });
                } else {
                    layer.msg(ret.msg, {time: 2000});
                }
            }
        })
    });
    //分页
    laypage.render({
        elem: 'pageDemo' //分页容器的id
        ,count: 100 //总页数
        ,skin: '#1E9FFF' //自定义选中色值
        //,skip: true //开启跳页
        ,jump: function(obj, first){
            if(!first){
                layer.msg('第'+ obj.curr +'页');
            }
        }
    });


    //添加数据
    $('#addType').click(function () {
        var index = layer.load(1);
        setTimeout(function () {
            layer.close(index);
            common.frame_show('分类添加','/admin/type/form','720','430');
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
            common.frame_show('分类编辑','/admin/type/form?id='+id,'720','430');
        }
    };
    function del(id) {
        layer.confirm('真的删除行么', function (index) {
            $.ajax({
                type: "DELETE",
                dataType: "json",
                url: "/admin/type/" + id + "/del",
                success: function (ret) {
                    if (ret.isOk) {
                        layer.msg("操作成功", {time: 2000}, function () {
                            layer.close(index);
                            window.location.href = "/admin/type/index";
                        });
                    } else {
                        layer.msg(ret.msg, {time: 2000});
                    }
                }
            });
        });
    }
    
    exports('type/update', datalist);
});