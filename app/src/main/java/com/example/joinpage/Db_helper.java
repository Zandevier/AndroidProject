package com.example.joinpage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.sql.Blob;

public class Db_helper extends SQLiteOpenHelper {

    public static final String DB_NAME= "Login.db" ;

    public Db_helper(Context context) {
        super(context, "Login.db",null,1);
    }


    @Override
    public void onCreate(SQLiteDatabase UserInfo) {
        UserInfo.execSQL("create Table users(srno int primary key,username TEXT,password TEXT,voterid TEXT,userimage BLOB,voteridimage BLOB)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase UserInfo, int oldVersion, int newVersion) {
        UserInfo.execSQL("drop Table if exists users");
    }

    public Boolean insertData(String username, String password, String voterid){
        SQLiteDatabase UserInfo = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username",username);
        contentValues.put("password",password);
        contentValues.put("voterid",voterid);

        long result = UserInfo.insert("users",null,contentValues);
        if (result == -1){
            return false;}
        else {
            return true;}
    }
    public Boolean checkusername(String username){
        SQLiteDatabase UserInfo = this.getWritableDatabase();
        Cursor cursor = UserInfo.rawQuery("Select * from users where username = ?" , new String[]{username});
        if (cursor.getCount()>0)
            return true;
        else
            return false;

    }
public Boolean checkpassword(String username,String password){
        SQLiteDatabase UserInfo = this.getWritableDatabase();
        Cursor cursor = UserInfo.rawQuery("Select * from users where username =? and password = ?" , new String[]{username,password});
        if (cursor.getCount()>0)
            return true;
        else
            return false;

    }
public Boolean checkvoterid(String voterid){
        SQLiteDatabase UserInfo = this.getWritableDatabase();
        Cursor cursor = UserInfo.rawQuery("Select * from users where voterid = ?" , new String[]{voterid});
        if (cursor.getCount()>0)
            return true;
        else
            return false;

    }

}

