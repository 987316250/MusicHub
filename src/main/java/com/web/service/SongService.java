package com.web.service;


import com.web.dao.SongMapper;
import com.web.pojo.Song;
import com.web.pojo.SongAndSinger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService {
    @Autowired
    SongMapper songMapper;
    public List<SongAndSinger> selectAll()
    {
        return songMapper.selectAll();
    }

    public List<SongAndSinger> selectAllByParameter(String musicName){
        return songMapper.selectAllByParameter(musicName);
    }

    public int deleteByPrimaryKey(Integer id){
        return songMapper.deleteByPrimaryKey(id);
    }

    public int insert(Song record){
        return insert(record);
    }

   public  int insertSelective(Song record){
        return songMapper.insertSelective(record);
   }

    public Song selectByPrimaryKey(Integer id){
        return songMapper.selectByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(Song record){
        return songMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(Song record){
        return songMapper.updateByPrimaryKey(record);
    }
}
