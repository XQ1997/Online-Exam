<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<header>
    <div class="navbar-fixed">
        <nav class="light-green darken-1">
            <div class="container">
                <div class="nav-wrapper">
                    <a href="/home" class="brand-logo">《数据库原理与应用》考试网站</a>
                    <ul id="nav-mobile4" class="right hide-on-med-and-down">
						<li>
							<div class="chip">
								<a href="#" class="dropdown-button" data-activates="user_dropdown" data-induration="3000"
									data-beloworigin="true" data-hover="true">
								<img src="/static/project/images/soccer4.jpg" alt="大黄鸭">
									<font size="3" color="#00008b"><shiro:principal property="name"/></font>
									<font size="3" color="#663399"><shiro:principal property="role"/></font>
								</a>
							</div>
							<ul class="dropdown-content yellow lighten-5" id="user_dropdown">
								<li><a href="/repassword" class="indigo-text text-darken-2">修改密码</a></li>
								<li><a href="/look" class="indigo-text text-darken-2" >查看信息</a></li>
								<li class="divider"></li>
								<li><a href="/logout" class="indigo-text text-darken-2">退出登陆</a></li>
							</ul>
						</li>
                    </ul>
                </div>
            </div>
        </nav>
    </div>
</header>