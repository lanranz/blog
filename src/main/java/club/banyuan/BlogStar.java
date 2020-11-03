package club.banyuan;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("club.banyuan")
public class BlogStar {
    public static void main(String[] args) {
        SpringApplication.run(BlogStar.class,args);
    }
}
