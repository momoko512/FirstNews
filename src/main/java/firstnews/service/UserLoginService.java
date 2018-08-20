package firstnews.service;


import firstnews.domain.User;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class UserLoginService {
    /*
    private String name;
    public String getName(){return name;}
    private  String password;

    public void userdoLogin(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse)throws Exception{
        UserDao userDao=new UserDao();
            name = httpServletRequest.getParameter("name");
            password = httpServletRequest.getParameter("password");
            if (null != name && null != password && !name.equals("") && !password.equals("")) {
                if (userDao.getuserbyname(name) != null) {
                    User user =userDao.getuserbyname(name);
                    if (user.getPassword().equals(password)) {
                        httpServletRequest.getSession().setAttribute("name", name);
                        httpServletRequest.getSession().setAttribute("password", password);
                        docookie(httpServletRequest, httpServletResponse);
                    }else {throw new PasswordException(name+"密码错误");}
                }else {throw new NullPointerException("该用户名没注册");}
            }
    }
    private void docookie(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
        String[] isrem=httpServletRequest.getParameterValues("remname");
        if(isrem!=null&&isrem.length>0){
            Cookie namecookie=new Cookie("name",name);
            Cookie passwordcookie=new Cookie("password",password);
            namecookie.setMaxAge(864000);
            passwordcookie.setMaxAge(864000);
            httpServletResponse.addCookie(namecookie);
            httpServletResponse.addCookie(passwordcookie);
        }else {
            Cookie[] cookies=httpServletRequest.getCookies();
            if(cookies!=null&&cookies.length>0){
                for(Cookie c:cookies){
                    if(c.getValue().equals(name)||c.getValue().equals(password)){
                        c.setMaxAge(0);
                        httpServletResponse.addCookie(c);
                    }
                }

            }

        }

    }
    */
    public User logincook(HttpServletRequest httpServletRequest) throws Exception {
        User user=null;
        Cookie[] cookies = httpServletRequest.getCookies();
        if (cookies != null && cookies.length > 0) {
            for (Cookie c : cookies) {
                if (c.getName().equals("name")) {
                    String name = c.getValue();
                    httpServletRequest.getSession().setAttribute("name", name);
                    user=new User();
                    user.setName(name);
                }
            }
        } else {
            httpServletRequest.getSession().setAttribute("name", null);
        }
        return user;
    }
}
