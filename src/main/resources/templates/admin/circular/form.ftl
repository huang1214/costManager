<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title> - 公告信息</title>
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
    <legend style="text-align:center;">公告添加</legend>
    <button class="layui-btn" style="position: relative;float: right;right: 100px;" onclick="javascript:location.replace(location.href)">
        <i class="layui-icon">&#x1002;</i>
    </button>
</fieldset>
<form class="layui-form layui-form-pane" action="">
    <div class="layui-form-item">
            <input type="hidden" name="id"  value="${(circular.id)!}" >
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label" style="width: 170px">公告内容</label>
        <div class="layui-input-inline">
            <input type="text" name="content" lay-verify="content" placeholder="请输入公告名称" value="${(circular.content)!}"
                   autocomplete="off" class="layui-input">
        </div>
    </div>


    <#--<div class="layui-form-item">-->
        <#--<label class="layui-form-label"  style="width: 170px">链接地址</label>-->
        <#--<div class="layui-input-inline">-->
            <#--<input type="text" name="url" lay-verify="url" placeholder="请输入公告名称" value="${(circular.url)!}"-->
                   <#--autocomplete="off" class="layui-input">-->
        <#--</div>-->
    <#--</div>-->

    <div class="layui-form-item">
        <label class="layui-form-label">上传封面图</label>
        <div class="layui-input-block">
            <button type="button" class="layui-btn" id="upload">
                <i class="layui-icon">&#xe67c;</i>图片上传
            </button>
            <input type="hidden" name="book">
        </div>
    </div>


    <div class="layui-form-item">
        <label class="layui-form-label"  style="width: 170px">跳转链接</label>
        <div class="layui-input-inline">
            <input type="text" name="url" lay-verify="url" placeholder="请输入链接" value="${(circular.url)!}"
                   autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label"  style="width: 170px">开始时间</label>
        <div class="layui-input-inline">
            <input type="text" class="layui-input" name="start" id="start" value="${(circular.start)!}" lay-verify="required">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label"  style="width: 170px">结束时间</label>
        <div class="layui-input-inline">
            <input type="text" class="layui-input" name="end" id="end" value="${(circular.end)!}" lay-verify="required">
        </div>
    </div>
    <#if circular.id == null>
        <div class="layui-form-item">
            <label class="layui-form-label"  style="width: 170px">是否可见</label>
            <div class="layui-input-block">
                <input type="checkbox" name="visible" lay-skin="switch" lay-text="ON|OFF" value="1" checked>
            </div>
        </div>
    </#if>


    <div class="layui-form-item">
        <button class="layui-btn" lay-submit lay-filter="add">立即提交</button>
    </div>
</form>

<script src="${ctx!}/js/plugins/layui/layui.js"></script>
<!-- layui规范化用法 -->
<script type="text/javascript">
    layui.config({
        base: '${ctx}/js/'
    }).use('admin/circular/form');
</script>
</body>

</html>
