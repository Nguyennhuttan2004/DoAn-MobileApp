package Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;

import com.example.doan_mobileapp.R;

public class GioHangActivity extends AppCompatActivity {
    Toolbar tb=findViewById(R.id.tbGiohang);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gio_hang);

        ToolbarBack();
    }

    private void ToolbarBack() {
        setSupportActionBar(tb);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}