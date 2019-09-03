package com.jcohy.scis.controller;

import com.jcohy.scis.common.JsonResult;
import com.jcohy.scis.common.PageJson;
import com.jcohy.scis.model.Dept;
import com.jcohy.scis.service.DeptService;
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
@RequestMapping("/admin/dept")
public class AdminDeptController {

    @Autowired
    private DeptService deptService;

    @GetMapping("/list")
    @ResponseBody
    public PageJson<Dept> all(ModelMap map){
        List<Dept> deptList = deptService.findAll();
        PageJson<Dept> page = new PageJson<>();
        page.setCode(0);
        page.setMsg("成功");
        page.setCount(deptList.size());
        page.setData(deptList);
        return page;
    }

    @GetMapping("/form")
    public String form(@RequestParam(required = false) Integer id, ModelMap map){

        if(id != null){
            Dept dept = deptService.findById(id);
            map.put("dept",dept);
        }
        return "admin/dept/form";
    }

    @PostMapping("/save")
    @ResponseBody
    public JsonResult save(Dept dept){
        try {
            if(dept.getId() == null){
                List<Dept> num = deptService.findByNum(dept.getNum());
                if(num == null || num.size()>0){
                    return JsonResult.fail("此学院已存在");
                }
            }
            deptService.save(dept);
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
            deptService.delete(id);
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
