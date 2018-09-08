package com.zhouhang.dao;

import com.zhouhang.domain.Traveller;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author zhouhang
 * @project_name projectssmdemo
 * @package com.zhouhang.dao
 * @date 2018/9/3
 */
public interface ITravellerDao {

    @Select("select * from traveller where id in (select travellerId from ORDER_TRAVELLER where orderId = #{orderId})")
    List<Traveller> findByOrderID(String orderId) throws Exception;
}
