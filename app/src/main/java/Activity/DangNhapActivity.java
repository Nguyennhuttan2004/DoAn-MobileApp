package Activity;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
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
import com.google.firebase.auth.FirebaseUser;

import Activity.DangKyActivity;
public class DangNhapActivity extends AppCompatActivity {
    EditText edtSignIpUser,edtSignInPass;
    TextView txtForgotPass,txtSignUp;
    Button btnSignIn;
    ImageView ivSIFB,ivSIGG;
    FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_nhap);

        addControl();
        addEvent();
    }
    private void addControl() {
        progressDialog = new ProgressDialog(this);
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
        String stremail = edtSignIpUser.getText().toString().trim();
        String strpassword = edtSignInPass.getText().toString().trim();
        FirebaseAuth auth = FirebaseAuth.getInstance();
        progressDialog.show();
        auth.signInWithEmailAndPassword(stremail, strpassword)
            .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    progressDialog.dismiss();
                    if (task.isSuccessful()) {
                        Intent intent = new Intent(DangNhapActivity.this, MainActivity.class);
                        startActivity(intent);
                        finishAffinity();

                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w(TAG, "createUserWithEmail:failure", task.getException());
                        Toast.makeText(DangNhapActivity.this, "Authentication failed.",
                                Toast.LENGTH_SHORT).show();
                    }
                }
            });
    }
}

