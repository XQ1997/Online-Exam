package com.xq.controller;

import com.xq.entity.User;
import com.xq.exception.ServiceException;
import com.xq.service.UserService;
import com.xq.util.ShiroUtil;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.util.SavedRequest;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

/**用户的登录登出控制器
 * @author fdy
 */
@Controller
public class HomeController {

    private Logger logger = LoggerFactory.getLogger(HomeController.class);
    @Autowired
    private UserService userService;
    @Autowired
    private ShiroUtil shiroUtil;

    /**登录页面
     * @return 跳转到登录页面
     */
    @GetMapping("/")
    public String login(){
        //获得subject对象
        Subject subject = SecurityUtils.getSubject();
        //判断当前是否有已经认证的账户(该subject是否认证)，认证过的话就退出该账户
        if(subject.isAuthenticated()){
            subject.logout();
        }
        //如果当前为记住我，直接跳转到首页
        if(subject.isRemembered()){
            return "redirect:/home";
        }
        return "login";
    }

    /**用户登录
     * @param stuNumber 表单中的学号或者工号
     * @param password 表单中的密码
     * @param request
     * @param redirectAttributes
     * @return
     */
    @PostMapping("/")
    public String login(String stuNumber, String password, HttpServletRequest request,
                       String rememberMe,RedirectAttributes redirectAttributes) {

        //1.创建Subject对象
        Subject subject = SecurityUtils.getSubject();
        //2.生成账号密码认证对象
        //2.1获得当前登录用户的ip,可以作为参数传递
        String ip = request.getRemoteAddr();
        //2.2将电话，密码，ip作为认证对象参数传递
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(stuNumber,DigestUtils.md5Hex(password),rememberMe!=null,ip);
        try {
            //3.根据账号密码进行登录
            subject.login(usernamePasswordToken);
            //登录成功之后跳转的目标页面的判断
            SavedRequest savedRequest = WebUtils.getSavedRequest(request);
            String url = "/home";
            if(savedRequest != null){
                url = savedRequest.getRequestUrl();
            }
            //登录成功重定向到首页
            return "redirect:" + url;
        }catch (UnknownAccountException | IncorrectCredentialsException e){
            redirectAttributes.addFlashAttribute("message","账号或者密码错误");
        }catch (LockedAccountException e){
            redirectAttributes.addFlashAttribute("message","账户已被锁定");
        }catch (AuthenticationException e){
            redirectAttributes.addFlashAttribute("message","账户或者密码错误");
        }
        return "redirect:/";
    }

    /**跳转到首页
     * @return
     */
    @GetMapping("/home")
    public String home(){
        return "home";
    }

    /**注销操作-退出系统
     * @param redirectAttributes
     * @return
     */
    @GetMapping("/logout")
    public String logout(RedirectAttributes redirectAttributes){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();

        redirectAttributes.addFlashAttribute("message","你已安全退出系统");
        return "/";
    }

    /**跳转到修改密码页面
     * @return
     */
    @GetMapping("/repassword")
    public String repassword(){
        return "repassword";
    }

    /**修改密码
     * @param oldpass 原密码
     * @param newpass 新密码
     * @param redirectAttributes
     * @return
     */
    @PostMapping("/repassword")
    public String repassword(String oldpass,String newpass,RedirectAttributes redirectAttributes){
        try{
            //获取当前的登陆对象
            User user = shiroUtil.getCurrAcc();
            userService.repassword(user,oldpass,newpass);
            redirectAttributes.addFlashAttribute("message","修改成功");
            return "redirect:/logout";
        }catch (ServiceException e){
            redirectAttributes.addFlashAttribute("message",e.getMessage());
            return "redirect:/repassword";
        }
    }

    /**跳转到注册页面
     * @return
     */
    @GetMapping("/regist")
    public String regist(){
        return "regist";
    }

    /**保存注册用户
     * @param user
     * @param redirectAttributes
     * @return
     */
    @PostMapping("/regist")
    public String saveUser(User user, RedirectAttributes redirectAttributes){
        try {
            userService.saveUser(user);
            redirectAttributes.addFlashAttribute("message", "用户注册成功");
            return "redirect:/";
        }catch (ServiceException e){
            redirectAttributes.addFlashAttribute("message","注册失败");
        }
        return "redirect:/regist";
    }

    /**跳转到忘记密码验证问题页面
     * @return
     */
    @GetMapping("/losepass")
    public String losepass(){
        return "validate";
    }

    /**获取回答的问题答案，回答正确之后进行设置新密码，问题有错误进行刷新
     * @param user
     * @param redirectAttributes
     * @return
     */
    @PostMapping("/losepass")
    public String lose(User user, RedirectAttributes redirectAttributes){
        try {
            userService.validate(user);
            redirectAttributes.addFlashAttribute("message", "验证通过，请设置新密码");
            redirectAttributes.addFlashAttribute("stuNumber", user.getStuNumber());
            return "redirect:/pass";
        }catch (ServiceException e){
            redirectAttributes.addFlashAttribute("message",e.getMessage());
        }
        return "redirect:/losepass";
    }

    /**忘记密码之后直接设置新密码
     * @return
     */
    @GetMapping("/pass")
    public String newpass(){
        return "pass";
    }

    /**保存新设置的密码，
     * @param password
     * @return
     */
    @PostMapping("/pass")
    public String savenew(String password,String stuNumber){
        userService.makepass(password,stuNumber);
        return "redirect:/";
    }

    /**查看用户详情信息
     * @return
     */
    @GetMapping("/look")
    public String lookUser(Model model){
        User user = shiroUtil.getCurrAcc();
        model.addAttribute("user",user);
        return "look";
    }
}
