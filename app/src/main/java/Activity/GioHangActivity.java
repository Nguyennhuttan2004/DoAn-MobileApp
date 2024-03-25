package Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
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
    TextView txtTotalFee,txtTax,txtDelivery,txtTotal,txtEmpty;
    Button btntt;
    RecyclerView rvGiohang;
    ScrollView scrollViewGH;

    private RecyclerView.Adapter adapter;
    private ManagmentGiohang managmentGiohang;
    private double tax;

    Toolbar tb=findViewById(R.id.tbGiohang);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gio_hang);

        tbGiohang=findViewById(R.id.tbGiohang);
        setSupportActionBar(tbGiohang);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        managmentGiohang=new ManagmentGiohang(this);
        addControls();
        ToolbarBack();

        setVariable();
        calculateCart();
        initList();
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

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        rvGiohang.setLayoutManager(linearLayoutManager);
        adapter= new CartAdapter(managmentGiohang.getListCart(), this, new ChangeNumberItemsListener() {
            @Override
            public void change() {
                calculateCart();
            }
        });
        rvGiohang.setAdapter(adapter);
    }


    private void calculateCart() {
        double percentTax=0.02;
        double delivery=10;

        tax=Math.round(managmentGiohang.getTotalFee()*percentTax*100.0)/100;

        double total= Math.round((managmentGiohang.getTotalFee()+tax+delivery)*100)/100;
        double itemTotal=Math.round(managmentGiohang.getTotalFee()*100)/100;

        txtTotalFee.setText(itemTotal+"đ");
        txtTax.setText(tax+"đ");
        txtDelivery.setText(delivery+"đ");
        txtTotal.setText(total+"đ");
    }


    private void ToolbarBack() {
        setSupportActionBar(tbGiohang);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void setVariable() {

    }
    private void addControls() {
        txtTotalFee=findViewById(R.id.txtTotalFee);
        txtTax=findViewById(R.id.txtTax);
        txtDelivery=findViewById(R.id.txtDelivery);
        txtTotal=findViewById(R.id.txtTotal);
        txtEmpty=findViewById(R.id.txtEmpty);
        btntt=findViewById(R.id.btntt);
        rvGiohang=findViewById(R.id.rvGiohang);
        scrollViewGH=findViewById(R.id.scrollViewGH);
        tbGiohang=findViewById(R.id.tbGiohang);
    }
}