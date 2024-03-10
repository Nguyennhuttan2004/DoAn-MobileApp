package Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
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
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    Toolbar toolbar;
    RecyclerView recyclerView;
    NavigationView navigationView;
    DrawerLayout drawerLayout;
    ViewFlipper viewFlipper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhXa();
        //ActionBar();
        ActionViewFlipper();
        addEvent();
        //onBackPressed();
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
        recyclerView =findViewById(R.id.recyclerview);
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
            Intent it = new Intent(MainActivity.this, ThanhToanActivity.class);
            startActivity(it);
        }
        else if (item.getItemId()==R.id.navUser){
            Intent it = new Intent(MainActivity.this, NguoidungActivity.class);
            startActivity(it);
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

}