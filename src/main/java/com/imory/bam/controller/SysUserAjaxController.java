package com.imory.bam.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.imory.bam.sysuser.bean.SysUser;
import com.imory.bam.sysuser.service.SysUserService;
import com.imory.bam.utils.MD5Util;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>名称</p>
 * <p/>
 * <p>wikiURL</p>
 *
 * @author zb.jiang
 * @version 1.0
 * @Date 2017/7/17
 */
@RestController
@RequestMapping("/bam/sysUserAjax")
public class SysUserAjaxController {

    @Autowired
    private SysUserService sysUserService;

    /**
     * 保存管理员
     *
     * @return
     */
    @RequestMapping("/saveSysUser")
    public Map<String, Object> saveSysUser(SysUser sysUser)
    {
        Map<String, Object> resultMap = new HashMap<>();
        if (sysUser.getId() == null)
        {
            //密码MD5加密
            sysUser.setPassword(MD5Util.MD5Encode(sysUser.getPassword(), "UTF-8"));
            sysUserService.insert(sysUser);
        } else
        {
            SysUser user = sysUserService.findUserById(sysUser.getId());
            user.setUserName(sysUser.getUserName());
            user.setLogonId(sysUser.getLogonId());
            user.setPassword(MD5Util.MD5Encode(sysUser.getPassword(), "UTF-8"));
            sysUserService.updateById(user);
        }
        if (sysUser.getId() != null)
        {
            resultMap.put("success", true);
        } else
        {
            resultMap.put("success", false);
        }
        return resultMap;
    }

    /**
     * 重置密码
     */
    @RequestMapping("/resetPsd")
    public Map<String, Object> resetPsd(Integer id)
    {
        Map<String, Object> resultMap = new HashMap<>();
        //密码重置为123456
        sysUserService.resertPsd(id);
        resultMap.put("success", true);
        return resultMap;
    }

    /**
     * 根据ID查询管理员信息
     *
     * @param id
     */
    @RequestMapping("/findSysUserById")
    public SysUser findSysUserById(Integer id)
    {
        return sysUserService.findUserById(id);
    }


    /**
     * 管理员列表
     *
     * @return
     */
    @RequestMapping("/listSysUser")
    public String listSysUser(@Param("draw") int draw, @Param("start") int start, @Param("length") int length, @Param("qryVal") String qryVal)
    {
        List<SysUser> sysUserList = sysUserService.listSysUser(start, length, qryVal);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("data", JSON.toJSON(sysUserList));
        jsonObject.put("draw", draw);
        jsonObject.put("recordsTotal", sysUserService.countSysUser(qryVal)); //:总记录数
        jsonObject.put("recordsFiltered", sysUserService.countSysUser(qryVal)); //过滤后的总记录数
        return jsonObject.toJSONString();
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @RequestMapping("/deleteById")
    public Map<String, Object> deleteById(Integer id)
    {
        Map<String, Object> resultMap = new HashMap<>();
        sysUserService.deleteById(id);
        resultMap.put("success", true);
        return resultMap;
    }

    /**
     * 删除
     *
     * @param ids
     * @return
     */
    @RequestMapping("/deleteByIds")
    public Map<String, Object> deleteByIds(Integer[] ids)
    {
        Map<String, Object> resultMap = new HashMap<>();
        sysUserService.deleteByIds(ids);
        resultMap.put("success", true);
        return resultMap;
    }
}
