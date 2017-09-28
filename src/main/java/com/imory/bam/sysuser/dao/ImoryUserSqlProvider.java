package com.imory.bam.sysuser.dao;

import java.util.Map;

public class ImoryUserSqlProvider {

    public String listImoryUser(Map<String,Object> paramsMap)
    {
        StringBuffer sql = new StringBuffer();
        sql.append("select * from imory_userinfo where 1=1 \n");
        if(paramsMap.get("name") != null)
        {
            sql.append(" and (username like CONCAT('%',#{name},'%') or nickName like CONCAT('%',#{name},'%'))\n");
        }
        if(paramsMap.get("level") != null)
        {
            sql.append(" and level like CONCAT('%',#{level},'%') \n");
        }
        if(paramsMap.get("state") != null)
        {
            sql.append(" and state = #{state} \n");
        }
        sql.append(" order by reg_time desc \n");
        if(paramsMap.get("startPos") != null && paramsMap.get("maxRows") != null)
        {
            sql.append("limit #{startPos},#{maxRows}");
        }
        return sql.toString();
    }
    
    public String countImoryUser(Map<String,Object> paramsMap)
    {
        StringBuffer sql = new StringBuffer();
        sql.append("select count(*) from imory_userinfo where 1=1 \n");
        if(paramsMap.get("name") != null)
        {
            sql.append(" and (username like CONCAT('%',#{name},'%') or nickName like CONCAT('%',#{name},'%'))\n");
        }
        if(paramsMap.get("level") != null)
        {
            sql.append(" and level like CONCAT('%',#{level},'%') \n");
        }
        if(paramsMap.get("state") != null)
        {
            sql.append(" and state like CONCAT('%',#{state},'%') \n");
        }
        return sql.toString();
    }
}
