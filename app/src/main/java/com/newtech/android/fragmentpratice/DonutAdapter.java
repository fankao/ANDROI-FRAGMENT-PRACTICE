package com.newtech.android.fragmentpratice;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.newtech.android.fragmentpratice.model.DonutDTO;

import java.util.List;

public class DonutAdapter extends RecyclerView.Adapter<DonutAdapter.DonutViewHolder>{
    private Context mContext;
    private List<DonutDTO> mDonutDTOS;
    private ClickLister sClickLister;
    public interface ClickLister{
        void onClick(View view,int position);
    }

    public void setClickLister(ClickLister clickLister) {
        sClickLister = clickLister;
    }

    public DonutAdapter(Context context, List<DonutDTO> donutDTOS) {
        mContext = context;
        mDonutDTOS = donutDTOS;
    }


    @NonNull
    @Override
    public DonutViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_donut,parent,false);
        return new DonutViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DonutViewHolder holder, int position) {
        holder.bind(mDonutDTOS.get(position));
    }

    @Override
    public int getItemCount() {
        return mDonutDTOS.size();
    }

    public class DonutViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imageDonut;
        TextView txtNameDonut,txtDescDonut,txtPrice;
        public DonutViewHolder(@NonNull View itemView) {
            super(itemView);
            imageDonut = itemView.findViewById(R.id.imageDonut);
            txtNameDonut = itemView.findViewById(R.id.txtNameDonut);
            txtDescDonut = itemView.findViewById(R.id.txtDesDonut);
            txtPrice = itemView.findViewById(R.id.txtPrice);
            itemView.setOnClickListener(this);
        }

        public void bind(DonutDTO dto){
            imageDonut.setImageResource(dto.getImage());
            txtNameDonut.setText(dto.getName());
            txtDescDonut.setText(dto.getShortDesc());
            txtPrice.setText(itemView.getResources().getString(R.string.price_donut,dto.getPrice()+""));
        }

        @Override
        public void onClick(View v) {
            sClickLister.onClick(v,getAdapterPosition());
        }
    }
}
