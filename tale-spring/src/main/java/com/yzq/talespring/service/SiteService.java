package com.yzq.talespring.service;

import com.yzq.talespring.model.dto.Statistics;
import com.yzq.talespring.model.entity.User;

/**
 * @author Yangzhengqian
 * @description
 * @date:Created time 2021/8/23 9:37
 * @modified By:
 */
public interface SiteService {
    /**
     * 初始化站点
     * @param user
     */
    void initSite(User user);
    Statistics getStatistics();
}
