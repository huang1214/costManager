package com.jcohy.scis.controller;

import com.jcohy.scis.common.JsonResult;
import com.jcohy.scis.model.Book;
import com.jcohy.scis.service.BookService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by jiac on 2017/12/27 16:04.
 * ClassName  : UploadController
 * Description  :
 */
@Controller
public class UploadController {

    @Autowired
    private BookService bookService;

    @Value("${file.path}")
    private String filePath;

    @PostMapping("/upload")
    @ResponseBody
    public JsonResult upload(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws FileNotFoundException {
        //上传到服务器的地址
        File upload = null;
        //上传到服务器的文件名
        String fileName = file.getOriginalFilename();
        StringBuffer url = request.getRequestURL();
        System.out.println("requestUrl----"+url.toString());
        upload = new File(filePath);
        if(!upload.exists()) upload.mkdirs();
        System.out.println("upload url:"+upload.getAbsolutePath());
        try {
            FileUtils.copyInputStreamToFile(file.getInputStream(),new File(upload+File.separator+fileName));
        } catch (IOException e) {
            e.printStackTrace();
            return JsonResult.fail(e.getMessage());
        }
        String downloadUrl = StringUtils.replace(url.toString(), "upload", "download");
        System.out.println("replaceUrl-----"+downloadUrl);
        Map<String,String> map = new HashMap<>();

        Book book = new Book();
        book.setName(fileName);
        book.setDownloadUrl(downloadUrl+"/"+fileName);
        book.setUploadUrl(filePath);
        book.setStatus("1");
        Book book1 = bookService.saveOrUpdate(book);
        return JsonResult.ok("book",book1);
    }

    @GetMapping("/download/{name}")
    public void download(@PathVariable("name") String name, HttpServletResponse response) throws IOException {


        File file = new File(filePath+File.separator+name);
        System.out.println(file);
        if(file.exists()) {
            // 设置强制下载不打开
            response.setContentType("application/force-download");
            // 设置文件名
            response.addHeader("Content-Disposition", "attachment;fileName=" + name);

            FileInputStream inputStream = new FileInputStream(file);
            byte[] data = new byte[(int)file.length()];
            int length = inputStream.read(data);
            inputStream.close();
            OutputStream stream = response.getOutputStream();
            stream.write(data);
            stream.flush();
            stream.close();
        }
    }
}
