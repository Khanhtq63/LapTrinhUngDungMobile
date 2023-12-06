package vn.tranquockhanh.coffeeorderingapp.MVVM;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

import vn.tranquockhanh.coffeeorderingapp.Model.CoffeeModel;

public class Repositoryu {

    FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
    List<CoffeeModel> coffeeModelsList = new ArrayList<>();

    CoffeeList interfacecoffeelist;

    public Repositoryu(CoffeeList interfacecoffeelist) {
        this.interfacecoffeelist = interfacecoffeelist;
    }

    public void getCoffee(){
        firebaseFirestore.collection("Coffee").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {

                if(task.isSuccessful()){
                    coffeeModelsList.clear();
                    for (DocumentSnapshot ds: task.getResult().getDocuments()){
                        CoffeeModel coffeeModel = ds.toObject(CoffeeModel.class);
                        coffeeModelsList.add(coffeeModel);
                        interfacecoffeelist.coffeeList(coffeeModelsList);
                    }
                }

            }
        });
    }

    public interface CoffeeList {
        void coffeeList(List<CoffeeModel>coffeeModels);
    }
}
