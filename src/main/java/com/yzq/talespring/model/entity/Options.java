package com.yzq.talespring.model.entity;


import lombok.Data;

/**
 * 配置选项
 *
 * @author biezhi
 */
@Data
//@Table(name = "t_options", pk = "name")
public class Options   {

    /**
     * 配置键
     */
    private String name;

    /**
     * 配置值
     */
    private String value;

    /**
     * 配置描述
     */
    private String description;

}