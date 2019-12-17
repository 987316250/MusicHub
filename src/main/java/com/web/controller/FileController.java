package com.web.controller;


import com.alibaba.fastjson.JSON;
import com.web.Utils.Result;
import com.web.pojo.Singer;
import com.web.pojo.Song;
import com.web.service.SingerService;
import com.web.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.Date;
import java.util.logging.Logger;

@Controller
@RequestMapping("/file")
public class FileController {
    Result result=new Result();
    private Logger logger=Logger.getLogger("FileController");
    @Autowired
    SongService songService;
    @Autowired
    SingerService singerService;
    //上传
    @RequestMapping(value = "/upload",method = RequestMethod.POST ,produces = "text/html;charset=UTF-8")
    @ResponseBody
    public    String upload(MultipartFile file, HttpServletRequest request,HttpServletResponse resp) throws IOException
    {
        logger.info("/upload");
        String path = request.getSession().getServletContext().getRealPath("upload");
        String fileName = file.getOriginalFilename();
        logger.info("上传文件名为"+fileName);
//        File dir = new File(path,fileName);
//        File myDir=new File("/home/music",fileName);//服务器上传音乐地址
        File myDir=new File("H:\\web实习项目码云\\MusicHub\\src\\main\\webapp\\WEB-INF\\static\\music\\",fileName);//测试地址
        if(myDir.exists())
        {
            System.out.println("歌曲已经存在");
            return JSON.toJSONString(result.fault);
        }


         Song song=new Song();
         Singer mysinger=null;
         //将该音乐文件插入数据库的操作
         //id name singer_id  location uploadTime category_id
         song.setName(fileName);
         String singerName=fileName.split("-")[1].split("\\.")[0];
         logger.info("歌手的姓名是"+singerName);
         //如果歌手存在或者不存在
        synchronized (singerService)
        {
            mysinger=singerService.selectSingerByName(singerName);
            //没有查到就插入
            if(mysinger==null)
            {
                Singer record=new Singer();
                record.setName(singerName);
                singerService.insertSelective(record);
                logger.info("主键回填的值为"+record.getId());
                mysinger=record;
            }
            else
            {
                System.out.println("歌手已经存在");
            }
        }

         //查到直接把id赋值
         //这里设置歌手的id
         song.setSingerId(mysinger.getId());
         song.setLocation("../music/"+fileName);
         song.setUploadtime(new Date());
         song.setCategoryId(1);

         System.out.println(song.toString());

         int res=songService.insertSelective(song);
//        如何该目录下的文件不存在就新建一个
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

    @RequestMapping(value = "/download" ,method = RequestMethod.GET,produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String download(@RequestParam String fileName , HttpServletRequest req , HttpServletResponse resp) throws HttpServerErrorException, IOException {
//           String fileName=req.getSession().getServletContext().getRealPath("/download");
        //       String path="/home/music     //服务器下载音乐地址
        String path="/Users/fanfan/Desktop/upload/";//测试下载路径本机
        String realPath=path+fileName;//合并路径
        System.out.println(fileName);
        fileName = URLEncoder.encode(fileName,"UTF-8");//文件名中有中文进行转码
        File file=new File(realPath);
        //文件不存在直接返回失败的json交给前端处理 否则开启输入输出流 读取之后写会前端 中文乱码问题
        if(!file.exists())
        {
            logger.info(fileName+"文件不存在");
            return JSON.toJSONString(result.fault);
        }
        else
        {
            InputStream inputStream=new BufferedInputStream(new FileInputStream(realPath));
            resp.addHeader("Content-Disposition", "attachment;filename=" +fileName );
            resp.setContentType("multipart/form-data");
            BufferedOutputStream out = new BufferedOutputStream(resp.getOutputStream());
            int len=0;
            while((len=inputStream.read())!=-1)
            {
                out.write(len);
                out.flush();
            }
            out.close();
            return JSON.toJSONString(result.success);
        }
    }

}
