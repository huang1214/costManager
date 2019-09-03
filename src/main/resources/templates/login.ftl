<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title> - 登录</title>
    <meta name="keywords" content="">
    <meta name="description" content="">
    <link href="${ctx!}/js/plugins/layui/css/layui.css" rel="stylesheet">
    <link href="${ctx!}/css/login.css" rel="stylesheet">
    <script src="${ctx!}/js/plugins/layui/layui.js" charset="utf-8" type="text/javascript"></script>
    <script src="${ctx!}/js/common.js" charset="utf-8" type="text/javascript"></script>
    <!--[if lt IE 9]>
    <meta http-equiv="refresh" content="0;ie.html" />
    <![endif]-->
    <script>if(window.top !== window.self){ window.top.location = window.location;}</script>
</head>

<body>
    <div class="layui-carousel video_mask" id="login_carousel" >
        <div carousel-item>
            <div class="carousel_div1"></div>
            <div class="carousel_div2"></div>
            <div class="carousel_div3"></div>
        </div>
        <div class="login layui-anim layui-anim-up">
            <h1>学科竞赛经费报销系统</h1>
            <form class="layui-form" action="${ctx!}/login" method="post">
                <div class="layui-form-item">
                    <input type="text" name="num" lay-verify="number" placeholder="请输入学号或者帐号" autocomplete="off"  value="" class="layui-input">
                </div>
                <div class="layui-form-item">
                    <input type="password" name="password" lay-verify="required" placeholder="请输入密码" autocomplete="off" value="" class="layui-input">
                </div>

                <div class="layui-input-block" style="margin-left: 0">
                    <select name="role" lay-verify="">
                        <option value="">请选择一个角色</option>
                        <option value="student">学生</option>
                        <option value="teacher">老师</option>
                        <option value="expert">审核员</option>
                        <option value="admin">管理员</option>
                    </select>
                <#--<input type="radio" name="role" value="student" title="学生" checked>-->
                    <#--<input type="radio" name="role" value="teacher" title="老师" >-->
                    <#--<input type="radio" name="role" value="expert" title="专家" >-->
                    <#--<input type="radio" name="role" value="admin" title="管理员" >-->
                </div>
                <button class="layui-btn login_btn" lay-submit="" lay-filter="login">登陆系统</button>
            </form>

        </div>

    </div>

</body>

</html>
<script>
    layui.config({
        base : "${ctx!}/js/"
    }).use(['form','layer','jquery','carousel', 'element'], function () {
        var $ = layui.jquery,
                form = layui.form,
                carousel = layui.carousel,
                layer = layui.layer;

        /**背景图片轮播*/
        carousel.render({
            elem: '#login_carousel',
            width: '100%',
            height: '100%',
            interval:3000,
            arrow: 'none',
            anim: 'fade',
            indicator:'none'
        });

        //监听登陆提交
        form.on('submit(login)', function (data) {
            $.ajax({
                type: "POST",
                dataType: "json",
                url: "/login",
                data: data.field,
                success: function(ret){
                    console.log(ret);
                    if(ret.isOk){
                        layer.msg("操作成功", {time: 1300},function(){
                            var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
                            parent.layer.close(index);
                            window.location.href=ret.returnUrl;
                        });
                    }else{
                        layer.msg(ret.msg, {time: 2000});
                    }
                }
            });
            return false;
        });
    });
</script>