package com.sleektech.dbnafrica.m_UI;

/**
 * Created by SLICKBOSS on 7/21/2017.
 */

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sleektech.dbnafrica.R;
import com.sleektech.dbnafrica.m_DataObject.Article;
import com.sleektech.dbnafrica.m_DetailActivity.DetailActivity;

import java.util.ArrayList;






public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {
    Context c;
    ArrayList<Article> articles;
    public MyAdapter(Context c, ArrayList<Article> articles) {
        this.c = c;
        this.articles = articles;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(c).inflate(R.layout.model,parent,false);
        return new MyViewHolder(v);
    }
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Article article=articles.get(position);
        final String title=article.getTitle();
        final String desc=article.getDescription();
        final String date=article.getDate();
        final String guid=article.getGuid();
        final String link=article.getLink();
        holder.titleTxt.setText(title);
        holder.descTxt.setText(Html.fromHtml(desc));
        holder.dateTxt.setText(date);
        holder.setItemClickListener(new ItemClickListener() {

            @Override
            public void onItemClick(int pos) {
                openDetailActivity(title,desc,date,guid,link);
            }
        });
    }
    @Override
    public int getItemCount() {
        return articles.size();
    }
    private void openDetailActivity(String...details)
    {
        Intent i=new Intent(c, DetailActivity.class);
        i.putExtra("TITLE_KEY",details[0]);
        i.putExtra("DESC_KEY",details[1]);
        i.putExtra("DATE_KEY",details[2]);
        i.putExtra("GUID_KEY",details[3]);
        i.putExtra("LINK_KEY",details[4]);
        c.startActivity(i);
    }
}


