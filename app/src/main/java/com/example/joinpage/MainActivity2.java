package com.example.joinpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    public TextView textView,textView2;
    public EditText username,password;
    public Button login;
    Db_helper DB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        textView =(TextView) findViewById(R.id.signup);
        textView2 = (TextView) findViewById(R.id.tt2);
        username = (EditText) findViewById(R.id.username1);
        password = (EditText) findViewById(R.id.password);
        login = (Button) findViewById(R.id.login);
        DB = new Db_helper(this);


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
                String user = username.getText().toString();
                String pass = password.getText().toString();
                if (user.equals("")||pass.equals("")){
                    Toast.makeText(MainActivity2.this, "Please enter the username and password", Toast.LENGTH_SHORT).show();
                }else{
                    boolean checkuserpass = DB.checkpassword(user,pass);
                    if (checkuserpass == true){
                        Toast.makeText(MainActivity2.this, "Signed in successful", Toast.LENGTH_SHORT).show();
                        Intent signin = new Intent(getApplicationContext(),MainActivity4.class);
                        startActivity(signin);

                    }
                    else{
                        Toast.makeText(MainActivity2.this, "wrong password and username", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}