package com.zhouhang.dao;

import com.zhouhang.domain.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author zhouhang
 * @project_name projectssmdemo
 * @package com.zhouhang
 * @date 2018/9/1
 */
public interface IProductDao {

    @Select("select * from product where id = #{id}")
    Product findById(String id);

    @Select("select * from product")
    List<Product> findAll() throws Exception;

    @Insert("insert into product(productNum,productName," +
            "cityName,departureTime,productPrice,productDesc," +
            "productStatus) values(#{productNum},#{productName}," +
            "#{cityName},#{departureTime},#{productPrice}," +
            "#{productDesc},#{productStatus})")
    void save(Product product);

}
