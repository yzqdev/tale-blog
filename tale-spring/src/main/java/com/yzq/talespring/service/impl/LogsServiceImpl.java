package com.yzq.talespring.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yzq.talespring.mapper.LogsMapper;
import com.yzq.talespring.model.entity.Logs;
import com.yzq.talespring.service.LogsService;
import org.springframework.stereotype.Service;

/**
 * @author Yangzhengqian
 * @description
 * @date:Created time 2021/8/23 13:39
 * @modified By:
 */
@Service
public class LogsServiceImpl extends ServiceImpl<LogsMapper, Logs> implements LogsService {
}
