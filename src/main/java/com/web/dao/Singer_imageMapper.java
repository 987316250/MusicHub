package com.web.dao;

import com.web.pojo.Singer;
import com.web.pojo.Singer_image;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
public interface Singer_imageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Singer_image record);

    int insertSelective(Singer_image record);

    Singer_image selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Singer_image record);

    int updateByPrimaryKey(Singer_image record);

    Singer_image  selectBySingerId(Integer id);

}