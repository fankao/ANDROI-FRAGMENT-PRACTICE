package com.newtech.android.fragmentpratice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.newtech.android.fragmentpratice.model.CartItem;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {
    private Context mContext;
    private List<CartItem> mCartItems;
    private ButtonClickListener mClickListener;
    public interface  ButtonClickListener{
        void onClick(View view, int pos);
    }

    public CartAdapter(Context context, List<CartItem> cartItems) {
        mContext = context;
        mCartItems = cartItems;
    }

    public void setClickListener(ButtonClickListener clickListener) {
        mClickListener = clickListener;
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_cart,parent,false);
        return new CartViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {
        holder.bind(mCartItems.get(position));
    }

    @Override
    public int getItemCount() {
        return mCartItems.size();
    }

    public class CartViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView imageDonut;
        TextView txtName,txtPrice,txtQuantity;
        ImageButton btnIncre, btnDecre;
        public CartViewHolder(@NonNull View itemView) {
            super(itemView);
            imageDonut = itemView.findViewById(R.id.imageDonut);
            txtName = itemView.findViewById(R.id.txtName);
            txtQuantity = itemView.findViewById(R.id.txtQuantity);
            txtPrice = itemView.findViewById(R.id.txtPrice);
            btnDecre = itemView.findViewById(R.id.btnDecre);
            btnIncre = itemView.findViewById(R.id.btnIncre);

            btnDecre.setOnClickListener(this);
            btnIncre.setOnClickListener(this);

        }

        public void bind(CartItem item){
            imageDonut.setImageResource(item.getDonut().getImage());
            txtName.setText(item.getDonut().getName());
            txtQuantity.setText(item.getQuantity()+"");
            txtPrice.setText(item.getDonut().getPrice()+"");
        }

        @Override
        public void onClick(View v) {
            mClickListener.onClick(itemView,getAdapterPosition());
        }
    }
}
