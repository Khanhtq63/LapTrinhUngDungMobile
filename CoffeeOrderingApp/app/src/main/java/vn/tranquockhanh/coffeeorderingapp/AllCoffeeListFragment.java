package vn.tranquockhanh.coffeeorderingapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

import vn.tranquockhanh.coffeeorderingapp.Adapter.CoffeeAdapter;
import vn.tranquockhanh.coffeeorderingapp.MVVM.CoffeeViewModel;
import vn.tranquockhanh.coffeeorderingapp.Model.CoffeeModel;


public class AllCoffeeListFragment extends Fragment {

    FirebaseFirestore firebaseFirestore;
    CoffeeAdapter adapter;
    RecyclerView recyclerView;
    CoffeeViewModel viewModel;

    public AllCoffeeListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_all_coffee_list, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.recViewAll);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new CoffeeAdapter();
        viewModel = new ViewModelProvider(getActivity()).get(CoffeeViewModel.class);
        viewModel.getCoffeeList().observe(getViewLifecycleOwner(), new Observer<List<CoffeeModel>>(){
            @Override
            public void onChanged(List<CoffeeModel>coffeeModels){
                    adapter.setCoffeeModelList(coffeeModels);
                    recyclerView.setAdapter(adapter);
            }
        });

    }


}