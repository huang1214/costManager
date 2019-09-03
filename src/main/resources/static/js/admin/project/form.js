layui.define(['element', 'layer', 'form','laydate'], function (exports) {
    var form = layui.form,
        laydate = layui.laydate,
        $ = layui.jquery;
    laydate.render({
        elem: '#start' //指定元素
    });

    laydate.render({
        elem: '#end' //指定元素
    });

    //自定义验证
    form.verify({
        name: function (value) {
            if (value.length <= 0 || value.length > 20) {
                return "名称必须1到00位"
            }
        },
        description:function (value) {
            if (value.length <= 1 || value.length > 100) {
                return "描述必须2到00位"
            }
        }

    });
    //监听登陆提交
    form.on('submit(add)', function (data) {
        $.ajax({
            type: "POST",
            dataType: "json",
            url: "/admin/allot/save",
            data: data.field,
            success: function(ret){
                if(ret.isOk){
                    layer.msg("操作成功", {time: 2000},function(){
                        var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
                        parent.layer.close(index);
                        window.parent.location.href="/admin/allot/index";
                    });
                }else{
                    layer.msg(ret.msg, {time: 2000});
                }
            }
        });
        return false;
    });


    form.on('select(depts)', function(data){
        // console.log(data.elem); //得到select原始DOM对象
        // console.log(data.value); //得到被选中的值
        // console.log(data.othis); //得到美化后的DOM对象
        var select = $("[name='major']");
        select.empty();
        $.ajax({
            type:"GET",
            data:{"id":data.value},
            url:"/major/dept",
            async: false,
            success:function (ret) {
                $("[name='category'] option:gt(0)").remove();

                var option='';
                var data = ret.majors;
                for(var i=0;i<data.length;i++){
                    option+='<option value="'+data[i].id+'">'+data[i].name+'</option></br>';
                }
                select.append(option);
            }
        });

        form.render('select','form');
    });
    exports('admin/allot/form', {});
});

