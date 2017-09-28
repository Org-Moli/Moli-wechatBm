package com.imory.bam.sysuser.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;

import com.imory.bam.sysuser.bean.ImoryUserInfo;

@Mapper
public interface ImoryUserMapper {

    
    @SelectProvider(type=ImoryUserSqlProvider.class,method="listImoryUser")
    List<ImoryUserInfo> listImoryUser(Map<String, Object> paramsMap);

    @SelectProvider(type=ImoryUserSqlProvider.class,method="countImoryUser")
    int countImoryUser(Map<String, Object> paramsMap);

    @Update({
        "update imory_userinfo set state = 2",
        "where uid = #{id}"
})
    int accountLock(String id);

    @Update({
        "update imory_userinfo set password = 'e10adc3949ba59abbe56e057f20f883e'",
        "where uid = #{id}"
})
    void resertPsd(@Param("id") String id);

    @Update({
        "update imory_userinfo set level = 2",
        "where uid = #{id}"
})
    void smrz(String id);

    @Select({
        "select * from imory_userinfo where uid = #{id}"
    })
    ImoryUserInfo getImoryUserInfo(String id);

    @Update({
        "update imory_userinfo ",
        "set username = #{username,jdbcType=VARCHAR},",
        "set password = #{password,jdbcType=VARCHAR},",
        "set nickName = #{nickName,jdbcType=VARCHAR},",
        "set mobile = #{mobile,jdbcType=VARCHAR},",
        "set openId = #{openId,jdbcType=VARCHAR},",
        "set unionId = #{unionId,jdbcType=VARCHAR},",
        "set level = #{level,jdbcType=INTEGER},",
        "set state = #{state,jdbcType=INTEGER},",
        "set avatar = #{avatar,jdbcType=VARCHAR},",
        "set avatar_small = #{avatar_small,jdbcType=VARCHAR},",
        "set email = #{email,jdbcType=VARCHAR},",
        "set wxSubscribe = #{wxSubscribe}",
        "wher uid = #{uid,jdbcType=VARCHAR}"
    })
    int update(ImoryUserInfo imoryUserInfo);

    @Delete({
        "delete from imory_userinfo where uid = #{uid}"
    })
    void deleteById(String uid);

}
