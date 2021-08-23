package com.yzq.talespring.controller.page;

import com.yzq.talespring.model.entity.User;
import com.yzq.talespring.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author yzq
 * @description
 * @date:Created time 2021/8/22 21:48
 * @modified By:
 */
@Controller
public class IndexController {
    public static String THEME = "themes/";
    @Resource
    UserService userService;
    @GetMapping("/")
    public String index() {
        return THEME+"index";
    }
  @GetMapping("/achives")
    public String achive() {
        return THEME+"achives";
    }
  @GetMapping("/article")
    public String article() {
        return THEME+"post";
    }


}
