package com.yzq.talespring.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yzq.talespring.model.entity.Contents;

import java.util.List;

/**
 * @author Yangzhengqian
 * @description
 * @date:Created time 2021/8/23 13:13
 * @modified By:
 */
public interface ContentsService extends IService<Contents> {
List<Contents> getIndexContents(String type, int limit);

}
