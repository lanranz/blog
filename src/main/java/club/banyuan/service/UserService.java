package club.banyuan.service;

import club.banyuan.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public void InsertUser(String name,String email,String password){
        userDao.InsertUser(name,email,password);
    }
}
