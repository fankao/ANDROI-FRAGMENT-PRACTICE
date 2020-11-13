package com.newtech.android.fragmentpratice.model;

import android.content.Context;

import com.newtech.android.fragmentpratice.model.CartItem;

import java.util.ArrayList;
import java.util.List;

public class CartLab {
    private static CartLab INSTANCE = null;
    private Context mContext;
    private List<CartItem> carts;

    private CartLab(Context context) {
        mContext = context.getApplicationContext();
        carts = new ArrayList<>();
    }

    public static CartLab getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = new CartLab(context);
        }
        return INSTANCE;
    }

    public List<CartItem> getCarts() {
        return carts;
    }

    public double getSubTotal() {
        double total = 0;
        for (CartItem cart : carts) {
            total += cart.calcPrice();
        }
        return total;
    }

    public void addItem(CartItem item) {
        for (CartItem cart : carts) {
            if (cart.getDonut().getId() == item.getDonut().getId()) {
                int index = carts.indexOf(cart);
                item.setQuantity(cart.getQuantity() + 1);
                carts.remove(index);
                carts.add(index, item);
                return;
            }
        }
        carts.add(item);
    }
}
