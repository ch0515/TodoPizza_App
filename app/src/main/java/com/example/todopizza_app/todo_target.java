package com.example.todopizza_app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class todo_target extends AppCompatActivity{
    Button ListAddButton;
    LinearLayout ListAdd;
    private Spinner pizzaspin;
    int[] spinnerImages;
    int selected_pizza_idx = 0;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.todo_target);

        ListAddButton = findViewById(R.id.ListAddButton);
        ListAdd = findViewById(R.id.Addlist);

        pizzaspin = findViewById(R.id.pizzaspin);
        spinnerImages = new int[]{
                R.drawable.gpimento,
                R.drawable.ham,
                R.drawable.mushroom,
                R.drawable.olive,
                R.drawable.onion,
                R.drawable.rpimento,
                R.drawable.tomato
        };
        EmotionCustomAdapter emotioncustomAdapter = new EmotionCustomAdapter(todo_target.this, spinnerImages);
        pizzaspin.setAdapter(emotioncustomAdapter);

        ListAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater inflater = (LayoutInflater)
                        getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                inflater.inflate(R.layout.todo_list, ListAdd, true);
            }
        });
    }


}
