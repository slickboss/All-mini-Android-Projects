package com.sleektech.dbnafrica.m_UI;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.sleektech.dbnafrica.R;

/**
 * Created by SLICKBOSS on 7/21/2017.
 */
public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    TextView titleTxt,descTxt,dateTxt;
    ItemClickListener itemClickListener;
    public MyViewHolder(View itemView) {
        super(itemView);
        titleTxt=(TextView)itemView.findViewById(R.id.titleTxt);
        descTxt=(TextView)itemView.findViewById(R.id.descTxt);
        dateTxt=(TextView)itemView.findViewById(R.id.dateTxt);
        itemView.setOnClickListener(this);
    }
    public void setItemClickListener(ItemClickListener itemClickListener)
    {
        this.itemClickListener=itemClickListener;
    }
    @Override
    public void onClick(View v) {
        this.itemClickListener.onItemClick(this.getLayoutPosition());
    }
}
