package com.yzq.talespring.model.entity;

import lombok.Data;

/**
 * 数据关系
 *
 * @author biezhi
 */
@Data
//@Table(name = "t_relationships", pk = "mid")
public class Relationships {

    /**
     * 文章主键
     */
    private Integer cid;

    /**
     * 项目主键
     */
    private Integer mid;

}