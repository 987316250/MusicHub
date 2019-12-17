package com.web.Utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.Map;
//后端返回json封装
@Controller
public class Result {
    public  int state;
    public  Map<String,Object> success=new HashMap<>();
    public  Map<String,Object> fault=new HashMap<>();
    public Result()
    {
       success.put("result","true");
       fault.put("result","false");
    }
}
