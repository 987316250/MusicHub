package com.web.service;

import com.web.dao.SingerMapper;
import com.web.pojo.Singer;
import com.web.pojo.SingerAndImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SingerService {
    @Autowired
    SingerMapper mapper;

    public List<SingerAndImage> selectAll()
    {
        return mapper.selectAll();
    }
    public Singer selectSingerByName(String name){
        return mapper.selectSingerByName(name);
    }

   public  int deleteByPrimaryKey(Integer id) {
        return mapper.deleteByPrimaryKey(id);
    }

   public  int insert(Singer record) {
        return mapper.insert(record);
    }

  public   int insertSelective(Singer record) {
        return mapper.insertSelective(record);
    }

   public  Singer selectByPrimaryKey(Integer id) {
        return mapper.selectByPrimaryKey(id);
    }

  public   int updateByPrimaryKeySelective(Singer record) {
        return mapper.updateByPrimaryKeySelective(record);
    }

  public   int updateByPrimaryKey(Singer record) {
        return mapper.updateByPrimaryKey(record);
    }
}
