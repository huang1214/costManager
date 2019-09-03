package com.jcohy.scis.controller;

import com.jcohy.scis.common.JsonResult;
import com.jcohy.scis.common.PageJson;
import com.jcohy.scis.model.Dept;
import com.jcohy.scis.model.Major;
import com.jcohy.scis.service.DeptService;
import com.jcohy.scis.service.MajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by jiac on 2018/5/25.
 * ClassName  : com.jcohy.scis.controller
 * Description  :
 */
@Controller
@RequestMapping("/admin/major")
public class AdminMajorController {

    @Autowired
    private MajorService majorService;

    @Autowired
    private DeptService deptService;

    @GetMapping("/list")
    @ResponseBody
    public PageJson<Major> all(ModelMap map){
        List<Major> majors = majorService.findAll();
        PageJson<Major> page = new PageJson<>();
        page.setCode(0);
        page.setMsg("成功");
        page.setCount(majors.size());
        page.setData(majors);
        return page;
    }

    @GetMapping("/form")
    public String form(@RequestParam(required = false) Integer id, ModelMap map){
        List<Dept> depts = deptService.findAll();
        map.put("depts",depts);
        if(id != null){
            Major major = majorService.findById(id);
            map.put("major",major);
        }
        return "admin/major/form";
    }

    @PostMapping("/save")
    @ResponseBody
    public JsonResult save(Major major){
        try {
            if(major.getId() == null){
                List<Major> num = majorService.findByNum(major.getNum());
                if(num == null || num.size()>0){
                    return JsonResult.fail("此专业已存在");
                }
            }
            majorService.save(major);
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
            majorService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.fail("删除失败");
        }
        return JsonResult.ok();
    }

//    @GetMapping("/{id}/change")
//    @ResponseBody
//    public JsonResult change(@PathVariable("id") Long id, String type){
//        try {
//            deptService.change(id,type);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            return JsonResult.fail(e.getMessage());
//        }
//        return JsonResult.ok("操作成功");
//    }
}
