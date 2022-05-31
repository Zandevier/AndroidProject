package com.example.joinpage;


import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {
    int select_photo = 1;
    Uri uri;//Uri is the Uniform Resource Identifier
    public TextView voterid_img,upload_img;
    private static final int CAMERA_REQUEST = 100;
    public static final int STORAGE_REQUEST = 101;
    public EditText username,password2,voterid;
    public Button signup_btn;
    Db_helper DB;

    ActivityResultLauncher<Intent> activityLauncher =registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {

                    Toast.makeText(MainActivity3.this, "image selected", Toast.LENGTH_SHORT).show();
                }
            }
    );


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);


        //Image picker code
        voterid_img = (TextView) findViewById(R.id.voterid_img);
        upload_img = (TextView) findViewById(R.id.upload_img);
        username = (EditText) findViewById(R.id.username1);
        password2 = (EditText) findViewById(R.id.password2);
        EditText uservoterid = (EditText) findViewById(R.id.voterid);
        signup_btn = (Button) findViewById(R.id.signup_btn);
        DB = new Db_helper(this);


        signup_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user= username.getText().toString();
                String pass = password2.getText().toString();

                String voterid = uservoterid.getText().toString();



                if (user.equals("")||pass.equals("")||voterid.equals("")){
                    Toast.makeText(MainActivity3.this, "Please enter all fields", Toast.LENGTH_SHORT).show();
                }else{
                    if (DB.checkusername(user) == true && DB.checkvoterid(voterid)==true) {
                        Toast.makeText(MainActivity3.this, "user already exists", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Boolean insert = DB.insertData(user,pass,voterid);
                        if (insert == true){
                            Toast.makeText(MainActivity3.this, "Account created succesfully", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Toast.makeText(MainActivity3.this, "Registration failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        });




//        ActivityResultLauncher<String> launcher = registerForActivityResult(new ActivityResultContracts.GetContent(), new ActivityResultCallback<Uri>() {
//            @Override
//            public void onActivityResult(Uri result) {
//                uri = data.getData();
//            }
//        });

        upload_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent uimg = new Intent(Intent.ACTION_PICK,MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                activityLauncher.launch(uimg);
            }
        });
        voterid_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent voter_img = new Intent(Intent.ACTION_PICK,MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                activityLauncher.launch(voter_img);
            }
        });


    }


}