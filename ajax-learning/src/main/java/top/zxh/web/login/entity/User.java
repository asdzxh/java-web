package top.zxh.web.login.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Date:2023/3/3
 * Author：zxh
 * Description: User实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    /*
    id 主键
     */
    private Integer id;
    /*
    用户名
     */
    private String username;
    /*
    密码
     */
    private String password;
}
