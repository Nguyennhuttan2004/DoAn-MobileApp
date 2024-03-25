package Activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.example.doan_mobileapp.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import Activity.DangKyActivity;
public class DangNhapActivity extends AppCompatActivity {
    EditText edtSignIpUser,edtSignInPass;
    TextView txtForgotPass,txtSignUp;
    Button btnSignIn;
    ImageView ivSIFB,ivSIGG;
    FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_nhap);

        addControl();
        addEvent();
    }
    private void addControl() {
        edtSignIpUser=findViewById(R.id.edtSignInUser);
        edtSignInPass=findViewById(R.id.edtSignInPass);
        txtForgotPass=findViewById(R.id.txtForgotPass);
        txtSignUp=findViewById(R.id.txtSignUp);
        btnSignIn=findViewById(R.id.btnSignIn);
        ivSIFB=findViewById(R.id.ivSIFB);
        ivSIGG=findViewById(R.id.ivSIGG);
    }
    private void addEvent() {
        txtSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(DangNhapActivity.this,DangKyActivity.class);
                startActivity(intent);
            }
        });
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nhanDangNhap();
            }
        });
    }
    private void nhanDangNhap() {
        Intent it = getIntent();
        String email = it.getStringExtra("email");
        edtSignIpUser.setText(email);
        //email = edtSignIpUser.getText().toString().trim();
        String password = edtSignInPass.getText().toString().trim();

        if (TextUtils.isEmpty(email)){
            Toast.makeText(DangNhapActivity.this,"Hãy nhập email",Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(password)){
            Toast.makeText(DangNhapActivity.this,"Hãy nhập mặt khẩu",Toast.LENGTH_SHORT).show();
            return;
        }
        firebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Toast.makeText(DangNhapActivity.this,"Đăng nhập thành công",Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(DangNhapActivity.this,MainActivity.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(DangNhapActivity.this,"Đăng nhập thất bại",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

