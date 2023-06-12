package com.example.todopizza_app;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    TextView today;
    Button targetbtn, CalMove;
    LinearLayout TargetAdd;
    ImageView gpimentoToppings, hamToppings, mushroomToppings, oliveToppings, onionToppings, rpimentoToppings, tomatoToppings;


    private Spinner spinner_fruits;
    String[] spinnerNames;
    int[] spinnerImages;
    int selected_fruit_idx = 0;
    int chenum = 0; //리스트 갯수
    String idvalue = ""; //목표 추가하면 목표마다 아이디를 넣을 변수
    int targetnum = 0; //리스트 개수를 세주는 변수
    ArrayList<String> idvalue2 = new ArrayList<>(); //목표 id값을 저장한 배열



    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // 목표 추가 버튼을 클릭하면 아이디값을 배열에 저장. -> 현재 추가 버튼이 눌린 목표 id와 배열안에 있는 id값을 비교
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        targetbtn = findViewById(R.id.targetbtn);

        TargetAdd = findViewById(R.id.TargetAdd);
        gpimentoToppings = findViewById(R.id.gpimentoToppings);
        hamToppings = findViewById(R.id.hamToppings);
        mushroomToppings = findViewById(R.id.mushroomToppings);
        oliveToppings = findViewById(R.id.oliveToppings);
        onionToppings = findViewById(R.id.onionToppings);
        rpimentoToppings = findViewById(R.id.rpimentoToppings);
        tomatoToppings = findViewById(R.id.tomatoToppings);

        targetbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("mytag", "???");
                ViewGroup view = (ViewGroup) LayoutInflater.from(MainActivity.this).inflate(R.layout.todo_target, null, false);
                Button ListAddButton = view.findViewById(R.id.ListAddButton);
                TargetAdd.addView(view);

                CheckBox listBox = view.findViewById(R.id.listBox);


                chenum = 0;
                idvalue = "ListAddButton";
                targetnum++;
                idvalue = idvalue + targetnum;
                idvalue2.add(idvalue); // 지정한 id값을 아이디값 배열에 저장
//                for(int i = 0; i<=idvalue2.toArray().length; i++){
//                    Log.d("id값",""+ idvalue2);
//                } 배열 값 확인

                Toast.makeText(MainActivity.this, idvalue + "", Toast.LENGTH_SHORT).show();
                spinner_fruits = view.findViewById(R.id.spinner_main_fruits);

                spinnerImages = new int[]{
                        R.drawable.gpimento,
                        R.drawable.ham,
                        R.drawable.mushroom,
                        R.drawable.olive,
                        R.drawable.onion,
                        R.drawable.rpimento,
                        R.drawable.tomato
                };
                spinnerNames = new String[]{
                        "초록피망",
                        "햄",
                        "버섯",
                        "올리브",
                        "양파",
                        "빨강피망",
                        "토마토"
                };
                CustomSpinnerAdapter customSpinnerAdapter = new CustomSpinnerAdapter(MainActivity.this, spinnerNames, spinnerImages);
                spinner_fruits.setAdapter(customSpinnerAdapter);

                spinner_fruits.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        selected_fruit_idx = spinner_fruits.getSelectedItemPosition();
                        //Toast.makeText(MainActivity.this, spinnerNames[selected_fruit_idx], Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });

                LinearLayout listContainer = view.findViewById(R.id.list);
                ListAddButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        // Toast.makeText(MainActivity.this, idvalue+"", Toast.LENGTH_SHORT).show(); +버튼을 클릭하면 해당 + 버튼의 아이디 값을 확인하자
                        Log.d("mytag", "click list add button");
                        View listChild = LayoutInflater.from(MainActivity.this).inflate(R.layout.todo_list, null, false);
                        listContainer.addView(listChild);
                        Button listdele = listChild.findViewById(R.id.listdele);
                        CheckBox listBox = listChild.findViewById(R.id.listBox);
                        listBox.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                revalidatePizzaToppings();
                            }
                        });
//                        if(targetnum == targetnum2){ //targetnum은 목표 추가 버튼을 클릭하면 증가하는 값. 이거랑 __비교해야해
//                            //__ 이 값은 지금 누른 버튼의 값이여야해
//                            //지금 내 생각은 지정한 아이디값이랑 뭘 비교해야해 근데 그 뭘 모르겟어
//                            chenum ++;
//                            Toast.makeText(MainActivity.this, chenum+"", Toast.LENGTH_SHORT).show();
//                        }
//                        for(int i=0; i<targetnum; i++){
//                            if(idvalue == idvalue2[i]){
//                                chenum ++;
//                                Toast.makeText(MainActivity.this, chenum+"", Toast.LENGTH_SHORT).show();
//                            }
//                        }
                        for (int i = 0; i < idvalue2.size(); i++) { //배열 사이즈만큼 for문 돌리기
                            String checkidvalue = idvalue2.get(i);
                            if (checkidvalue == idvalue) {
                                chenum++;
                                Toast.makeText(MainActivity.this, chenum + "", Toast.LENGTH_SHORT).show();
                            }
                        }
                        listdele.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                revalidatePizzaToppings();
                                listContainer.removeView(listChild);
                                chenum--; //삭제하면 리스트 개수 감소
                            }
                        });
                    }
                });
            }
        });

        today = findViewById(R.id.today);
        targetbtn = findViewById(R.id.targetbtn);
        CalMove = findViewById(R.id.CalMove);
        TargetAdd = findViewById(R.id.TargetAdd);


        long now = System.currentTimeMillis(); //오늘 날짜 가져오는 로직
        Date date = new Date(now);
        SimpleDateFormat mFormat = new SimpleDateFormat("yyyy년 MM월 dd일");
        String time = mFormat.format(date);
        today.setText(time); //

        CalMove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), calender.class);
                startActivity(intent);
                finish(); //캘린더로 넘어가는 화면
            }
        });
    }

    public void revalidatePizzaToppings() {
        LinearLayout listContainer = findViewById(R.id.TargetAdd);
        // Log.d("mytag", listContainer.getChildCount() + "");
        for (int i = 0; i < listContainer.getChildCount(); i++) {
            CardView targetList = (CardView) listContainer.getChildAt(i);
            LinearLayout list = (LinearLayout) targetList.findViewById(R.id.list);
            int totalCount = list.getChildCount();
            Log.d("mytag", list.getChildCount() + "");
            int checkCount = 0;
            for (int j = 0; j < list.getChildCount(); j++) {
                CheckBox box = list.findViewById(R.id.listBox); //체크박스
                Log.d("mytag", box.isChecked() + "");
                if (box.isChecked() == true) checkCount++; //체크박스 체크 여부 개수랑 totalCount비교
            }

            if (chenum == checkCount) {
                String spinnerName = spinnerNames[selected_fruit_idx];
                if (spinnerName == "초록피망") {
                    gpimentoToppings.setVisibility(View.VISIBLE);
                } else if (spinnerName == "햄") {
                    hamToppings.setVisibility(View.VISIBLE);
                } else if (spinnerName == "버섯") {
                    mushroomToppings.setVisibility(View.VISIBLE);
                } else if (spinnerName == "올리브") {
                    oliveToppings.setVisibility(View.VISIBLE);
                } else if (spinnerName == "양파") {
                    onionToppings.setVisibility(View.VISIBLE);
                } else if (spinnerName == "빨강피망") {
                    rpimentoToppings.setVisibility(View.VISIBLE);
                } else {
                    tomatoToppings.setVisibility(View.VISIBLE);
                }
            }else if(totalCount != checkCount){
                String spinnerName = spinnerNames[selected_fruit_idx];
                if (spinnerName == "초록피망") {
                    gpimentoToppings.setVisibility(View.INVISIBLE);
                } else if (spinnerName == "햄") {
                    hamToppings.setVisibility(View.INVISIBLE);
                } else if (spinnerName == "버섯") {
                    mushroomToppings.setVisibility(View.INVISIBLE);
                } else if (spinnerName == "올리브") {
                    oliveToppings.setVisibility(View.INVISIBLE);
                } else if (spinnerName == "양파") {
                    onionToppings.setVisibility(View.INVISIBLE);
                } else if (spinnerName == "빨강피망") {
                    rpimentoToppings.setVisibility(View.INVISIBLE);
                } else {
                    tomatoToppings.setVisibility(View.INVISIBLE);
                }
            }
        }
    }
}