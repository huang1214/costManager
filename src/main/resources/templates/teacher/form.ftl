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
                        <input type="hidden" name="id"  value="${(project.id)!}" >
                    </div>

                    <div class="layui-form-item" style="margin-top: 10px">
                        <label class="layui-form-label">项目名</label>
                        <div class="layui-input-inline">
                            <input type="text" name="num" lay-verify="number"  placeholder="请输入项目名" value="${project.name}"
                                   autocomplete="off" class="layui-input ">
                        </div>
                    </div>

                    <div class="layui-form-item">
                        <label class="layui-form-label">项目来源</label>
                        <div class="layui-input-inline">
                            <input type="text" name="proResource" lay-verify="required" placeholder="请输入项目来源" value="${project.proResource}"
                                   autocomplete="off" class="layui-input">
                        </div>
                    </div>

                    <div class="layui-form-item">
                        <label class="layui-form-label">经费来源</label>
                        <div class="layui-input-inline">
                            <input type="text" name="moneyResource" lay-verify="required" placeholder="请输入经费来源" value="${project.moneyResource}"
                                   autocomplete="off" class="layui-input">
                        </div>
                    </div>

                    <div class="layui-form-item">
                        <label class="layui-form-label">指导老师</label>
                        <div class="layui-input-inline">
                            <select name="teacher" lay-filter="teacher">
                                <option value="">请选择指导老师</option>
                            <#list teachers as x>
                                <option value="${x.id}"
                                    <#if (project.teacher.num == x.name)> selected="selected" </#if>
                                >${x.name}</option>
                            </#list>
                            </select>
                        </div>
                    </div>

                    <div class="layui-form-item">
                        <label class="layui-form-label">上传</label>
                        <div class="layui-input-block">
                            <button type="button" class="layui-btn" id="upload">
                                <i class="layui-icon">&#xe67c;</i>创业项目申请书
                            </button>
                            <input type="hidden" name="uploadUrl">
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
    }).use('teacher/form');
</script>
</body>

</html>
