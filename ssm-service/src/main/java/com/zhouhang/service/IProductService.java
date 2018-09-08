package com.zhouhang.service;

import com.zhouhang.domain.Permission;
import com.zhouhang.domain.Product;

import java.util.List;

/**
 * @author zhouhang
 * @project_name projectssmdemo
 * @package com.zhouhang
 * @date 2018/9/1
 */
public interface IProductService {

    List<Product> findAll(Integer page,Integer pageSize) throws Exception;
    void save(Product product);

}
