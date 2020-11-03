package club.banyuan.controller;

import club.banyuan.bean.Blog;
import club.banyuan.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;
import java.beans.IntrospectionException;
@Controller
public class BlogController {
    @Autowired
    private BlogService blogService;

    @GetMapping("/blog/{id}")
    public String getBlogInfo(@PathVariable(name = "id") Integer blogId, Model model){
        Blog blog = blogService.findBlogDetail(blogId);
        model.addAttribute("blogs",blog);
        model.addAttribute("comments",blog.getComments());
        return "item";
    }

}
