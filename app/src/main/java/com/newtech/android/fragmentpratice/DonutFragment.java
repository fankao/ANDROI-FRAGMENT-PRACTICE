package com.newtech.android.fragmentpratice;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.newtech.android.fragmentpratice.model.DonutDTO;
import com.newtech.android.fragmentpratice.model.DonutLab;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DonutFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DonutFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    private static final String ARG_PARAM1 = "donutId";
    private int donutId;

    ImageView imageDonut;
    TextView txtNameDonut, txtDescDonut, txtPrice, txtRestaurantInfo;
    ImageButton btnDecre,btnIncre;

    public DonutFragment() {
        // Required empty public constructor
    }

    public static DonutFragment newInstance(int donutId) {
        DonutFragment fragment = new DonutFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, donutId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            donutId = getArguments().getInt(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_donut, container, false);
        imageDonut = view.findViewById(R.id.imageDonut);
        txtNameDonut = view.findViewById(R.id.txtNameDonut);
        txtDescDonut = view.findViewById(R.id.txtDescDonut);
        txtPrice = view.findViewById(R.id.txtPrice);
        txtRestaurantInfo = view.findViewById(R.id.txtRestaurantInfo);
        DonutDTO donut = DonutLab.getInstance(getActivity()).getDonut(donutId);
        showDonutInfo(view, donut);
        return view;
    }

    private void showDonutInfo(View view, DonutDTO donut) {
        if(donut!=null){
            imageDonut.setImageResource(donut.getImage());
            txtNameDonut.setText(donut.getName());
            txtDescDonut.setText(donut.getShortDesc());
            txtPrice.setText(view.getResources().getString(R.string.price_donut,donut.getPrice()+""));
            txtRestaurantInfo.setText(donut.getRestaurantInfo());
        }
    }
}