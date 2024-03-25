package Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.example.doan_mobileapp.R;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import Adapter.BestFoodAdapter;
import Adapter.CategoryAdapter;
import model.Category;
import model.SanPham;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    Toolbar toolbar;
    RecyclerView rvBestsell,rvCate;
    NavigationView navigationView;
    DrawerLayout drawerLayout;
    ViewFlipper viewFlipper;
    BestFoodAdapter bestFoodAdapter;
    CategoryAdapter categoryAdapter;
    ImageView searchBtn;
    FirebaseDatabase db=FirebaseDatabase.getInstance();
    EditText editSearch;
    FirebaseAuth mAuth = FirebaseAuth.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControl();
        addEvent();
        ActionViewFlipper();
        //onBackPressed();
        initBestfood();
        initCategory();
        setVariable();
    }
    private void addControl() {
        toolbar = findViewById(R.id.toolbar);
        rvBestsell =findViewById(R.id.rvBestsell);
        rvCate =findViewById(R.id.rvCate);
        navigationView = findViewById(R.id.navigationview);
        viewFlipper = findViewById(R.id.viewflipper);
        drawerLayout = findViewById(R.id.drawerlayout);
        searchBtn = findViewById(R.id.searchBtn);
        editSearch = findViewById(R.id.editSearch);
    }
    private void addEvent() {
        navigationView.bringToFront();
        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
    }
    private void ActionViewFlipper() {
        ArrayList<String> mangquangcao = new ArrayList<>();
        mangquangcao.add("https://firebasestorage.googleapis.com/v0/b/doanmobile-db.appspot.com/o/banner1.jpg?alt=media&token=dbcc1357-da9c-4171-a2bc-6d59f250a425");
        mangquangcao.add("https://firebasestorage.googleapis.com/v0/b/doanmobile-db.appspot.com/o/banner3.jpg?alt=media&token=ef8cf400-9446-47b4-a0a8-07e223e9776d");
        mangquangcao.add("https://firebasestorage.googleapis.com/v0/b/doanmobile-db.appspot.com/o/banner2.jpg?alt=media&token=2ceda759-236f-4981-ad10-9eba80517769");
        for(int i =0; i< mangquangcao.size();i++){
            ImageView imageView = new ImageView(getApplicationContext());
            Picasso.get().load(mangquangcao.get(i)).into(imageView);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            viewFlipper.addView(imageView);
        }
        viewFlipper.setFlipInterval(3000);
        viewFlipper.setAutoStart(true);
        Animation animation_slide_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_in_right);
        Animation animation_slide_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_out_right);
        viewFlipper.setInAnimation(animation_slide_in);
        viewFlipper.setOutAnimation(animation_slide_out);
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.navHome){
            Toast.makeText(this,"Bạn đang ở trang chính",Toast.LENGTH_SHORT).show();
        }
        else if (item.getItemId()==R.id.navCart){
            Intent it = new Intent(MainActivity.this, GioHangActivity.class);
            startActivity(it);
        }
        else if (item.getItemId()==R.id.navUser){
            Intent it = new Intent(MainActivity.this, NguoidungActivity.class);
            startActivity(it);
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
    public void onBackPressed(){
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else{
            super.onBackPressed();
        }
    }
    private void setVariable() {
        searchBtn.setOnClickListener(v -> {
            String text= editSearch.getText().toString().trim();
            if(!text.isEmpty()){
                Intent it = new Intent(MainActivity.this, DanhMucActivity.class);
                it.putExtra("txt",text);
                it.putExtra("isSearch",true);
                startActivity(it);
            }
        });
        
    }
    private void initBestfood() {
        DatabaseReference myRef = db.getReference("SanPham");
        ArrayList<SanPham> list = new ArrayList<>();
        Query qr = myRef.orderByChild("bestfood").equalTo(true);
        qr.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()){
                    for(DataSnapshot issue : snapshot.getChildren()){
                        list.add(issue.getValue(SanPham.class));
                    }
                    if (list.size() >0){
                        bestFoodAdapter = new BestFoodAdapter(list);
                        rvBestsell.setLayoutManager(new LinearLayoutManager(MainActivity.this,LinearLayoutManager.VERTICAL,false));
                        rvBestsell.setAdapter(bestFoodAdapter);
                    }
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {}
        });
    }
    private void initCategory() {
        DatabaseReference myRef = db.getReference("Category");
        ArrayList<Category> listCa = new ArrayList<>();
        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()){
                    for(DataSnapshot issue : snapshot.getChildren()){
                        listCa.add(issue.getValue(Category.class));
                    }
                    if (listCa.size() >0){
                        categoryAdapter = new CategoryAdapter(listCa);
                        rvCate.setLayoutManager(new GridLayoutManager(MainActivity.this,4));
                        rvCate.setAdapter(categoryAdapter);
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    /*@Override
    protected void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            Toast.makeText(this,"Bạn đã đăng nhập thành công",Toast.LENGTH_SHORT).show();
        } else {
            Intent it = new Intent(MainActivity.this, DangNhapActivity.class);
            startActivity(it);
        }
    }*/
}