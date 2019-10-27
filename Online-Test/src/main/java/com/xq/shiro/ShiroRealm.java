package com.xq.shiro;

import com.xq.entity.User;
import com.xq.exception.ServiceException;
import com.xq.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class ShiroRealm extends AuthorizingRealm {
    //获得日志对象
    private Logger logger = LoggerFactory.getLogger(ShiroRealm.class);
    @Autowired
    private UserService userService;

    /**判断角色和权限
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    /**判断登录
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;
        //从认证器中获得输入的电话
        String stuNumber = usernamePasswordToken.getUsername();
        if(stuNumber != null){
            //根据获得的电话获得用户对象
            User user = userService.findByNumber(stuNumber);
            if(user == null){
                throw new ServiceException("找不到账户" + stuNumber);
            }else{
               //usernamePasswordToken.getHost()获得认证对象传过来的ip地址
               logger.info("{},登录了系统{}",user,usernamePasswordToken.getHost());
               //返回一个简单的认证消息 第一个参数为使用getPrincipal()方法时返回的值，第二个参数为凭证，第三个参数为realm类的名(实现Realm接口中getName()方法中声明)
               return new SimpleAuthenticationInfo(user,user.getPassword(),getName());
            }
        }
        return null;
    }
}
