package com.zhouhang.service.Impl;

import com.github.pagehelper.PageHelper;
import com.zhouhang.dao.IOrdersDao;
import com.zhouhang.domain.Orders;
import com.zhouhang.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author zhouhang
 * @project_name projectssmdemo
 * @package com.zhouhang.service.Impl
 * @date 2018/9/2
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS)
public class OrderServiceImpl implements IOrderService {
    @Autowired
    private IOrdersDao ordersDao;

    @Override
    public List<Orders> findAll(Integer page, Integer pageSize) throws Exception {
        PageHelper.startPage(page,pageSize);
        return ordersDao.findAll();
    }

    @Override
    public Orders findById(String id) throws Exception {
        return ordersDao.findById(id);
    }
}
