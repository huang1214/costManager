package com.jcohy.scis.controller;

import com.jcohy.scis.common.JsonResult;
import com.jcohy.scis.common.PageJson;
import com.jcohy.scis.model.*;
import com.jcohy.scis.service.DeptService;
import com.jcohy.scis.service.MajorService;
import com.jcohy.scis.service.StudentService;
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
@RequestMapping("/admin/student")
public class AdminStudentController extends BaseController{

    @Autowired
    private StudentService studentService;

    @Autowired
    private DeptService deptService;

    @Autowired
    private MajorService majorService;

    @GetMapping("/list")
    @ResponseBody
    public PageJson<Student> all(ModelMap map){
        PageRequest pageRequest = getPageRequest();
        Page<Student> students = studentService.findAll(pageRequest);
        PageJson<Student> page = new PageJson<>();
        page.setCode(0);
        page.setMsg("成功");
        page.setCount(students.getContent().size());
        page.setData(students.getContent());
        return page;
    }

    @GetMapping("/form")
    public String form(@RequestParam(required = false) Integer id, ModelMap map){
        List<Dept> depts = deptService.findAll();
        List<Major> majors = majorService.findAll();
        map.put("depts",depts);
        map.put("majors",majors);
        if(id != null){
            Student student = studentService.findById(id);
            map.put("student",student);
        }
        return "admin/student/form";
    }

    @PostMapping("/save")
    @ResponseBody
    public JsonResult save(Student student){
        try {
            studentService.saveOrUpdate(student);
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
            studentService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.fail("删除失败");
        }
        return JsonResult.ok();
    }
}
