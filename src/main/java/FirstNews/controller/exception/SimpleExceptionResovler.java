package FirstNews.controller.exception;
/*全局异常捕获*/


import FirstNews.controller.SearchController;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import java.io.StringWriter;

@ControllerAdvice
public class SimpleExceptionResovler {
    private static Logger log = LogManager.getLogger(SimpleExceptionResovler.class);
    @ExceptionHandler(UriException.class)
    public ModelAndView uriException(UriException ex){
        log.warn("warn uri>>>>>>>>>>>>>"+ex.getMessage());
        String s=ex.getMessage();
        return new ModelAndView("error","error",s);

}
    @ExceptionHandler({PasswordException.class})
public ModelAndView passException(PasswordException ex){
        log.warn("warn  pass>>>>>>>>>>>"+ex.getMessage());
        String s=ex.getMessage();
        return new ModelAndView("error","error",s);
    }
    @ExceptionHandler({Exception.class})
    public void exception(Exception ex){
        Logger log1 = LogManager.getLogger(SearchController.class);
        log1.error("uuuuuuuuuuu"+ ex.getLocalizedMessage());
    }




}
