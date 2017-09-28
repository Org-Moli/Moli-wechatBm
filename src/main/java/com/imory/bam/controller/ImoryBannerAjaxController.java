package com.imory.bam.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.imory.bam.sysuser.bean.ImoryBanner;
import com.imory.bam.sysuser.service.ImoryBannerService;

@RestController
@RequestMapping("/bam/imoryBanner")
public class ImoryBannerAjaxController {

    @Autowired
    private ImoryBannerService imoryBannerService;
    
    @RequestMapping("/upload")
    public void upload(@RequestParam MultipartFile file, HttpServletRequest request, HttpServletResponse response)
    {
        InputStream inputStream = null;
        try {
            inputStream = file.getInputStream();
         //   String url = ""
            String realPath = request.getSession().getServletContext().getRealPath("/WEB-INF/upload/");
            String originalFilename = file.getOriginalFilename();
            String pathname = realPath + "/"+originalFilename;
            File tempFile = new File(pathname);
            // 写文件到磁盘
            file.transferTo(tempFile);
            ImoryBanner imoryBanner = new ImoryBanner();
            String uuid = UUID.randomUUID().toString().replaceAll("-", ""); 
            imoryBanner.setUid(uuid);
            imoryBanner.setBannerUrl(pathname);
            imoryBanner.setBannerImg(pathname);
            imoryBannerService.save(imoryBanner);
        System.out.println("sucess !");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            response.getWriter().write("{\"code\":200}");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
}
