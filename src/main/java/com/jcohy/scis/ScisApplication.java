package com.jcohy.scis;

import com.jcohy.scis.interception.CommonIntercepter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.servlet.MultipartConfigElement;

@SpringBootApplication
@Configuration
public class ScisApplication extends WebMvcConfigurerAdapter{

	@Autowired
	private CommonIntercepter commonIntercepter;


	public static void main(String[] args) {
		SpringApplication.run(ScisApplication.class, args);
	}


	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(commonIntercepter).addPathPatterns("/admin/**");
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		//登录首页
		registry.addViewController("/").setViewName("index");
		registry.addViewController("/index").setViewName("login");
		//修改密码
		registry.addViewController("/admin/update").setViewName("/update");
		//学生主页跳转
//		registry.addViewController("/student/main").setViewName("/student/main");
		registry.addViewController("/student/index").setViewName("/student/index");
		registry.addViewController("/student/notice").setViewName("/student/notice");
		//专家主页跳转
		registry.addViewController("/expert/main").setViewName("/expert/main");
		registry.addViewController("/expert/index").setViewName("/expert/index");
		registry.addViewController("/expert/examine").setViewName("/expert/examine");
		registry.addViewController("/expert/notice").setViewName("/expert/notice");
		//老师主页跳转
		registry.addViewController("/teacher/main").setViewName("/teacher/main");
		registry.addViewController("/teacher/index").setViewName("/teacher/index");
		registry.addViewController("/teacher/examine").setViewName("/teacher/examine");
		registry.addViewController("/teacher/notice").setViewName("/teacher/notice");
		//管理员主页，从登录
		registry.addViewController("/admin/main").setViewName("/admin/main");
		registry.addViewController("/admin/index").setViewName("/admin/index");
		registry.addViewController("/admin/notice").setViewName("/admin/notice");
		registry.addViewController("/admin/student/index").setViewName("/admin/student/index");

		registry.addViewController("/admin/teacher/index").setViewName("/admin/teacher/index");

		registry.addViewController("/admin/expert/index").setViewName("/admin/expert/index");

		registry.addViewController("/admin/allot/index").setViewName("/admin/allot/index");

		registry.addViewController("/admin/circular/index").setViewName("/admin/circular/index");

		registry.addViewController("/admin/project/index").setViewName("/admin/project/index");

		registry.addViewController("/admin/dept/index").setViewName("/admin/dept/index");
		registry.addViewController("/admin/major/index").setViewName("/admin/major/index");
		registry.addViewController("/admin/type/index").setViewName("/admin/type/index");
		registry.addViewController("/admin/type/update").setViewName("/admin/type/update");
		registry.addViewController("/admin/graph/index").setViewName("/admin/graph/index");

	}

	@Bean
	public MultipartConfigElement multipartConfigElement() {
		MultipartConfigFactory factory = new MultipartConfigFactory();
		//单个文件最大
		factory.setMaxFileSize("102400KB"); //KB,MB
		/// 设置总上传数据总大小
		factory.setMaxRequestSize("102400KB");
		return factory.createMultipartConfig();
	}
}
