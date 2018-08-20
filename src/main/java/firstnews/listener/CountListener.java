package firstnews.listener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.concurrent.atomic.AtomicLong;

@WebListener
public class CountListener implements HttpSessionListener {
    private static final Logger logger = LogManager.getLogger(CountListener.class);
    private AtomicLong count = new AtomicLong(0);

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        count.incrementAndGet();
        se.getSession().getServletContext().setAttribute("count", count);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        count.decrementAndGet();
        se.getSession().getServletContext().setAttribute("count", count);
    }
}
