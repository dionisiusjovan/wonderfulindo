package com.wi.wonderfulindo;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {
    EditText emailAd, pwd;
    Button btnLogin, btnback;
    ProgressBar progressBar;
    FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mFirebaseAuth = FirebaseAuth.getInstance();
        emailAd = findViewById(R.id.editEmail);
        pwd = findViewById(R.id.editPassword);
        progressBar = findViewById(R.id.loginProgressBar);
        btnLogin = findViewById(R.id.btnsignin);
        btnback = findViewById(R.id.loginBack);

        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });

        mAuthStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser mFirebaseUser = mFirebaseAuth.getCurrentUser();
                if (mFirebaseUser != null){
                    Toast.makeText(LoginActivity.this, "You're signed in", Toast.LENGTH_LONG).show();
                    Intent i = new Intent(LoginActivity.this, HomeActivity.class);
                    startActivity(i);
                } else {
                    Toast.makeText(LoginActivity.this, "Please Sign In first!", Toast.LENGTH_LONG).show();
                }
            }
        };
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailAd.getText().toString();
                String pass = pwd.getText().toString();
                if (email.isEmpty()){
                    emailAd.setError("Please enter your email!");
                    emailAd.requestFocus();
                } else if (pass.isEmpty()){
                    pwd.setError("Please enter your password!");
                    pwd.requestFocus();
                } else if(email.isEmpty() && pass.isEmpty()){
                    Toast.makeText(LoginActivity.this, "Fields are Empty", Toast.LENGTH_SHORT).show();
                } else if(!(email.isEmpty() && pass.isEmpty())){
                    progressBar.setVisibility(View.VISIBLE);
                    mFirebaseAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            progressBar.setVisibility(View.GONE);
                            if (!task.isSuccessful()) {
                                Toast.makeText(LoginActivity.this, "An error occured! Please Retry to Sign In", Toast.LENGTH_SHORT).show();
                            } else{
                                Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                                startActivity(intent);
                            }
                        }
                    });
                } else {
                    Toast.makeText(LoginActivity.this, "Error", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        mFirebaseAuth.addAuthStateListener(mAuthStateListener);
    }
}
