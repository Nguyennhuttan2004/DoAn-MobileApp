package com.example.doan_mobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DangKyActivity extends AppCompatActivity {
    EditText editHoten,editSdt,editEmail,editSignupPass,editRePass;
    Button btnSignup;
    TextView txtSignin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_ky);
        addControl();

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String hoten = editHoten.getText().toString().trim();
                String sdt = editSdt.getText().toString().trim();
                String email = editEmail.getText().toString().trim();
                String password = editSignupPass.getText().toString().trim();
                String repass = editRePass.getText().toString().trim();

                Intent getInformation = new Intent(DangKyActivity.this, DangNhapActivity.class);
                getInformation.putExtra("hoten",hoten);
                getInformation.putExtra("sdt",sdt);
                getInformation.putExtra("email",email);
                getInformation.putExtra("password",password);
                startActivity(getInformation);
            }
        });
        txtSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openSignin = new Intent(DangKyActivity.this, DangNhapActivity.class);
                startActivity(openSignin);
            }
        });
    }

    public void addControl(){
        editHoten = findViewById(R.id.editHoten);
        editSignupPass = findViewById(R.id.editSignupPass);
        editSdt = findViewById(R.id.editSdt);
        editEmail = findViewById(R.id.editEmail);
        editRePass = findViewById(R.id.editRePass);
        txtSignin = findViewById(R.id.txtSignin);
        btnSignup = findViewById(R.id.btnSignup);
    }
}