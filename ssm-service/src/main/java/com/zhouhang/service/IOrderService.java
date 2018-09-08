package com.zhouhang.service;

import com.zhouhang.domain.Orders;

import java.util.List;

/**
 * @author zhouhang
 * @project_name projectssmdemo
 * @package com.zhouhang.service
 * @date 2018/9/2
 */
public interface IOrderService {
    List<Orders> findAll(Integer page,Integer pageSize) throws Exception;
    Orders findById(String id) throws Exception;
}
