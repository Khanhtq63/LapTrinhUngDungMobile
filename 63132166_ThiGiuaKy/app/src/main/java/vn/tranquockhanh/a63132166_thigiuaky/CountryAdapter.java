package vn.tranquockhanh.a63132166_thigiuaky;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class CountryAdapter extends BaseAdapter {
    //
    private ArrayList<Country> dsQuocGia; //Nguồn dữ liệu
    private Context context;
    private LayoutInflater inflater;// XML <--> JAVA

    public CountryAdapter(ArrayList<Country> dsQuocGia, Context context) {
        this.dsQuocGia = dsQuocGia;
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }
    //
    class ControlHoler{// tương ứng với file item layout
        ImageView imageViewFlag;
        TextView textViewName;
        TextView textViewPopulation;
    }

    @Override
    public int getCount() {
        return dsQuocGia.size();
    }

    @Override
    public Object getItem(int i) {
        return dsQuocGia.get(i);
    }

    @Override
    public long getItemId(int i) {// Chưa đựng đến
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        //get Item's View for setting data
        ControlHoler itemControlHoler; // stores refs to XML
        if(view == null) {// inflate from layout item XML
            view=inflater.inflate(R.layout.activity_file_layout,null);
            //set refs for controls
            itemControlHoler = new ControlHoler();
            itemControlHoler.imageViewFlag=view.findViewById(R.id.imageView);
            itemControlHoler.textViewName=view.findViewById(R.id.textViewNationName);
            itemControlHoler.textViewPopulation=view.findViewById(R.id.textView2);
            view.setTag(itemControlHoler);

        }
        else{
            itemControlHoler = (ControlHoler)view.getTag();
        }
        //set data
        Country nationI = dsQuocGia.get(i);
        itemControlHoler.textViewName.setText(nationI.getCountryName());
        itemControlHoler.textViewPopulation.setText("Population"+nationI.getPopulation());
        int resImageID = context.getResources().getIdentifier(
                nationI.getCountryFlag(),"mipmap",
                context.getPackageName());
        itemControlHoler.imageViewFlag.setImageResource(resImageID);

        final Country nationII = dsQuocGia.get(i);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Chuyển đến CountryDetailActivity khi người dùng bấm vào một quốc gia
                Intent intent = new Intent(context, CustomitemActivity.class);
                intent.putExtra("countryName", nationII.getCountryName());
                intent.putExtra("population", nationII.getPopulation());
                intent.putExtra("countryFlag", nationII.getCountryFlag());
                context.startActivity(intent);
            }
        });
        return view;

    }
}
