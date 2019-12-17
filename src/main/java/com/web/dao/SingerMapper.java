package com.web.dao;

import com.web.pojo.Singer;
import com.web.pojo.SingerAndImage;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface SingerMapper {
    public List<SingerAndImage> selectAll();


    Singer selectSingerByName(String name);

    int deleteByPrimaryKey(Integer id);

    int insert(Singer record);

    int insertSelective(Singer record);

    Singer selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Singer record);

    int updateByPrimaryKey(Singer record);
}