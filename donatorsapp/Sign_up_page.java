package com.example.donatorsapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Sign_up_page extends AppCompatActivity {
 private TextInputEditText regname,regUsername,regEmail,regPhone,regPass;
 Button regbuton,regTologinBtn;
 FirebaseDatabase rootnode;
 DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_page);


        regbuton=findViewById(R.id.regButn);
        regTologinBtn=findViewById(R.id.regToLogIn);
        regUsername=findViewById(R.id.regname);
        regEmail=findViewById(R.id.regEmail);
        regPhone=findViewById(R.id.regNumber);
        regPass=findViewById(R.id.regpass);
        regname=findViewById(R.id.regname);

regTologinBtn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent= new Intent(Sign_up_page.this,  Login_Page.class);
        startActivity(intent);
    }
});




regbuton.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {

        if (  !validateName() | !validateNumber() | !validatePass()){
            return;
        }
        rootnode=FirebaseDatabase.getInstance();
        reference= rootnode.getReference("user");

        String username= regUsername.getText().toString();
        String pass= regPass .getText().toString();
        String email= regEmail .getText().toString();
        String number= regPhone .getText().toString();
        String name= regname.getText().toString();
      Userhelper helperUser= new  Userhelper(username,name,pass,email,number);

        reference.child(name).setValue(helperUser);
        Intent intent= new Intent(Sign_up_page.this, Login_Page.class);
        startActivity(intent);
        finish();

    }
});



    }
    private Boolean validateName(){
        String val= regname.getText().toString();

        if(val.isEmpty()){
            regname.setError("Field cannot be empty");
            return false;
        }
        else{
            regname.setError(null);
            return true;
        }
    }
    private Boolean validateuserName(){
        String val= regUsername.getText().toString();

        if(val.isEmpty()){
            regUsername.setError("Field cannot be empty");
            return false;
        }
        else{
            regUsername.setError(null);
            return true;
        }
    }

    private Boolean validateNumber(){
        String val= regPhone.getText().toString();

        if(val.isEmpty()){
            regPhone.setError("Field cannot be empty");
            return false;
        }
        else{
            regPhone.setError(null);
            return true;
        }
    }
    private Boolean validatePass(){
        String val= regUsername.getText().toString();
String passwordVal= "^" +
        "(?=.*[a-zA-Z])" +      //any letter
        "(?=\\S+$)" +           //no white spaces
        ".{4,}" +               //at least 4 characters
        "$";
        if(val.isEmpty()){
            regPass.setError("Field cannot be empty");
            return false;
        }else if (!val.matches(passwordVal)){
            regPass.setError("Password is too weak");
            return false;
        }
        else{
            regPass.setError(null);
            return true;
        }
    }


}