package com.itcast.mapper;


import com.itcast.pojo.brand;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface brandMapper {
    /*
    * 查询所有
    * */
    List<brand> selectAll();

    /*
    * 查看详情
    * */
    brand selectByid(int id);

    /*
    * 多条件查询
    * 散装参数，@Param("SQL语句的占位符名称")
    * 对象参数，对象的属性名称要和参数占位符名称一样
    * map集合，保证sql中的参数名和map集合的键的名称一样
    * */
    //List<brand> selectBycondition(@Param("companyName") String companyName, @Param("brandName") String brandName);
    List<brand> selectBycondition(brand br);
    List<brand> selectBycondition2(brand br);
    //单条件动态查询
    List<brand> selectBySingle(brand br);

    void add(brand br);
    //修改数据
    void updata(brand br);

    void updata2(brand br);

    void delectByid(int id);

    void delectByids(@Param("ids") int[] ids);

    //可以使用注解完成简单的操作
    @Select("select * from tb_brand")
    List<brand> selectAll2();


}
