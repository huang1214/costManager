<!DOCTYPE html>

<html >
<head>
    <meta charset="utf-8" />
    <title>学科竞赛经费报销系统</title>
    <link rel="shortcut icon" href="${ctx}/images/jcohy.png" type="image/x-icon">
    <!-- layui.css -->
    <link href="${ctx!}/js/plugins/layui/css/layui.css" rel="stylesheet" />
    <!-- font-awesome.css -->
    <link href="${ctx!}/css/font-awesome.css" rel="stylesheet" />
    <!-- animate.css -->
    <link href="${ctx!}/css/animate.min.css" rel="stylesheet" />
    <!-- 本页样式 -->
    <link href="${ctx!}/css/main.css" rel="stylesheet" />
</head>
<body>
    <div class="layui-layout layui-layout-admin">
        <!--顶部-->
        <div class="layui-header">
            <div class="ht-console">
                <div class="ht-user">
                    <img src="${ctx!}/images/jcohy.png" />
                    <a class="ht-user-name">${role}</a>
                </div>
            </div>
            <span class="sys-title">学科竞赛经费报销系统</span>
            <ul class="ht-nav">
                <li class="ht-nav-item">
                    <a id="updatePassword" style="cursor: pointer"><i class="fa fa-power-off fa-fw"></i>修改密码</a>
                    <input type="hidden" value="${Session.user.num?c}" id="num">
                    <input type="hidden" value="${Session.role}" id="role">
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
                        <a href="javascript:;"><i class="fa fa-home fa-fw"></i>首页</a>
                    </li>

                    <li class="layui-nav-item">
                        <a href="javascript:;"><i class="fa fa-user fa-fw"></i>用户管理</a>
                        <dl class="layui-nav-child">
                            <dd><a href="javascript:;" data-url="${ctx!}/admin/student/index" data-id="1">学生信息管理</a></dd>
                            <dd><a href="javascript:;" data-url="${ctx!}/admin/teacher/index" data-id="2">教师信息管理</a></dd>
                            <dd><a href="javascript:;" data-url="${ctx!}/admin/expert/index" data-id="3">审核员信息管理</a></dd>
                        </dl>
                    </li>

                    <li class="layui-nav-item">
                        <a href="javascript:;"><i class="fa fa-file-text fa-fw"></i>项目管理</a>
                        <dl class="layui-nav-child">
                            <dd><a href="javascript:;" data-url="${ctx!}/admin/project/index" data-id="4">我的项目</a></dd>
                            <dd><a href="javascript:;" data-url="${ctx!}/admin/allot/index" data-id="5">评审分配</a></dd>
                            <dd><a href="javascript:;" data-url="${ctx!}/project/history" data-id="6">历史项目</a></dd>
                            <#--<dd><a href="javascript:;" data-url="${ctx!}/admin/project/index" data-id="5">项目审核</a></dd>-->
                        </dl>
                    </li>

                    <li class="layui-nav-item">
                        <a href="javascript:;"><i class="fa fa-check fa-fw"></i>学院管理</a>
                        <dl class="layui-nav-child">
                            <dd><a href="javascript:;" data-url="${ctx!}/admin/dept/index" data-id="7">学院信息</a></dd>
                        </dl>
                        <dl class="layui-nav-child">
                            <dd><a href="javascript:;" data-url="${ctx!}/admin/major/index" data-id="8">系所信息</a></dd>
                        </dl>
                    </li>

                    <li class="layui-nav-item">
                        <a href="javascript:;"><i class="fa fa-plus-square fa-fw"></i>类别管理</a>
                        <dl class="layui-nav-child">
                            <dd><a href="javascript:;" data-url="${ctx!}/admin/type/index" data-id="5">类别信息</a></dd>
                        </dl>
                        <dl class="layui-nav-child">
                            <dd><a href="javascript:;" data-url="${ctx!}/admin/type/update" data-id="9">类别管理</a></dd>
                        </dl>
                    </li>

                    <li class="layui-nav-item">
                        <a href="javascript:;"><i class="fa fa-file-text fa-fw"></i>统计信息</a>
                        <dl class="layui-nav-child">
                            <dd><a href="javascript:;" data-url="${ctx!}/admin/graph/index" data-id="10">统计信息</a></dd>
                        </dl>
                    </li>

                    <li class="layui-nav-item">
                        <a href="javascript:;"><i class="fa fa-comment fa-fw"></i>消息管理</a>
                        <dl class="layui-nav-child">
                            <dd><a href="javascript:;" data-url="${ctx!}/admin/notice" data-id="12">我的消息</a></dd>
                        </dl>
                        <dl class="layui-nav-child">
                            <dd><a href="javascript:;" data-url="${ctx!}/admin/circular/index" data-id="13">发布通告</a></dd>
                        </dl>
                    </li>
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
                            学科竞赛经费报销系统
                            <span style="padding-left:1em;">用户帐号：${Session.user.num?c}</span>
                            <span style="padding-left:1em;">用户姓名：${Session.user.name}</span>
                            <span style="padding-left:1em;">角色：${Session.role}</span>
                        </p>
                    </div>
                </div>
            </div>
        </div>


    <script src="${ctx!}/js/plugins/layui/layui.js"></script>

    <!-- layui规范化用法 -->
    <script type="text/javascript">
        layui.config({
            base: '${ctx!}/js/'
        }).use('main');
    </script>
</body>
</html>