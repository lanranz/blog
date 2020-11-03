package club.banyuan.dao;

import club.banyuan.bean.Blog;
import club.banyuan.bean.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogDao {
    List<Blog> getAllBlogs();
    User getUserByUsernameAndPassword(String username, String password);
    public Blog getBlogById(Integer blogId);
}
