package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;

public class SignUpActivity extends AppCompatActivity {

    Button btn;
    EditText etName,etMail,etPass;
    private FirebaseAuth mAuth;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        btn=findViewById(R.id.btnSignUp);
        etName=findViewById(R.id.etNameSignUp);
        etMail=findViewById(R.id.etEmailSignUp);
        etPass=findViewById(R.id.etPassSignUp);
        mAuth = FirebaseAuth.getInstance();
        progressBar=findViewById(R.id.progressBar);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String mail=etMail.getText().toString().trim();
                String pass=etPass.getText().toString().trim();
                String name=etName.getText().toString().trim();

                if(mail.isEmpty())
                {
                    etMail.setError("Email is required");
                    etMail.requestFocus();
                    return;
                }
                if(!Patterns.EMAIL_ADDRESS.matcher(mail).matches())
                {
                    etMail.setError("Please enter a valid email");
                    etMail.requestFocus();
                    return;
                }
                if(pass.isEmpty())
                {
                    etPass.setError("Password is required");
                    etPass.requestFocus();
                    return;
                }
                if(pass.length()<6)
                {
                    etPass.setError("Minimum length 6");
                }
                if(name.isEmpty())
                {
                    etName.setError("Name is required");
                    etName.requestFocus();
                    return;
                }
                progressBar.setVisibility(View.VISIBLE);

                mAuth.createUserWithEmailAndPassword(mail,pass)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                progressBar.setVisibility(View.INVISIBLE);
                                if(task.isSuccessful())
                                {
                                    finish();
                                    Intent intent=new Intent(SignUpActivity.this,MainActivity.class);
                                    startActivity(intent);

                                }
                                else
                                {
                                    if(task.getException()instanceof FirebaseAuthUserCollisionException )
                                    {
                                        Toast.makeText(getApplicationContext(),"This mail is already used",Toast.LENGTH_LONG).show();
                                    }
                                }
                            }
                        });

            }
        });
    }
}
