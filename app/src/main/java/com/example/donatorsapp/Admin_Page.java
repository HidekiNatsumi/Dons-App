package com.example.donatorsapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Admin_Page extends AppCompatActivity {
Button hisBtn,logoutbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_page);
  hisBtn=findViewById(R.id.histBtn);

  hisBtn.setBackgroundResource(R.mipmap.histtt);
        logoutbtn=findViewById(R.id.logoutBtn3);
        logoutbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(Admin_Page.this,  Login_Page.class);
                startActivity(intent);
            }
        });

 hisBtn.setOnClickListener(new View.OnClickListener() {
     @Override
     public void onClick(View view) {
         Intent intent= new Intent(Admin_Page.this,  HistoryPage.class);
         startActivity(intent);
     }
 });
    }
}
/*
Admin page
*/
