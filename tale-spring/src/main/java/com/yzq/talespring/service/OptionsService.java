package com.yzq.talespring.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yzq.talespring.model.entity.Options;

/**
 * @author Yangzhengqian
 * @description
 * @date:Created time 2021/8/23 11:29
 * @modified By:
 */
public interface OptionsService extends IService<Options> {
    void saveOptions(String name,String value);
}
