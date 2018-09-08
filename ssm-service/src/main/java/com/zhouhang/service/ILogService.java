package com.zhouhang.service;

import com.zhouhang.domain.SysLog;

import java.util.List;

/**
 * @author zhouhang
 * @project_name projectssmdemo
 * @package com.zhouhang.service
 * @date 2018/9/7
 */
public interface ILogService {
    void saveLog(SysLog log);
    List<SysLog>  findAll();
}
