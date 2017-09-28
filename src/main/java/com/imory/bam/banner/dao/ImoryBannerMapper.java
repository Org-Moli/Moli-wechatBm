package com.imory.bam.banner.dao;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import com.imory.bam.banner.bean.ImoryBanner;

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
