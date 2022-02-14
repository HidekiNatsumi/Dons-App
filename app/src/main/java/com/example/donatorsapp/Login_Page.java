package com.example.donatorsapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class Login_Page extends AppCompatActivity {
Button callSignup,loginbtn;
    TextInputEditText username,pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login_page);
        username=findViewById(R.id.log_user);
        pass=findViewById(R.id.log_pass);
         loginbtn=findViewById(R.id.logInBtn);
         loginbtn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {

                 if(!validatePass() |!validateUsername()){
                     return;
                 }
                 else{
                     isUser();
                 }

             }

         });
        callSignup=findViewById(R.id.callSignUp);
        callSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Login_Page.this,Sign_up_page.class);
                        startActivity(intent);



            }
        });



    }
    private Boolean validateUsername(){
        String val=username.getText().toString();

        if(val.isEmpty()){
            username.setError("Field cannot be empty");
            return false;
        }
        else {
            username.setError(null);
            return true;
        }
    }
    private Boolean validatePass(){
        String val=username.getText().toString();

        if(val.isEmpty()){
            pass.setError("Field cannot be empty");
            return false;
        }
        else {
            username.setError(null);
            return true;
        }
    }




    private void isUser() {
       String userEnterName= username.getText().toString().trim();
        String userEnterPass= pass.getText().toString().trim();

        DatabaseReference reference= FirebaseDatabase.getInstance().getReference("user");
        Query checkUser= reference.orderByChild("username").equalTo(userEnterName);
        checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()){
                    username.setError(null);


                    String passwordFromDb=snapshot.child(userEnterName).child("password").getValue(String.class);
                    if(passwordFromDb.equals(userEnterPass)){
                        username.setError(null);
                        String usernameFromDb=snapshot.child(userEnterName).child("username").getValue(String.class);
                        String emailFromDb=snapshot.child(userEnterName).child("email").getValue(String.class);
                        String namedFromDb=snapshot.child(userEnterName).child("name").getValue(String.class);
                        String phoneFromDb=snapshot.child(userEnterName).child("phoneNr").getValue(String.class);
                        Intent intent= new Intent(getApplicationContext(),UserProfile.class);
                        intent.putExtra("name",namedFromDb);
                        intent.putExtra("username",usernameFromDb);

                        intent.putExtra("password",passwordFromDb);
                        intent.putExtra("email",emailFromDb);
                        intent.putExtra("phoneNr",phoneFromDb);
                        startActivity(intent);
                    }
                    else{
                        pass.setError("Wrong password");
                        pass.requestFocus();
                    }
                }
                else {
                    username.setError("No user exist");
                    username.requestFocus();
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot snapshot) {
            if(snapshot.exists()){
                username.setError(null);
                String passwordFromDb=snapshot.child(userEnterName).child("password").getValue(String.class);
                if(passwordFromDb.equals("admin")){
                    String usernameFromDb=snapshot.child(userEnterName).child("username").getValue(String.class);
                    String emailFromDb=snapshot.child(userEnterName).child("email").getValue(String.class);
                    String namedFromDb=snapshot.child(userEnterName).child("name").getValue(String.class);
                    String phoneFromDb=snapshot.child(userEnterName).child("phoneNr").getValue(String.class);
                    Intent intent=new Intent(Login_Page.this,Admin_Page.class);
                    intent.putExtra("name",namedFromDb);
                    intent.putExtra("username",usernameFromDb);

                    intent.putExtra("password",passwordFromDb);
                    intent.putExtra("email",emailFromDb);
                    intent.putExtra("phoneNr",phoneFromDb);
                    startActivity(intent);
                }
            }
        }

        @Override
        public void onCancelled(@NonNull DatabaseError error) {

        }
    });

    }
}