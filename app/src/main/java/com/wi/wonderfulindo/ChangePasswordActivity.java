package com.wi.wonderfulindo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.EmailAuthCredential;
import com.google.firebase.auth.EmailAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ChangePasswordActivity extends AppCompatActivity {

    TextView userEmail;
    ImageView back;
    EditText oldPass, newPass, confirmPass;
    Button btnSave;
    ProgressBar progressBar;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        oldPass = findViewById(R.id.oldPassword);
        newPass = findViewById(R.id.newPassword);
        confirmPass = findViewById(R.id.confirmPassword);
        btnSave = findViewById(R.id.btnsave);
        progressBar = findViewById(R.id.cPassProgressBar);

        firebaseAuth = FirebaseAuth.getInstance();
        final FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();

        userEmail = findViewById(R.id.txtUserEmail);
        userEmail.setText(firebaseUser.getEmail());

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String old = oldPass.getText().toString();
                final String newp = newPass.getText().toString();
                String confirm = confirmPass.getText().toString();
                if (old.isEmpty()){
                    oldPass.setError("Please enter your password!");
                    oldPass.requestFocus();
                }else if (newp.isEmpty()){
                    newPass.setError("Please enter your password!");
                    newPass.requestFocus();
                }else if (confirm.isEmpty()) {
                    confirmPass.setError("Please enter your password!");
                    confirmPass.requestFocus();
                }else if(newp.length() < 8 || confirm.length() < 8){
                    newPass.setError("Password can't be less then 8 characters!");
                    newPass.requestFocus();
                }else if (!newp.equalsIgnoreCase(confirm)){
                    confirmPass.setError("Your Password is wrong!");
                    confirmPass.requestFocus();
                }else if((!(newp.isEmpty() && confirm.isEmpty())) && (!(newp.length() < 8 && confirm.length() < 8))
                        && (!(!newp.equalsIgnoreCase(confirm)))){
                    progressBar.setVisibility(View.VISIBLE);
                    AuthCredential credential = EmailAuthProvider.getCredential(firebaseUser.getEmail(), old);

                    firebaseUser.reauthenticate(credential).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            firebaseUser.updatePassword(newp).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    progressBar.setVisibility(View.GONE);
                                    if (task.isSuccessful()){
                                        Toast.makeText(ChangePasswordActivity.this, "Changing Password Success!", Toast.LENGTH_SHORT).show();
                                        startActivity(new Intent(ChangePasswordActivity.this, ProfileActivity.class));
                                        finish();
                                    } else {
                                        Toast.makeText(ChangePasswordActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                        }
                    });
                } else {
                    Toast.makeText(ChangePasswordActivity.this, "Error", Toast.LENGTH_SHORT).show();
                }
            }
        });

        back = findViewById(R.id.btnbackcp);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }
}
