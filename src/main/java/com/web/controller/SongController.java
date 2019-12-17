package com.web.controller;


import com.alibaba.fastjson.JSON;
import com.web.Utils.Result;
import com.web.pojo.Song;
import com.web.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.util.logging.Logger;

@Controller
@RequestMapping("/song")
public class SongController {
    Logger logger =Logger.getLogger("SongController");
      @Autowired
     SongService songService;
      Result result=new Result();
      @RequestMapping("/delete")
      @ResponseBody
    public String deleteSong(@RequestParam Integer id)
      {

          //从music目录中删掉该路径下的音乐
          Song s=songService.selectByPrimaryKey(id);
          try
          {
              File file=new File("H:\\web实习项目码云\\MusicHub\\src\\main\\webapp\\WEB-INF\\static\\music\\"+s.getName());
              if(file.exists())
              {
                  file.delete();
                  logger.info("删除成功");
              }
              else
                  logger.info("该文件不存在");
          }
          catch (Exception e)
          {
              e.printStackTrace();
          }
         //再从数据库删掉
          int res=songService.deleteByPrimaryKey(id);
          if(res>0)
          {
              return JSON.toJSONString(result.success);
          }
          else
          {
              return JSON.toJSONString(result.fault);
          }
      }


}
