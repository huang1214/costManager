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
                        <input type="hidden" name="id"  value="${(student.id)!}" >
                    </div>


                    <div class="layui-form-item" style="margin-top: 10px">
                        <label class="layui-form-label">学号</label>
                        <div class="layui-input-inline">
                            <input type="text" name="num" lay-verify="number"  placeholder="请输入学号" value="${(student.num?c)!}"
                                   autocomplete="off" class="layui-input ">
                        </div>
                    </div>


                    <div class="layui-form-item">
                        <label class="layui-form-label">姓名</label>
                        <div class="layui-input-inline">
                            <input type="text" name="name" lay-verify="required" placeholder="请输入姓名" value="${student.name}"
                                   autocomplete="off" class="layui-input">
                        </div>
                    </div>


                    <div class="layui-form-item">
                        <label class="layui-form-label">密码</label>
                        <div class="layui-input-inline">
                            <input type="text" name="password" lay-verify="required" placeholder="请输入密码" value="${student.password}"
                                   autocomplete="off" class="layui-input">
                        </div>
                    </div>


                    <div class="layui-form-item">
                        <label class="layui-form-label">性别</label>
                        <div class="layui-input-inline">
                            <input type="radio" name="sex" title="男" value="男" <#if student.sex == "男">checked</#if> />
                            <input type="radio" name="sex" title="女" value="女" <#if student.sex == "女">checked</#if> />
                        </div>
                    </div>

                    <div class="layui-form-item">
                        <label class="layui-form-label">电话</label>
                        <div class="layui-input-inline">
                            <input type="text" name="phone" lay-verify="required" placeholder="请输入电话" value="${student.phone}"
                                   autocomplete="off" class="layui-input">
                        </div>
                    </div>


                    <div class="layui-form-item">
                        <label class="layui-form-label">请选择院系</label>
                        <div class="layui-input-inline">
                            <select name="dept" lay-filter="depts">
                                <option value="">请选择院系</option>
                            <#list depts as x>
                                <option value="${x.id}"
                                    <#if (student.major.dept.name == x.name)> selected="selected" </#if>
                                >${x.name}</option>
                            </#list>
                            </select>
                        </div>
                        <div class="layui-input-inline">
                            <select name="major" lay-filter="majors">
                                <option value="">请选择专业</option>
                            <#list majors as x>
                                <option value="${x.id}"
                                    <#if (student.major.name == x.name)> selected="selected" </#if>
                                >${x.name}</option>
                            </#list>
                            </select>
                        </div>
                    </div>

                    <div class="layui-form-item">
                        <label class="layui-form-label">班级</label>
                        <div class="layui-input-inline">
                            <input type="text" name="sclass" lay-verify="required" placeholder="请输入班级" value="${student.sclass}"
                                   autocomplete="off" class="layui-input">
                        </div>
                    </div>

                    <div class="layui-form-item">
                        <label class="layui-form-label">出生日期</label>
                        <div class="layui-input-inline">
                            <input type="text" name="birth" value="${(student.birth)!}" class="layui-input" id="birth">
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
    }).use('admin/student/form');
</script>
</body>

</html>
