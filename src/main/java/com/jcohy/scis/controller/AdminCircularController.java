package com.jcohy.scis.controller;

import com.jcohy.scis.common.JsonResult;
import com.jcohy.scis.common.PageJson;
import com.jcohy.scis.model.Circular;
import com.jcohy.scis.service.CircularService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by jiac on 2018/1/31 15:23.
 * ClassName  : AdminCircularController
 * Description  :
 */
@Controller
@RequestMapping("/admin/circular")
public class AdminCircularController {

    @Autowired
    private CircularService circularService;

    @GetMapping("/list")
    @ResponseBody
    public PageJson<Circular> all(ModelMap map){
        List<Circular> categories = circularService.findAll();
        PageJson<Circular> page = new PageJson<>();
        page.setCode(0);
        page.setMsg("成功");
        page.setCount(categories.size());
        page.setData(categories);
        return page;
    }

    @GetMapping("/form")
    public String form(@RequestParam(required = false) Integer id, ModelMap map){

        if(id != null){
            Circular circular = circularService.findById(id);
            map.put("circular",circular);
        }
        return "admin/circular/form";
    }

    @PostMapping("/save")
    @ResponseBody
    public JsonResult save(Circular circular){
        try {
            if(circular.getVisible() == null){
                circular.setVisible(0);
            }
            circularService.saveOrUpdate(circular);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.fail("添加失败");
        }
        return JsonResult.ok();
    }

    @DeleteMapping("{id}/del")
    @ResponseBody
    public JsonResult del(@PathVariable("id") Integer id){
        try {
            circularService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.fail("删除失败");
        }
        return JsonResult.ok();
    }
    @GetMapping("{id}/change")
    @ResponseBody
    public JsonResult change(@PathVariable("id") Integer id, String type){
        try {
            circularService.change(id,type);

        } catch (Exception e) {

            e.printStackTrace();
            return JsonResult.fail(e.getMessage());
        }
        return JsonResult.ok();
    }
}
