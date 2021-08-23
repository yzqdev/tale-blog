package com.yzq.talespring.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Yangzhengqian
 * @description
 * @date:Created time 2021/8/23 15:12
 * @modified By:
 */
@Controller

public class PartialPageController {
    @GetMapping("/header")
    public String getHead(){
        return  "admin/header";
    }
}
