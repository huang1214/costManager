package com.jcohy.scis.controller;

import com.jcohy.scis.common.JsonResult;
import com.jcohy.scis.common.PageJson;
import com.jcohy.scis.model.Project;
import com.jcohy.scis.model.Type;
import com.jcohy.scis.service.ProjectService;
import com.jcohy.scis.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Copyright  : 2017- www.jcohy.com
 * Created by jiac on 23:54 2018/2/6
 * Email: jia_chao23@126.com
 * ClassName: AdminTypeController
 * Description:
 **/
@Controller
@RequestMapping("/admin/type")
public class AdminTypeController {

    @Autowired
    private TypeService typeService;

    @Autowired
    private ProjectService projectService;

    @GetMapping("/list")
    @ResponseBody
    public PageJson<Type> all(ModelMap map){
        List<Type> typeList = typeService.findAll();
        PageJson<Type> page = new PageJson<>();
        page.setCode(0);
        page.setMsg("成功");
        page.setCount(typeList.size());
        page.setData(typeList);
        return page;
    }

    @GetMapping("/form")
    public String form(@RequestParam(required = false) Integer id, ModelMap map){

        if(id != null){
            Type type = typeService.findById(id);
            map.put("type",type);
        }
        return "admin/type/form";
    }

    @PostMapping("/save")
    @ResponseBody
    public JsonResult save(Type type){
        try {
            if(type.getId() == null){
                List<Type> num = typeService.findByNum(type.getNum());
                if(num == null || num.size()>0){
                    return JsonResult.fail("此类型已存在");
                }
            }
            typeService.saveOrUpdate(type);
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
            Type type = typeService.findById(id);
            List<Project> projects = projectService.findByType(type);
            if(projects.size()>0){
                return JsonResult.fail("此类别有项目引用，删除失败！！");
            }else{
                typeService.delete(id);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.fail("删除失败");
        }
        return JsonResult.ok();
    }

}
