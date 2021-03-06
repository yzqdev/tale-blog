package com.yzq.talespring.controller.page;

import cn.hutool.crypto.digest.MD5;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yzq.talespring.bootstrap.TaleConst;
import com.yzq.talespring.model.dto.Statistics;
import com.yzq.talespring.model.dto.Types;
import com.yzq.talespring.model.entity.Contents;
import com.yzq.talespring.model.entity.User;
import com.yzq.talespring.model.params.LoginParam;
import com.yzq.talespring.service.ContentsService;
import com.yzq.talespring.service.SiteService;
import com.yzq.talespring.service.UserService;
import com.yzq.talespring.utils.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.List;

/**
 * @author Yangzhengqian
 * @description
 * @date:Created time 2021/8/23 12:21
 * @modified By:
 */
@Controller
@RequestMapping(value = "/admin")
@Slf4j
public class AdminPageController {
    @Resource
    UserService userService;
    @Resource
    SiteService siteService;
    @Resource
    ContentsService contentsService;

    @GetMapping("/login")
    public String adminLogin() {
        return "admin/login";
    }

    @GetMapping("/index")
    public String adminIndex(Model model) {
        Statistics statistics = siteService.getStatistics();
        List<Contents> articles = contentsService.getIndexContents(Types.RECENT_ARTICLE, 5);
        model.addAttribute("statistics", statistics);
        model.addAttribute("articles", articles);
        return "admin/index";
    }

    @GetMapping("/article/new")
    public String articleNew() {
        return "admin/article/new";
    }

    @GetMapping("/articles")
    public String articles() {
        return "admin/articles";
    }
    @GetMapping("/setting")
    public String settings() {
        return "admin/setting";
    }  @GetMapping("/themes")
    public String themes() {
        return "admin/themes";
    } @GetMapping("/template")
    public String template() {
        return "admin/tpl_list";
    }
 @GetMapping("/comments")
    public String comments() {
        return "admin/comments";
    } @GetMapping("/categories")
    public String cate() {
        return "admin/categories";
    }

    @GetMapping("/profile")
    public String profile(Model model, HttpSession session) {
        //User u = (User) session.getAttribute("user");
        User u=userService.getById(1);
        System.out.println(u);
        System.out.println("------------------------------>");
        model.addAttribute(TaleConst.LOGIN_SESSION_KEY, u);


        return "admin/profile";
    }

    @GetMapping("/pages")
    public String articlePage() {
        return "admin/pages";
    }

    @GetMapping("/attaches")
    public String attaches() {
        return "admin/attaches";
    }

    @ResponseBody
    @PostMapping("/login")
    public CommonResult adminLoginPost(LoginParam loginParam, HttpSession session, HttpServletResponse response) {

        try {
            long count = userService.count(new QueryWrapper<User>().eq("username", loginParam.getUsername()));
            if (count < 1) {
                return CommonResult.failed("??????????????????");
            }
            String pwd = MD5.create().digestHex(loginParam.getUsername() + loginParam.getPassword());
            User user = userService.getOne(new QueryWrapper<User>().eq("username", loginParam.getUsername()).eq("password", pwd));
            if (user == null) {
                return CommonResult.failed("????????????????????????");
            }
            session.setAttribute(TaleConst.LOGIN_SESSION_KEY, user);
            if (StringUtils.hasText(loginParam.getRememberMe())) {
                //TaleUtils.setCookie(response, user.getUid());
                Cookie cookie = new Cookie(TaleConst.USER_IN_COOKIE, String.valueOf(user.getUid()));
                response.addCookie(cookie);


            }
            user.setLogged(new Timestamp(System.currentTimeMillis()));
            userService.updateById(user);
            log.info("???????????????{}", loginParam.getUsername());
            return CommonResult.success(user);
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.failed("????????????");
        }

    }
}
