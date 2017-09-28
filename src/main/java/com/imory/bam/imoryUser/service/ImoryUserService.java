package com.imory.bam.imoryUser.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imory.bam.imoryUser.bean.ImoryUserInfo;
import com.imory.bam.imoryUser.dao.ImoryUserMapper;

@Service
public class ImoryUserService {

    @Autowired
    private ImoryUserMapper imoryUserMapper;
    
    public List<ImoryUserInfo> listImoryUser(Map<String, Object> paramsMap) {
        return imoryUserMapper.listImoryUser(paramsMap);
    }

    public int countImoryUser(Map<String, Object> paramsMap) {
        return imoryUserMapper.countImoryUser(paramsMap);
    }

    public int accountLock(String id) {
        return imoryUserMapper.accountLock(id);
    }

    public void resertPsd(String id) {
        imoryUserMapper.resertPsd(id);
    }

    public void smrz(String id) {
        imoryUserMapper.smrz(id);
        
    }

    public ImoryUserInfo getImoryUserInfo(String id) {
        return imoryUserMapper.getImoryUserInfo(id);
    }

    public int update(ImoryUserInfo imoryUserInfo) {
        return imoryUserMapper.update(imoryUserInfo);
    }

    public void deleteById(String uid) {
        imoryUserMapper.deleteById(uid);
        
    }

}
