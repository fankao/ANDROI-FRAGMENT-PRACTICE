package com.newtech.android.fragmentpratice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.newtech.android.fragmentpratice.model.CartItem;
import com.newtech.android.fragmentpratice.model.CartLab;

import org.w3c.dom.Text;

import java.util.List;

public class CartActivity extends AppCompatActivity {
    RecyclerView recyclerCart;
    List<CartItem> mCartItems;
    CartAdapter mCartAdapter;
    TextView txtSubtotal,txtTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        recyclerCart = findViewById(R.id.recyclerCart);
        recyclerCart.setLayoutManager(new LinearLayoutManager(this));
        mCartItems = CartLab.getInstance(this).getCarts();
        mCartAdapter = new CartAdapter(this,mCartItems);
        recyclerCart.setAdapter(mCartAdapter);

        txtSubtotal = findViewById(R.id.txtSubTotal);
        txtSubtotal.setText("$"+ CartLab.getInstance(this).getSubTotal());
    }
}