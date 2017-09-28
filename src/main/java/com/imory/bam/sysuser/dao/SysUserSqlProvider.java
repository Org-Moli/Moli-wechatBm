package com.imory.bam.sysuser.dao;

import org.apache.commons.lang3.StringUtils;

import java.util.Map;

/**
 * <p>名称</p>
 * <p/>
 * <p>wikiURL</p>
 *
 * @author zb.jiang
 * @version 1.0
 * @Date 2017/7/20
 */
public class SysUserSqlProvider {

    public String listSysUser(Map<String, Object> paramsMap)
    {
        String qryVal = (String) paramsMap.get("qryVal");
        StringBuffer sql = new StringBuffer();
        sql.append("select * from sys_user where 1 = 1\n");
        if (StringUtils.isNotBlank(qryVal))
        {
            sql.append("and userName like '%" + qryVal + "%' \n");
            sql.append("or logonId like '%" + qryVal + "%'");
        }
        if(paramsMap.get("startPos") != null && paramsMap.get("maxRows") != null)
        {
            sql.append("limit #{startPos},#{maxRows}");
        }
        return sql.toString();
    }

    public String countSysUser(Map<String, Object> paramsMap)
    {
        String qryVal = (String) paramsMap.get("qryVal");
        StringBuffer sql = new StringBuffer();
        sql.append("select count(*) from sys_user where 1 = 1\n");
        if (StringUtils.isNotBlank(qryVal))
        {
            sql.append("and userName like '%" + qryVal + "%' \n");
            sql.append("or logonId like '%" + qryVal + "%'");
        }
        return sql.toString();
    }

    public String deleteByIds(Map<String, Object> paramsMap)
    {
        Integer[] ids = (Integer[]) paramsMap.get("ids");

        StringBuffer sql = new StringBuffer();
        sql.append("update sys_user set enabled = 0 where id in \n");
        sql.append("(\n");
        for (int i = 0; i < ids.length; i++)
        {
            if (i != ids.length - 1)
            {
                sql.append(ids[i] + ",");
            } else
            {
                sql.append(ids[i]);
            }
        }
        sql.append(")\n");

        return sql.toString();
    }
}
