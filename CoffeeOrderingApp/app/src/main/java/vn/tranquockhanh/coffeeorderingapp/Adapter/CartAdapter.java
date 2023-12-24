package vn.tranquockhanh.coffeeorderingapp.Adapter;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import com.bumptech.glide.Glide;

import java.util.List;

import vn.tranquockhanh.coffeeorderingapp.Model.CartModel;
import vn.tranquockhanh.coffeeorderingapp.R;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartHolder> {

    List<CartModel> cartModellist;


    @Override
    public CartHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cartlistlayout,parent,false);
        return new CartHolder(view);
    }

    @Override
    public void onBindViewHolder(CartAdapter.CartHolder holder, int position) {

        Glide.with(holder.itemView.getContext()).load(cartModellist.get(position).getImageURL()).into(holder.imageOfCoffee);

        holder.price.setText("Ordered " + String.valueOf(cartModellist.get(position).getQuantity())
                + " for $" + String.valueOf(cartModellist.get(position).getTotalprice()));

        holder.name.setText(cartModellist.get(position).getCoffeename());

    }

    @Override
    public int getItemCount() {
        return cartModellist.size();
    }

    public void setCartModellist(List<CartModel> cartModellist){
        this.cartModellist = cartModellist;
    }

    class CartHolder extends ViewHolder {

        TextView name, price;
        ImageView imageOfCoffee;
        public CartHolder(View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.cartcoffeename);
            price = itemView.findViewById(R.id.orderdetail);
            imageOfCoffee = itemView.findViewById(R.id.cartImage);
        }
    }

}
