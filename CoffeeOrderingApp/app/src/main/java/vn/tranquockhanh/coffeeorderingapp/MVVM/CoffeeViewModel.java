// Import các thư viện và packages cần thiết
package vn.tranquockhanh.coffeeorderingapp.MVVM;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import vn.tranquockhanh.coffeeorderingapp.Model.CoffeeModel;

// Lớp ViewModel trong mô hình MVVM, được sử dụng để giữ và quản lý dữ liệu liên quan đến giao diện người dùng
public class CoffeeViewModel extends ViewModel implements Repositoryu.CoffeeList {

    // MutableLiveData để giữ danh sách CoffeeModel và thông báo về sự thay đổi
    MutableLiveData<List<CoffeeModel>> mutableLiveData = new MutableLiveData<List<CoffeeModel>>();

    // Đối tượng Repositoryu để tương tác với dữ liệu từ Firebase
    Repositoryu repositoryu = new Repositoryu(this);

    // Constructor, được gọi khi ViewModel được tạo
    public CoffeeViewModel()
    {
        // Gọi phương thức để lấy dữ liệu từ Firebase Firestore ngay khi ViewModel được khởi tạo
        repositoryu.getCoffee();
    }

    // Phương thức trả về LiveData của danh sách CoffeeModel để quan sát sự thay đổi
    public LiveData<List<CoffeeModel>> getCoffeeList(){
        return mutableLiveData;
    }

    // Phương thức được gọi khi dữ liệu từ Firebase đã sẵn sàng
    @Override
    public void coffeeList(List<CoffeeModel> coffeeModels) {
        // Cập nhật giá trị của MutableLiveData để thông báo về sự thay đổi
        mutableLiveData.setValue(coffeeModels);
    }
}
