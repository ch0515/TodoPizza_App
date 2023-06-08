package com.example.todopizza_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.lang.annotation.Target;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    TextView today;
    Button targetbtn, CalMove, ListAddButton;
    LinearLayout TargetAdd;

    CardView Addtarget;
    private Spinner spinner_fruits;
    String[] spinnerNames;
    int[] spinnerImages;
    int selected_fruit_idx = 0;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        today = findViewById(R.id.today);
        targetbtn = findViewById(R.id.targetbtn);
        CalMove = findViewById(R.id.CalMove);
        Addtarget = findViewById(R.id.Addtarget);
        ListAddButton = findViewById(R.id.ListAddButton);
        TargetAdd = findViewById(R.id.TargetAdd);


        long now = System.currentTimeMillis();
        Date date = new Date(now);
        SimpleDateFormat mFormat = new SimpleDateFormat("yyyy년 MM월 dd일");
        String time = mFormat.format(date);
        today.setText(time);

        targetbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                LayoutInflater inflater = (LayoutInflater)
//                        getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//                inflater.inflate(R.layout.todo_target, TargetAdd, true);
                Addtarget.setVisibility(View.VISIBLE);
            }
        });
        CalMove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), calender.class);
                startActivity(intent);
                finish();
            }
        });

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
        CustomSpinnerAdapter customSpinnerAdapter = new CustomSpinnerAdapter(MainActivity.this, spinnerNames, spinnerImages);
        spinner_fruits.setAdapter(customSpinnerAdapter);

        spinner_fruits.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selected_fruit_idx = spinner_fruits.getSelectedItemPosition();
                Toast.makeText(MainActivity.this, spinnerNames[selected_fruit_idx], Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ListAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater = (LayoutInflater)
                        getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                inflater.inflate(R.layout.todo_list, TargetAdd, true);
            }
        });
    }

}