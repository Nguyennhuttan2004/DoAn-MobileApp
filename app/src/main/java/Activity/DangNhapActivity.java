package Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.doan_mobileapp.R;

import Activity.DangKyActivity;

public class DangNhapActivity extends AppCompatActivity {
    EditText editSigninUser, editSigninPass;
    TextView txtForgtoPass, txtSignup;
    Button btnSignin;
    ImageView imgSIFB,imgSIGG;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_nhap);

        addControl();
        addBtnEvent();
        Event();
    }

    private void Event() {
        Intent getInformation = getIntent();
        String email = getInformation.getStringExtra("email");
        editSigninUser.setText(email);
    }

    private void addBtnEvent() {
        txtSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openSignup = new Intent(DangNhapActivity.this, DangKyActivity.class);
                startActivity(openSignup);
            }
        });
        btnSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openMain = new Intent(DangNhapActivity.this, MainActivity.class);
                startActivity(openMain);
            }
        });
    }

    private void addControl() {
        editSigninUser = findViewById(R.id.editSigninUser);
        editSigninPass = findViewById(R.id.editSigninPass);
        txtForgtoPass = findViewById(R.id.txtForgtoPass);
        txtSignup = findViewById(R.id.txtSignup);
        btnSignin = findViewById(R.id.btnSignin);
        imgSIFB = findViewById(R.id.imgSIFB);
        imgSIGG = findViewById(R.id.imgSIGG);
    }
}