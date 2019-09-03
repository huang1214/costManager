﻿<!DOCTYPE html>

<html >
<head>
    <meta charset="utf-8" />
    <title>后台管理系统</title>
    <link rel="shortcut icon" href="${ctx}/images/ico/jcohy.png" type="image/x-icon">
    <!-- layui.css -->
    <link href="${ctx!}/js/plugins/layui/css/layui.css" rel="stylesheet" />
    <!-- font-awesome.css -->
    <link href="${ctx!}/css/font-awesome.css" rel="stylesheet" />
    <!-- animate.css -->
    <link href="${ctx!}/css/animate.min.css" rel="stylesheet" />
    <!-- 本页样式 -->
    <link href="${ctx!}/css/jcohy/main.css" rel="stylesheet" />
</head>
<body>
    <div class="layui-layout layui-layout-admin">
        <!--顶部-->
        <div class="layui-header">
            <div class="ht-console">
                <div class="ht-user">
                    <img src="${ctx!}/images/ico/jcohy.png" />
                    <a class="ht-user-name">超级管理员</a>
                </div>
            </div>
            <span class="sys-title">后台管理系统</span>
            <ul class="ht-nav">
                <li class="ht-nav-item">
                    <a target="_blank" href="/">前台入口</a>
                </li>
                <li class="ht-nav-item">
                    <a href="javascript:;" id="individuation"><i class="fa fa-tasks fa-fw" style="padding-right:5px;"></i>个性化</a>
                </li>
                <li class="ht-nav-item">
                    <a href="${ctx!}/logout"><i class="fa fa-power-off fa-fw"></i>注销</a>
                </li>
            </ul>
        </div>
        <!--侧边导航-->
        <div class="layui-side">
            <div class="layui-side-scroll">
                <ul class="layui-nav layui-nav-tree" lay-filter="leftnav">
                    <li class="layui-nav-item layui-this">
                        <a href="javascript:;"><i class="fa fa-home"></i>首页</a>
                    </li>
                    <li class="layui-nav-item">
                        <a href="javascript:;"><i class="fa fa-file-text"></i>内容管理</a>
                        <dl class="layui-nav-child">
                            <dd><a href="javascript:;" data-url="${ctx!}/admin/blog/index" data-id="1">文章管理</a></dd>
                            <dd><a href="javascript:;" data-url="${ctx!}/admin/resource/index" data-id="2">资源管理</a></dd>
                            <dd><a href="javascript:;" data-url="${ctx!}/admin/category/index" data-id="3">分类管理</a></dd>
                            <dd><a href="javascript:;" data-url="${ctx!}/admin/tag/index" data-id="4">标签管理</a></dd>
                            <dd><a href="javascript:;" data-url="${ctx!}/admin/category/index" data-id="5">时光轴管理</a></dd>
                            <#--<dd><a href="javascript:;">笔记本管理</a></dd>-->
                            <#--<dd><a href="javascript:;" data-url="datalist.html" data-id="4">文章回收站</a></dd>-->
                            <#--<dd><a href="javascript:;">资源回收站</a></dd>-->
                        </dl>
                    </li>
                    <li class="layui-nav-item">
                        <a href="javascript:;"><i class="fa fa-user"></i>用户管理</a>
                        <dl class="layui-nav-child">
                            <dd><a href="javascript:;" data-url="${ctx!}/admin/user/index" data-id="11">全部用户</a></dd>
                            <dd><a href="javascript:;">黑名单管理</a></dd>
                        </dl>
                    </li>
                    <li class="layui-nav-item">
                        <a href="javascript:;"><i class="fa fa-wrench"></i>扩展管理</a>
                        <dl class="layui-nav-child">
                            <dd><a href="javascript:;" data-url="${ctx!}/admin/link/index" data-id="8">友情链接</a></dd>
                            <dd><a href="javascript:;" data-url="${ctx!}/admin/sys/index" data-id="9">系统设置</a></dd>
                            <dd><a href="javascript:;" data-url="${ctx!}/admin/notice/index" data-id="10">网站公告</a></dd>
                            <dd><a href="javascript:;" data-url="datalist.html" data-id="6">更新日志</a></dd>
                            <dd><a href="javascript:;" data-url="datalist.html" data-id="7">留言管理</a></dd>
                        </dl>
                    </li>
                    <#--<li class="layui-nav-item">-->
                        <#--<a href="javascript:;"><i class="fa fa-cog"></i>系统配置</a>-->
                        <#--<dl class="layui-nav-child">-->
                            <#--<dd><a href="javascript:;">SEO配置</a></dd>-->
                            <#--<dd><a href="javascript:;">QQ互联</a></dd>-->
                            <#--<dd><a href="javascript:;">数据库配置</a></dd>-->
                            <#--<dd><a href="javascript:;">站点地图</a></dd>-->
                        <#--</dl>-->
                    <#--</li>-->
                    <#--<li class="layui-nav-item">-->
                        <#--<a href="javascript:;"><i class="fa fa-info-circle"></i>其他信息</a>-->
                        <#--<dl class="layui-nav-child">-->
                            <#--<dd><a href="javascript:;">操作日志</a></dd>-->
                        <#--</dl>-->
                    <#--</li>-->
                </ul>
            </div>
        </div>
        <!--收起导航-->
        <div class="layui-side-hide layui-bg-cyan">
            <i class="fa fa-long-arrow-left fa-fw"></i>收起导航
        </div>
        <!--主体内容-->
        <div class="layui-body">
            <div style="margin:0;position:absolute;top:15px;bottom:0px;width:100%;" class="layui-tab layui-tab-brief" lay-filter="tab" lay-allowclose="true">
                <ul class="layui-tab-title">
                    <li lay-id="0" class="layui-this">首页</li>
                </ul>
                <div class="layui-tab-content">
                    <div class="layui-tab-item layui-show">
                        <p style="padding: 10px 15px; margin-bottom: 20px; margin-top: 10px; border:1px solid #ddd;display:inline-block;">
                            上次登陆
                            <span style="padding-left:1em;">IP：</span>
                            <span style="padding-left:1em;">地点：</span>
                            <span style="padding-left:1em;">时间：</span>
                        </p>
                        <fieldset class="layui-elem-field layui-field-title">
                            <legend>统计信息</legend>
                            <div class="layui-field-box">
                                <div style="display: inline-block; width: 100%;">
                                    <div class="ht-box layui-bg-blue">
                                        <p>123</p>
                                        <p>用户总数</p>
                                    </div>
                                    <div class="ht-box layui-bg-red">
                                        <p>32</p>
                                        <p>今日注册</p>
                                    </div>
                                    <div class="ht-box layui-bg-green">
                                        <p>55</p>
                                        <p>今日登陆</p>
                                    </div>
                                    <div class="ht-box layui-bg-orange">
                                        <p>123</p>
                                        <p>文章总数</p>
                                    </div>
                                    <div class="ht-box layui-bg-cyan">
                                        <p>321</p>
                                        <p>资源总数</p>
                                    </div>
                                    <div class="ht-box layui-bg-black">
                                        <p>231</p>
                                        <p>笔记总数</p>
                                    </div>
                                </div>
                            </div>
                        </fieldset>
                    </div>
                </div>
            </div>
        </div>
        <!--底部信息-->
        <div class="layui-footer">
            <p style="line-height:44px;text-align:center;">Copyright © 2017 - Jcohy. All Rights Reserved</p>
        </div>
        <!--快捷菜单-->
        <div class="short-menu" style="display:none">
            <fieldset class="layui-elem-field layui-field-title">
                <legend style="color:#fff;padding-top:10px;padding-bottom:10px;">快捷菜单</legend>
                <div class="layui-field-box">
                    <div style="width:832px;margin:0 auto;">
                        <div class="windows-tile windows-two">
                            <i class="fa fa-file-text"></i>
                            <span data-url="datalist.html" data-id="1">文章管理</span>
                        </div>
                        <div class="windows-tile windows-one">
                            <i class="fa fa-volume-up"></i>
                            <span data-url="datalist.html" data-id="2">网站公告</span>
                        </div>
                        <div class="windows-tile windows-one">
                            <i class="fa fa-comments-o"></i>
                            <span data-url="datalist.html" data-id="3">留言管理</span>
                        </div>
                        <div class="windows-tile windows-two">
                            <i class="fa fa-handshake-o"></i>
                            <span data-url="datalist.html" data-id="4">友情链接</span>
                        </div>
                        <div class="windows-tile windows-one">
                            <i class="fa fa-arrow-circle-right"></i>
                            <span data-url="datalist.html" data-id="5">更新日志</span>
                        </div>
                        <div class="windows-tile windows-one">
                            <i class="fa fa-wrench"></i>
                            <span data-url="datalist.html" data-id="6">操作日志</span>
                        </div>
                        <div class="windows-tile windows-one">
                            <i class="fa fa-tags"></i>
                            <span data-url="datalist.html" data-id="7">资源管理</span>
                        </div>
                        <div class="windows-tile windows-one">
                            <i class="fa fa-pencil-square-o"></i>
                            <span data-url="datalist.html" data-id="8">笔记管理</span>
                        </div>
                        <div class="windows-tile windows-two">
                            <i class="fa fa-hourglass-half"></i>
                            <span data-url="datalist.html" data-id="9">时光轴管理</span>
                        </div>
                        <div style="clear:both;"></div>
                    </div>
                </div>
            </fieldset>

        </div>
        <!--个性化设置-->
        <div class="individuation animated flipOutY layui-hide">
            <ul>
                <li><i class="fa fa-cog" style="padding-right:5px"></i>个性化</li>
            </ul>
            <div class="explain">
                <small>从这里进行系统设置和主题预览</small>
            </div>
            <div class="setting-title">设置</div>
            <div class="setting-item layui-form">
                <span>侧边导航</span>
                <input type="checkbox" lay-skin="switch" lay-filter="sidenav" lay-text="ON|OFF" checked>
            </div>
            <div class="setting-item layui-form">
                <span>管家提醒</span>
                <input type="checkbox" lay-skin="switch" lay-filter="steward" lay-text="ON|OFF" checked>
            </div>
            <div class="setting-title">主题</div>
            <div class="setting-item skin skin-default" data-skin="skin-default">
                <span>低调优雅</span>
            </div>
            <div class="setting-item skin skin-deepblue" data-skin="skin-deepblue">
                <span>蓝色梦幻</span>
            </div>
            <div class="setting-item skin skin-pink" data-skin="skin-pink">
                <span>姹紫嫣红</span>
            </div>
            <div class="setting-item skin skin-green" data-skin="skin-green">
                <span>一碧千里</span>
            </div>
        </div>
    </div>
    <!-- layui.js -->
    <script src="${ctx!}/js/jquery.js"></script>
    <script src="${ctx!}/js/jquery.cookie.js"></script>

    <script src="${ctx!}/js/plugins/layui/layui.js"></script>

    <!-- layui规范化用法 -->
    <script type="text/javascript">
        layui.config({
            base: '${ctx!}/js/jcohy/'
        }).use('main');
    </script>
</body>
</html>