package FirstNews.service;

import FirstNews.dao.UserDao;
import FirstNews.controller.exception.PasswordException;
import FirstNews.mybean.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegistService {

    public User regist(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        UserDao userDao = new UserDao();
        UserLoginService userLoginService = new UserLoginService();
        httpServletRequest.setCharacterEncoding("utf-8");
        User user = new User();
        String name = httpServletRequest.getParameter("name");
        String password = httpServletRequest.getParameter("password");
        String repassword = httpServletRequest.getParameter("repassword");
        if (password.equals(repassword)) {
            if (userDao.getuserbyname(name) == null) {
                user.setName(name);
                user.setPassword(password);
                //写入user表
                userDao.addUser(user);
                userLoginService.userdoLogin(httpServletRequest, httpServletResponse);
            } else {
                user.setName("该用户名已注册");
                throw new PasswordException("该用户名已注册");
            }

        } else {
            user.setName("密码错误");
            throw new PasswordException("注册密码错误");
        }
        return user;
    }
}