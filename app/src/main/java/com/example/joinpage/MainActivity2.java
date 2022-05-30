package com.example.joinpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    public TextView textView,textView2;
    public Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        textView =(TextView) findViewById(R.id.signup);
        textView2 = (TextView) findViewById(R.id.tt2);
        login = (Button) findViewById(R.id.login);

        textView2.setPaintFlags(textView2.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);
        textView.setPaintFlags(textView.getPaintFlags()|Paint.UNDERLINE_TEXT_FLAG);
//        LayerDrawable bottomBorder = getBorders(Color.BLACK,0,0,0,10);
//        textView2.setBackground(bottomBorder);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this,MainActivity3.class);
                //Intent is used to perform actions on the screen
                startActivity(intent);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ns_page = new Intent(MainActivity2.this,MainActivity4.class);
                startActivity(ns_page);
            }
        });
    }
}