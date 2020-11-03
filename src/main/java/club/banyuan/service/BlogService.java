package club.banyuan.service;

import club.banyuan.bean.Blog;
import club.banyuan.bean.Comment;
import club.banyuan.bean.User;
import club.banyuan.dao.BlogDao;
import club.banyuan.dao.CommentDao;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BlogService {
    @Autowired
    private BlogDao blogDao;

    @Autowired
    private CommentDao commentDao;

     public PageInfo<Blog> getBlogs(Integer pageNum,Integer pageSize){
         PageHelper.startPage(pageNum,pageSize);
         return new PageInfo<Blog>(blogDao.getAllBlogs());
    }

    public User getUser(String username,String password){
        User user = blogDao.getUserByUsernameAndPassword(username, password);
        return user;
    }

    public Blog findBlogDetail(Integer blogId){
         return blogDao.getBlogById(blogId);
    }

    public List<Comment> getCommentsByBlog(Integer blogId){
         return commentDao.getCommentsByBlog(blogId);
    }
}
