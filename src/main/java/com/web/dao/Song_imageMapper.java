package com.web.dao;

import com.web.pojo.Singer;
import com.web.pojo.Song_image;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface Song_imageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Song_image record);

    int insertSelective(Song_image record);

    Song_image selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Song_image record);

    int updateByPrimaryKey(Song_image record);

    public Singer selectBySingerId(Integer id);
}