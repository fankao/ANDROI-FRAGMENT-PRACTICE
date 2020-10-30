package com.newtech.android.fragmentpratice;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.newtech.android.fragmentpratice.model.DonutDTO;
import com.newtech.android.fragmentpratice.model.DonutLab;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ListDonutFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListDonutFragment extends Fragment {
    RecyclerView recyclerDonut;
    DonutAdapter mDonutAdapter;
    List<DonutDTO> mDonutDTOS;

    private CallBack mCallBack;

    public interface CallBack {
        void onSelectedItem(int id);
    }

    public ListDonutFragment() {
    }

    public static ListDonutFragment newInstance() {
        ListDonutFragment fragment = new ListDonutFragment();
        return fragment;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mCallBack = (CallBack) context;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDonutDTOS = DonutLab.getInstance(getActivity()).getDonutDTOS();
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_donut, container, false);
        recyclerDonut = view.findViewById(R.id.recyclerDonut);
        recyclerDonut.setLayoutManager(new LinearLayoutManager(getActivity()));
        mDonutAdapter = new DonutAdapter(getActivity(), mDonutDTOS);
        recyclerDonut.setAdapter(mDonutAdapter);
        mDonutAdapter.setClickLister(new DonutAdapter.ClickLister() {
            @Override
            public void onClick(View view, int position) {
                Log.d(this.getClass().getSimpleName(), "Donut: " + mDonutDTOS.size());
                mCallBack.onSelectedItem(mDonutDTOS.get(position).getId());
            }
        });

        return view;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mCallBack = null;
    }
}