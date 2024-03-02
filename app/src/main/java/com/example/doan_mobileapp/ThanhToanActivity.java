package com.example.doan_mobileapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.doan_mobileapp.adapter.ThanhToanAdapter;
import com.example.doan_mobileapp.interfaceTT.IClickItemTT;
import com.example.doan_mobileapp.model.ThanhToan;

import java.util.ArrayList;

public class ThanhToanActivity extends AppCompatActivity {
    RecyclerView recycThanhtoan;
    ThanhToanAdapter thanhtoanAdapter;
    ArrayList<ThanhToan> arrTT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thanh_toan);
        addControl();
        loadData();
    }
    private void loadData() {
        arrTT.add(new ThanhToan(1,"Thẻ ngân hàng",R.drawable.icongoogle));
        arrTT.add(new ThanhToan(2,"Tiền mặt",R.drawable.icongoogle));
    }
    private void addControl() {
        recycThanhtoan=findViewById(R.id.recycThanhtoan);
        recycThanhtoan.setLayoutManager(new LinearLayoutManager(this));

        RecyclerView.ItemDecoration itemDecoration=new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
        recycThanhtoan.addItemDecoration(itemDecoration);

        arrTT=new ArrayList<>();
        thanhtoanAdapter=new ThanhToanAdapter(this, arrTT, new IClickItemTT() {
            @Override
            public void onClickItemTT(ThanhToan tt) {
                onClickGoToTT(tt);
            }
        });
        recycThanhtoan.setAdapter(thanhtoanAdapter);
    }
    private void onClickGoToTT(ThanhToan tt) {
        if (tt.getPtid()==1)
        {
            Intent it = new Intent(this,NhapTheActivity.class);
            startActivity(it);
        }
        else
        {
            Intent it = new Intent(this, NhapDiaChiActivity.class);
            startActivity(it);
        }
    }
}