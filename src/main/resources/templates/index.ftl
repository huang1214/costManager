﻿<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; Charset=utf-8">
    <meta http-equiv="Content-Language" content="zh-CN">
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
    <title>学科竞赛经费报销系统</title>
    <link rel="shortcut icon" href="${ctx!}/images/logo.png" type="image/x-icon">
    <!--Layui-->
    <link href="${ctx!}/js/plugins/layui/css/layui.css" rel="stylesheet" />
    <!--font-awesome-->
    <link href="${ctx!}/css/font-awesome.min.css" rel="stylesheet" />
    <!--全局样式表-->
    <link href="${ctx!}/css/global.css" rel="stylesheet" />
    <link href="${ctx!}/css/animate.min.css" rel="stylesheet" />
    <!-- 本页样式表 -->
    <link href="${ctx!}/css/index.css" rel="stylesheet" />
    <#--<link href="${ctx!}/css/video-js.css" rel="stylesheet" />-->
    <style>
        tr td:not(:nth-child(0)),
        tr th:not(:nth-child(0)) {
            text-align: center;
        }
        /*可选*/
        .layui-laypage > * {
            float: left;
        }
        .layui-field-title .layui-field-box{
            padding: 10px 20px 10px 30px;
        }
        .layui-table-cell{
            padding-top: 4px;
            height: 45px;
        }
        .star-so{
            text-align: center;
            margin-bottom: 10px;
        }
        .star-so input.layui-input{
            width: 200px;
            display: inline-block;
        }

    </style>
</head>
<body>
    <!-- 导航 -->
    <nav class="blog-nav layui-header">
        <div class="blog-container">
            <!-- 用户登陆 -->
			<a class="blog-logo" href="/" style="top: -16px;">竞赛报销信息</a>

            <div class="blog-user"></div>

            <div class="blog-main">
                <div class="blog-main-right">
                <#--<div class="blog-search">-->
                    <#--<div class="layui-row">-->
                        <#--<div class="layui-form layui-col-md12 star-so">-->
                            <#--<input class="layui-input" placeholder="请输入关键字" name="keyword" id="keyword">-->

                            <#--<button class="layui-btn" id="search" "><i class="layui-icon">&#xe615;</i></button>-->
                        <#--</div>-->
                    <#--</div>-->
                <#--</div>-->
            </div>
            <#--</div>-->
            <!-- 导航菜单 -->
			<ul class="layui-nav" lay-filter="nav">
                导航信息
			</ul>
			<!-- 手机和平板的导航开关 -->
			<a class="blog-navicon" href="javascript:;">
				<i class="fa fa-navicon"></i>
			</a>
        </div>
    </nav>
    <!-- 主体（一般只改变这里的内容） -->
    <div class="blog-body">

    	<div class="layui-carousel blog-bg" id="carousel">
		  <div carousel-item>
              <div><img src="../static/images/banner1.jpg" alt=""></div>
              <div><img src="../static/images/banner2.jpg" alt=""></div>
		  </div>
		</div>

        <div class="blog-container">
            <div class="blog-main" id="project">
                <div class="blog-main-left animated slideInLeft" id="projectLeft">
					<@projectList>
						<#list list as x>
							<div class="article shadow animated fadeInLeft">
                                <#--<div class="article-left ">-->
                                    <#--<img src="${ctx!}/images/01.jpg" alt="${x.name}"/>-->
                                <#--</div>-->
                                <div class="article-right">
                                    <div class="article-title">
                                        <a href="/project/${x.id}">竞赛名称：${x.name}</a>
                                    </div>
                                    <div class="article-abstract">
                                        金额预算：${x.proResource}   准核报销：${x.moneyResource}
                                    </div>
<#--                                    <div class="article-abstract">-->
<#--                                        <a href="project/video/${(x.id)!}" target="_blank">竞赛视频地址 ${x.video.downloadUrl}</a>-->
<#--                                    </div>-->
                                    <div class="article-abstract">
                                        竞赛描述：${x.desc}
                                    </div>
                                    <#--<div class="article-abstract">-->
                                        <#--指导老师：${x.teacher.name}-->
                                    <#--</div>-->
                                </div>
                                <div class="clear"></div>
                                <div class="article-footer">
                                    <span class="article-author"><i class="fa fa-user"></i>&nbsp;&nbsp;${x.student.name}</span>
                                    <span class="article-author"><i class="fa fa-user"></i>&nbsp;&nbsp;${x.teacher.name} 老师</span>
                                    <span><i class="fa fa-clock-o"></i>&nbsp;&nbsp;${x.createDate}</span>
                                </div>
                            </div>
						</#list>
					</@projectList>
                </div>
                <!--右边小栏目-->
                <#--<div class="blog-main-right" id="projectRight">-->
                    <#--<@projectList>-->
                        <#--<#list list as x>-->
							<#--<div class="article shadow animated fadeInLeft" >-->
                                <#--<#if (x.video.downloadUrl) == null >-->
                                    <#--<div class="video_div" style="width: 73%">-->
                                        <#--<img src="${ctx!}/images/01.jpg" alt="${x.name}"/>-->
                                    <#--</div>-->
                                    <#--<div style="float: right;width: 20%">-->
                                        <#--${x.name}项目无参赛视频-->
                                    <#--</div>-->
                                <#--<#else >-->
                                    <#--<div class="video_div">-->
                                        <#--<video id="my-video" class="video-js vjs-default-skin" controls preload="none"  data-setup="{}" poster="http://vjs.zencdn.net/v/oceans.png">-->
                                            <#--<source src="http://vjs.zencdn.net/v/oceans.mp4" type="video/mp4">-->
                                        <#--</video>-->
                                    <#--</div>-->
                                    <#--<div style="float: right;width: 20%">-->
                                        <#--${x.name}项目参赛视频-->
                                    <#--</div>-->
                                <#--</#if>-->
                            <#--</div>-->
                        <#--</#list>-->
                    <#--</@projectList>-->
                <#--</div>-->
                <div class="blog-main-right">
                    <div class="blog-search">
                        <form class="layui-form" action="">
                            <div class="layui-form-item">
                                <div class="search-keywords  shadow">
                                    <input type="text" name="keyword" id="keyword" lay-verify="required" placeholder="请输入关键字" autocomplete="off" class="layui-input ">
                                </div>
                                <div class="search-submit  shadow">
                                    <a class="search-btn" lay-submit lay-filter="formSearch"><i class="fa fa-search"></i></a>
                                </div>
                                <#--<input class="layui-input" placeholder="请输入关键字" name="keyword" id="keyword">-->

                                <#--<button class="layui-btn" id="search"><i class="layui-icon">&#xe615;</i></button>-->
                            </div>
                        </form>
                    </div>
                    <!--推荐/点击排行-->
                    <div class="layui-tab layui-tab-brief shadow animated fadeInRight" lay-filter="docDemoTabBrief">
                        <ul class="layui-tab-title">
                            <li class="layui-this">点击排行</li>
                            <!--<li>站长推荐</li>-->
                        </ul>
                        <div class="layui-tab-content">
                            <div class="layui-tab-item layui-show">
                                <ul class="blog-module-ul">
                                    <@projectList>
                                        <#list list as x>
                                            <#if x_index == 0>
                                                <li><i class="layui-badge-rim layui-bg-red">${x_index+1}</i>&nbsp;&nbsp;<a href="/project/${x.id}">${x.name}</a></li>
                                            <#elseif x_index == 1>
                                                <li><i class="layui-badge-rim layui-bg-orange">${x_index+1}</i>&nbsp;&nbsp;<a href="/project/${x.id}">${x.name}</a></li>
                                            <#elseif x_index == 2>
                                                <li><i class="layui-badge-rim layui-bg-green">${x_index+1}</i>&nbsp;&nbsp;<a href="/project/${x.id}">${x.name}</a></li>
                                            <#else >
                                               <li><i class="layui-badge-rim">${x_index+1}</i>&nbsp;&nbsp;<a href="/project/${x.id}">${x.name}</a></li>
                                            </#if>

                                        </#list>
                                    </@projectList>

                                <#--<li><i class="layui-badge-rim layui-bg-red">1</i>&nbsp;&nbsp;<a href="/jobSeeker/job/1">Java开发工程师</a></li>-->
                                <#--<li><i class="layui-badge-rim layui-bg-orange">2</i>&nbsp;&nbsp;<a href="/jobSeeker/job/1">高级php开发工程师</a></li>-->
                                <#--<li><i class="layui-badge-rim layui-bg-green">3</i>&nbsp;&nbsp;<a href="/jobSeeker/job/1">c#软件工程师!</a></li>-->
                                <#--<li><i class="layui-badge-rim">4</i>&nbsp;&nbsp;<a href="/jobSeeker/job/1">办公室文员</a></li>-->
                                <#--<li><i class="layui-badge-rim">5</i>&nbsp;&nbsp;<a href="/jobSeeker/job/1">销售总监/经理</a></li>-->
                                </ul>
                            </div>
                        </div>
                    </div>

                    <div class="blog-module shadow">
                        <div class="blog-module-title">友情链接</div>
                        <ul class="blogroll">
                            <li><a target="_blank" href="http://www.layui.com/" title="Layui">Layui</a></li>
                            <li><a target="_blank" href="http://www.pagemark.cn/" title="页签">页签</a></li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="clear"></div>
        </div>
    </div>

    <!--侧边导航-->
    <ul class="layui-nav layui-nav-tree layui-nav-side blog-nav-left layui-hide" lay-filter="nav">
    </ul>

    <!--遮罩-->
    <div class="blog-mask animated layui-hide"></div>
    <!-- layui.js -->
    <script src="${ctx!}/js/plugins/layui/layui.js"></script>
    <!-- 全局脚本 -->
    <script src="${ctx!}/js/global.js"></script>
    <#--<script src="${ctx!}/js/canvas-particle.js"></script>-->
    <!-- 本页脚本 -->
    <script src="${ctx!}/js/index.js"></script>
    <#--<script src="${ctx!}/js/video.min.js"></script>-->
    <#--<script type="text/javascript">-->
        <#--var myPlayer = videojs('my-video');-->
        <#--videojs("my-video").ready(function(){-->
            <#--var myPlayer = this;-->
            <#--myPlayer.play();-->
        <#--});-->
    <#--</script>-->
</body>
</html>