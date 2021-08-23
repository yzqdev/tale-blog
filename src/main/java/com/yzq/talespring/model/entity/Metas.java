package com.yzq.talespring.model.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 元数据
 *
 * @author biezhi
 */
@Data
 @TableName( "t_metas" )
public class Metas   {

    /**
     * 项目主键
     */
    @TableId(type = IdType.AUTO)
    private Integer mid;

    /**
     * 项目名称
     */
    private String  name;

    /**
     * 项目缩略名
     */
    private String  slug;

    /**
     * 项目类型
     */
    private String  type;

    /**
     * 项目描述
     */
    private String  description;

    /**
     * 项目排序
     */
    private Integer sort;

    /**
     * 父级
     */
    private Integer parent;

    /**
     * 项目下文章数
     */

    private Integer count;

}