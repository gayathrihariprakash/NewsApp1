package news.com.newsapp.newsadapter;

import android.support.v7.widget.RecyclerView;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import news.com.newsapp.NewsDetails;
import news.com.newsapp.R;
import news.com.newsapp.newsdetails.Article;
import news.com.newsapp.returndate.GetDate;

import java.util.List;



public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.MyViewHolder> {

    private List<Article> articleList;

    public NewsAdapter(List<Article> articleList) {
        this.articleList = articleList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        Article article = articleList.get(position);

        Glide.with(holder.NewsImage.getContext())
                .load(article.getUrlToImage())
                .centerCrop()
                .into(holder.NewsImage);
        holder.NewsTitle.setText(article.getTitle());
        holder.NewsTime.setText(GetDate.formatNewsApiDate(article.getPublishedAt()));
        holder.NewsContent.setText(article.getDescription());



        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NewsDetails.launch(v.getContext(), position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return articleList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView NewsImage;
        TextView NewsTitle;
        TextView NewsTime;
        TextView NewsContent;

        public MyViewHolder(View itemView) {
            super(itemView);
            NewsImage = (ImageView) itemView.findViewById(R.id.newsimage);
            NewsTitle = (TextView) itemView.findViewById(R.id.newstitle);
            NewsTime = (TextView) itemView.findViewById(R.id.newstime);
            NewsContent = (TextView) itemView.findViewById(R.id.newscontent);
        }
    }
}
