package com.web.service;

import com.web.dao.Singer_imageMapper;
import com.web.pojo.Singer_image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Singer_imageService {
    @Autowired
    Singer_imageMapper singer_imageMapper;

    int deleteByPrimaryKey(Integer id) {
        return singer_imageMapper.deleteByPrimaryKey(id);
    }

    int insert(Singer_image record) {
        return singer_imageMapper.insert(record);
    }

    public int insertSelective(Singer_image record) {
        return singer_imageMapper.insertSelective(record);
    }

    Singer_image selectByPrimaryKey(Integer id) {
        return singer_imageMapper.selectByPrimaryKey(id);
    }

    int updateByPrimaryKeySelective(Singer_image record) {
        return singer_imageMapper.updateByPrimaryKeySelective(record);
    }

    int updateByPrimaryKey(Singer_image record) {
        return singer_imageMapper.updateByPrimaryKey(record);
    }

    public Singer_image selectBySingerId(Integer id)
    {
            return singer_imageMapper.selectBySingerId(id);
    }
}
