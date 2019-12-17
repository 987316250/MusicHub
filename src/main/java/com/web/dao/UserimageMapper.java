package com.web.dao;

import com.web.pojo.Userimage;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserimageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Userimage record);

    int insertSelective(Userimage record);

    Userimage selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Userimage record);

    int updateByPrimaryKey(Userimage record);
}