package com.yzq.talespring.model.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 配置选项
 *
 * @author biezhi
 */
@Data
@TableName("t_options")
public class Options {

    /**
     * 配置键
     */
    @TableId(type = IdType.AUTO)
    private Integer id;
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