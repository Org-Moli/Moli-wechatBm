package com.imory.bam.sysuser.dao;

import com.imory.bam.sysuser.bean.SysUser;
import org.apache.ibatis.annotations.*;

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
@Mapper
public interface SysUserMapper {

    @Select({
            "select * from sys_user where id = #{id}"
    })
    SysUser findUserById(@Param("id") Integer id);

    @Insert({
            "insert into sys_user(logonId,userName,password,level,enabled,createTime)",
            "values",
            "(#{logonId},#{userName},#{password},1,1,now())"
    })
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Integer.class)
    int insert(SysUser sysUser);

    @Update({
            "update sys_user set password = 'e10adc3949ba59abbe56e057f20f883e'",
            "where id = #{id}"
    })
    void resertPsd(@Param("id") Integer id);

    @SelectProvider(type = SysUserSqlProvider.class,method = "listSysUser")
    List<SysUser> listSysUser(Map<String, Object> paramsMap);

    @SelectProvider(type = SysUserSqlProvider.class,method = "countSysUser")
    int countSysUser(Map<String, Object> paramsMap);

    @Update({
            "update sys_user set enabled = 0 where id = #{id}"
    })
    void deleteById(@Param("id") Integer id);

    @UpdateProvider(type = SysUserSqlProvider.class, method = "deleteByIds")
    void deleteByIds(Map<String, Object> paramsMap);

    @Select({
            "select * from sys_user where logonId = #{logonId} and password = #{password}"
    })
    SysUser userLogon(@Param("logonId") String logonId, @Param("password") String password);

    @Select({
            "select * from sys_user where logonId = #{logonId}"
    })
    SysUser findSysUserByLogonId(@Param("logonId") String logonId);

    @Update({
            "update sys_user",
            "set password = #{password,jdbcType=VARCHAR},",
            "userName = #{userName,jdbcType=VARCHAR},",
            "logonId = #{logonId,jdbcType=VARCHAR}",
            "where id = #{id,jdbcType=INTEGER}"
    })
    int updateById(SysUser sysUser);
}
