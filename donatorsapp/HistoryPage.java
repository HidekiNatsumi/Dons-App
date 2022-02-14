package com.example.donatorsapp;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class HistoryPage extends AppCompatActivity {
FirebaseDatabase database;
DatabaseReference reference;
TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_page);
textView=findViewById(R.id.textView);


         reference = FirebaseDatabase.getInstance().getReference().child("donate") ;

              reference.addValueEventListener(new ValueEventListener() {
                  @Override
                  public void onDataChange(@NonNull DataSnapshot snapshot) {
                       if(snapshot.exists()){
                              String data=snapshot.getValue().toString();
                              textView.setText(data);
                       }
                  }

                  @Override
                  public void onCancelled(@NonNull DatabaseError error) {

                  }
              });
    }


    }
