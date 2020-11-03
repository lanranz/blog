package club.banyuan.controller;

import club.banyuan.bean.Blog;
import club.banyuan.bean.User;
import club.banyuan.service.BlogService;
import club.banyuan.service.UserService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {
    @Autowired
    private BlogService blogService;
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String getHomePage(Model model, @RequestParam(defaultValue = "1") Integer pageNum,
                              @RequestParam(defaultValue = "10") Integer pageSize) {
        PageInfo<Blog> blogs = blogService.getBlogs(pageNum,pageSize);
        model.addAttribute("blogs", blogs);
        System.out.println(blogs);
        return "index";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }


    @PostMapping("/login")
    public String loginTo(HttpSession session, String username, String password) {
        User user = blogService.getUser(username, password);
        if (user == null) {
            return "redirect:/login";
        } else {
            session.setAttribute("user",user);
            return "redirect:/admin";
        }
    }

    @GetMapping("/admin")
    public void admin(Model model,HttpSession session) {
        model.addAttribute("user",session.getAttribute("user"));
    }

    @GetMapping("/register")
    public String register(){
        return "register";
    }

    @PostMapping("/register")
    public void registerTo(String name,String email,String password){
        userService.InsertUser(name,email,password);
    }

}
