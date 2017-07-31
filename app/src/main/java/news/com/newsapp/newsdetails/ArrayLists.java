package news.com.newsapp.newsdetails;

import java.util.ArrayList;
import java.util.List;


public class ArrayLists {
    private static List<news.com.newsapp.newsdetails.Article> articles = new ArrayList<>();

    public static List<news.com.newsapp.newsdetails.Article> getArticles() {
        return articles;
    }

    public static void setArticles(List<news.com.newsapp.newsdetails.Article> articles) {
        ArrayLists.articles = articles;
    }
}
