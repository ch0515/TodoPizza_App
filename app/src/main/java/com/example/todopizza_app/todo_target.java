package com.example.todopizza_app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;


public class todo_target extends Activity {
    Button ListAddButton;
    LinearLayout Addlist;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.todo_target);
        ListAddButton = findViewById(R.id.ListAddButton);

        ListAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Addlist.setVisibility(View.VISIBLE);
            }
        });
    }
}
