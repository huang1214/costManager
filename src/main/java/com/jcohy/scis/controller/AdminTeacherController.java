package com.jcohy.scis.controller;

import com.jcohy.scis.common.JsonResult;
import com.jcohy.scis.common.PageJson;
import com.jcohy.scis.model.Dept;
import com.jcohy.scis.model.Teacher;
import com.jcohy.scis.service.DeptService;
import com.jcohy.scis.service.MajorService;
import com.jcohy.scis.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by jiac on 2018/4/2.
 * Description  :
 */
@Controller
@RequestMapping("/admin/teacher")
public class AdminTeacherController extends BaseController{

    @Autowired
    private TeacherService teacherService;
    @Autowired
    private DeptService deptService;


    @GetMapping("/index")
    public String index(ModelMap map){
        List<Dept> depts = deptService.findAll();
        map.put("depts",depts);
        return "admin/teacher/index";
    }

    @GetMapping("/list")
    @ResponseBody
    public PageJson<Teacher> all(ModelMap map){
        PageRequest pageRequest = getPageRequest();
        Page<Teacher> teachers = teacherService.findAll(pageRequest);
        PageJson<Teacher> page = new PageJson<>();
        page.setCode(0);
        page.setMsg("成功");
        page.setCount(teachers.getContent().size());
        page.setData(teachers.getContent());
        return page;
    }

    @GetMapping("/form")
    public String form(@RequestParam(required = false) Integer id, ModelMap map){
        List<Dept> depts = deptService.findAll();
        map.put("depts",depts);
        if(id != null){
            Teacher teacher = teacherService.findById(id);
            map.put("teacher",teacher);
        }
        return "admin/teacher/form";
    }

    @PostMapping("/save")
    @ResponseBody
    public JsonResult save(Teacher teacher){
        try {
            teacherService.saveOrUpdate(teacher);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.fail(e.getMessage());
        }
        return JsonResult.ok();
    }

    @DeleteMapping("{id}/del")
    @ResponseBody
    public JsonResult del(@PathVariable("id") Integer id){
        try {
            teacherService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.fail("删除失败");
        }
        return JsonResult.ok();
    }
}
