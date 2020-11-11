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
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private View parent_view;
    EditText etMail,etPass;
    String name,pass,mail;
    ProgressBar progressBar;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_simple_light);
        parent_view = findViewById(android.R.id.content);
        etMail=findViewById(R.id.etMailLogin);
        etPass=findViewById(R.id.etPassLogin);
        progressBar=findViewById(R.id.progressBar);

        mAuth = FirebaseAuth.getInstance();

        /*Tools.setSystemBarColor(this, android.R.color.white);
        Tools.setSystemBarLight(this);
*/
        ((View) findViewById(R.id.forgot_password)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(parent_view, "Forgot Password", Snackbar.LENGTH_SHORT).show();
            }
        });

        Button btn=findViewById(R.id.sign_up);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(MainActivity.this,SignUpActivity.class);
                startActivity(intent);
            }
        });
        Button btn1=findViewById(R.id.btnLogin);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mail=etMail.getText().toString().trim();
                pass=etPass.getText().toString().trim();

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
                progressBar.setVisibility(View.VISIBLE);

                mAuth.signInWithEmailAndPassword(mail,pass)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful())
                                {
                                    finish();
                                    Intent intent=new Intent(MainActivity.this,DashBoard.class);
                                    startActivity(intent);
                                }
                                else
                                {
                                    Toast.makeText(getApplicationContext(),task.getException().getMessage(),Toast.LENGTH_LONG).show();
                                    progressBar.setVisibility(View.INVISIBLE);
                                }
                            }
                        });



            }
        });



    }

    @Override
    protected void onStart() {
        super.onStart();
        if(mAuth.getCurrentUser()!=null)
        {
            finish();
            Intent intent=new Intent(MainActivity.this,DashBoard.class);
            startActivity(intent);
        }
    }
}
