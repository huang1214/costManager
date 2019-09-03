<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title> - 学生信息</title>
    <meta name="keywords" content="">
    <meta name="description" content="">

    <link href="${ctx!}/js/plugins/layui/css/layui.css" rel="stylesheet" />
    <style type="text/css">
        .layui-form-item{
            margin: 20px 0 0 200px
        }
        .layui-form-label{
            width: 120px;
        }
    </style>
</head>

<body>

<fieldset id="dataList" class="layui-elem-field layui-field-title sys-list-field">
    <legend style="text-align:center;">添加</legend>
</fieldset>
<div class="container-fluid larry-wrapper">
    <div class="row">
        <div class="col-xs-12 col-sm-12 col-md-12">
            <section class="panel panel-padding">
                <form id="form1" class="layui-form "  lay-filter="form">

                    <div class="layui-form-item">
                        <input type="hidden" name="id"  value="${(allot.id)!}" >
                    </div>


                    <div class="layui-form-item">
                        <label class="layui-form-label">待审核备案</label>
                        <div class="layui-input-inline">
                            <select name="project" lay-filter="project" lay-verify="required">
                                <option value="">请选择备案项目</option>
                            <#list projects as x>
                                <option value="${x.id}"
                                    <#if (allot.project.name == x.name)> selected="selected" </#if>
                                >${x.name}</option>
                            </#list>
                            </select>
                        </div>
                    </div>


                    <div class="layui-form-item">
                        <label class="layui-form-label">选择审核人员</label>
                        <div class="layui-input-inline">
                            <select name="expert" lay-filter="teacher" lay-verify="required">
                                <option value="">请选择审核人员</option>
                            <#list experts as x>
                                <option value="${x.id}"
                                    <#if (allot.expert.name == x.name)> selected="selected" </#if>
                                >${x.name}</option>
                            </#list>
                            </select>
                        </div>
                    </div>



                    <div class="layui-form-item">
                        <label class="layui-form-label">审核内容</label>
                        <div class="layui-input-inline">
                            <input type="text" name="content" lay-verify="required" placeholder="请输入评审内容" value="${allot.content}"
                                   autocomplete="off" class="layui-input">
                        </div>
                    </div>



                    <div class="layui-form-item">
                        <label class="layui-form-label">开始时间</label>
                        <div class="layui-input-inline">
                            <input type="text" name="start" value="${(allot.start)!}" class="layui-input" id="start" lay-verify="required">
                        </div>
                    </div>

                    <div class="layui-form-item">
                        <label class="layui-form-label">结束时间</label>
                        <div class="layui-input-inline">
                            <input type="text" name="end" value="${(allot.end)!}" class="layui-input" id="end" lay-verify="required">
                        </div>
                    </div>


                    <div class="layui-form-item">
                        <button class="layui-btn" lay-submit lay-filter="add">立即提交</button>
                    </div>

                </form>
            </section>
        </div>
    </div>
</div>

<script src="${ctx!}/js/plugins/layui/layui.js"></script>
<script src="${ctx!}/js/common.js"></script>
<!-- layui规范化用法 -->
<script type="text/javascript">
    layui.config({
        base: '${ctx}/js/'
    }).use('admin/allot/form');
</script>
</body>

</html>
