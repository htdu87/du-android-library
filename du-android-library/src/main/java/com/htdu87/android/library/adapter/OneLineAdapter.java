package com.htdu87.android.library.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.htdu87.android.library.R;
import com.htdu87.android.library.event.ListEvents;
import com.htdu87.android.library.model.OneLineItem;

import java.util.List;

public class OneLineAdapter extends RecyclerView.Adapter<OneLineAdapter.OneLineViewHolder> implements View.OnClickListener {
    private LayoutInflater inflater;
    private List data;
    private ListEvents events;

    public OneLineAdapter(Context c, List data) {
        this.data = data;
        inflater=LayoutInflater.from(c);
    }

    public OneLineAdapter(Context c, List data, ListEvents events) {
        this(c,data);
        this.events = events;
    }

    public void setListEventsListener(ListEvents events) {
        this.events = events;
    }

    public void setData(List data) {
        this.data = data;
        notifyDataSetChanged();
    }

    public void addAll(List list){
        data.addAll(list);
        notifyDataSetChanged();
    }

    public void clear(){
        data.clear();
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public OneLineViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new OneLineViewHolder(inflater.inflate(R.layout.item_one_line,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull OneLineViewHolder holder, int position) {
        OneLineItem item= (OneLineItem) data.get(position);
        holder.itemView.setTag(position);
        holder.itemView.setOnClickListener(this);
        holder.text.setText(item.getLineOne());
        if (item.getIcon()!=null){
            holder.icon.setImageResource(item.getIcon());
            holder.icon.setVisibility(View.VISIBLE);
        } else {
            holder.icon.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public void onClick(View v) {
        if (events!=null){
            int pos=(Integer) v.getTag();
            events.onItemClick(data.get(pos),pos);
        }
    }

    /**
     *
     */
    static class OneLineViewHolder extends RecyclerView.ViewHolder {
        TextView text;
        ImageView icon;

        OneLineViewHolder(@NonNull View itemView) {
            super(itemView);
            text=itemView.findViewById(R.id.text);
            icon=itemView.findViewById(R.id.img_icon);
        }
    }
}
