package com.zhouhang.controller;

import com.zhouhang.domain.SysLog;
import com.zhouhang.service.ILogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import java.util.List;

/**
 * @author zhouhang
 * @project_name projectssmdemo
 * @package com.zhouhang.controller
 * @date 2018/9/7
 */
@Controller
@RequestMapping("/sysLog")
public class LogController {
    @Autowired
    private ILogService logService;

    @RequestMapping("/findAll.do")
    @RolesAllowed("ADMIN")
//    @Secured("ROLE_ADMIN")
//    @PreAuthorize("authentication.principal.username == 'zhouhang'")
    public ModelAndView findAll() {
        List<SysLog> logList = logService.findAll();
        ModelAndView mv = new ModelAndView();
        mv.addObject("sysLogs",logList);
        mv.setViewName("syslog-list");
        return mv;
    }
}
