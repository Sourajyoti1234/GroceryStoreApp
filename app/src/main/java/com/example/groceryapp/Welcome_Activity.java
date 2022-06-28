package com.example.groceryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.google.firebase.auth.FirebaseAuth;

import java.net.Inet4Address;

public class Welcome_Activity extends AppCompatActivity {
    ImageView logoname;
    LottieAnimationView lottieAnimationView;
    Button signup,login;
    ProgressBar progressBar;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        progressBar=findViewById(R.id.progressBar);
        progressBar.setVisibility(View.GONE);

        logoname=(ImageView) findViewById(R.id.logoname);
        lottieAnimationView=(LottieAnimationView) findViewById(R.id.lotteanimation);
        signup=(Button) findViewById(R.id.sign_up_btn);
        login=(Button) findViewById(R.id.loginwelcome);
        logoname.setAlpha(0.1f);
        signup.setTranslationX(1000);
        login.setTranslationX(-1000);
        logoname.animate().alpha(1.0f).setDuration(1500);
        signup.animate().translationX(0).setDuration(2300);
        login.animate().translationX(0).setDuration(2300);
        auth=FirebaseAuth.getInstance();
        if(auth.getCurrentUser()!=null){
            progressBar.setVisibility(View.VISIBLE);
            startActivity(new Intent(Welcome_Activity.this,MainActivity.class));
            Toast.makeText(this, "Please wait you are already logged in!", Toast.LENGTH_SHORT).show();
            finish();
        }

    }
    public void open_signup(View view) {
        startActivity(new Intent(Welcome_Activity.this,RegistrationActivity.class));

    }

    public void open_login(View view) {

        startActivity(new Intent(Welcome_Activity.this,LoginActivity.class));
    }
}