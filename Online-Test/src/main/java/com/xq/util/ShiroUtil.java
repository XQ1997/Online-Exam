package com.xq.util;

import com.xq.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Component;

/**shiro工具类--用来获取当前对象
 * @author
 */
@Component
public class ShiroUtil {

    public User getCurrAcc(){
        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getPrincipal();
        return user;
    }

}
