package vn.tranquockhanh.coffeeorderingapp.MVVM;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import vn.tranquockhanh.coffeeorderingapp.Model.CoffeeModel;

public class CoffeeViewModel extends ViewModel implements Repositoryu.CoffeeList {

    MutableLiveData<List<CoffeeModel>> mutableLiveData = new MutableLiveData<List<CoffeeModel>>();
    Repositoryu repositoryu = new Repositoryu(this);


    public CoffeeViewModel()
    {
        repositoryu.getCoffee();
    }

    public LiveData<List<CoffeeModel>> getCoffeeList(){
        return mutableLiveData;
    }

    @Override
    public void coffeeList(List<CoffeeModel> coffeeModels) {
        mutableLiveData.setValue(coffeeModels);
    }
}
