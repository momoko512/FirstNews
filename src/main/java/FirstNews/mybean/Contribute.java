package FirstNews.mybean;

public class Contribute extends All{
    //是否被审核过，默认值为空表示等待审核
    private int review;
    //审核是否通过
    private int pass;

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
}
