package com.example.joinpage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.sql.Blob;

public class Db_helper extends SQLiteOpenHelper {

    public static final String DB_NAME= "Login.db" ;
    public static final int DB_VERSION = 2;
    private static final String TAG = "NULL";

    public Db_helper(Context context) {
        super(context, "Login.db",null,2);
    }


    @Override
    public void onCreate(SQLiteDatabase UserInfo) {
//        UserInfo.execSQL("create Table users(srno int primary key ,username TEXT,password TEXT,voterid TEXT,userimage BLOB,voteridimage BLOB)");
        onUpgrade(UserInfo,0,2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase UserInfo, int oldVersion, int newVersion) {
//        UserInfo.execSQL("drop Table if exists users");
        if (oldVersion<1){
            UserInfo.execSQL("create Table users(srno int primary key,username TEXT,password TEXT,voterid TEXT,userimage BLOB,voteridimage BLOB)");
        }
        if (oldVersion<2){
            UserInfo.execSQL("alter table users add column selected_party TEXT");
        }
    }


    public Boolean insertData(String username, String password, String voterid){
        SQLiteDatabase UserInfo = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username",username);
        contentValues.put("password",password);
        contentValues.put("voterid",voterid);

        long result = UserInfo.insert("users",null,contentValues);
        return result != -1;
    }
    public Boolean checkusername(String username){
        SQLiteDatabase UserInfo = this.getWritableDatabase();
        Cursor cursor = UserInfo.rawQuery("Select * from users where username = ?" , new String[]{username});
        return cursor.getCount() > 0;

    }
public Boolean checkpassword(String username,String password){
        SQLiteDatabase UserInfo = this.getWritableDatabase();
        Cursor cursor = UserInfo.rawQuery("Select * from users where username =? and password = ?" , new String[]{username,password});
    return cursor.getCount() > 0;

    }
public Boolean checkvoterid(String voterid){
        SQLiteDatabase UserInfo = this.getWritableDatabase();
        Cursor cursor = UserInfo.rawQuery("Select * from users where voterid = ?" , new String[]{voterid});
    return cursor.getCount() > 0;

    }

public Boolean InsertParty(String selected_party){
        SQLiteDatabase UserInfo = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("selected_party",selected_party);
        long result = UserInfo.insert("users",null,contentValues);
        return result != -1;

}
    public Boolean checkinsertParty(String selected_party){
        SQLiteDatabase UserInfo = this.getWritableDatabase();
        Cursor cursor = UserInfo.rawQuery("Select * from users where selected_party = ?" , new String[]{selected_party});
        return cursor.getCount() > 0;

    }
    public String fetchParty(){
        SQLiteDatabase UserInfo = this.getWritableDatabase();
        Cursor cursor = UserInfo.rawQuery("Select * from users where selected_party",null,null);
//        while (cursor.moveToNext()){
//            Log.e(TAG,"fetch data "+ cursor.getString(2));
//        }
        Log.d(TAG,"The fetch data is "+ cursor.getString(2));
        return String.valueOf(cursor.getCount());
    }
}

