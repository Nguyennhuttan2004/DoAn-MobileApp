package Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.doan_mobileapp.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;

import Adapter.DanhMucAdapter;
import model.SanPham;

public class DanhMucActivity extends AppCompatActivity {
    RecyclerView rvDanhmuc= findViewById(R.id.rvDanhmuc);
    int CategoryID;
    String CategoryTen,searchTxt;
    boolean isSearch;
    Toolbar tbDM= findViewById(R.id.toolbarDM);
    FirebaseDatabase db= FirebaseDatabase.getInstance();
    DanhMucAdapter danhMucAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danh_muc);

        ToolbarBack();
        getIntentExtra();
        initDanhmuc();
    }
    private void ToolbarBack() {
        setSupportActionBar(tbDM);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    private void getIntentExtra() {
        CategoryID=getIntent().getIntExtra("CategoryID",0);
        CategoryTen=getIntent().getStringExtra("CategoryTen");

        //tbDM.setTitle("");
        searchTxt=getIntent().getStringExtra("txt");
        isSearch=getIntent().getBooleanExtra("isSearch",false);
    }
    private void initDanhmuc() {
        DatabaseReference myRef = db.getReference("SanPham");
        ArrayList<SanPham> list = new ArrayList<>();

        Query qr;
        if(isSearch){
            qr=myRef.orderByChild("ten").startAt(searchTxt).endAt(searchTxt+'\uf88f');
        }else{
            qr=myRef.orderByChild("styleID").equalTo(CategoryID);
            //tbDM.setTitle(categoryTen);
        }
        qr.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    for(DataSnapshot issue : snapshot.getChildren()){
                        list.add(issue.getValue(SanPham.class));
                    }
                    if(list.size()>0){
                        danhMucAdapter = new DanhMucAdapter(list);
                        rvDanhmuc.setLayoutManager(new GridLayoutManager(DanhMucActivity.this,2));
                        rvDanhmuc.setAdapter(danhMucAdapter);
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }


}