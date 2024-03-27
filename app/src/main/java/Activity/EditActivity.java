package Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.doan_mobileapp.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

import model.SanPham;

public class EditActivity extends AppCompatActivity {
    ImageView imgedtSP;
    EditText edtTen,edtGia,edtId,edtStyleId,edtMota;
    CheckBox cbBest;
    Button btnSave,btnDelete;
    SanPham sp;
    Toolbar toolbar;
    FirebaseDatabase db;
    int position = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        addControl();
        getIntentExtra();
        setVariable();
        ToolbarBack();
        addEvent();
    }

    private void addEvent() {
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveDATA();
            }
        });
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteDATA();
            }
        });
    }

    private void deleteDATA() {
    }

    private void saveDATA() {
        db = FirebaseDatabase.getInstance();
        DatabaseReference myRef = db.getReference("SanPham");
        Map<String, Object> map = new HashMap<>();
        map.put("edtTen",edtTen.getText().toString().trim());
        map.put("edtGia",edtGia.getText().toString().trim());
        map.put("edtMota",edtMota.getText().toString().trim());
        map.put("edtId",edtId.getText().toString().trim());
        map.put("edtStyleId",edtStyleId.getText().toString().trim());
        map.put("cbBest",isbestfood());

        

    }
    private boolean isbestfood(){
        if(cbBest.isChecked()){
            return true;
        }
        return false;
    }

    private void setVariable() {
        Glide.with((EditActivity.this))
                .load(sp.getHinh())
                .into(imgedtSP);
        edtGia.setText(sp.getGia()+"");
        edtTen.setText(sp.getTen());
        edtMota.setText(sp.getMota());
        edtId.setText(sp.getId()+"");
        edtStyleId.setText(sp.getStyleID()+"");
        cbBest.setChecked(sp.isBestfood());
    }
    private void addControl() {
        imgedtSP = findViewById(R.id.imgedtSP);
        edtTen = findViewById(R.id.edtTen);
        edtGia = findViewById(R.id.edtGia);
        edtId = findViewById(R.id.edtId);
        edtStyleId = findViewById(R.id.edtStyleId);
        edtMota = findViewById(R.id.edtMota);
        cbBest = findViewById(R.id.cbBest);
        btnSave = findViewById(R.id.btnSave);
        btnDelete = findViewById(R.id.btnDelete);
    }
    private void getIntentExtra() {
        sp = (SanPham) getIntent().getSerializableExtra("sp");
    }
    private void ToolbarBack() {
        toolbar = findViewById(R.id.tbEdit);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}