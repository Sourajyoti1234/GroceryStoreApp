package com.example.groceryapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    EditText email,password;
    Button sign_in;
    TextView signup;
    FirebaseAuth auth;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        progressBar=findViewById(R.id.progressBar);

        email=(EditText) findViewById(R.id.email_field);
        password=(EditText) findViewById(R.id.password_field);
        sign_in=(Button) findViewById(R.id.log_in);
        signup=(TextView) findViewById(R.id.sign_in_link);
        auth=FirebaseAuth.getInstance();
        progressBar.setVisibility(View.GONE);



    }
    public void goto_sign_up(View view) {
        startActivity(new Intent(LoginActivity.this,RegistrationActivity.class));
    }

    public void goto_sign_in(View view) {
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.RESULT_UNCHANGED_SHOWN);
        progressBar.setVisibility(View.VISIBLE);
        loginUser();
    }
    private void loginUser(){

        String userEmail=email.getText().toString().trim();
        String userPassword=password.getText().toString().trim();

        if(TextUtils.isEmpty(userEmail)){

            Toast.makeText(LoginActivity.this, "Email is Empty!", Toast.LENGTH_SHORT).show();
            progressBar.setVisibility(View.GONE);
            return;
        }
        if(TextUtils.isEmpty(userPassword)){

            Toast.makeText(LoginActivity.this, "Password is Empty!", Toast.LENGTH_SHORT).show();
            progressBar.setVisibility(View.GONE);
            return;
        }

        if(userPassword.length()<8)
        {
            Toast.makeText(LoginActivity.this, "Password must be greater than 8 letters", Toast.LENGTH_SHORT).show();
            progressBar.setVisibility(View.GONE);
            return;
        }
        auth.signInWithEmailAndPassword(userEmail,userPassword).addOnCompleteListener(this,new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()) {

                    Toast.makeText(LoginActivity.this, "Login Successfully!", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(LoginActivity.this, "Account Not found!", Toast.LENGTH_SHORT).show();
                }
                progressBar.setVisibility(View.GONE);
            }
        });



    }
}