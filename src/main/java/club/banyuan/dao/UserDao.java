package club.banyuan.dao;

import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
    void InsertUser(String name,String email,String password);
}
