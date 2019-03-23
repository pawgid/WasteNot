package com.example.wastenot.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.wastenot.R;
import com.squareup.picasso.Picasso;

public class DescriptionActivity extends AppCompatActivity {





    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.description);
        Bundle bundle = getIntent().getExtras();
        int id = bundle.getInt("ID");
        String detailedDescription = bundle.getString("TITLE");
        String imageUrl = bundle.getString("IMAGE_URL");
        Button navigate = (Button) findViewById(R.id.navigate);
        TextView idTxt = (TextView) findViewById(R.id.detailsText);
        TextView detailedDescTxt = (TextView) findViewById(R.id.detailedDescription);
        ImageView dishImage = (ImageView) findViewById(R.id.dishImage);
        idTxt.setText("ID " + String.valueOf(id));
        detailedDescTxt.setText(detailedDescription);
        Picasso.get().load(imageUrl).into(dishImage);

        navigate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), MapsActivity.class);
                v.getContext().startActivity(intent);
            }
        });
    }






}
