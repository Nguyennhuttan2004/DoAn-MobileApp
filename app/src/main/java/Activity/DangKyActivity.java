package Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.doan_mobileapp.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class DangKyActivity extends AppCompatActivity {
    EditText edtHoTen,edtEmail,edtPass,edtRePass;
    Button btnSignUp;
    TextView txtSignIn;
    ImageView ivSIFB,ivSIGG;
    FirebaseAuth firebaseAuth= FirebaseAuth.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_ky);

        edtHoTen=findViewById(R.id.edtHoTen);
        edtEmail=findViewById(R.id.edtEmail);
        edtPass=findViewById(R.id.edtPass);
        edtRePass=findViewById(R.id.edtRePass);
        btnSignUp=findViewById(R.id.btnSignUp);
        txtSignIn=findViewById(R.id.txtSignIn);

        txtSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(DangKyActivity.this,DangNhapActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email,password;
                email = String.valueOf(edtEmail.getText());
                password = String.valueOf(edtPass.getText());

                if (TextUtils.isEmpty(email)){
                    Toast.makeText(DangKyActivity.this,"Enter Email",Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(password)){
                    Toast.makeText(DangKyActivity.this,"Enter Password",Toast.LENGTH_SHORT).show();
                    return;
                }

                firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(DangKyActivity.this,"Đăng ký thành công",Toast.LENGTH_SHORT).show();
                            Intent intent=new Intent(DangKyActivity.this,DangNhapActivity.class);
                            startActivity(intent);
                        }
                        else {
                            Toast.makeText(DangKyActivity.this,"Đăng ký thất bại",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

    }
}

