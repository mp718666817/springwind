package com.example.controller;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/user")
public class UserController {
    /**
     * 上传的fileupload
     */
    @RequestMapping("/fileupload")
    public String testFileUpload(HttpServletRequest request) throws Exception {
        String path = request.getSession().getServletContext().getRealPath("/images/");
        File file = new File(path);
        if (!file.exists()){
            file.mkdirs();
        }

        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);

        List<FileItem> items = upload.parseRequest(request);

        for (FileItem item : items) {
            if(item.isFormField()){

            }
            else {
                // 获取上传文件的名称
                String filename = item.getName();
                System.out.println(filename);
                // 把文件的名称设置唯一值，uuid
                String uuid = UUID.randomUUID().toString().replace("-", "");
                filename = uuid+"_"+filename;
                System.out.println(filename);
                System.out.println(path);
                // 完成文件上传
                item.write(new File(path,filename));
                // 删除临时文件
                item.delete();
            }
        }

        System.out.println("方法执行。。。");
        return "success";
    }
    @RequestMapping("/fileupload1")
    public String testFileUpload1(HttpServletRequest request, MultipartFile upload) throws Exception {
        String path = request.getSession().getServletContext().getRealPath("/images/");
        File file = new File(path);
        if (!file.exists()){
            file.mkdirs();
        }

        // 获取上传文件的名称
        String filename = upload.getOriginalFilename();
        System.out.println(filename);
        // 把文件的名称设置唯一值，uuid
        String uuid = UUID.randomUUID().toString().replace("-", "");
        filename = uuid+"_"+filename;
        System.out.println(filename);
        System.out.println(path);
        // 完成文件上传
        upload.transferTo(new File(path,filename));
        // 删除临时文件


        System.out.println("方法执行。。。");
        return "success";
    }
    @RequestMapping("/fileupload2")
    public String testFileUpload2(MultipartFile upload) throws Exception {
        //获取url地址
        String path = "http://localhost:9090/fileuploadserver_war_exploded/uploads/";
        // 获取上传文件的名称
        String filename = upload.getOriginalFilename();
        // 把文件的名称设置唯一值，uuid
        /*String uuid = UUID.randomUUID().toString().replace("-", "");
        filename = uuid+"_"+filename;*/
        //创建客户端
        Client client = Client.create();
        WebResource resource = client.resource(path+filename);
        //上传文件
        resource.put(upload.getBytes());

        System.out.println("方法执行。。。");
        return "success";
    }


}
