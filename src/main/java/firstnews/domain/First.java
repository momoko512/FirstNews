package firstnews.domain;

import java.util.List;

public class First {
    private List<Contribute> contributes;
    private List<News> news;

    public List<Contribute> getContributes() {
        return contributes;
    }

    public void setContributes(List<Contribute> contributes) {
        this.contributes = contributes;
    }

    public List<News> getNews() {
        return news;
    }

    public void setNews(List<News> news) {
        this.news = news;
    }
}
