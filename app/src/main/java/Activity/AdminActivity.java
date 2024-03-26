package Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.doan_mobileapp.R;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

import Activity.interfaceTT.IClickItemAM;
import Activity.interfaceTT.IClickItemTT;
import Adapter.AdminAdapter;
import Adapter.ThanhToanAdapter;
import model.Admin;
import model.ThanhToan;

public class AdminActivity extends AppCompatActivity {
    //Toolbar toolbar;
    RecyclerView recycAdmin;
    AdminAdapter adminAdapter;
    ArrayList<Admin> arrAM;
    Toolbar tbAdmin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        addControl();
        loadData();
        ToolbarBack();
    }
    private void loadData() {
        arrAM.add(new Admin(1,"Sản phẩm",R.drawable.icon_google));
        arrAM.add(new Admin(2,"Tài khoản",R.drawable.icon_google));
        arrAM.add(new Admin(3,"Đơn hàng",R.drawable.icon_google));
    }
    private void addControl() {
        recycAdmin=findViewById(R.id.recycAdmin);
        recycAdmin.setLayoutManager(new LinearLayoutManager(this));
        //RecyclerView.ItemDecoration itemDecoration=new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
        //recycThanhtoan.addItemDecoration(itemDecoration);
        arrAM=new ArrayList<>();
        adminAdapter = new AdminAdapter(this, arrAM, new IClickItemAM() {
            @Override
            public void onClickItemAM(Admin am) {
                onClickGoToAM(am);
            }
        });

        recycAdmin.setAdapter(adminAdapter);

        //tb = findViewById(R.id.tbthanhtoan);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void onClickGoToAM(Admin am) {
        if (am.getId()==1)
        {
            Intent it = new Intent(this, SPAdminActivity.class);
            startActivity(it);
        }
        else if (am.getId()==2)
        {
            Intent it = new Intent(this, SPAdminActivity.class);
            startActivity(it);
        }
        else {
            Intent it = new Intent(this, SPAdminActivity.class);
            startActivity(it);
        }
    }

    private void onClickGoToTT(ThanhToan tt) {
        if (tt.getPtid()==1)
        {
            Intent it = new Intent(this, NhapTheActivity.class);
            startActivity(it);
        }
        else
        {
            Intent it = new Intent(this, NhapDiaChiActivity.class);
            startActivity(it);
        }
    }
    private void ToolbarBack() {
        tbAdmin=findViewById(R.id.tbAdmin);
        setSupportActionBar(tbAdmin);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}