package com.zhouhang.service.Impl;

import com.github.pagehelper.PageHelper;
import com.zhouhang.dao.IProductDao;
import com.zhouhang.domain.Product;
import com.zhouhang.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author zhouhang
 * @project_name projectssmdemo
 * @package com.zhouhang.service.Impl
 * @date 2018/9/1
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS)
public class ProductServiceImpl implements IProductService {
    @Autowired
    private IProductDao productDao;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Product> findAll(Integer page,Integer pageSize) throws Exception {
        PageHelper.startPage(page,pageSize);
        return productDao.findAll();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void save(Product product) {
        productDao.save(product);
    }
}
