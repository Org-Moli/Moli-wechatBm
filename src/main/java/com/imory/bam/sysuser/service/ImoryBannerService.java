package com.imory.bam.sysuser.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imory.bam.sysuser.bean.ImoryBanner;
import com.imory.bam.sysuser.dao.ImoryBannerMapper;

@Service
public class ImoryBannerService {

    @Autowired
    private ImoryBannerMapper imoryBannerMapper;

    public void save(ImoryBanner imoryBanner) {
        imoryBannerMapper.insert(imoryBanner);
        
    }
}
