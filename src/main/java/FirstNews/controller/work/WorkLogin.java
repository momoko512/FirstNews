package FirstNews.controller.work;

import FirstNews.dao.WorkDao;
import FirstNews.mybean.Work;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@org.springframework.stereotype.Controller
public class WorkLogin implements Controller{
    @Override
    @RequestMapping(value = "/work/login")
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
       ModelAndView modelAndView=new ModelAndView();
        String name=httpServletRequest.getParameter("name");
       String password=httpServletRequest.getParameter("password");
        WorkDao workDao=new WorkDao();
        Work work=workDao.getbyname(name);
        if(work.getPassword().equals(password)){
            httpServletRequest.getSession().setAttribute("workname",name);
            modelAndView=new ModelAndView("work/workhome");
        }else {modelAndView=new ModelAndView("work/work");}
        return modelAndView;
    }
    @RequestMapping(value = "/work/regist")
    public ModelAndView regist(HttpServletRequest httpServletRequest){
        String name=httpServletRequest.getParameter("name");
        String password=httpServletRequest.getParameter("password");
        Work work=new Work();
        work.setName(name);
        work.setPassword(password);
        WorkDao workDao=new WorkDao();
        workDao.addwork(work);
        return new ModelAndView("work/wait");
    }
    @RequestMapping(value = "/work/work")
    public  ModelAndView work(){
        return new ModelAndView("work/work");
    }
    @RequestMapping(value = "/work/register")
    public  ModelAndView register(){
        return new ModelAndView("work/register");
    }
}
