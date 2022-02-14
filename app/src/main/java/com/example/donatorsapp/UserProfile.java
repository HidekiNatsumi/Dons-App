package com.example.donatorsapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class UserProfile extends AppCompatActivity {
 Button donateBtn,logoutBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
       donateBtn=findViewById(R.id.donateBtn);
       logoutBtn=findViewById(R.id.logoutBtn);


       donateBtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent= new Intent(UserProfile.this,  DonatePage.class);
               startActivity(intent);

           }
       });
       logoutBtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent=new Intent(UserProfile.this,  Login_Page.class);
               startActivity(intent);
               finish();
           }
       });

    }
}