package com.example.joinpage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity7 extends AppCompatActivity {
    public ImageView imageView6,imageView7,imageView8,imageView9;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);
        imageView6 = (ImageView) findViewById(R.id.imageView6);
        imageView7 = (ImageView) findViewById(R.id.imageView7);
        imageView8 = (ImageView) findViewById(R.id.imageView8);
        imageView9 = (ImageView) findViewById(R.id.imageView9);

        imageView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView6.setVisibility(View.INVISIBLE);
            }
        });imageView7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView7.setVisibility(View.INVISIBLE);
            }
        });imageView8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView8.setVisibility(View.INVISIBLE);
            }
        });imageView9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView9.setVisibility(View.INVISIBLE);
            }
        });
    }
}