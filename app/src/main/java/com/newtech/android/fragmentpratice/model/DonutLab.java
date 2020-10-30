package com.newtech.android.fragmentpratice.model;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import com.newtech.android.fragmentpratice.R;

import java.util.ArrayList;
import java.util.List;

public class DonutLab {
    private static DonutLab INSTANCE = null;
    private Context mContext;
    private List<DonutDTO> mDonutDTOS;

    private DonutLab(Context context) {
        mContext = context.getApplicationContext();
        mDonutDTOS = new ArrayList<>();
    }


    public static DonutLab getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = new DonutLab(context);
        }
        return INSTANCE;
    }


    public List<DonutDTO> getDonutDTOS() {
        mDonutDTOS.add(new DonutDTO(1, "Tasty Donut", "Spicy tasty donut family", "\n" +
                "Order a Large Pizza but the size is the equivalent of a medium/small " +
                "from other places at the same price range.",
                10.0, R.drawable.donut_yellow));
        mDonutDTOS.add(new DonutDTO(2, "Pink Donut", "Spicy tasty donut family", "\n" +
                "Order a Large Pizza but the size is the equivalent of a medium/small " +
                "from other places at the same price range.",
                20.0, R.drawable.donut_red));
        mDonutDTOS.add(new DonutDTO(3, "Floating Donut", "Spicy tasty donut family", "\n" +
                "Order a Large Pizza but the size is the equivalent of a medium/small " +
                "from other places at the same price range.", 30.0, R.drawable.green_donut));

        Log.d(this.getClass().getSimpleName(),"Donut sizes: "+mDonutDTOS.size());
        return mDonutDTOS;
    }

    public DonutDTO getDonut(final int id) {
        for (DonutDTO item : mDonutDTOS) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public List<DonutDTO> getDonutByNameContaining(final String keyword){
        List<DonutDTO> donutsSearched = new ArrayList<>();
        for (DonutDTO item : mDonutDTOS) {
            if(item.getName().trim().toLowerCase().contains(keyword)){
                donutsSearched.add(item);
            }
        }
        return donutsSearched;
    }

}
