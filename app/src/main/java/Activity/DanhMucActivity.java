package Activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.doan_mobileapp.R;
import androidx.appcompat.widget.Toolbar;

public class DanhMucActivity extends AppCompatActivity {
    RecyclerView rvDanhmuc;
    int categoryId;
    String categoryTen,searchTxt;
    boolean isSearch;
    Toolbar tbDM;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danh_muc);

        addControl();
        getIntentExtra();



        tbDM.setTitle(categoryTen);
        tbDM = findViewById(R.id.toolbarDM);
        setSupportActionBar(tbDM);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void addControl() {

    }

    private void getIntentExtra() {
        categoryId=getIntent().getIntExtra("CategoryId",0);
        categoryTen=getIntent().getStringExtra("Category");
        searchTxt=getIntent().getStringExtra("txt");
        isSearch=getIntent().getBooleanExtra("isSearch",false);


    }
}