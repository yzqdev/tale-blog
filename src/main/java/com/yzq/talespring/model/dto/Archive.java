package com.yzq.talespring.model.dto;

import com.yzq.talespring.model.entity.Contents;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * 文章归档
 * <p>
 * Created by biezhi on 2017/2/23.
 */
@Data
public class Archive {

    private String         dateStr;
    private Date           date;
    private String         count;
    private List<Contents> articles;

}
