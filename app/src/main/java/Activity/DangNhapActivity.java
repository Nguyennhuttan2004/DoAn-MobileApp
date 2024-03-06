package Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.doan_mobileapp.R;

public class DangNhapActivity extends AppCompatActivity {
    EditText editUser, editSigninPass;
    TextView txtForgotpass, txtSignup;
    Button btnSignin;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_nhap);

        addControl();
        Intent getInformation = getIntent();
        String email = getInformation.getStringExtra("email");
        editUser.setText(email);
        txtSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openSignup = new Intent(DangNhapActivity.this, DangKyActivity.class);
                startActivity(openSignup);
            }
        });
    }

    private void addControl() {
        editUser = findViewById(R.id.editUser);
        editSigninPass = findViewById(R.id.editSigninPass);
        txtForgotpass = findViewById(R.id.txtForgtopass);
        txtSignup = findViewById(R.id.txtSignup);
        btnSignin = findViewById(R.id.btnSignin);
    }
}