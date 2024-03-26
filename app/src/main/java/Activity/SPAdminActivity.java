package Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doan_mobileapp.R;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import Adapter.BestFoodAdapter;
import Adapter.CategoryAdapter;
import Adapter.SanPhamAdapter;
import model.SanPham;

public class SPAdminActivity extends AppCompatActivity {
    Toolbar tbspadmin;
    RecyclerView rvSPadmin;
    SanPhamAdapter sanPhamAdapter;
    FirebaseDatabase db=FirebaseDatabase.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spadmin);
        ToolbarBack();
        addControl();
        addEvent();
        initFood();
    }

    private void addEvent() {
    }

    private void initFood() {
        DatabaseReference myRef = db.getReference("SanPham");
        ArrayList<SanPham> list = new ArrayList<>();
        Query qr = myRef.orderByChild("id");
        qr.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()){
                    for(DataSnapshot issue : snapshot.getChildren()){
                        list.add(issue.getValue(SanPham.class));
                    }
                    if (list.size() >0){
                        sanPhamAdapter = new SanPhamAdapter(list);
                        rvSPadmin.setLayoutManager(new LinearLayoutManager(SPAdminActivity.this,LinearLayoutManager.VERTICAL,false));
                        rvSPadmin.setAdapter(sanPhamAdapter);
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void ToolbarBack() {
        tbspadmin=findViewById(R.id.tbspadmin);
        setSupportActionBar(tbspadmin);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }
    private void addControl() {
        rvSPadmin =findViewById(R.id.rvSPadmin);
    }
}