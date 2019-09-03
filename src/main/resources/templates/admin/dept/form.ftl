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
    <legend style="text-align:center;">院系添加</legend>
</fieldset>
<form class="layui-form layui-form-pane" action="">
    <div class="layui-form-item">
            <input type="hidden" name="id"  value="${(dept.id)!}" >
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">院系编号</label>
        <div class="layui-input-inline">
            <input type="text" name="num" lay-verify="number" placeholder="请输入院系编号" value="${(dept.num)!}"
                   autocomplete="off" <#if (dept.num) == null>class="layui-input" <#else> class="layui-input layui-disabled" disabled</#if>>
        </div>
        <span style="color: red">必填</span>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">院系名称</label>
        <div class="layui-input-inline">
            <input type="text" name="name" lay-verify="required" placeholder="请输入院系名称" value="${(dept.name)!}"
                   autocomplete="off" class="layui-input">
        </div>
        <span style="color: red">必填</span>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">院系主任</label>
        <div class="layui-input-inline">
            <input type="text" name="chairman" lay-verify="required" placeholder="请输入院系主任" value="${(dept.chairman)!}"
                   autocomplete="off" class="layui-input">
        </div>
        <span style="color: red">必填</span>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">电话</label>
        <div class="layui-input-inline">
            <input type="text" name="tel" lay-verify="required" placeholder="请输入院系电话" value="${(dept.tel)!}"
                   autocomplete="off" class="layui-input">
        </div>
        <span style="color: red">必填</span>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">院系描述：</label>
        <div class="layui-input-block">
            <textarea id="description" name="desc" placeholder="请输入内容：必填" lay-verify="required" class="layui-textarea" style="width: 60%">${(dept.desc)!}</textarea>
        </div>
        <span style="color: red">必填</span>
    </div>

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
    }).use('dept/form');
</script>
</body>

</html>
