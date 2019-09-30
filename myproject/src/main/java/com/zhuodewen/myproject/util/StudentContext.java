package com.zhuodewen.myproject.util;

import com.zhuodewen.myproject.domain.Student;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;

//定义用户登录的工具类(用户获取和设置session)
public class StudentContext {
     //session中员工的常量
     public static final String STUDENT_IN_SESSION="STUDENT_IN_SESSION";

    /*--------------------------------利用SpringMVC获取session的固定方法-------------------------------*/
    public static HttpSession getSession(){
        //获取session的固定操作(SpringMVC框架的方法)
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).
                                     getRequest().getSession();
    }
    /*----------------------------------当前登录员工的对象相关----------------------------------------------*/
    //获取当前登录的用户,将用户设置到session中
    public static Student getCurrentUser(){
        return (Student) getSession().getAttribute(STUDENT_IN_SESSION);
    }

    //设置当前登录的用户,将用户设置到session中
    public static void setCurrentUser(Student student){
        getSession().setAttribute(STUDENT_IN_SESSION,student);
    }
    /*--------------------------------------------------------------------------------*/
}
