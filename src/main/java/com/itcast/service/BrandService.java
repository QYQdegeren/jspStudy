package com.itcast.service;

import com.itcast.mapper.brandMapper;
import com.itcast.pojo.brand;
import com.itcast.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class BrandService {

    SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();

    /*
    * 查询所有
    * */
    public List<brand> selectAll(){
        //调用brandMapper中的selectAll方法

        SqlSession sqlSession = sqlSessionFactory.openSession();
        brandMapper mapper = sqlSession.getMapper(brandMapper.class);
        List<brand> brands = mapper.selectAll();
        sqlSession.close();
        return brands;
    }
}
