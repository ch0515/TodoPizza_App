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
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class todo_target extends AppCompatActivity{
    Button ListAddButton;
    LinearLayout ListAdd;

    private Spinner spinner_fruits;
    String[] spinnerNames;
    int[] spinnerImages;
    int selected_fruit_idx = 0;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.todo_target);

        ListAddButton = findViewById(R.id.ListAddButton);
        ListAdd = findViewById(R.id.Addlist);
        spinner_fruits = (Spinner)findViewById(R.id.spinner_main_fruits);

        spinnerNames = new String[]{
                "초록피망",
                "햄",
                "버섯",
                "올리브",
                "양파",
                "빨강피망",
                "토마토"
        };
        spinnerImages = new int[]{
                R.drawable.gpimento,
                R.drawable.ham,
                R.drawable.mushroom,
                R.drawable.olive,
                R.drawable.onion,
                R.drawable.rpimento,
                R.drawable.tomato
        };
        CustomSpinnerAdapter customSpinnerAdapter = new CustomSpinnerAdapter(todo_target.this, spinnerNames, spinnerImages);
        spinner_fruits.setAdapter(customSpinnerAdapter);

        spinner_fruits.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selected_fruit_idx = spinner_fruits.getSelectedItemPosition();
                Toast.makeText(todo_target.this, spinnerNames[selected_fruit_idx], Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

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
