package com.imory.bam.controller;

import com.alibaba.fastjson.JSONObject;
import com.imory.bam.configuration.prop.RuntimesProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <p>名称</p>
 * <p/>
 * <p>wikiURL</p>
 *
 * @author zb.jiang
 * @version 1.0
 * @Date 2017/7/15
 */
@RestController
@RequestMapping("/bam")
public class CommonAjaxController {

    @Autowired
    private RuntimesProperties runtimesProperties;

    @RequestMapping("doAjaxLogin")
    public String doAjaxLogin(String logonId, String password)
    {
        JSONObject jsonObject = new JSONObject();
        return jsonObject.toString();
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String upload(@RequestParam("file") MultipartFile file)
    {
        JSONObject jsonObject = new JSONObject();

        String filePath = this.getClass().getClassLoader().getResource("").getPath() + "resources" + File.separator + "upload" + File.separator;

        File uploadFile = new File(filePath);
        if (!uploadFile.exists())
        {
            uploadFile.mkdirs();
        }

        try
        {
            String fileName = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + file.getOriginalFilename();
            file.transferTo(new File(filePath + fileName));
            jsonObject.put("success", true);
            jsonObject.put("url", "/upload/" + fileName);
        } catch (IOException e)
        {
            jsonObject.put("success", false);
            e.printStackTrace();
        }
        return jsonObject.toString();
    }
}
