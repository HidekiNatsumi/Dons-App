package com.example.donatorsapp;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Holder extends RecyclerView.ViewHolder {
    View view;

    public Holder(@NonNull View itemView) {
        super(itemView);

        view = itemView;


    }
    public void setView(Context context,String name,String value){
        TextView nametv=view.findViewById(R.id.name_tv);
        TextView vauletv=view.findViewById(R.id.value_tv);

        nametv.setText(name);
         vauletv.setText(value);

    }
}
