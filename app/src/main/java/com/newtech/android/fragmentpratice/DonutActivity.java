package com.newtech.android.fragmentpratice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

public class DonutActivity extends AppCompatActivity {
    DonutFragment mDonutFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donut);
        mDonutFragment = DonutFragment.newInstance(getIntent().getIntExtra("donutId",0));
        getSupportFragmentManager()
                .beginTransaction().add(R.id.frgDonut,mDonutFragment)
                .commit();
    }
}