package com.web.service;

import com.web.dao.AdminMapper;
import com.web.pojo.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    @Autowired
    AdminMapper adminMapper;

    public Admin selectByName(String name) {
        return adminMapper.selectByName(name);
    }

    int deleteByPrimaryKey(Integer id) {
        return adminMapper.deleteByPrimaryKey(id);
    }

    int insert(Admin record) {
        return adminMapper.insert(record);
    }

    int insertSelective(Admin record) {
        return adminMapper.insertSelective(record);
    }

    Admin selectByPrimaryKey(Integer id) {
        return adminMapper.selectByPrimaryKey(id);
    }

    int updateByPrimaryKeySelective(Admin record) {
        return adminMapper.updateByPrimaryKeySelective(record);
    }

    int updateByPrimaryKey(Admin record) {
        return adminMapper.updateByPrimaryKey(record);
    }
}