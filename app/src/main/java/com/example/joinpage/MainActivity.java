package com.example.joinpage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    public Button button;
    public TextView text;
    public ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = (TextView) findViewById(R.id.text);
        text.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        text.setSelected(true);

        img = (ImageView) findViewById(R.id.img);
        img.setElevation(10);

        button = (Button) findViewById(R.id.btn1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                startActivity(intent);
            }
        });
    }
}