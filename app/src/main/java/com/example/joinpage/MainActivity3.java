package com.example.joinpage;


import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {
    int select_photo = 1;
    Uri uri;//Uri is the Uniform Resource Identifier
    public TextView voterid_img,upload_img;
    private static final int CAMERA_REQUEST = 100;
    public static final int STORAGE_REQUEST = 101;

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