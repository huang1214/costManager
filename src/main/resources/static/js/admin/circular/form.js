layui.define(['element', 'layer', 'form','laydate','upload'], function (exports) {
    var form = layui.form,
        laydate = layui.laydate,
        upload = layui.upload,
        $ = layui.jquery;
    //自定义验证
    form.verify({
        content: function (value) {
            if (value.length <= 0 || value.length > 200) {
                return "内容必须1到200位"
            }
        }

    });
    var posterWidth = 560, posterHeight = 300;
    upload.render({
        elem: '#upload' ,//绑定元素
        url: '/upload',
        size:0,
        before: function(input) {
            input.preview(function(index, file, result){
                var img = new Image();
                img.onload = function() {
                    console.log('choose poster', img.width, img.height);
                    if (posterWidth === img.width && posterHeight === img.height) {
                        $('#upload_poster_preview').attr('src', result); //图片链接（base64）不支持ie8
                        input.upload(index, file);
                    } else {
                        layer.msg('海报尺寸必须为：' + posterWidth + 'x' + posterHeight + 'px');
                    }
                };
            });
            box = $("#upload").parent('.layui-input-block');
            if (box.find('div').length > 0) {
                box.firstChild('div').html('<div class="imgbox"><p>上传中...</p></div>');
            } else {
                box.append('<div class="layui-inline"><div class="imgbox"><p>上传中...</p></div></div>');
            }
        },
        done: function(res) {
            if (res.isOk) {
                console.log(res);
                box.find('div').find('div.imgbox').html('<p>下载地址：<a href="' + res.book.downloadUrl + '">' + res.book.name + '</a></p>');
                box.find('input[type=hidden]').val(res.book.id);
            } else {
                box.next('div').find('p').html('上传失败...')
            }
        }
    });

    laydate.render({
        elem: '#start' //指定元素
        ,type:'datetime'
    });
    laydate.render({
        elem: '#end' //指定元素
        ,type:'datetime'
    });
    //监听登陆提交
    form.on('submit(add)', function (data) {
        // console.log(data.elem);//被执行事件的元素DOM对象，一般为button对象
        // console.log(data.form);//被执行提交的form对象，一般在存在form标签时才会返回
        // console.log(data.field);//当前容器的全部表单字段，名值对形式：{name: value}
        $.ajax({
            type: "POST",
            dataType: "json",
            url: "/admin/circular/save",
            data: data.field,
            success: function(ret){
                console.log(ret);
                if(ret.isOk){
                    layer.msg("操作成功", {time: 2000},function(){
                        var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
                        parent.layer.close(index);
                        window.parent.location.href="/admin/circular/index";
                    });
                }else{
                    layer.msg(ret.msg, {time: 2000});
                }
            }
        });
        return false;
    });

    exports('admin/circular/form', {});
});

