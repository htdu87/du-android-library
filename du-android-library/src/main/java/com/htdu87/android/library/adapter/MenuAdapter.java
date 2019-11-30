package com.htdu87.android.library.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.htdu87.android.library.R;
import com.htdu87.android.library.model.MenuItem;

import java.util.List;


public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MenuViewHolder> implements View.OnClickListener {
    private List<MenuItem> data;
    private LayoutInflater inflater;
    private MenuAdapterEvents events;
    private Context context;
    private Integer tinColor;
    private Integer drawableId;

    public MenuAdapter(List<MenuItem> data, Context c, MenuAdapterEvents e) {
        this.data = data;
        inflater=LayoutInflater.from(c);
        events=e;
        context=c;
    }

    public MenuAdapter(List<MenuItem> data, Context c, MenuAdapterEvents e,Integer tinColor,Integer drawableId) {
        this.data = data;
        inflater=LayoutInflater.from(c);
        events=e;
        context=c;
        this.tinColor=tinColor;
        this.drawableId=drawableId;
    }

    public void add(MenuItem menuItem){
        data.add(menuItem);
    }

    @NonNull
    @Override
    public MenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MenuViewHolder(inflater.inflate(R.layout.item_menu,parent,false),
                tinColor,drawableId,context);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuViewHolder holder, int position) {
        MenuItem item=data.get(position);
        holder.lblName.setText(item.getName());

        holder.itemView.setTag(position);
        holder.itemView.setOnClickListener(this);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public void onClick(View v) {
        MenuItem item=data.get((Integer) v.getTag());
        events.onMenuItemClick(item);
    }

    /**
     *
     */
    static class MenuViewHolder extends RecyclerView.ViewHolder {
        ImageView imgIcon;
        TextView lblName;

        MenuViewHolder(@NonNull View itemView, Integer tinColor, Integer resId, Context c) {
            super(itemView);
            imgIcon=itemView.findViewById(R.id.img_icon);
            if (tinColor!=null)
                imgIcon.setColorFilter(ContextCompat.getColor(c,tinColor));
            if (resId!=null)
                imgIcon.setImageResource(resId);

            lblName=itemView.findViewById(R.id.lbl_name);
        }
    }

    /**
     *
     */
    public interface MenuAdapterEvents {
        void onMenuItemClick(MenuItem item);
    }
}
