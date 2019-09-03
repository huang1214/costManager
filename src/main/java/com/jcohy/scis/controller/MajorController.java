package com.jcohy.scis.controller;

import com.jcohy.scis.common.JsonResult;
import com.jcohy.scis.model.Dept;
import com.jcohy.scis.model.Major;
import com.jcohy.scis.service.DeptService;
import com.jcohy.scis.service.MajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Copyright  : 2017- www.jcohy.com
 * Created by jiac on 22:15 2018/4/6
 * Email: jia_chao23@126.com
 * ClassName: MajorController
 * Description:
 **/
@Controller
@RequestMapping("/major/")
public class MajorController extends BaseController{

    @Autowired
    private MajorService majorService;

    @Autowired
    private DeptService deptService;

    @GetMapping("/dept")
    @ResponseBody
    public JsonResult getCategoryByTypeId(@RequestParam Integer id){
        System.out.println(id);
        Dept dept = deptService.findById(id);
        List<Major> categories = majorService.findByDept(dept);
        return JsonResult.ok("majors",categories);
    }

}
