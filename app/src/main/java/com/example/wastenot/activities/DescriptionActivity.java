package com.example.wastenot.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;
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
        TextView idTxt = (TextView) findViewById(R.id.detailsText);
        idTxt.setText("ID " + String.valueOf(id));
        TextView detailedDescTxt = (TextView) findViewById(R.id.detailedDescription);
        detailedDescTxt.setText(detailedDescription);
        ImageView dishImage = (ImageView) findViewById(R.id.dishImage);
        Picasso.get().load(imageUrl).into(dishImage);
    }
}
