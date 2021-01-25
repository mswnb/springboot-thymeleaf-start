package cn.msw.springbootthymeleafstart.controller;

import cn.msw.springbootthymeleafstart.bean.UserPlus;
import cn.msw.springbootthymeleafstart.service.UserPlusService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * @Author 毛送文
 * @Date 2021/1/19 22:44
 * @Version 1.0
 */
@Controller
public class TableController {
    @Autowired
    private UserPlusService userPlusService;
    @GetMapping("/basic_table")
    public String basic_table(){
        int i=10/0;
        return "table/basic_table";
    }

    @GetMapping("/user/delete/{id}")
    public String deleteUserPlusById(@PathVariable("id") Long id,
                                     @RequestParam(value = "pn",defaultValue = "1") Integer pn,
                                     RedirectAttributes ra){
        userPlusService.removeById(id);
        ra.addAttribute("pn",pn);
        return "redirect:/dynamic_table";
    }

    @GetMapping("/dynamic_table")
    public String dynamic_table(@RequestParam(value = "pn",defaultValue = "1") Integer pn, Model model){
       /* List<User> users = Arrays.asList(new User("毛送文", "123456"), new User("张三", "7654321"),
                new User("李四", "88888888"));

        model.addAttribute("users",users);*/
        /*List<UserPlus> list = userPlusService.list();
        model.addAttribute("userPlus",list);*/
        /*分页查询数据*/
        Page<UserPlus> userPlusPage = new Page<>(pn,2);
        /*分页查询结果*/
        IPage<UserPlus> page = userPlusService.page(userPlusPage);
        model.addAttribute("page",page);

        return "table/dynamic_table";
    }
    @GetMapping("/editable_table")
    public String editable_table(){
        return "table/editable_table";
    }
    @GetMapping("/pricing_table")
    public String pricing_table(){
        return "table/pricing_table";
    }
    @GetMapping("/responsive_table")
    public String responsive_table(){
        return "table/responsive_table";
    }
}
