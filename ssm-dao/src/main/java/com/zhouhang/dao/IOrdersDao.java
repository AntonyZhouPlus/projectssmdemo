package com.zhouhang.dao;

import com.zhouhang.domain.Member;
import com.zhouhang.domain.Orders;
import com.zhouhang.domain.Product;
import com.zhouhang.domain.Traveller;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author zhouhang
 * @project_name projectssmdemo
 * @package com.zhouhang.dao
 * @date 2018/9/2
 */
public interface IOrdersDao {

    @Select("select * from orders")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "orderNum",property = "orderNum"),
            @Result(column = "orderTime",property = "orderTime"),
            @Result(column = "orderStatus",property = "orderStatus"),
            @Result(column = "peopleCount",property = "peopleCount"),
            @Result(column = "payType",property = "payType"),
            @Result(column = "orderDesc",property = "orderDesc"),
            @Result(column = "productId",property = "product",javaType = Product.class,
                    one = @One(select = "com.zhouhang.dao.IProductDao.findById")),
    })
    List<Orders> findAll() throws Exception;



    @Select("select * from orders where id = #{id}")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "orderNum",property = "orderNum"),
            @Result(column = "orderTime",property = "orderTime"),
            @Result(column = "orderStatus",property = "orderStatus"),
            @Result(column = "peopleCount",property = "peopleCount"),
            @Result(column = "payType",property = "payType"),
            @Result(column = "orderDesc",property = "orderDesc"),
            @Result(column = "productId",property = "product",javaType = Product.class,
                    one = @One(select = "com.zhouhang.dao.IProductDao.findById")),
            @Result(column = "memberId",property = "member",javaType = Member.class,
                    one = @One(select = "com.zhouhang.dao.IMemberDao.selectByPrimaryKey")),
            @Result(column = "id",property = "travellers",
                    many = @Many(select = "com.zhouhang.dao.ITravellerDao.findByOrderID"))
    })
    Orders findById(String id) throws Exception;
}
