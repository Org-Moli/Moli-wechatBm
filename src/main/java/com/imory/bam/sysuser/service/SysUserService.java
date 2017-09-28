package com.imory.bam.sysuser.service;

import com.imory.bam.sysuser.bean.SysUser;
import com.imory.bam.sysuser.dao.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
 * @Date 2017/7/11
 */
@Service
public class SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    /**
     * 根据Id查用户
     *
     * @param id
     * @return
     */
    public SysUser findUserById(Integer id)
    {
        return sysUserMapper.findUserById(id);
    }

    /**
     * 新增管理员
     *
     * @return
     */
    public int insert(SysUser sysUser)
    {
        return sysUserMapper.insert(sysUser);
    }

    /**
     * 重置密码
     */
    public void resertPsd(Integer id)
    {
        sysUserMapper.resertPsd(id);
    }

    /**
     * 用户列表
     *
     * @param startPos
     * @param maxRows
     * @return
     */
    public List<SysUser> listSysUser(Integer startPos, Integer maxRows, String qryVal)
    {
        Map<String, Object> paramsMap = new HashMap<>();
        paramsMap.put("startPos", startPos);
        paramsMap.put("maxRows", maxRows);
        paramsMap.put("qryVal", qryVal);
        return sysUserMapper.listSysUser(paramsMap);
    }

    public int countSysUser(String qryVal)
    {
        Map<String, Object> paramsMap = new HashMap<>();
        paramsMap.put("qryVal", qryVal);
        return sysUserMapper.countSysUser(paramsMap);
    }


    /**
     * 登录
     *
     * @param logonId
     * @param password
     * @return
     */
    public SysUser userLogon(String logonId, String password)
    {
        return sysUserMapper.userLogon(logonId, password);
    }

    /**
     * 查询
     *
     * @param logonId
     * @return
     */
    public SysUser findSysUserByLogonId(String logonId)
    {
        return sysUserMapper.findSysUserByLogonId(logonId);
    }

    /**
     * 更新
     *
     * @return
     */
    public int updateById(SysUser sysUser)
    {
        return sysUserMapper.updateById(sysUser);
    }

    /**
     * 删除
     *
     * @param id
     */
    public void deleteById(Integer id)
    {
        sysUserMapper.deleteById(id);
    }

    /**
     * 删除
     *
     * @param ids
     */
    public void deleteByIds(Integer[] ids)
    {
        Map<String, Object> paramsMap = new HashMap<>();
        paramsMap.put("ids", ids);
        sysUserMapper.deleteByIds(paramsMap);
    }

    public int register(SysUser user) {
        return sysUserMapper.insert(user);
    }
}
