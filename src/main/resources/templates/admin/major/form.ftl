<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title> - 标签信息</title>
    <meta name="keywords" content="">
    <meta name="description" content="">

    <link href="${ctx!}/js/plugins/layui/css/layui.css" rel="stylesheet" />
    <style type="text/css">
        .layui-form-item{
            margin: 50px 0 0 200px
        }

    </style>
</head>

<body>

<fieldset id="dataList" class="layui-elem-field layui-field-title sys-list-field">
    <legend style="text-align:center;">专业添加</legend>
</fieldset>
<form class="layui-form layui-form-pane" action="">
    <div class="layui-form-item">
            <input type="hidden" name="id"  value="${(major.id)!}" >
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">专业编号</label>
        <div class="layui-input-inline">
            <input type="text" name="num" lay-verify="number" placeholder="请输入专业编号" value="${(major.num)!}"
                   autocomplete="off" <#if (major.num) == null>class="layui-input" <#else> class="layui-input layui-disabled" disabled</#if>>
        </div>
        <span style="color: red">必填</span>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">专业名称</label>
        <div class="layui-input-inline">
            <input type="text" name="name" lay-verify="required" placeholder="请输入专业名称" value="${(major.name)!}"
                   autocomplete="off" class="layui-input">
        </div>
        <span style="color: red">必填</span>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">专业所属学院</label>
        <div class="layui-input-inline">
            <select name="dept" lay-filter="dept" lay-verify="required">
                <option value="">请选择项目</option>
                            <#list depts as x>
                                <option value="${x.id}"
                                    <#if (major.dept.name == x.name)> selected="selected" </#if>
                                >${x.name}</option>
                            </#list>
                </select>
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">辅导员</label>
        <div class="layui-input-inline">
            <input type="text" name="assistant" lay-verify="required" placeholder="请输入辅导员" value="${(major.assistant)!}"
                   autocomplete="off" class="layui-input">
        </div>
        <span style="color: red">必填</span>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">电话</label>
        <div class="layui-input-inline">
            <input type="text" name="tel" lay-verify="required" placeholder="请输入专业电话" value="${(major.tel)!}"
                   autocomplete="off" class="layui-input">
        </div>
        <span style="color: red">必填</span>
    </div>

    <#--<div class="layui-form-item">-->
        <#--<label class="layui-form-label">专业描述：</label>-->
        <#--<div class="layui-input-block">-->
            <#--<textarea id="description" name="desc" placeholder="请输入内容：必填" lay-verify="required" class="layui-textarea" style="width: 60%">${(major.desc)!}</textarea>-->
        <#--</div>-->
        <#--<span style="color: red">必填</span>-->
    <#--</div>-->

    <div class="layui-form-item">
        <button class="layui-btn" lay-submit lay-filter="add">立即提交</button>
    </div>
</form>

<script src="${ctx!}/js/plugins/layui/layui.js"></script>
<script src="${ctx!}/js/common.js"></script>
<!-- layui规范化用法 -->
<script type="text/javascript">
    layui.config({
        base: '${ctx}/js/admin/'
    }).use('major/form');
</script>
</body>

</html>
