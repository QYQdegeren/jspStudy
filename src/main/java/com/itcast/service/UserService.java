package com.itcast.service;

import com.itcast.mapper.UserMapper;
import com.itcast.pojo.User;
import com.itcast.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class UserService {


    SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();

//    登陆方法
    public User login(String username,String password){

        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User us = mapper.select(username, password);
        sqlSession.close();
        return us;

    }
}
