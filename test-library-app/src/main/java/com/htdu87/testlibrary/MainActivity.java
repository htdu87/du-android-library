package com.htdu87.testlibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.htdu87.android.library.ui.Loading;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void gotoNoActionbar(View v){
        startActivity(new Intent(this,NoActionbarActivity.class));
    }

    public void gotoFullScreen(View v){
        startActivity(new Intent(this,FullScreenActivity.class));
    }

    public void showLoading(View v){
        Loading l=new Loading(this,"Wait");
        l.show();
    }
}
