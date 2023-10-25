package vn.tranquockhanh.a63132166_thigiuaky;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class activityBai2 extends AppCompatActivity {

    ArrayList<String> dsChu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai2);
        findControl();
        dsChu = new ArrayList<String>();
        dsChu.add("A");
        dsChu.add("B");
        dsChu.add("C");
        dsChu.add("D");
        dsChu.add("E");
        dsChu.add("F");
        dsChu.add("G");
        dsChu.add("H");
        ArrayAdapter<String> adapterQG;
        adapterQG = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                dsChu
        );

        autoCHU.setAdapter(adapterQG);
        autoCHU.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String itemChon = dsChu.get(i);
                String thongBao = "Bạn chọn chữ: " + itemChon;
                Intent intent = new Intent(activityBai2.this, ThongBao.class);
                intent.putExtra("chonChu", itemChon);
                startActivity(intent);
            }
        });
    }
    public void findControl(){
        autoCHU = findViewById(R.id.CHU);
    }
    ListView autoCHU;

}