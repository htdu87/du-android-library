package com.htdu87.testlibrary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.htdu87.android.library.adapter.MenuAdapter;
import com.htdu87.android.library.event.ListEvents;
import com.htdu87.android.library.model.MenuItem;

import java.util.ArrayList;

public class NoActionbarActivity extends AppCompatActivity implements MenuAdapter.MenuAdapterEvents {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        MenuAdapter adapter=new MenuAdapter(new ArrayList<MenuItem>(),this,this,R.color.colorPrimaryDark,R.drawable.ic_edit_black_24dp);
        adapter.add(new com.htdu87.android.library.model.MenuItem(1,"Điều trị"));
        adapter.add(new com.htdu87.android.library.model.MenuItem(2,"Khách hàng"));

        RecyclerView recyclerView=findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new GridLayoutManager(this,3));
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onMenuItemClick(MenuItem item) {

    }
}
