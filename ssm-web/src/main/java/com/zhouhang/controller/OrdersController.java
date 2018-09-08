package com.zhouhang.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhouhang.domain.Orders;
import com.zhouhang.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author zhouhang
 * @project_name projectssmdemo
 * @package com.zhouhang.controller
 * @date 2018/9/2
 */
@Controller
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    IOrderService orderService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page",defaultValue = "1") Integer page,
                                @RequestParam(name = "pageSize",defaultValue = "3") Integer pageSize) throws Exception {

        List<Orders> ordersList = orderService.findAll(page,pageSize);
        PageInfo pageInfo = new PageInfo(ordersList);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("pageInfo",pageInfo);
        modelAndView.setViewName("orders-list");
        return modelAndView;
    }

    @RequestMapping("/findById.do")
    public ModelAndView findById(String id) throws Exception {
        Orders orders = orderService.findById(id);
        ModelAndView mv = new ModelAndView();
        mv.addObject("orders",orders);
        mv.setViewName("orders-show");
        return mv;
    }

}
