package com.web.controller;
import com.alibaba.fastjson.JSON;
import com.web.pojo.Singer;
import com.web.pojo.User;
import com.web.service.SingerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.logging.Logger;
import  com.web.Utils.*;
@Controller
@RequestMapping("/singer")
public class SingerController {
    @Autowired
    SingerService singerService;
    Logger logger =Logger.getLogger("SingerController");
    @RequestMapping("/delete")
    @ResponseBody
    public  String delete(@RequestParam Integer id)
    {
        Result result=new Result();
        int res=singerService.deleteByPrimaryKey(id);
        if(res>0)
        {
            return JSON.toJSONString(result.success);
        }
        else
        {
            return JSON.toJSONString(result.fault);
        }
    }

    @RequestMapping("/add")
    @ResponseBody
    public String insertSelective(Singer singer)
    {
        Result result=new Result();
        logger.info("/add");
        System.out.println(singer.toString());
        int res=singerService.insertSelective(singer);
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
