layui.define(['element', 'layer', 'util', 'form','common'], function (exports) {
    var $ = layui.jquery,
        element = layui.element,
        form = layui.form,
        layer = layui.layer,
        util = layui.util,
        form = layui.form,
        common = layui.common;
    //登录后禁用后退功能。
    $(document).ready(function(e) {
        if (window.history && window.history.pushState) {
            $(window).on('popstate', function () {
                window.history.pushState('forward', null, '#');
                window.history.forward(1);
            });
        }
        window.history.pushState('forward', null, '#'); //在IE中必须得有这两行
        window.history.forward(1);
    });

    //监听左侧导航点击
    element.on('nav(leftnav)', function (elem) {
        var url = $(elem).children('a').attr('data-url');   //页面url
        var id = $(elem).children('a').attr('data-id');     //tab唯一Id
        var title = $(elem).children('a').text();           //菜单名称
            if (title == "首页") {
                element.tabChange('tab', 0);
                return;
            }
            if (url == undefined) return;

            var tabTitleDiv = $('.layui-tab[lay-filter=\'tab\']').children('.layui-tab-title');
            var exist = tabTitleDiv.find('li[lay-id=' + id + ']');
            if (exist.length > 0) {
                //切换到指定索引的卡片
                element.tabChange('tab', id);
            } else {
                var index = layer.load(1);
                //由于Ajax调用本地静态页面存在跨域问题，这里用iframe
                setTimeout(function () {
                    //模拟菜单加载
                    layer.close(index);
                    element.tabAdd('tab', { title: title, content: '<iframe src="' + url + '" style="width:100%;height:100%;border:none;outline:none;"></iframe>', id: id });
                    //切换到指定索引的卡片
                    element.tabChange('tab', id);
                }, 500);
            }

    });

    //监听快捷菜单点击
    $('.short-menu .layui-field-box>div>div').click(function () {
        var elem = this;
        var url = $(elem).children('span').attr('data-url');
        var id = $(elem).children('span').attr('data-id');
        var title = $(elem).children('span').text();

        if (url == undefined) return;

        var tabTitleDiv = $('.layui-tab[lay-filter=\'tab\']').children('.layui-tab-title');
        var exist = tabTitleDiv.find('li[lay-id=' + id + ']');
        if (exist.length > 0) {
            //切换到指定索引的卡片
            element.tabChange('tab', id);
        } else {
            var index = layer.load(1);
            //由于Ajax调用本地静态页面存在跨域问题，这里用iframe
            setTimeout(function () {
                //模拟菜单加载
                layer.close(index);
                element.tabAdd('tab', { title: title, content: '<iframe src="' + url + '" style="width:100%;height:100%;border:none;outline:none;"></iframe>', id: id });
                //切换到指定索引的卡片
                element.tabChange('tab', id);
            }, 500);
        }
        $('div.short-menu').slideUp('fast');
    });

    //监听侧边导航开关
    form.on('switch(sidenav)', function (data) {
        if (data.elem.checked) {
            showSideNav();
            layer.msg('这个开关是layui的开关改编的');
        } else {
            hideSideNav();
        }
    });

    //收起侧边导航点击事件
    $('.layui-side-hide').click(function () {
        hideSideNav();
        $('input[lay-filter=sidenav]').siblings('.layui-form-switch').removeClass('layui-form-onswitch');
        $('input[lay-filter=sidenav]').prop("checked", false);
    });

    //鼠标靠左展开侧边导航
    $(document).mousemove(function (e) {
        if (e.pageX == 0) {
            showSideNav();
            $('input[lay-filter=sidenav]').siblings('.layui-form-switch').addClass('layui-form-onswitch');
            $('input[lay-filter=sidenav]').prop("checked", true);
        }
    });

    var ishide = false;
    //隐藏侧边导航
    function hideSideNav() {
        if (!ishide) {
            $('.layui-side').animate({ left: '-200px' });
            $('.layui-side-hide').animate({ left: '-200px' });
            $('.layui-body').animate({ left: '0px' });
            $('.layui-footer').animate({ left: '0px' });
            var tishi = layer.msg('鼠标靠左自动显示菜单', { time: 1500 });
            layer.style(tishi, {
                top: 'auto',
                bottom: '50px'
            });
            ishide = true;
        }
    }
    //显示侧边导航
    function showSideNav() {
        if (ishide) {
            $('.layui-side').animate({ left: '0px' });
            $('.layui-side-hide').animate({ left: '0px' });
            $('.layui-body').animate({ left: '200px' });
            $('.layui-footer').animate({ left: '200px' });
            ishide = false;
        }
    }
    $('#updatePassword').click(function () {
        var index = layer.load(1);
        setTimeout(function () {
            layer.close(index);
            common.frame_show('修改密码','/admin/update',$(window).width()*0.6,$(window).height()*0.6);
            // layer.msg('打开添加窗口');
        }, 500);
    });

    exports('main', {});
});
