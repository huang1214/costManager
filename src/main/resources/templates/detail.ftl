﻿<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; Charset=utf-8">
    <meta http-equiv="Content-Language" content="zh-CN">
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
    <title>竞赛信息</title>
    <link rel="shortcut icon" href="${ctx!}/images/logo.png" type="image/x-icon">
    <!--Layui-->
    <link href="${ctx!}/js/plugins/layui/css/layui.css" rel="stylesheet" />
    <!--font-awesome-->
    <link href="${ctx!}/css/font-awesome.min.css" rel="stylesheet" />
    <!--全局样式表-->
    <link href="${ctx!}/css/global.css" rel="stylesheet" />
    <link href="${ctx!}/css/animate.min.css" rel="stylesheet" />
    <!-- 本页样式表 -->
    <link href="${ctx!}/css/detail.css" rel="stylesheet" />
</head>
<body>
    <!-- 导航 -->
    <nav class="blog-nav layui-header">
        <div class="blog-container">

            <a class="blog-logo" href="/">竞赛经费审核信息</a>
            <!-- 用户登陆 -->
            <div class="blog-user"></div>

            <!-- 手机和平板的导航开关 -->
            <a class="blog-navicon" href="javascript:;">
                <i class="fa fa-navicon"></i>
            </a>
        </div>
    </nav>
    <!-- 主体（一般只改变这里的内容） -->
    <div class="blog-body">
        <!-- 这个一般才是真正的主体内容 -->
        <div class="blog-container">
            <div class="blog-main">
                <blockquote class="layui-elem-quote sitemap layui-breadcrumb shadow">
                	<a href="/" title="网站首页">网站首页</a>
<#--                	<a href="javascript;" title="项目信息">竞赛审核信息</a>-->
                	<a><cite class="title"></cite></a>
           		</blockquote>
                <!--左边文章列表-->
                <div class="animated slideInLeft">
                	<!-- 文章内容（使用Kingeditor富文本编辑器发表的） -->
                    <form class="layui-form">
                        <div class="article-detail shadow">

                            <div class="layui-form-item">
                                <input type="hidden" name="id" value="${project.id}">
                            </div>

                            <div class="article-detail-title title">${project.name}  </a></div>
                            <div class="article-detail-info">
                                <span>竞赛团队负责人：${project.student.name}</span>
                                <span>编辑时间：${project.createDate}</span>
                                <span>项目状态： 审核通过</span>
                            <div class="article-detail-sign">
                                <hr class="layui-bg-gray">
                                <p>经费预算：${project.proResource}</p>
                                <p>申请报销：${project.moneyResource}</p>
                                <p>指导老师：${project.teacher.name}</p>
                                <p>审核者：${expert.name}</p>

                                <div class="article-detail-content">
                                    <p>竞赛描述：</p>
                                ${project.desc}
                                </div >
                                <p>审核图片下载地址：${project.book.downloadUrl}</p>
                            </div>


                            <div class="layui-form-item">
                                <div class="layui-input-block">
                                    <#--<#if (job.status)== 0>-->
                                        <#--<button class="layui-btn" lay-submit lay-filter="send">立即投递</button>-->
                                    <#--<#else>-->
                                        <#--<button class="layui-btn" lay-submit lay-filter="send">取消投递</button>-->
                                    <#--</#if>-->
                                </div>
                            </div>

                        </div>
                    </form>
                </div>

                <!--右边小栏目-->
                <#--<div class="blog-main-right">-->
                	<#--<!--右边悬浮 平板或手机设备显示&ndash;&gt;-->
                    <#--<div class="category-toggle"><i class="fa fa-chevron-left"></i></div>-->
                	<#--<!-- 分类导航 &ndash;&gt;-->
                	<#--<div class="article-category shadow">-->
                        <#--<div class="article-category-title">分类导航</div>-->
                        <#--<a href="javascript:go(1)">杂文随笔</a>-->
                        <#--<a href="javascript:go(2)">JAVA基础</a>-->
                        <#--<a href="javascript:go(3)">Web前端</a>-->
                        <#--<a href="javascript:go(4)">My Sql</a>-->
                        <#--<div class="clear"></div>-->
                    <#--</div>-->
                <#--</div>-->
            </div>
            <div class="clear"></div>
        </div>
    </div>

    <!-- 底部 -->
    <#--<footer class="blog-footer">-->
        <#--<p><span>Copyright</span><span>&copy;</span><span>2018</span><a href="localhost">SCIS</a></p>-->
    <#--</footer>-->

    <!--遮罩-->
    <div class="blog-mask animated layui-hide"></div>
    <!-- layui.js -->
    <script src="${ctx!}/js/plugins/layui/layui.js"></script>
    <!-- 全局脚本 -->
    <script src="${ctx!}/js/global.js"></script>
    <script type="text/javascript">
        layui.define([ 'layer',  'form'], function (exports) {
            var $ = layui.jquery,
            layer = layui.layer,
            form  = layui.form ;
            // 修改个人资料
            var user = MyLocalStorage.get("user");
            user = JSON.parse(user);
            form.on('submit(send)', function(data){
                data = data.field;
                console.log(data);
                console.log(user);
                if(user != null){
                    $.ajax({
                        type: 'GET',
                        async:true,
                        url: "/jobSeeker/send?userId="+user.id+"&jobId="+data.id,
                        success:function(result) {
                            if (result.isOk) {
                                layer.msg(result.msg,{icon:1,time:2000});
                            } else {
                                layer.msg(result.msg,{anim:6,time:2000});
                            }
                        }
                    });
                }else{
                    layer.msg("请先登录",{anim:6,time:2000});
                    window.location.href="/user/login";
                }
                return false;
            });
        });
    </script>
</body>
</html>