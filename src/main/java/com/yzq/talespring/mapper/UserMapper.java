package com.yzq.talespring.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yzq.talespring.model.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author yzq
 * @description
 * @date:Created time 2021/8/22 21:41
 * @modified By:
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
