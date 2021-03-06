package com.yzq.talespring.controller.page;

import com.yzq.talespring.model.entity.User;
import com.yzq.talespring.model.params.InstallParam;
import com.yzq.talespring.service.OptionsService;
import com.yzq.talespring.service.SiteService;
import com.yzq.talespring.utils.CommonResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.nio.file.Files;
import java.nio.file.Paths;

import static com.yzq.talespring.bootstrap.TaleConst.CLASSPATH;

/**
 * @author yzq
 * @description
 * @date:Created time 2021/8/22 23:51
 * @modified By:
 */
@Controller
@RequestMapping("/home")
public class InstallController {
    @Resource
    SiteService siteService;
    @Resource
    OptionsService optionsService;
    //@Value("${tale.allow-install}")
    private boolean allowReinstall = false;

    @GetMapping("/")
    public String index(Model model) {
        boolean existInstall = Files.exists(Paths.get(CLASSPATH + "install.lock"));
        System.out.println(!allowReinstall && existInstall);
        model.addAttribute("is_install", false);
        //model.addAttribute("is_install", !allowReinstall && existInstall);
        return "install";
    }

    @ResponseBody
    @PostMapping("/install")
    public CommonResult<String> install(InstallParam installParam) {
        if (isRepeatInstall()) {
            return CommonResult.failed("请勿重复安装");
        }

        User temp = new User();
        temp.setUsername(installParam.getAdminUser());
        temp.setPassword(installParam.getAdminPwd());
        temp.setEmail(installParam.getAdminEmail());
        siteService.initSite(temp);
        optionsService.saveOptions("site_url", installParam.getSiteUrl());
        optionsService.saveOptions("site_title", installParam.getSiteTitle());

        return CommonResult.success("sucess");
    }

    private boolean isRepeatInstall() {
        return Files.exists(Paths.get(CLASSPATH + "install.lock"));

    }
}
