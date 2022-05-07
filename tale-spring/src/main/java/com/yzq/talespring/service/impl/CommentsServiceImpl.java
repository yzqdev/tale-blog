package com.yzq.talespring.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yzq.talespring.mapper.CommentsMapper;
import com.yzq.talespring.model.entity.Comments;
import com.yzq.talespring.service.CommentsService;
import org.springframework.stereotype.Service;

/**
 * @author Yangzhengqian
 * @description
 * @date:Created time 2021/8/23 13:21
 * @modified By:
 */
@Service
public class CommentsServiceImpl extends ServiceImpl<CommentsMapper, Comments> implements CommentsService {
}
