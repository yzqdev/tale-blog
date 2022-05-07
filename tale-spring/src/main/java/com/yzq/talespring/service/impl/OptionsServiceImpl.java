package com.yzq.talespring.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yzq.talespring.mapper.OptionsMapper;
import com.yzq.talespring.model.entity.Options;
import com.yzq.talespring.service.OptionsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Yangzhengqian
 * @description
 * @date:Created time 2021/8/23 11:30
 * @modified By:
 */
@Service
public class OptionsServiceImpl extends ServiceImpl<OptionsMapper, Options> implements OptionsService {
    @Resource
    OptionsMapper optionsMapper;

    @Override
    public void saveOptions(String name, String value) {
        QueryWrapper<Options> queryWrapper= new QueryWrapper<>();
        queryWrapper.eq("name",name);
       long count=optionsMapper.selectCount(queryWrapper);
      if (count>0){
         Options setOptions=optionsMapper.selectOne(queryWrapper);
         setOptions.setName(name);
         setOptions.setValue(value);
         optionsMapper.updateById(setOptions);
      }else {
          Options options = new Options();
          options.setName(name);
          options.setValue(value);
          options.setDescription(null);

          optionsMapper.insert(options);
      }
    }
}
