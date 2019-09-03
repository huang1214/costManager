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
        p{
            margin: 0;
            padding: 0;
        }
        .layui-input-block {
            margin-left: 150px;
        }
        .tag,
        .tag-defined {
            display: inline-block;
            position: relative;
            padding: 0 20px;
            border: 1px solid #DDD;
            border-radius: 2px;
            cursor: pointer;
            line-height: 36px;
            margin: 0 10px 10px 0;
        }

        .tag-selected {
            border: 1px solid #5FB878;
            color: #5FB878;
        }

        .tick-box {
            display: none;
        }

        .tag .tick-bg {
            position: absolute;
            right: 0;
            bottom: 0;
            border: 10px solid;
            border-color: transparent #5FB878 #5FB878 transparent;
        }

        .tag .tick {
            position: absolute;
            right: 0;
            bottom: -12px;
            font-size: 10px;
            color: #FFF;
        }
        .imgbox{
            margin-top: 20px;
            font-size: 16px;
            color: red;
        }
        .layui-input-block{
            margin-left: 110px;
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
                            <input type="text" name="name" lay-verify="required"  placeholder="请输入项目名" value="${project.name}"
                                   autocomplete="off" class="layui-input ">

                        </div>
                        <span style="color: red">必填</span>
                    </div>

                    <div class="layui-form-item">
                        <label class="layui-form-label">项目类型</label>
                        <div class="layui-input-inline">
                            <select name="type" lay-filter="required" lay-verify="required">
                                <option value="">请选择项目类型</option>
                            <#list types as x>
                                <option value="${x.id}"
                                    <#if (project.type.name == x.name)> selected="selected" </#if>
                                >${x.name}</option>
                            </#list>
                            </select>
                        </div>
                    </div>

                    <div class="layui-form-item">
                        <label class="layui-form-label">参赛形式</label>
                        <div class="layui-input-inline">
                            <select name="genre" lay-filter="genre" lay-verify="required">
                                <option value="个人赛" selected="selected">个人赛</option>
                                <option value="团体赛" >团体赛</option>
                            </select>
                        </div>
                    </div>
                    <div class="layui-form-item" id="group" style="display: none">
                        <label class="layui-form-label">组员学号</label>
                        <div class="layui-input-block">
                            <div class="tag-defined">添加组员学号</div>
                            <input type="hidden" name="groups" value="" data-count="5">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">经费预算</label>
                        <div class="layui-input-inline">
                            <input type="text" name="proResource" lay-verify="required" placeholder="请输入经费预算" value="${project.proResource}"
                                   autocomplete="off" class="layui-input" pattern="^[1-9]\d*$">

<#--                            <select name="proResource" lay-filter="proResource" lay-verify="required">-->
<#--                                <option value="个人" selected="selected">个人</option>-->
<#--                                <option value="学校" >学校</option>-->
<#--                            </select>-->
                        </div>
                        <span style="color: red">必填</span>
                    </div>

                    <div class="layui-form-item">
                        <label class="layui-form-label">申请报销</label>
                        <div class="layui-input-inline">
                            <input type="text" name="moneyResource" placeholder="请输入申请报销经费" lay-verify="required" value="${project.moneyResource}"
                                   autocomplete="off" class="layui-input" pattern="^[1-9]\d*$">
<#--                            <select name="moneyResource" lay-filter="proResource" lay-verify="required">-->
<#--                                <option value="个人" selected="selected">个人</option>-->
<#--                                <option value="学校" >学校</option>-->
<#--                            </select>-->
                        </div>
                        <span style="color: red">必填</span>
                    </div>

                    <div class="layui-form-item">
                        <label class="layui-form-label">描述：</label>
                        <div class="layui-input-block">
                                <textarea id="description" name="desc" placeholder="请输入内容：必填" lay-verify="required" class="layui-textarea" style="width: 60%">${(project.desc)!}</textarea>
                        </div>
                    </div>


                    <div class="layui-form-item">
                        <label class="layui-form-label">指导老师</label>
                        <div class="layui-input-inline">
                            <select name="teacher" lay-filter="teacher" lay-verify="required">
                                <option value="">请选择指导老师</option>
                            <#list teachers as x>
                                <option value="${x.id}"
                                    <#if (project.teacher.num == x.name)> selected="selected" </#if>
                                >${x.name}</option>
                            </#list>
                            </select>
                        </div>
                        <span style="color: red">必填</span>
                    </div>

                    <div class="layui-form-item">
                        <label class="layui-form-label">上传资料</label>
                        <div class="layui-input-block">
                            <button type="button" class="layui-btn" id="upload" lay-verify="required">
                                <i class="layui-icon">&#xe67c;</i>凭证照片或资料
                            </button>
                            <span style="color: red">必填，文件大小为100M</span>
                            <input type="hidden" name="book">
                        </div>
                    </div>

<#--                    <div class="layui-form-item">-->
<#--                        <label class="layui-form-label">上传视频</label>-->
<#--                        <div class="layui-input-block">-->
<#--                            <button type="button" class="layui-btn" id="uploadVideo">-->
<#--                                <i class="layui-icon">&#xe67c;</i>上传参赛视频-->
<#--                            </button>-->
<#--                            <input type="hidden" name="video" lay-verify="required">-->
<#--                            <span style="color: red">必填，文件大小为100M,格式为MP4</span>-->
<#--                        </div>-->
<#--                    </div>-->

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
    }).use('student/form');
</script>
</body>

</html>
