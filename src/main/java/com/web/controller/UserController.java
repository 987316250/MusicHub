package com.web.controller;

import com.alibaba.fastjson.JSON;
import com.web.Utils.Result;
import com.web.pojo.User;
import com.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.logging.Logger;

@Controller
@RequestMapping("/user")
public class UserController {
    Logger logger =Logger.getLogger("UserController");
    @Autowired
    UserService userService;
    Result result=new Result();

    /**
     * 用户登陆验证
     * @param name
     * @param password
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/login" ,method = RequestMethod.POST)
    public String AdminLogin(@RequestParam String name , @RequestParam String password) {
        logger.info(name+"用户/login");
        User user = userService.selectByName(name);
        if(user.getPassword().equals(password)&&user.getPassword()!=null&&!user.getPassword().equals(""))
        {
            logger.info("用户登陆成功");
            return JSON.toJSONString(result.success);
        }
        else
        {
            logger.info("用户登陆失败");
            return JSON.toJSONString(result.fault);
        }

    }

   @RequestMapping("/delete")
   @ResponseBody
   public String deleteByPrimaryKey(@RequestParam Integer id)
   {
       int res=userService.deleteByPrimaryKey(id);
       if(res>0)
       {
           return JSON.toJSONString(result.success);
       }
       else
       {
           return JSON.toJSONString(result.fault);
       }
   }


   @RequestMapping("/update")
   @ResponseBody
   public String updateByPrimaryKey(User user)
   {
       logger.info("/update");
       System.out.println(user.toString());
         int res=userService.updateByPrimaryKey(user);
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
    public String insertSelective(User user)
   {
       logger.info("/add");
       System.out.println(user.toString());
       int res=userService.insertSelective(user);
       if(res>0)
       {
           return JSON.toJSONString(result.success);
       }
       else
       {
           return JSON.toJSONString(result.fault);
       }
   }


   @RequestMapping("/main")
    public String Usermain()
   {
       return "UserMain";
   }
}
