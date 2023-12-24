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

// Class đại diện cho Repository trong mô hình MVVM
public class Repositoryu {

    // Firebase Firestore để tương tác với cơ sở dữ liệu
    FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();

    // Danh sách để lưu trữ đối tượng CoffeeModel
    List<CoffeeModel> coffeeModelsList = new ArrayList<>();

    // Interface để thông báo về việc nhận dữ liệu
    CoffeeList interfacecoffeelist;

    // Constructor nhận một interface để thông báo về việc nhận dữ liệu
    public Repositoryu(CoffeeList interfacecoffeelist) {
        this.interfacecoffeelist = interfacecoffeelist;
    }

    // Phương thức để lấy dữ liệu từ Firestore
    public void getCoffee(){
        // Thực hiện truy vấn đến bảng "Coffee" trong Firestore
        firebaseFirestore.collection("Coffee").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {

                // Kiểm tra xem truy vấn có thành công hay không
                if(task.isSuccessful()){
                    // Nếu thành công, xóa danh sách hiện tại
                    coffeeModelsList.clear();

                    // Duyệt qua từng DocumentSnapshot trong kết quả truy vấn
                    for (DocumentSnapshot ds: task.getResult().getDocuments()){
                        // Tạo một đối tượng CoffeeModel từ DocumentSnapshot
                        CoffeeModel coffeeModel = ds.toObject(CoffeeModel.class);

                        // Thêm đối tượng CoffeeModel vào danh sách
                        coffeeModelsList.add(coffeeModel);

                        // Thông báo về việc có dữ liệu mới thông qua interface
                        interfacecoffeelist.coffeeList(coffeeModelsList);
                    }
                }
            }
        });
    }

    // Interface để thông báo về việc nhận dữ liệu danh sách CoffeeModel
    public interface CoffeeList {
        void coffeeList(List<CoffeeModel> coffeeModels);
    }
}
