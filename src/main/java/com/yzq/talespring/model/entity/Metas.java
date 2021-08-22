package com.yzq.talespring.model.entity;


import lombok.Data;

/**
 * 元数据
 *
 * @author biezhi
 */
@Data
//@Table(name = "t_metas", pk = "mid")
public class Metas   {

    /**
     * 项目主键
     */
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