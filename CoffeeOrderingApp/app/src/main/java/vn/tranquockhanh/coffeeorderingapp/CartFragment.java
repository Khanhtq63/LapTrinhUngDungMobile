package vn.tranquockhanh.coffeeorderingapp;

import static android.app.ProgressDialog.show;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

import vn.tranquockhanh.coffeeorderingapp.Adapter.CartAdapter;
import vn.tranquockhanh.coffeeorderingapp.Model.CartModel;


public class CartFragment extends Fragment {

    CartAdapter mAdapter;
    RecyclerView recyclerView;
    FirebaseFirestore firestore;
    Button orderbutton;
    TextView orderSummary;
    NavController navController;
    List<CartModel> cartModelList = new ArrayList<>();
    int totalOrderCost = 0;
    List<Integer> saveTotalCost = new ArrayList<>();

    public CartFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cart, container, false);
    }

    @Override
    public void onViewCreated(View view,Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        orderbutton = view.findViewById(R.id.orderNow);
        navController = Navigation.findNavController(view);
        firestore = FirebaseFirestore.getInstance();
        mAdapter = new CartAdapter();
        recyclerView = view.findViewById(R.id.cartRecView);

        orderSummary = view.findViewById(R.id.orderNow);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        firestore.collection("Cart").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(Task<QuerySnapshot> task) {

                cartModelList.clear();

                if(task.isSuccessful()){
                    for(DocumentSnapshot ds: task.getResult().getDocuments()){
                        CartModel cartModel = ds.toObject(CartModel.class);
                        cartModelList.add(cartModel);

                        mAdapter.setCartModellist(cartModelList);

                        recyclerView.setAdapter(mAdapter);
                    }
                }
            }
        });

        firestore.collection("Cart").addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(QuerySnapshot value,FirebaseFirestoreException error) {

                if(value!=null){
                    for(DocumentSnapshot ds: value.getDocuments()){
                        CartModel cartModel = ds.toObject(CartModel.class);
                        int valueofallprices = cartModel.getTotalprice();
                        saveTotalCost.add(valueofallprices);
                    }

                    for(int i=0;i<saveTotalCost.size();i++){
                        totalOrderCost +=Integer.parseInt(String.valueOf(saveTotalCost.get(i)));
                    }
                    orderSummary.setText("Tổng cộng là "+String.valueOf(totalOrderCost)+" đ");
                    totalOrderCost =0;
                    saveTotalCost.clear();
                }

            }
        });

        //cart empty
        orderbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                firestore.collection("Coffee").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {

                        if(task.isSuccessful()){
                            QuerySnapshot tasks = task.getResult();
                            for(DocumentSnapshot ds: task.getResult().getDocuments()){
                                ds.getReference()
                                        .update("quantity",0);


                            }
                        }

                    }
                });

                //xóa cart
                firestore.collection("Cart").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(Task<QuerySnapshot> task) {
                        if(task.isSuccessful()){
                            QuerySnapshot tasks = task.getResult();
                            for(DocumentSnapshot ds: task.getResult().getDocuments()){
                                ds.getReference()
                                        .delete();


                            }
                        }
                    }
                });

                navController.navigate(R.id.action_cartFragment_to_allCoffeeListFragment2);
                Toast.makeText(getContext(),"Đặt hàng thành công",Toast.LENGTH_SHORT).show();


            }
        });
    }
}