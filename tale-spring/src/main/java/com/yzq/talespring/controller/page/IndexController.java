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

    @Resource
    UserService userService;
    @GetMapping("/")
    public String index() {
        return  "themes/index";
    }
  @GetMapping("/archives")
    public String achive() {
        return "themes/archives";
    }
  @GetMapping("/article")
    public String article() {
        return  "themes/post";
    }


}
