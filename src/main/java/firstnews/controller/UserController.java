package firstnews.controller;

import firstnews.dao.UserDao;
import firstnews.domain.User;
import firstnews.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserDao userDao;

    @PostMapping("/login")
    public User login(@RequestBody User loginUser, HttpServletRequest httpServletRequest) {
        User user = userDao.get(loginUser.getName());
        if (user != null && (user.getPassword().equals(loginUser.getPassword()))) {
            httpServletRequest.getSession().setAttribute("name", user.getName());
        } else {
            user = null;
        }
        return user;
    }

    @PostMapping("/getcookie")
    public User getCookie(HttpServletRequest httpServletRequest) throws Exception {
        UserLoginService userLoginService = new UserLoginService();
        return userLoginService.logincook(httpServletRequest);
    }

    @GetMapping("/headlogin")
    public ModelAndView headLogin() {
        return new ModelAndView("headlogin");
    }

    @PostMapping("/docookie")
    public void doCookie(Boolean iscookie, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        String name = httpServletRequest.getSession().getAttribute("name").toString();
        if (iscookie) {
            Cookie namecookie = new Cookie("name", name);
            namecookie.setMaxAge(864000);
            httpServletResponse.addCookie(namecookie);
        } else {
            Cookie[] cookies = httpServletRequest.getCookies();
            if (cookies != null && cookies.length > 0) {
                for (Cookie c : cookies) {
                    if (c.getValue().equals(name)) {
                        c.setMaxAge(0);
                        httpServletResponse.addCookie(c);
                    }
                }

            }
        }
    }

    @GetMapping("/exit")
    public ModelAndView exit(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse) {
        System.out.println("exit");
        doCookie(false,httpServletRequest,httpServletResponse);
        httpServletRequest.getSession().setAttribute("name", null);
        return new ModelAndView("headnologin");
    }
    @GetMapping("/registe")
    public ModelAndView registe(){
        return new ModelAndView("registe");
    }

}



