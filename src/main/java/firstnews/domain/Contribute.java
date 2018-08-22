package firstnews.domain;
import org.springframework.stereotype.Component;

import java.io.Serializable;


public class Contribute implements Serializable {

    private int id;
    private String name;
    private String title;
    private String detail;
    private byte[] image;
    //是否被审核过，默认值为空表示等待审核
    private int review;
    //审核是否通过
    private int pass;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }


    public int getReview() {
        return review;
    }

    public void setReview(int review) {
        this.review = review;
    }

    public int getPass() {
        return pass;
    }

    public void setPass(int pass) {
        this.pass = pass;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}