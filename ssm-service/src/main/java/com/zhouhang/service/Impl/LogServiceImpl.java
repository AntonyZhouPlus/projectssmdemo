package com.zhouhang.service.Impl;

import com.zhouhang.dao.ILogDao;
import com.zhouhang.domain.SysLog;
import com.zhouhang.service.ILogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhouhang
 * @project_name projectssmdemo
 * @package com.zhouhang.service.Impl
 * @date 2018/9/7
 */
@Service
public class LogServiceImpl implements ILogService {
    @Autowired
    private ILogDao logDao;

    @Override
    public void saveLog(SysLog log) {
        logDao.insert(log);
    }

    @Override
    public List<SysLog> findAll() {
        return logDao.selectAll();
    }
}
