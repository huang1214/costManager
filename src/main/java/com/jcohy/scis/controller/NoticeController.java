package com.jcohy.scis.controller;

import com.jcohy.scis.common.JsonResult;
import com.jcohy.scis.common.PageJson;
import com.jcohy.scis.model.Notice;
import com.jcohy.scis.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by jiac on 2018/5/10.
 * ClassName  : com.jcohy.scis.controller
 * Description  :
 */
@Controller
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    @RequestMapping("notice/{level}")
    @ResponseBody
    public PageJson<Notice> level(@PathVariable Integer level){
        List<Notice> notices = noticeService.findByLevel(level);

        PageJson<Notice> page = new PageJson<>();
        page.setCode(0);
        page.setMsg("成功");
        page.setCount(notices.size());
        page.setData(notices);
        return page;
    }
}
