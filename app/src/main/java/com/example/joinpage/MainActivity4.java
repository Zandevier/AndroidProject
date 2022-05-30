package com.example.joinpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity4 extends AppCompatActivity {

    public ImageView imageView2,imageView3,imageView4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        imageView2 = (ImageView) findViewById(R.id.imageView2);
        imageView3 = (ImageView) findViewById(R.id.imageView3);
        imageView4 = (ImageView) findViewById(R.id.imageView4);


        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent chrome_link  = new Intent(Intent.ACTION_VIEW, Uri.parse("https://results.eci.gov.in/"));
                startActivity(chrome_link);
            }
        });
        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent chrome_link  = new Intent(Intent.ACTION_VIEW, Uri.parse("https://results.eci.gov.in/ResultPcByeApril2022/partywiseresult-S25.htm"));
                startActivity(chrome_link);
            }
        });
        imageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent chrome_link  = new Intent(Intent.ACTION_VIEW, Uri.parse("https://ceo.maharashtra.gov.in/"));
                startActivity(chrome_link);
            }
        });
    }
}