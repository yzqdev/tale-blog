package com.yzq.talespring.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author yzq
 * @description
 * @date:Created time 2021/8/22 21:48
 * @modified By:
 */
@Controller
public class IndexController {
    @GetMapping("/install")
    public String install(){
        return "install";
    }

}
