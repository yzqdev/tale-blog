package com.yzq.talespring.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yzq.talespring.mapper.ContentsMapper;
import com.yzq.talespring.model.entity.Contents;
import com.yzq.talespring.service.ContentsService;
import org.springframework.stereotype.Service;

/**
 * @author Yangzhengqian
 * @description
 * @date:Created time 2021/8/23 13:13
 * @modified By:
 */
@Service
public class ContentsServiceImpl extends ServiceImpl<ContentsMapper, Contents> implements ContentsService {
}
