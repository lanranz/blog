package club.banyuan.bean;

import lombok.Data;

import java.util.Date;

@Data
public class Comment {
    Integer id;
    String content;
    Date createdTime;
    User commenter;
    Integer blogId;
}
