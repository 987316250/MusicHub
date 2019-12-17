package com.web.service;

import com.web.dao.FavouriteMapper;
import com.web.pojo.Favourite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FavouriteService {
    @Autowired
    FavouriteMapper favouriteMapper;

    int deleteByPrimaryKey(Integer id) {
        return favouriteMapper.deleteByPrimaryKey(id);
    }

    int insert(Favourite record) {
        return favouriteMapper.insert(record);
    }

    int insertSelective(Favourite record) {
        return favouriteMapper.insertSelective(record);
    }

    Favourite selectByPrimaryKey(Integer id) {
        return favouriteMapper.selectByPrimaryKey(id);
    }

    int updateByPrimaryKeySelective(Favourite record) {
        return favouriteMapper.updateByPrimaryKeySelective(record);
    }

    int updateByPrimaryKey(Favourite record) {
        return favouriteMapper.updateByPrimaryKey(record);
    }
}
