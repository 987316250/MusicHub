package com.web.dao;

import com.web.pojo.Favourite;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface FavouriteMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Favourite record);

    int insertSelective(Favourite record);

    Favourite selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Favourite record);

    int updateByPrimaryKey(Favourite record);
}