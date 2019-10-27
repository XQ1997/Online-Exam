package com.xq.entity;

import java.io.Serializable;

/** 用户实体类
 * @author xq
 */
public class User implements Serializable {
    public static final String TYPE_ADMIN = "管理员";
    public static final String TYPE_TEACHER = "教师";
    public static final String TYPE_STUDENT = "学生";

    private Integer id;

    /**
     * 学生姓名
     */
    private String name;

    /**
     * 是否注册,true为注册，false为未注册
     */
    private Byte registNo;

    /**
     * 性别
     */
    private String sex;

    /**
     * 学号或教师工号
     */
    private String stuNumber;

    /**
     * 登录密码
     */
    private String password;

    /**
     * 角色，分别为学生，教师，管理员
     */
    private String role;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Byte getRegistNo() {
        return registNo;
    }

    public void setRegistNo(Byte registNo) {
        this.registNo = registNo;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getStuNumber() {
        return stuNumber;
    }

    public void setStuNumber(String stuNumber) {
        this.stuNumber = stuNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", registNo=" + registNo +
                ", sex='" + sex + '\'' +
                ", stuNumber='" + stuNumber + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}