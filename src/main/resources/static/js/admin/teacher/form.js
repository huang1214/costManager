﻿layui.define(['layer','form','common','laydate'], function (exports) {
    var $ = layui.jquery,
        layer = layui.layer,
        form = layui.form,
        laydate = layui.laydate,
        common = layui.common;

    laydate.render({
        elem: '#birth' //指定元素
    });
    //监听私密radio
    form.on('radio(privacy)', function (data) {
        console.log(data.value);
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
            common.frame_show('编辑','/admin/teacher/form?id='+id,$(window).width(),$(window).height());
        }
    };

    function del(id) {
        $.ajax({
            method:"DELETE",
            dataType:"JSON",
            url:"/admin/teacher/"+id+"/del",
            success:function (ret) {
                if (ret.isOk) {
                    layer.msg("操作成功", {time: 2000}, function () {
                        layer.close(index);
                        window.location.href = "/admin/teacher/index";
                    });
                } else {
                    layer.msg(ret.msg, {time: 2000});
                }
            }
        })
    }
    form.on('select(depts)', function(data){

    });


    form.on('submit(add)', function(data){
        console.log(data.elem); //被执行事件的元素DOM对象，一般为button对象
        console.log(data.form); //被执行提交的form对象，一般在存在form标签时才会返回
        console.log(data.field); //当前容器的全部表单字段，名值对形式：{name: value}
        $.ajax({
            type: "POST",
            dataType: "json",
            url: "/admin/teacher/save",
            data: data.field,
            success: function(ret){
                console.log(ret);
                if(ret.isOk){
                    layer.msg("操作成功", {time: 2000},function(){
                        var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
                        parent.layer.close(index);
                        window.parent.location.href="/admin/teacher/index";
                    });
                }else{
                    layer.msg(ret.msg, {time: 2000});
                }
            }
        });
        return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
    });
    exports('admin/teacher/form', datalist);
});