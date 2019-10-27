package com.xq.service;

import com.xq.entity.User;
import com.xq.entity.UserExample;
import com.xq.exception.ServiceException;
import com.xq.mapper.UserMapper;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/** 用户业务实现
 * @author xq
 */
@Service
public class UserService {

    private Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserMapper userMapper;

    /**根据学号或工号查询该用户
     * @param stuNumber
     * @return
     */
    public User findByNumber(String stuNumber) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andStuNumberEqualTo(stuNumber);
        List<User> userList = userMapper.selectByExample(userExample);
        if(userList != null && !userList.isEmpty()){
            return userList.get(0);
        }
        return null;
    }

    /**修改密码
     * @param user
     * @param oldpass
     * @param newpass
     */
    public void repassword(User user, String oldpass, String newpass) throws ServiceException {
        if(DigestUtils.md5Hex(oldpass).equals(user.getPassword())){
            user.setPassword(DigestUtils.md5Hex(newpass));
            userMapper.updateByPrimaryKeySelective(user);
        }else{
            throw new ServiceException("输入原密码错误，请重新输入");
        }
    }

    /**保存注册用户
     * @param user
     */
    public void saveUser(User user) throws ServiceException{
        UserExample userExample = new UserExample();
        userExample.createCriteria().andStuNumberEqualTo(user.getStuNumber());
        List<User> userList = userMapper.selectByExample(userExample);
        if(userList != null && !userList.isEmpty()){
            throw new ServiceException("该学号/工号已经注册，请重新填写");
        }
        user.setPassword(DigestUtils.md5Hex(user.getPassword()));
        userMapper.insertSelective(user);
        logger.info("注册成功{}",user);
    }

    /**验证问题答案
     * @param user
     */
    public void validate(User user) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andStuNumberEqualTo(user.getStuNumber());
        List<User> userList = userMapper.selectByExample(userExample);
        if(userList != null && !userList.isEmpty()){
            User duser = userList.get(0);
            if(user.getName() == null && user.getName() != duser.getName()){
                throw new ServiceException("信息填写错误，验证失败！");
            }
            if(user.getRole() == null && user.getRole() != duser.getRole()){
                throw new ServiceException("信息填写错误，验证失败！");
            }
        }else{
            throw new ServiceException("该用户尚未注册，验证失败！");
        }
    }

    /**忘记密码之后重新设置密码
     * @param password 新密码
     * @param stuNumber 学号或工号
     */
    public void makepass(String password, String stuNumber) {
        User user = findByNumber(stuNumber);
        user.setPassword(DigestUtils.md5Hex(password));
        userMapper.updateByPrimaryKeySelective(user);
    }
}
