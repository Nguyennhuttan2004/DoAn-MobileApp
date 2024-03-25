package Activity;

import static com.example.doan_mobileapp.R.id.imageView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.doan_mobileapp.R;

import model.SanPham;

public class ChiTietActivity extends AppCompatActivity {
    Toolbar toolbar = findViewById(R.id.tbDetailSP);
    Button btnThemvaogiohang;
    TextView txtTensp,txtGiasp,txtMotachitiet,txtNumber;
    ImageButton btnTru,btnCong;
    ImageView ivHinhSP;
    SanPham sp;
    private int num=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet);

        addControl();
        ToolbarBack();
        //lấy data sp từ main hoặc cate qua intent
        getIntentExtra();
        //gán giá trị từ intent đến id
        setVariable();
    }
    private void addControl() {
        btnThemvaogiohang=findViewById(R.id.btnThemvaogiohang);
        txtTensp=findViewById(R.id.txtTensp);
        txtGiasp=findViewById(R.id.txtGiasp);
        txtMotachitiet=findViewById(R.id.txtMotachitiet);
        btnTru=findViewById(R.id.btnTru);
        txtNumber=findViewById(R.id.txtNumber);
        btnCong=findViewById(R.id.btnCong);
        ivHinhSP=findViewById(R.id.ivHinhSP);
    }
    private void ToolbarBack() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    private void getIntentExtra() {
        sp = (SanPham) getIntent().getSerializableExtra("sp");
    }
    private void setVariable() {
        Glide.with((ChiTietActivity.this))
                .load(sp.getHinh())
                .into(ivHinhSP);
        txtGiasp.setText("$" + sp.getGia());
        txtTensp.setText(sp.getTen());
        txtMotachitiet.setText(sp.getMota());
    }
}