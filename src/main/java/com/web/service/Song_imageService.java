package com.web.service;

import com.web.dao.Song_imageMapper;
import com.web.pojo.Song_image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Song_imageService {
    @Autowired
    Song_imageMapper mapper;

    int deleteByPrimaryKey(Integer id) {
        return mapper.deleteByPrimaryKey(id);
    }

    int insert(Song_image record) {
        return mapper.insert(record);
    }

    int insertSelective(Song_image record) {
        return mapper.insertSelective(record);
    }

    Song_image selectByPrimaryKey(Integer id) {
        return mapper.selectByPrimaryKey(id);
    }

    int updateByPrimaryKeySelective(Song_image record) {
        return mapper.updateByPrimaryKeySelective(record);
    }

    int updateByPrimaryKey(Song_image record) {
        return mapper.updateByPrimaryKey(record);
    }
}
