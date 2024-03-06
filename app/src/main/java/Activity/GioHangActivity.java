package Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.doan_mobileapp.R;

import java.util.ArrayList;

import Activity.adapter.GioHangAdapter;
import Activity.model.GioHang;

public class GioHangActivity extends AppCompatActivity {
    RecyclerView recyclerviewgiohang;
    GioHangAdapter giohangAdapter;
    ArrayList<GioHang> arr_giohang;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gio_hang);
        addControls();
        loadData();
    }
    private void loadData() {
        arr_giohang.add(new GioHang("Gà rán",50000,3,R.drawable.ga_ran_sot));
        arr_giohang.add(new GioHang("Gà gaf",50000,3,R.drawable.ga_ran_sot));
    }

    private void addControls() {
        recyclerviewgiohang=findViewById(R.id.recyclerviewgiohang);
        recyclerviewgiohang.setLayoutManager(new LinearLayoutManager(this));

        arr_giohang=new ArrayList<>();

        giohangAdapter=new GioHangAdapter(this,arr_giohang);
        recyclerviewgiohang.setAdapter(giohangAdapter);
    }
}