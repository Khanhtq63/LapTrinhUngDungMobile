package vn.tranquockhanh.coffeeorderingapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

import java.util.HashMap;
import java.util.Objects;

import vn.tranquockhanh.coffeeorderingapp.Model.CoffeeModel;


public class CoffeeDetailFragment extends Fragment {

    NavController navController;
    int quantity=0;
    FirebaseFirestore firebaseFirestore;
    Button add, sub, order;
    TextView coffeename, description,quantityview, orderINFO;
    ImageView imageView;
    String coffeeid, name, coffeedescription,imageURL;
    int price =0;



    int totalPrice =0;


    public CoffeeDetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_coffee_detail, container, false);
    }

    @Override
    public void onViewCreated( View view,  Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        imageView = view.findViewById(R.id.CoffeeDetailImage);
        coffeename = view.findViewById(R.id.coffeenamedetail);
        description = view.findViewById(R.id.coffeedetaildetail);
        add = view.findViewById(R.id.incrementcoffee);
        sub = view.findViewById(R.id.decrementcoffee);
        quantityview = view.findViewById(R.id.quantityDETAILnUMBER);
        firebaseFirestore = FirebaseFirestore.getInstance();
        navController = Navigation.findNavController(view);
        order = view.findViewById(R.id.orderdetail);
        orderINFO = view.findViewById(R.id.orderINFO);

        name = CoffeeDetailFragmentArgs.fromBundle(getArguments()).getCoffeename();
        coffeeid = CoffeeDetailFragmentArgs.fromBundle(getArguments()).getId();
        imageURL = CoffeeDetailFragmentArgs.fromBundle(getArguments()).getImageurl();
        coffeedescription = CoffeeDetailFragmentArgs.fromBundle(getArguments()).getDescription();
        price = CoffeeDetailFragmentArgs.fromBundle(getArguments()).getPrice();

        Glide.with(view.getContext()).load(imageURL).into(imageView);
        coffeename.setText(name+" đ "+String.valueOf(price));
        description.setText(coffeedescription);

        firebaseFirestore.collection("Coffee").document(coffeeid).addSnapshotListener(new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(DocumentSnapshot value,FirebaseFirestoreException error) {

                CoffeeModel coffeeModel = value.toObject(CoffeeModel.class);
                quantity = coffeeModel.getQuantity();
                quantityview.setText(String.valueOf(quantity));
                //Hiển thị giá tiền
                totalPrice = quantity *price;
                orderINFO.setText(String.valueOf("Tổng cộng là"+totalPrice));

                if(quantity==0){
                    firebaseFirestore.collection("Cart").document(name).delete().addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(Task<Void> task) {

                        }
                    });
                }

            }
        });



        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(quantity == 10){
                    Toast.makeText(getContext(),"Không thể đặt hàng thêm",Toast.LENGTH_SHORT).show();
                    quantityview.setText(String.valueOf(quantity));
                } else{

                    quantity++; //quantity = quantity+1;
                    quantityview.setText(String.valueOf(quantity));
                    //Hiển thị giá tiền
                    totalPrice = quantity *price;
                    orderINFO.setText(String.valueOf("Tổng cộng là"+totalPrice));

                    firebaseFirestore.collection("Coffee").document(coffeeid).update("quantity",quantity).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(Task<Void> task) {

                        }
                    });

                    

                }



            }
        });

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(quantity ==0){
                    Toast.makeText(getContext(),"Không có gì trong giỏ hàng",Toast.LENGTH_SHORT).show();
                    quantityview.setText(String.valueOf(quantity));
                    quantity = 0;
                    totalPrice =0;





                } else{
                    quantity--; //quantity = quantity-1;
                    quantityview.setText(String.valueOf(quantity));
                    //Hiển thị giá tiền
                    totalPrice = quantity *price;
                    orderINFO.setText(String.valueOf("Tổng cộng là"+totalPrice));

                    //cập nhật số lượng
                    firebaseFirestore.collection("Coffee").document(coffeeid).update("quantity",quantity).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(Task<Void> task) {



                        }
                    });

                }



            }
        });
        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(quantity==0) {

                    navController.navigate(R.id.action_coffeeDetailFragment_to_allCoffeeListFragment);
                    Toast.makeText(getContext(),"Bạn chưa đặt hàng" + name,Toast.LENGTH_SHORT).show();

                } else {
                    AddToCart();

                    CoffeeDetailFragmentDirections.ActionCoffeeDetailFragmentToAllCoffeeListFragment
                                action = CoffeeDetailFragmentDirections.actionCoffeeDetailFragmentToAllCoffeeListFragment();

                        action.setQuantity(quantity);
                        navController.navigate(action);
                        Toast.makeText(getContext(),"Bạn đã đặt hàng" + name,Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    //Tạo 1 đơn hàng mới

    private void AddToCart() {


            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("coffeename", coffeename.getText().toString()); //Chuyển dữ liệu sang String để nhận dữ liệu từ firebase
            hashMap.put("quantity",quantity);
            hashMap.put("totalprice",totalPrice);
            hashMap.put("coffeeid",coffeeid);
            hashMap.put("imageURL",imageURL);

            firebaseFirestore.collection("Cart").document(name).set(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(Task<Void> task) {




                }
            });

        }
}

