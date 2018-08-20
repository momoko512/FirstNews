package firstnews.controller;

import firstnews.dao.ContributeDAO;
import firstnews.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Controller
public class LoginController {

    @Autowired
    private UserDao userDao;




    /*
    @Override
    @RequestMapping(value = "/login")
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        new UserLoginService().userdoLogin(httpServletRequest,httpServletResponse);
        String uri=httpServletRequest.getSession().getAttribute("page").toString();
        httpServletRequest.getRequestDispatcher(uri).forward(httpServletRequest,httpServletResponse);
        return null;
    }
    @RequestMapping(value = "editpassword")
    public ModelAndView editPassword(){
        return new ModelAndView("editpassword");
    }
    @RequestMapping(value = "submiteditpassword")
    public ModelAndView editPasswordResulr(HttpServletRequest httpServletRequest){
        String str;
        String name=httpServletRequest.getParameter("name");
        String password=httpServletRequest.getParameter("password");
        String newpassword=httpServletRequest.getParameter("newpassword");
        String repassword=httpServletRequest.getParameter("repassword");
        String sename=httpServletRequest.getSession().getAttribute("name").toString();
        String sepassword=httpServletRequest.getSession().getAttribute("password").toString();
        if(name.equals(sename)){
            if(password.equals(sepassword)){
                if(newpassword.equals(repassword)&&!newpassword.isEmpty()){
                    User user=new User();
                    user.setName(name);
                    user.setPassword(newpassword);
                    UserDao userDao=new UserDao();
                    userDao.update(user);
                    httpServletRequest.getSession().setAttribute("password",newpassword);
                    str="更改密码成功";
                }else {str="新密码确认错误";}
            }else {str="密码输入错误";}
        }else {str="用户名不符";}
        return new ModelAndView("editpasswordresult","str",str);
    }
    */
}
