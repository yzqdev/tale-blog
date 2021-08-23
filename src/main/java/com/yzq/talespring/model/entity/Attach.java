package com.yzq.talespring.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 附件
 * <p>
 * Created by biezhi on 2017/2/23.
 */
@Data
@TableName( "t_attach")
public class Attach  {
@TableId(type = IdType.AUTO)
    private Integer id;
    private String  fname;
    private String  ftype;
    private String  fkey;
    private Integer authorId;
    private Integer created;

}
