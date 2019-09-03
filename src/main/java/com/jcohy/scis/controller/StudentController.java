package com.jcohy.scis.controller;

import com.jcohy.lang.StringUtils;
import com.jcohy.scis.common.JsonResult;
import com.jcohy.scis.common.PageJson;
import com.jcohy.scis.model.*;
import com.jcohy.scis.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/student")
public class StudentController extends BaseController{

    @Autowired
    private StudentService studentService;


    @Autowired
    private TeacherService teacherService;

    @Autowired
    private ProjectService projectService;

    @Autowired
    private AllotService allotService;

    @Autowired
    private NoticeService noticeService;

    @Autowired
    private TypeService typeService;

    @Autowired
    private ExpertService expertService;

    @Autowired
    private DeptService deptService;

    private Logger logger = LoggerFactory.getLogger(StudentController.class);

    @GetMapping("/main")
    public String main(ModelMap map){
        List<Notice> notices = noticeService.findAll();
        map.put("size",notices.size());
        map.put("url","/notice/list");
        return "/student/main";
    }

    @GetMapping("/notice/all")
    @ResponseBody
    public PageJson<Notice> notice(@SessionAttribute("user") Student student , ModelMap map){
        List<Notice> notices = noticeService.findbyNum(student.getNum());
        List<Notice> noticeList = notices.stream().filter(x -> x.getLevel() <= 3).collect(Collectors.toList());
        PageJson<Notice> page = new PageJson<>();
        page.setCode(0);
        page.setMsg("成功");
        page.setCount(noticeList.size());
        page.setData(noticeList);
        return page;
    }

    @DeleteMapping("/notice/{id}/del")
    @ResponseBody
    public JsonResult del(@PathVariable("id") Integer id){
        try {
            noticeService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.fail("删除失败");
        }
        return JsonResult.ok();
    }

    @GetMapping("/project/list")
    @ResponseBody
    public PageJson<Project> all(@SessionAttribute("user") Student student , ModelMap map){
//        Student student = studentService.findByNum(num);
        List<Project> projects = projectService.findByStudent(student.getNum());
        for(Project project : projects){
            Expert expert = allotService.findByProject(project);
            if(expert == null){
                project.setExpert(null);
            }
            project.setExpert(expert);
        }
        PageJson<Project> page = new PageJson<>();
        page.setCode(0);
        page.setMsg("成功");
        page.setCount(projects.size());
        page.setData(projects);
        return page;
    }

    @GetMapping("/form")
    public String form(@RequestParam(required = false) Integer id, ModelMap map){
        List<Teacher> teachers = teacherService.findAll();
        List<Type> types = typeService.findAll();
        map.put("types",types);
        map.put("teachers",teachers);
        if(id != null){
            Project project = projectService.findById(id);
            map.put("project",project);
        }
        return "student/form";
    }


    /**
     *
     * @return
     */
    @PostMapping("/save")
    @ResponseBody
    public JsonResult saveOrUpdate(@SessionAttribute("user") Student student,Project project){
        if (project == null){
            System.out.println("project为空");
        }else{
            System.out.println(project);
            if (project.getTeam()!= null){
                if (!project.getTeam().equals("")){
                    String Teams = project.getTeam();
                    String[] team = Teams.split(",");
                    for(String num:team){
                        Student stu = studentService.findByNum(Long.parseLong(num));
                        System.out.println(stu);
                        if(stu==null){
                            return JsonResult.fail("学号："+num+"的学生不存在");
                        }
                    }
                }else{
                    project.setTeam("个人赛无团队");
                }
            } else{
                project.setTeam("个人赛无团队");
            }

            Project ret = projectService.findByName(project.getName());
            if(ret != null){
                return JsonResult.fail("此竞赛项目已经申报，请不要重复申报！");
            }

            project.setStudent(student);
            try {
                projectService.saveOrUpdate(project);
            } catch (Exception e) {
                e.printStackTrace();
                return JsonResult.fail(e.getMessage());
            }
            return JsonResult.ok();
        }
        return JsonResult.fail("project为空异常");

    }

    @DeleteMapping("/project/{id}/del")
    @ResponseBody
    public JsonResult delproject(@PathVariable("id") Integer id){
        try {
            List<Allot> allots = allotService.findByOtherId(id, "project");
            if(allots.size()>0){
                return JsonResult.fail("此项目已被分配，无法删除");
            }
            projectService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.fail("");
        }
        return JsonResult.ok();
    }

    @GetMapping("/teacher")
    public String teacher(@RequestParam(required = false) Integer id, ModelMap map){
        List<Teacher> teachers = teacherService.findAll();
        List<Dept> depts = deptService.findAll();
        map.put("depts",depts);
        map.put("teachers",teachers);
        if(id != null){
            Student student = studentService.findById(id);
            map.put("student",student);
        }
        return "teacher/teacher";
    }

    @GetMapping("/expert")
    public String expert(@RequestParam(required = false) Integer id, ModelMap map){
        List<Expert> experts = expertService.findAll();
        map.put("experts",experts);
        if(id != null){
            Student student = studentService.findById(id);
            map.put("student",student);
        }
        return "expert/expert";
    }

    @GetMapping("/list")
    @ResponseBody
    public PageJson<Student> student(@SessionAttribute("user") Student student , ModelMap map){
        List<Student> students = studentService.findAll();
        PageJson<Student> page = new PageJson<>();
        page.setCode(0);
        page.setMsg("成功");
        page.setCount(students.size());
        page.setData(students);
        return page;
    }


    @GetMapping("/search")
    @ResponseBody
    public PageJson search(String keyword,String dept,String major){
        List<Student> students = new ArrayList<>();
        PageJson<Student> page = new PageJson<>();
        if(StringUtils.isAllEmpty(keyword,dept,major)){
            students = studentService.findAll();
            page.setCode(0);
            page.setMsg("成功");
            page.setCount(students.size());
            page.setData(students);
            return page;
        }

        if(!StringUtils.isEmpty(keyword)){
            boolean isNum = keyword.matches("[0-9]+");
            if(isNum){
                Student student = studentService.findByNum(Long.parseLong(keyword));
                if(dept != null && !dept.equals("")){
                    if(major != null && major.equals("")){
                        if(student != null && student.getMajor().getName().equals(major)){
                            students.add(student);
                        }
                    }
                }else{
                    students.add(student);
                }
            }else{
                Student student = studentService.findByName(keyword);
                if(dept != null && !dept.equals("")){
                    if(student != null && student.getMajor().getName().equals(major)){
                        students.add(student);
                    }
                }else{
                    students.add(student);
                }
            }
        }else{
            List<Student> teacherList = studentService.findAll();
            if(!StringUtils.isEmpty(dept)){
                List<Student> list = teacherList.stream().filter(x -> x.getMajor().getName().equals(major)).collect(Collectors.toList());
                students = list;
            }else{
                students = teacherList;
            }
        }
        page.setCode(0);
        page.setMsg("成功");
        page.setCount(students.size());
        page.setData(students);
        return page;
    }
}
