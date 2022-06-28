package com.example.groceryapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.L;
import com.example.groceryapp.models.UserModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegistrationActivity extends AppCompatActivity {

    Button signUpbtn;

    EditText name,email,password;

    TextView signIn;
    FirebaseAuth mAuth;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);





        signUpbtn= findViewById(R.id.button_for_sign_up);
        name=findViewById(R.id.nameid);
        email= findViewById(R.id.emailid);
        password=findViewById(R.id.passwordid);
        signIn= findViewById(R.id.sign_in_link);
        progressBar=findViewById(R.id.progressBar);
        progressBar.setVisibility(View.GONE);




        mAuth=FirebaseAuth.getInstance();
        signUpbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                progressBar.setVisibility(View.VISIBLE);
                createUser();
            }
        });
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegistrationActivity.this,LoginActivity.class));
            }
        });
    }
    private void createUser(){


        String userName= name.getText().toString().trim() ;
        String userEmail=email.getText().toString().trim();
        String userPassword=password.getText().toString().trim();



        if(TextUtils.isEmpty(userName)){

            Toast.makeText(RegistrationActivity.this, "Name is Empty!", Toast.LENGTH_SHORT).show();
            progressBar.setVisibility(View.GONE);
            return;
        }
        if(TextUtils.isEmpty(userEmail)){

            Toast.makeText(RegistrationActivity.this, "Email is Empty!", Toast.LENGTH_SHORT).show();
            progressBar.setVisibility(View.GONE);
            return;
        }
        if(TextUtils.isEmpty(userPassword)){

            Toast.makeText(RegistrationActivity.this, "Password is Empty!", Toast.LENGTH_SHORT).show();
            progressBar.setVisibility(View.GONE);
            return;
        }
        if(userPassword.length()<8)
        {
            Toast.makeText(RegistrationActivity.this, "Password must be greater than 8 letters", Toast.LENGTH_SHORT).show();
            progressBar.setVisibility(View.GONE);
            return;
        }

        mAuth.createUserWithEmailAndPassword(userEmail,userPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    UserModel user=new UserModel(userName,userEmail,userPassword);
                    FirebaseDatabase.getInstance().getReference("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful()){
                                progressBar.setVisibility(View.GONE);
                                Toast.makeText(RegistrationActivity.this, "Registered!", Toast.LENGTH_SHORT).show();
                                name.setText("");
                                email.setText("");
                                password.setText("");
                            }
                            else
                            {
                                progressBar.setVisibility(View.GONE);
                                Toast.makeText(RegistrationActivity.this, "Failed!", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }else{
                    Toast.makeText(RegistrationActivity.this, "Failed!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        /*
        if(userPassword.length() < 8)
        {
            Toast.makeText(this, "Password must be strong & greater than 8 letters", Toast.LENGTH_SHORT).show();
        }

        */
    }
}

















