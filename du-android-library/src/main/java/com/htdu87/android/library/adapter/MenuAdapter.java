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
import com.htdu87.android.library.model.MenuItem;

import java.util.List;


public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MenuViewHolder> implements View.OnClickListener {
    private List<MenuItem> data;
    private LayoutInflater inflater;
    private MenuAdapterEvents events;

    public MenuAdapter(List<MenuItem> data, Context c, MenuAdapterEvents e) {
        this.data = data;
        inflater=LayoutInflater.from(c);
        events=e;
    }

    public void add(MenuItem menuItem){
        data.add(menuItem);
    }

    @NonNull
    @Override
    public MenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MenuViewHolder(inflater.inflate(R.layout.item_menu,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MenuViewHolder holder, int position) {
        MenuItem item=data.get(position);
        holder.lblName.setText(item.getName());
        if (item.getIcon()==null)
            holder.imgIcon.setImageDrawable(null);
        else
            holder.imgIcon.setImageResource(item.getIcon());

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

        MenuViewHolder(@NonNull View itemView) {
            super(itemView);
            imgIcon=itemView.findViewById(R.id.img_icon);
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
