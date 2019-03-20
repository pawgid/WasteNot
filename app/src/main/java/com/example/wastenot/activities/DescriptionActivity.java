package com.example.wastenot.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.wastenot.R;

public class DescriptionActivity extends AppCompatActivity {



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.description);

        Bundle bundle = getIntent().getExtras();
        String title = bundle.getString("TITLE");
        TextView titleTxt = (TextView) findViewById(R.id.title);
        titleTxt.setText(title);
    }
}
