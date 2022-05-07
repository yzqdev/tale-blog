package com.yzq.talespring.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 数据关系
 *
 * @author biezhi
 */
@Data
 @TableName(  "t_relationships" )
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