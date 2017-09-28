package com.imory.bam.sysuser.dao;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectKey;

import com.imory.bam.sysuser.bean.ImoryBanner;

@Mapper
public interface ImoryBannerMapper {

    @Insert({
        "insert into imory_banner (uid, bannerImg, bannerUrl, state,",
        "operatorId, createTime) ",
        "values (#{uid,jdbcType=VARCHAR}, #{bannerImg,jdbcType=VARCHAR}, #{bannerUrl,jdbcType=VARCHAR}, ",
        "1, #{operatorId,jdbcType=VARCHAR}, now())"
    })
    int insert(ImoryBanner imoryBanner);
    

}
