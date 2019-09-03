package com.jcohy.scis.controller;

import com.jcohy.scis.common.JsonResult;
import com.jcohy.scis.common.PageJson;
import com.jcohy.scis.model.Expert;
import com.jcohy.scis.service.ExpertService;
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
@RequestMapping("/admin/expert")
public class AdminExpertsController extends BaseController{

    @Autowired
    private ExpertService expertService;


    @GetMapping("/list")
    @ResponseBody
    public PageJson<Expert> all(ModelMap map){
        PageRequest pageRequest = getPageRequest();
        Page<Expert> experts = expertService.findAll(pageRequest);
        PageJson<Expert> page = new PageJson<>();
        page.setCode(0);
        page.setMsg("成功");
        page.setCount(experts.getContent().size());
        page.setData(experts.getContent());
        return page;
    }

    @GetMapping("/form")
    public String form(@RequestParam(required = false) Integer id, ModelMap map){

        if(id != null){
            Expert expert = expertService.findById(id);
            map.put("expert", expert);
        }
        return "admin/expert/form";
    }

    @PostMapping("/save")
    @ResponseBody
    public JsonResult save(Expert expert){
        try {
            expertService.saveOrUpdate(expert);
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
            expertService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.fail("删除失败");
        }
        return JsonResult.ok();
    }
}
