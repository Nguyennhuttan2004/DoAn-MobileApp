package Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.doan_mobileapp.R;

public class NguoidungActivity extends AppCompatActivity {
    Toolbar toolbar=findViewById(R.id.tbNgdung);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nguoidung);

        ToolbarBack();
        addControl();
        addEvent();
    }
    private void addControl() {
    }
    private void addEvent() {
    }
    private void ToolbarBack() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}