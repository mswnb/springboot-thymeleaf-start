package cn.msw.springbootthymeleafstart.controller;

import cn.msw.springbootthymeleafstart.bean.Account;
import cn.msw.springbootthymeleafstart.bean.City;
import cn.msw.springbootthymeleafstart.bean.User;
import cn.msw.springbootthymeleafstart.service.AccountService;
import cn.msw.springbootthymeleafstart.service.CityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Author 毛送文
 * @Date 2021/1/16 18:39
 * @Version 1.0
 */
@Controller
@Slf4j
public class IndexController {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private AccountService accountService;
    @Autowired
    private CityService cityService;
    @Autowired
    private StringRedisTemplate redisTemplate;
    @PostMapping("/city")
    @ResponseBody
    public City saveCity(City city){
        cityService.saveCity(city);
        return city;
    }

    @GetMapping("/city")
    @ResponseBody
    public City getCityById(@RequestParam("id") Long id){
        return cityService.getCityById(id);
    }

    @GetMapping("/acct")
    @ResponseBody
    public Account getAcct(@RequestParam("id") Long id){
        return accountService.getAcctById(id);
    }

    @GetMapping("/sql")
    @ResponseBody
    public String queryAccount(){
        List<Account> accounts = jdbcTemplate.query("select * from account", new BeanPropertyRowMapper<Account>(Account.class));
        return accounts.toString();
    }
    /**
     * 来登录页
     * @return 登录页面
     */
    @GetMapping(value = {"/","/login"})
    public String loginPage(){
        return "login";
    }

    @PostMapping("/login")
    public String main(User user, HttpSession session, Model model){
        System.out.println(user);
        if(!(StringUtils.isEmpty(user.getUserName())) && "123456".equals(user.getPassword())){
            session.setAttribute("loginUser",user);
            //登录成功,重定向到main.html 重定向防止表单重复提交
            return "redirect:/main.html";
        }else{
            model.addAttribute("msg","用户名或密码错误！");
            //回到登录页面
            return "login";
        }

    }

    /**
     *去main页面
     * @return 主页面
     */
    @GetMapping("/main.html")
    public String mainPage(HttpSession session,Model model){
        log.info("当前方法是{}","mainPage");
        //是否登录,拦截器,过滤器
        /*User user = (User) session.getAttribute("loginUser");
        if(user!=null){
            return "main";
        }else {
            model.addAttribute("msg","请重新登录!");
            //回到登录页面
            return "login";
        }*/
        ValueOperations<String, String> operations = redisTemplate.opsForValue();
        String s = operations.get("/main.html");
        String s2 = operations.get("/sql");
        model.addAttribute("mainCount",s);
        model.addAttribute("sqlCount",s2);
        return "main";
    }
}
