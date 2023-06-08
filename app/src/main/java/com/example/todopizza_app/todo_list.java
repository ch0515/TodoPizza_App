package com.example.todopizza_app;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;

public class todo_list extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.todo_list);
    }
}
