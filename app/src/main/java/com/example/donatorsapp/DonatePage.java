package com.example.donatorsapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DonatePage extends AppCompatActivity {
    FirebaseDatabase rootnode;
    DatabaseReference reference;
    EditText amount,donate_name;

    Button sendAm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donate_page);
  amount=findViewById(R.id.amount);
  sendAm=findViewById(R.id.donateBtn2);
  donate_name=findViewById(R.id.donateName);


  sendAm.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
          rootnode=FirebaseDatabase.getInstance();
          reference= rootnode.getReference("donate");
          String amount2= amount.getText().toString();
          String donatename2=donate_name.getText().toString();
          DonationHelper helper=  new DonationHelper(amount2,donatename2);


          reference.push().setValue(helper);


      }
  });



    }
}