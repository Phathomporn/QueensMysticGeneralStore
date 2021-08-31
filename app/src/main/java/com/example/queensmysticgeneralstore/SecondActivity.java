package com.example.queensmysticgeneralstore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    String results;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        results = intent.getStringExtra("result");

        InitInstances();
    }

    private void InitInstances() {

        final TextView tvResults = (TextView) findViewById(R.id.tvResults);
        tvResults.setText(""+results);
    }
}
