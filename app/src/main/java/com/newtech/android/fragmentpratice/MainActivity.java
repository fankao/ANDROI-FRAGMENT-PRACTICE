package com.newtech.android.fragmentpratice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity implements ListDonutFragment.CallBack{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onSelectedItem(int id) {
        Intent intent = new Intent(MainActivity.this,DonutActivity.class);
        Log.d(this.getClass().getSimpleName(),id+"");
        intent.putExtra("donutId",id);
        startActivity(intent);
    }
}