package com.example.joinpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity4 extends AppCompatActivity {

    public ImageView imageView2,imageView3,imageView4,election_img,Result_img,candidateinfo,evm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        imageView2 = (ImageView) findViewById(R.id.imageView2);
        imageView3 = (ImageView) findViewById(R.id.imageView3);
        imageView4 = (ImageView) findViewById(R.id.imageView4);
        election_img = (ImageView) findViewById(R.id.election_img);
        Result_img = (ImageView) findViewById(R.id.Result_img);
        candidateinfo = (ImageView) findViewById(R.id.candidateinfo);
        evm = (ImageView) findViewById(R.id.evm);


        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent chrome_link  = new Intent(Intent.ACTION_VIEW, Uri.parse("https://results.eci.gov.in/"));
                startActivity(chrome_link);
            }
        });
        election_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent election_link  = new Intent(MainActivity4.this,MainActivity5.class);
                startActivity(election_link);
            }
        });
        Result_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent result_link  = new Intent(MainActivity4.this,MainActivity6.class);
                startActivity(result_link);
            }
        });
        candidateinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent c_info_link  = new Intent(MainActivity4.this,MainActivity7.class);
                startActivity(c_info_link);
            }
        });
        evm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent evm_link  = new Intent(MainActivity4.this,MainActivity8.class);
                startActivity(evm_link);
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