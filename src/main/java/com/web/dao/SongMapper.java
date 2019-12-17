package com.web.dao;

import com.web.pojo.Song;
import com.web.pojo.SongAndSinger;

import java.util.List;

public interface SongMapper {

    List<SongAndSinger>selectAll();

    List<SongAndSinger>selectAllByParameter(String musicName);

    int deleteByPrimaryKey(Integer id);

    int insert(Song record);

    int insertSelective(Song record);

    Song selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Song record);

    int updateByPrimaryKey(Song record);
}