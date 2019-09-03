layui.use(['jquery','carousel','layer','form'], function (exports) {
    var $ = layui.jquery;
    var form = layui.form;
    var width = width || window.innerWeight || document.documentElement.clientWidth || document.body.clientWidth;
    width = width>1200 ? 1170 : (width > 992 ? 962 : width);
    var carousel = layui.carousel;
    //建造实例
    carousel.render({
      elem: '#carousel'
      ,width: width+'px' //设置容器宽度
      ,height:'360px'
      ,indicator: 'inside'
      ,arrow: 'always' //始终显示箭头
      ,anim: 'default' //切换动画方式
      
    });

    //搜索
    // $('#search').click(function () {
    //     var keyword = $("#keyword").val();
    //     console.log(keyword);
    //     $.ajax({
    //         type: "POST",
    //         dataType: "json",
    //         url: "/project/search?keyword="+keyword,
    //         success:function(result) {
    //             if (result.isOk) {
    //                 console.log(result.data);
    //                 createHtml(result.data);
    //             } else {
    //                 layer.msg(result.msg,{anim:6});
    //             }
    //         }
    //     });
    // });
    form.on('submit(formSearch)', function (data) {
        var keyword = $("#keyword").val();
        $.ajax({
            type: "POST",
            dataType: "json",
            url: "/project/search?keyword="+keyword,
            success:function(result) {
                if (result.isOk) {
                    console.log(result.data);
                    createHtml(result.data);
                } else {
                    layer.msg(result.msg,{anim:6});
                }
            }
        });
        return false;
    });
    // function createHtml(data) {
    //     var project = $("#project");
    //     var projectRight = $("#projectRight");
    //     var projectLeft = $("#projectLeft");
    //     projectLeft.empty();
    //     projectRight.empty();
    //     var detailHtml = '';
    //     for(var i=0;i<data.length;i++){
    //         detailHtml += '<div class="article shadow animated fadeInLeft">';
    //         detailHtml += '<div class="article-left ">';
    //         detailHtml += '<img src="/images/01.jpg" alt="'+data[i].name+'"/>';
    //         detailHtml += '</div>';
    //         detailHtml += '<div class="article-right">';
    //         detailHtml += '<div class="article-title">';
    //         detailHtml += '<a href="/project/'+data[i].id+'">项目名称：'+data[i].name+'</a></div>';
    //         detailHtml += '<div class="article-abstract">项目来源：'+data[i].proResource+'</div>';
    //         detailHtml += '<div class="article-abstract">经费来源：'+data[i].moneyResource+'</div>';
    //         detailHtml += '<div class="article-abstract">项目描述：'+data[i].desc+'</div>';
    //         detailHtml += '<div class="article-abstract">指导老师：'+data[i].teacher.name+'</div>';
    //         detailHtml += '</div>';
    //         detailHtml += '<div class="clear"></div>';
    //         detailHtml += '<div class="article-footer">';
    //         detailHtml += '<span><i class="fa fa-user"></i>&nbsp;&nbsp;'+data[i].student.name+'</span>';
    //         detailHtml += '<span class="article-author"><i class="fa fa-clock-o"></i>&nbsp;&nbsp;'+data[i].createDate+'</span>';
    //         detailHtml += '</div></div>';
    //     }
    //     projectLeft.append(detailHtml);
    //     detailHtml = '';
    //     for(var i=0;i<data.length;i++){
    //         detailHtml += '<div class="article shadow animated fadeInLeft">';
    //         if(data[i].video.downloadUrl == null) {
    //             detailHtml += '<div class="video_div" style="width: 73%">';
    //             detailHtml += '<img src="/images/01.jpg" alt="' + data[i].name + '"/>';
    //             detailHtml += '</div>';
    //             detailHtml += '<div style="float: right;width: 20%">' + data[i].name + "项目无参赛视频";
    //             detailHtml += '</div>';
    //         }else{
    //             detailHtml += '<div class="video_div" style="width: 73%">';
    //             detailHtml += '<video id="my-video" class="video-js vjs-default-skin" controls preload="none"  data-setup="{}" poster="http://vjs.zencdn.net/v/oceans.png">';
    //             detailHtml += '<source src="http://vjs.zencdn.net/v/oceans.mp4" type="video/mp4">';
    //             detailHtml += '</video>';
    //             detailHtml += '</div>';
    //             detailHtml += '<div style="float: right;width: 20%">'+data[i].name + "项目参赛视频";
    //             detailHtml += '</div>';
    //         }
    //         detailHtml += '</div>';
    //     }
    //     projectRight.append(detailHtml);
    //     project.append(projectRight);
    //     project.append(projectLeft);
    // }
    function createHtml(data) {
        obj = $("#projectLeft");
        obj.empty();
        var detailHtml = '';
        for(var i=0;i<data.length;i++){
            detailHtml += '<div class="article shadow animated fadeInLeft">';
            detailHtml += '<div class="article-right">';
            detailHtml += '<div class="article-title">';
            detailHtml += '<a href="/project/'+data[i].id+'">竞赛项目名称：'+data[i].name+'</a></div>';
            detailHtml += '<div class="article-abstract">项目来源：'+data[i].proResource+'&nbsp;&nbsp;经费预算：'+data[i].moneyResource+'</div>';
            detailHtml += '<div class="article-abstract">';
            //detailHtml += '<a href="/project/video/'+data[i].id+'">项目视频地址：'+data[i].video.downloadUrl+'</a></div>';
            detailHtml += '<div class="article-abstract">项目描述：'+data[i].desc+'</div>';
            detailHtml += '<div class="article-abstract">指导老师：'+data[i].teacher.name+'</div>';
            detailHtml += '</div>';
            detailHtml += '<div class="clear"></div>';
            detailHtml += '<div class="article-footer">';
            detailHtml += '<span><i class="fa fa-user"></i>&nbsp;&nbsp;'+data[i].student.name+'</span>';
            detailHtml += '<span><i class="fa fa-user"></i>&nbsp;&nbsp;'+data[i].teacher.name+'老师</span>';
            detailHtml += '<span class="article-author"><i class="fa fa-clock-o"></i>&nbsp;&nbsp;'+data[i].createDate+'</span>';
            detailHtml += '</div></div>';
        }
        obj.append(detailHtml);
    }
    $(function () {
        //播放公告
        playAnnouncement(5000);
    });
    
    function playAnnouncement(interval) {
        var index = 0;
        var $announcement = $('.home-tips-container>span');
        //自动轮换
        setInterval(function () {
            index++;    //下标更新
            if (index >= $announcement.length) {
                index = 0;
            }
            $announcement.eq(index).stop(true, true).fadeIn().siblings('span').fadeOut();  //下标对应的图片显示，同辈元素隐藏
        }, interval);
    }

    exports('index', {});
});