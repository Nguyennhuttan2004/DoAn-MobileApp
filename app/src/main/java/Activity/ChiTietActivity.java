package Activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;

import com.example.doan_mobileapp.R;

public class ChiTietActivity extends AppCompatActivity {

    Toolbar toolbar;
    Button btnThemvaogiohang;
    TextView txtTensp,txtGiasp,txtMotachitiet,txtNumber;
    ImageButton btnTru,btnCong;
    ImageView ivHinhSP;
    Toolbar tbDetailSP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet);
        addControls();
        ToolbarBack();
    }

    private void ToolbarBack() {
        tbDetailSP = findViewById(R.id.tbDetailSP);
        setSupportActionBar(tbDetailSP);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void addControls() {
        btnThemvaogiohang=findViewById(R.id.btnThemvaogiohang);
        txtTensp=findViewById(R.id.txtTensp);
        txtGiasp=findViewById(R.id.txtGiasp);
        txtMotachitiet=findViewById(R.id.txtMotachitiet);
        btnTru=findViewById(R.id.btnTru);
        txtNumber=findViewById(R.id.txtNumber);
        btnCong=findViewById(R.id.btnCong);
        ivHinhSP=findViewById(R.id.ivHinhSP);
    }

}