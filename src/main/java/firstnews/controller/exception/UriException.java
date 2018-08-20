package firstnews.controller.exception;

import firstnews.controller.SearchController;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.PrintWriter;
import java.io.StringWriter;

public class UriException extends Exception {
    private String message;

    public UriException() {
        super();
        StringWriter stringWriter=new StringWriter();
        printStackTrace(new PrintWriter(stringWriter));
        Logger log = LogManager.getLogger(UriException.class);
        log.error(stringWriter.toString());
    }

    public UriException(String message) {
        super(message);
        this.message=message;
    }

    public UriException(String message, Throwable throwable) {
        super(message, throwable);
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
