package com.web.service;

import com.web.dao.UserimageMapper;
import com.web.pojo.Userimage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserimageService {
    @Autowired
    UserimageMapper mapper;

    int deleteByPrimaryKey(Integer id) {
        return mapper.deleteByPrimaryKey(id);
    }

    int insert(Userimage record) {
        return mapper.insert(record);
    }

    int insertSelective(Userimage record) {
        return mapper.insertSelective(record);
    }

    Userimage selectByPrimaryKey(Integer id) {
        return mapper.selectByPrimaryKey(id);
    }

    int updateByPrimaryKeySelective(Userimage record) {
        return mapper.updateByPrimaryKeySelective(record);
    }

    int updateByPrimaryKey(Userimage record) {
        return mapper.updateByPrimaryKey(record);
    }
}
