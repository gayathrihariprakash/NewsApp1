package news.com.newsapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import news.com.newsapp.newsadapter.NewsAdapter;
import news.com.newsapp.newsdetails.GetArticlesResponse;
import news.com.newsapp.newsdetails.ArrayLists;
import news.com.newsapp.path.NewsAPI;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    private RecyclerView newsRecyclerView;
    private NewsAdapter newsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        newsRecyclerView = (RecyclerView) findViewById(R.id.activity_main_recyclerview);
        newsRecyclerView.setLayoutManager(new GridLayoutManager(this,2));

        Call<GetArticlesResponse> call = NewsAPI.getApi().getArticles("national-geographic", "top");
        call.enqueue(new Callback<GetArticlesResponse>() {
            @Override
            public void onResponse(Call<GetArticlesResponse> call, Response<GetArticlesResponse> response) {
                GetArticlesResponse getArticlesResponse = response.body();
                ArrayLists.setArticles(getArticlesResponse.getArticles());
                newsAdapter = new NewsAdapter(getArticlesResponse.getArticles());
                newsRecyclerView.setAdapter(newsAdapter);
            }

            @Override
            public void onFailure(Call<GetArticlesResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error " + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
