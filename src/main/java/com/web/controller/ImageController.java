package com.web.controller;

import com.alibaba.fastjson.JSON;
import com.web.Utils.Result;
import com.web.pojo.Singer;
import com.web.pojo.*;
import com.web.pojo.Song;
import com.web.service.SingerService;
import com.web.service.Singer_imageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import sun.rmi.runtime.Log;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.logging.Logger;

@Controller
@RequestMapping("/img")
public class ImageController {
    Logger logger=Logger.getLogger("ImageController");
    @Autowired
    SingerService singerService;
    @Autowired
    Singer_imageService singer_imageService;
    @RequestMapping(value = "/upload",method = RequestMethod.POST ,produces = "text/html;charset=UTF-8")
    @ResponseBody
    public  String upload(MultipartFile file, HttpServletRequest request, HttpServletResponse resp) throws IOException
    {
        Result result=new Result();
        logger.info("/upload");
        String path = request.getSession().getServletContext().getRealPath("upload");
        String fileName = file.getOriginalFilename();
        logger.info("上传文件名为"+fileName);
//        File dir = new File(path,fileName);
//        File myDir=new File("/home/music",fileName);//服务器上传音乐地址
        File myDir=new File("H:\\web实习项目码云\\MusicHub\\src\\main\\webapp\\WEB-INF\\static\\images\\singer\\",fileName);//测试地址
        //将该图片插入数据库的操作
       Singer_image singer_image=new Singer_image();
        singer_image.setLocation("../images/singer/"+fileName);
        String singerName=fileName.split("\\.")[0];
        Singer singer=singerService.selectSingerByName(singerName);
        if(singer==null)
        {
            logger.info("不存在该歌手");
            System.out.println("不添加");
            return JSON.toJSONString(result.fault);
        }
        else
        {
            //singer.getId();
          Singer_image singer_image1=singer_imageService.selectBySingerId(singer.getId());
          if(singer_image1!=null){
              logger.info("该歌手图片已经存在");
              return JSON.toJSONString(result.fault);
          }
          else
          {
                singer_image.setSingerId(singer.getId());
                try
                {
                    int res=singer_imageService.insertSelective(singer_image);
                   logger.info("影响条数有"+res);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
          }

        }
        if(!myDir.exists())
        {
            myDir.mkdirs();
        }
        String json=null;
        //MultipartFile自带的解析方法  
        try {
            //移到指定目录下
            file.transferTo(myDir);
            logger.info("上传成功");
//            resp.sendRedirect("/admin/songPage");
            json= JSON.toJSONString(result.success);
        }
        catch (Exception e )
        {

            json= JSON.toJSONString(result.success);
            e.printStackTrace();
//            resp.sendRedirect("/admin/fault");
        }
        return json;

    }

}
