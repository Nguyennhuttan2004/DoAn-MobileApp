package Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doan_mobileapp.R;

import Adapter.CartAdapter;
import Helper.ChangeNumberItemsListener;
import Helper.ManagmentGiohang;

public class GioHangActivity extends AppCompatActivity {
    Toolbar tbGiohang;
    TextView txtTotalFee,txtDelivery,txtTotal,txtEmpty;
    Button btntt;
    RecyclerView rvGiohang;
    ScrollView scrollViewGH;
    private RecyclerView.Adapter adapter;
    private ManagmentGiohang managmentGiohang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gio_hang);

        managmentGiohang=new ManagmentGiohang(this);
        addControls();
        ToolbarBack();

        setVariable();
        calculateCart();
        initList();
        addEvent();
    }

    private void addEvent() {
        btntt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoTT();
            }
        });
    }

    private void gotoTT() {
        Intent it = new Intent(GioHangActivity.this, ThanhToanActivity.class);
        startActivity(it);
    }

    private void initList() {
        if(managmentGiohang.getListCart().isEmpty()){
            txtEmpty.setVisibility(View.VISIBLE);
            scrollViewGH.setVisibility(View.GONE);
        }
        else {
            txtEmpty.setVisibility(View.GONE);
            scrollViewGH.setVisibility(View.VISIBLE);
        }

        rvGiohang.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        adapter= new CartAdapter(managmentGiohang.getListCart(), this, new ChangeNumberItemsListener() {
            @Override
            public void change() {
                calculateCart();
            }
        });
        rvGiohang.setAdapter(adapter);
    }
    private void calculateCart() {
        double delivery=10;

        double total= Math.round((managmentGiohang.getTotalFee()+delivery)*100)/100;
        double itemTotal=Math.round(managmentGiohang.getTotalFee()*100)/100;

        txtTotalFee.setText(itemTotal+"đ");
        txtDelivery.setText(delivery+"đ");
        txtTotal.setText(total+"đ");
    }
    private void ToolbarBack() {
        tbGiohang=findViewById(R.id.tbGiohang);
        setSupportActionBar(tbGiohang);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    private void setVariable() {

    }
    private void addControls() {
        txtTotalFee=findViewById(R.id.txtTotalFee);
        txtDelivery=findViewById(R.id.txtDelivery);
        txtTotal=findViewById(R.id.txtTotal);
        txtEmpty=findViewById(R.id.txtEmpty);
        btntt=findViewById(R.id.btntt);
        rvGiohang=findViewById(R.id.rvGiohang);
        scrollViewGH=findViewById(R.id.scrollViewGH);
    }
}