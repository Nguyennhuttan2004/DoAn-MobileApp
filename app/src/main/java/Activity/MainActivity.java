package Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
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
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.example.doan_mobileapp.R;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import Activity.interfaceTT.IClickItemDM;
import Activity.interfaceTT.IClickItemSP;
import Activity.interfaceTT.IClickItemTT;
import Adapter.BestFoodAdapter;
import Adapter.CategoryAdapter;
import model.Category;
import model.SanPham;
import model.ThanhToan;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    Toolbar toolbar;
    RecyclerView rvBestsell,rvCate;
    NavigationView navigationView;
    DrawerLayout drawerLayout;
    ViewFlipper viewFlipper;
    FirebaseDatabase db;
    BestFoodAdapter bestFoodAdapter;
    CategoryAdapter categoryAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhXa();
        //ActionBar();
        ActionViewFlipper();
        addEvent();
        //onBackPressed();
        initBestfood();
        initCategory();
    }

    private void initBestfood() {
        db= FirebaseDatabase.getInstance();
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
                        bestFoodAdapter = new BestFoodAdapter(list, new IClickItemSP() {
                            @Override
                            public void onClickItemSP(SanPham sp) {
                                onClickGoToSP(sp);
                            }
                        });
                        rvBestsell.setLayoutManager(new LinearLayoutManager(MainActivity.this,LinearLayoutManager.VERTICAL,false));
                        rvBestsell.setAdapter(bestFoodAdapter);
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void initCategory() {
        db= FirebaseDatabase.getInstance();
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

    private void addEvent() {

        navigationView.bringToFront();
        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
    }
    public void onBackPressed(){
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else{
            super.onBackPressed();
        }
    }
    private void ActionViewFlipper() {
        ArrayList<String> mangquangcao = new ArrayList<>();
        mangquangcao.add("https://upload.wikimedia.org/wikipedia/commons/thumb/e/e8/Hatch_Green_Chile_Hamburger.jpg/1280px-Hatch_Green_Chile_Hamburger.jpg");
        mangquangcao.add("https://upload.wikimedia.org/wikipedia/commons/thumb/b/bb/Pizza_Vi%E1%BB%87t_Nam_%C4%91%E1%BA%BF_d%C3%A0y%2C_x%C3%BAc_x%C3%ADch_%28SNaT_2018%29_%287%29.jpg/440px-Pizza_Vi%E1%BB%87t_Nam_%C4%91%E1%BA%BF_d%C3%A0y%2C_x%C3%BAc_x%C3%ADch_%28SNaT_2018%29_%287%29.jpg");
        mangquangcao.add("https://upload.wikimedia.org/wikipedia/commons/0/00/Mmm..._sometimes_I_just_want_yellow_mustard._Sue_me._%285914352808%29.jpg");
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

    //private void ActionBar() {
        //setSupportActionBar(toolbar);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //toolbar.setNavigationIcon(android.R.drawable.ic_menu_sort_by_size);
        //toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            //@Override
            //public void onClick(View v) {
                //drawerLayout.openDrawer(GravityCompat.START);
            //}
        //});
    //}

    private void anhXa() {
        toolbar = findViewById(R.id.toolbar);
        rvBestsell =findViewById(R.id.rvBestsell);
        rvCate =findViewById(R.id.rvCate);
        navigationView = findViewById(R.id.navigationview);
        viewFlipper = findViewById(R.id.viewflipper);
        drawerLayout = findViewById(R.id.drawerlayout);
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
    private void onClickGoToSP(SanPham sp) {

            Intent it = new Intent(this, ChiTietActivity.class);
            startActivity(it);
    }
}