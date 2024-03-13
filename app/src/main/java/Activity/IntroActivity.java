package Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.doan_mobileapp.R;

public class IntroActivity extends AppCompatActivity {
    TextView txtIntroSignin,txtIntroSignup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        txtIntroSignin=findViewById(R.id.txtIntroSignin);
        txtIntroSignup=findViewById(R.id.txtIntroSignup);

        txtIntroSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(IntroActivity.this, DangNhapActivity.class);
                startActivity(it);
            }
        });
        txtIntroSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(IntroActivity.this, DangKyActivity.class);
                startActivity(it);
            }
        });
    }
}