package firstnews.controller;

public class ResponseModel<T> {

    private boolean success;
    private String message;
    private T content;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    public static <T> ResponseModel<T> SUCCESS(T content) {
        ResponseModel<T> responseModel = new ResponseModel<T>();
        responseModel.content = content;
        responseModel.success = true;
        responseModel.message = "success";
        return responseModel;
    }
}
