package com.imory.bam.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import com.imory.bam.sysuser.bean.ImoryUserInfo;
import com.imory.bam.sysuser.service.ImoryUserService;

@RestController
@RequestMapping("/bam/imory_userAjax")
public class ImoryUserAjaxController {
    
    @Autowired
    private ImoryUserService imoryUserService;
    
    
    /**
     * 消费用户列表
     * @param draw
     * @param start
     * @param length
     * @return
     */
    @RequestMapping("/listImoryUser")
    public String listImoryUser(@Param("draw") int draw, @Param("start") int start, @Param("length") int length, @Param("name") String name,
            @Param("level") Integer level, @Param("state") String state)
    {
        Map<String, Object> paramsMap = new HashMap<>();
        paramsMap.put("startPos", start);
        paramsMap.put("maxRows", length);
        if(StringUtils.isNotBlank(name))
        {
            paramsMap.put("name", name);
        }
        if(level != null)
        {
            paramsMap.put("level", level);
        }
        if(StringUtils.isNotBlank(state))
        {
            paramsMap.put("state", state);
        }
        List<ImoryUserInfo> list = imoryUserService.listImoryUser(paramsMap);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("data", JSON.toJSON(list));
        jsonObject.put("draw", draw);
        jsonObject.put("recordsTotal", imoryUserService.countImoryUser(paramsMap)); //:总记录数
        jsonObject.put("recordsFiltered", imoryUserService.countImoryUser(paramsMap)); //过滤后的总记录数
        return jsonObject.toJSONString();
    }
    
    /**
     * 锁定账号
     * @param id
     * @return
     */
    @RequestMapping("/lockAccount")
    public Map<String,Object> accountLock(String id) 
    {
        HashMap<String,Object> result = Maps.newHashMap();
        int insert = imoryUserService.accountLock(id);
        if(insert > 0)
        {
            result.put("success", true); 
        }else
        {
            result.put("success", false); 
        }
        return result;
    }
    
    
    /**
     * 重置密码
     * @param id
     * @return
     */
    @RequestMapping("/resetPsd")
    public Map<String, Object> resetPsd(String id)
    {
        Map<String, Object> resultMap = new HashMap<>();
        //密码重置为123456
        imoryUserService.resertPsd(id);
        resultMap.put("success", true);
        return resultMap;
    }
    
    /**
     *实名认证
     * @param id
     * @return
     */
    @RequestMapping("/smrz")
    public Map<String, Object> smrz(String id)
    {
        Map<String, Object> resultMap = new HashMap<>();
        imoryUserService.smrz(id);
        resultMap.put("success", true);
        return resultMap;
    }
    
    /**
     * 查看客户信息
     * @param id
     * @return
     */
    @RequestMapping("/getImoryUserInfo")
    public ImoryUserInfo getImoryUserInfo(String id)
    {
       return  imoryUserService.getImoryUserInfo(id);
    }
    
    /**
     * 修改客户信息
     * @param imoryUserInfo
     * @return
     */
    @RequestMapping("/update")
    public Map<String,Object> update(ImoryUserInfo imoryUserInfo)
    {
        Map<String, Object> resultMap = new HashMap<>();
        int insert = imoryUserService.update(imoryUserInfo);
        if(insert > 0 )
        {
            resultMap.put("success", true);
        }else
        {
            resultMap.put("success", false);
        }
        return resultMap;
    }
    
    /**
     * 删除客户
     * @param id
     * @return
     */
    @RequestMapping("/deleteById")
    public Map<String,Object> deleteById(String id)
    {
        Map<String, Object> resultMap = new HashMap<>();
        imoryUserService.deleteById(id);
        resultMap.put("success", true);
        return resultMap; 
    }
 }
