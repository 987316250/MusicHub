package com.web.service;

import com.web.dao.UserMapper;
import com.web.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;
    public List <User>selectAll(){
        return userMapper.selectAll();
    }

    public User selectByName(String name)
    {
        return  userMapper.selectByName(name);
    }

     public  int deleteByPrimaryKey(Integer id){
          return userMapper.deleteByPrimaryKey(id);
    }

    public  int insertSelective(User record){
         return userMapper.insertSelective(record);
    };
//
//    int insert(User record){
//
//    };
//

//
//    User selectByPrimaryKey(Integer id){
//
//    };
//
//    int updateByPrimaryKeySelective(User record){
//
//    };
//
   public  int updateByPrimaryKey(User record){
        return userMapper.updateByPrimaryKey(record);
    }
}