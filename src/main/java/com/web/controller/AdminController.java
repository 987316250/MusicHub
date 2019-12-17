package com.web.controller;
import com.alibaba.fastjson.JSON;
import com.web.Utils.Result;
import com.web.dao.SongMapper;
import com.web.dao.UserMapper;
import com.web.pojo.*;
import com.web.service.AdminService;
import com.web.service.SingerService;
import com.web.service.SongService;
import com.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.logging.Logger;

@Controller
@RequestMapping("/admin")
public class AdminController {
    Logger logger = Logger.getLogger("AdminController");
    @Autowired
    AdminService adminService;
    @Autowired
    UserService userService;
    @Autowired
    SongService songService;
    @Autowired
    SingerService singerService;
    Result result = new Result();

    /**
     * 后台登陆界面
     * @return
     */
    @RequestMapping("/index")
    public String adminLogin()
    {
        return "adminLogin";
    }
    /**
     * 后台管理主界面
     * @return
     */
    @RequestMapping("/dashboard")
    public String adminMain()
    {
        return "dashboard";
    }

    /**
     * 后台音乐界面
     * @return
     */
    @RequestMapping("/songPage")
    public String songPage(HttpServletRequest req)
    {
        List<SongAndSinger> list=songService.selectAll();
        //这里可以先select一下所有歌再渲染页面
        if(list==null)
        {
           logger.info("歌单为空");
        }
        else
        {
            req.getSession().setAttribute("list",list);
        }
       return "songPage";
//        return JSON.toJSONString(list);

    }

    @RequestMapping("/uploadAndDown")
    public String  uploadPage() {
       return "uploadPage";
    }

    /**
     * 验证登陆接口
     * @param name
     * @param password
     * @return
     */


    /**
     * user界面
     * @param httpServletRequest
     * @return
     */
    @RequestMapping("/user")
//    @ResponseBody //如果前后端分离可以传json鉴于现阶段只是应付任务后期改springboot框架再调整
    public String  user(HttpServletRequest httpServletRequest)
    {
        //当访问user页面的时候需要将查询到的数据渲染会前端
        List<User> list=userService.selectAll();
        httpServletRequest.getSession().setAttribute("list",list);
        return "adminUser";
//        return JSON.toJSONString(list);
    }

    @RequestMapping("/singer")
    public String singer(HttpServletRequest req)
    {
        //渲染页面
        List<SingerAndImage>list=singerService.selectAll();
        System.out.println(list.size());
        req.getSession().setAttribute("list",list);
//        return JSON.toJSONString(list);
        return "singerPage";
    }

    /**
     * 登陆错误错误页面
     * @return
     */
    @RequestMapping("/fault")
    public String fault()
    {
        return "adminFault";
    }

    /**
     * 管理员登陆逻辑
     * @param name
     * @param password
     * @return
     */

    @RequestMapping(value = "/login" ,method = RequestMethod.POST)
    @ResponseBody
    public String AdminLogin(@RequestParam String name ,@RequestParam String password) {
        logger.info(name+"管理员/login");
              Admin admin=adminService.selectByName(name);;
                if(admin!=null&&admin.getPassword().equals(password)&&admin.getPassword()!=null&&!admin.getPassword().equals(""))
                {
                    logger.info("登陆成功");
                    return JSON.toJSONString(result.success);
                }
                else
                    {
                    logger.info("登陆失败");
                    return JSON.toJSONString(result.fault);
                }


    }





}
