package com.jcohy.scis.controller;

import com.jcohy.lang.StringUtils;
import com.jcohy.scis.common.JsonResult;
import com.jcohy.scis.exception.ServiceException;
import com.jcohy.scis.model.Admin;
import com.jcohy.scis.model.Expert;
import com.jcohy.scis.model.Student;
import com.jcohy.scis.model.Teacher;
import com.jcohy.scis.service.AdminService;
import com.jcohy.scis.service.ExpertService;
import com.jcohy.scis.service.StudentService;
import com.jcohy.scis.service.TeacherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * ClassName  : LoginController
 * Description  :登录模块处理
 */
@Controller
public class LoginController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
    @Autowired
    private AdminService adminService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private ExpertService expertService;


    /**
     * 登录处理
     * @param num
     * @param password
     * @param role
     * @return
     */
    @PostMapping("/login")
    @ResponseBody
    public JsonResult login(Long num, String password,
                            @RequestParam(required = false) String role, HttpServletRequest request){
        try {
            if(num == null || StringUtils.isEmpty(password)){
                return JsonResult.fail("用户名或者密码不能为空");
            }
            HttpSession session = request.getSession();
            session.setAttribute("role",role);
            logger.error("name:{}  password:{}  type:{}",num,password,role);
            switch (StringUtils.trim(role)) {
                case "student": {
                    Student login = studentService.login(num, password);
                    if (login == null) {
                        return JsonResult.fail("登录失败,用户名不存在");
                    }
                    if (!login.getPassword().equals(password)) {
                        return JsonResult.fail("登录失败,用户名账号密码不匹配");
                    }
                    session.setAttribute("user", login);
                    return JsonResult.ok().set("returnUrl", "/student/main");
                }
                case "teacher": {
                    Teacher login = teacherService.login(num, password);
                    if (login == null) {
                        return JsonResult.fail("登录失败,用户名不存在");
                    }
                    if (!login.getPassword().equals(password)) {
                        return JsonResult.fail("登录失败,用户名账号密码不匹配");
                    }
                    session.setAttribute("user", login);
                    return JsonResult.ok().set("returnUrl", "/teacher/main");
                }
                case "expert": {
                    Expert login = expertService.login(num, password);
                    if (login == null) {
                        return JsonResult.fail("登录失败,用户名不存在");
                    }
                    if (!login.getPassword().equals(password)) {
                        return JsonResult.fail("登录失败,用户名账号密码不匹配");
                    }
                    session.setAttribute("user", login);
                    return JsonResult.ok().set("returnUrl", "/expert/main");
                }
                case "admin": {
                    Admin login = adminService.login(num, password);
                    if (login == null) {
                        return JsonResult.fail("登录失败,用户名不存在");
                    }
                    if (!login.getPassword().equals(password)) {
                        return JsonResult.fail("登录失败,用户名账号密码不匹配");
                    }
                    session.setAttribute("user", login);
                    return JsonResult.ok().set("returnUrl", "/admin/main");
                }
            }
        } catch (Exception e) {
            return JsonResult.fail(e.getMessage());
        }
        return JsonResult.fail("角色不存在");
    }


    /**
     * 注销用户
     * @param request
     * @param response
     * @return
     */
    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response){

        return "redirect:/";
    }



    @PostMapping("/admin/update/")
    @ResponseBody
    public JsonResult updatePassword(@SessionAttribute("role") String role,@RequestParam Long num,@RequestParam String oldPassword, @RequestParam String newPassword,
                                 @RequestParam String rePassword, ModelMap map){
        logger.error("role:{}",role);
        if(StringUtils.isEmpty(role)){
            return JsonResult.fail("此用户不存在");
        }
        if(StringUtils.isBlank(oldPassword) || StringUtils.isBlank(newPassword) || StringUtils.isBlank(rePassword)){
            return JsonResult.fail("参数不完整");
        }
        if(!newPassword.equals(rePassword)){
            return JsonResult.fail("两次输入密码不一致");
        }
        if(role.equals("student")){
            Student dbUser = studentService.findByNum(num);
            if(!dbUser.getPassword().equals(oldPassword)){
                return JsonResult.fail("旧密码不正确");
            }
            dbUser.setPassword(newPassword);
            studentService.updatePassword(dbUser);
        }else if(role.equals("teacher")){
            Teacher dbUser = teacherService.findByNum(num);
            if(!dbUser.getPassword().equals(oldPassword)){
                return JsonResult.fail("旧密码不正确");
            }
            dbUser.setPassword(newPassword);
            teacherService.updatePassword(dbUser);
        }else if(role.equals("expert")){
            Expert dbUser = expertService.findByNum(num);
            if(!dbUser.getPassword().equals(oldPassword)){
                return JsonResult.fail("旧密码不正确");
            }
            dbUser.setPassword(newPassword);
            expertService.updatePassword(dbUser);
        }else if(role.equals("admin")){
            Admin dbUser = adminService.findByNum(num);
            if(!dbUser.getPassword().equals(oldPassword)){
                return JsonResult.fail("旧密码不正确");
            }
            dbUser.setPassword(newPassword);
            adminService.updatePassword(dbUser);
        }
        return JsonResult.ok();
    }


}
