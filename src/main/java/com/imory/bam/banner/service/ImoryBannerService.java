package com.imory.bam.banner.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imory.bam.banner.bean.ImoryBanner;
import com.imory.bam.banner.dao.ImoryBannerMapper;

@Service
public class ImoryBannerService {

    @Autowired
    private ImoryBannerMapper imoryBannerMapper;

    public void save(ImoryBanner imoryBanner) {
        imoryBannerMapper.insert(imoryBanner);
        
    }
}
