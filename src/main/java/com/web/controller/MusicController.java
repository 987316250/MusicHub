package com.web.controller;


import com.alibaba.fastjson.JSON;
import com.web.Utils.Result;
import com.web.pojo.Song;
import com.web.pojo.SongAndSinger;
import com.web.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.logging.Logger;

@Controller
@RequestMapping("/search")
public class MusicController {
    /**
     * 前台搜索功能接口
     */
    Logger logger=Logger.getLogger("MusicController");
    @Autowired
    SongService songService;

    @RequestMapping("/musicName")
    @ResponseBody
    public String searchMusic(@RequestParam String musicName)
    {
        Result result=new Result();
         List<SongAndSinger> songList=songService.selectAllByParameter(musicName);
        System.out.println(songList.size());
         if(songList==null)
         {
             logger.info("没有此音乐");
             return JSON.toJSONString(result.fault);
         }
         else
         {
             logger.info("音乐已经查到");
             return JSON.toJSONString(songList);
         }
    }

}
