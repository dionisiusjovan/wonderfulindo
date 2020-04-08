package com.wi.wonderfulindo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegisterActivity extends AppCompatActivity {
    private TextView tvSignIn;
    EditText emailId, password;
    Button btnRegister;
    ProgressBar progressBar;
    FirebaseAuth mFirebaseAuth;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mFirebaseAuth = FirebaseAuth.getInstance();
        emailId = findViewById(R.id.txtEmail);
        password = findViewById(R.id.txtPassword);
        progressBar = findViewById(R.id.registerProgressBar);
        btnRegister = findViewById(R.id.btnregister);

        FirebaseUser firebaseUser = mFirebaseAuth.getCurrentUser();

        if (firebaseUser != null){
            Intent intent = new Intent(RegisterActivity.this, HomeActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailId.getText().toString();
                String pass = password.getText().toString();
                if (email.isEmpty()){
                    emailId.setError("Please enter your email!");
                    emailId.requestFocus();
                } else if (pass.isEmpty()){
                    password.setError("Please enter your password!");
                    password.requestFocus();
                } else if(email.isEmpty() && pass.isEmpty()){
                    Toast.makeText(RegisterActivity.this, "Fields are Empty", Toast.LENGTH_SHORT).show();
                } else if(pass.length() < 8){
                    password.setError("Password can't be less then 8 characters!");
                    password.requestFocus();
                } else if(!(email.isEmpty() && pass.isEmpty())){
                    progressBar.setVisibility(View.VISIBLE);
                    mFirebaseAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            progressBar.setVisibility(View.GONE);
                            if (!task.isSuccessful()){
                                Toast.makeText(RegisterActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            } else {
                                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                            }
                        }
                    });
                } else {
                    Toast.makeText(RegisterActivity.this, "Error", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        tvSignIn = findViewById(R.id.signin);
        tvSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

}
