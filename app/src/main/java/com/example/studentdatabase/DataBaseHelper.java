package com.example.studentdatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.lang.annotation.Target;
import java.util.ArrayList;


public class DataBaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE = "lgn.db";
    public static final String TABLE = "login_table";
    public static final String Clm1 = "UserName";
    public static final String Clm2 = "Password";

    public static final String STUDENT_TABLE = "data_table";
    public static final String Clmm1 = "Roll_No";
    public static final String Clmm2 = "Name";
    public static final String Clmm3 = "City";
    public static final String Clmm4 = "Marks";

    Cursor res2;

    public DataBaseHelper(Context context) {

        super(context, DATABASE, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(" CREATE TABLE " + TABLE + " (UserName TEXT,Password TEXT) ");
        db.execSQL(" CREATE TABLE " + STUDENT_TABLE + " (Roll_No TEXT,Name TEXT,City TEXT,Marks TEXT) ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE);
        db.execSQL(" DROP TABLE IF EXISTS " + STUDENT_TABLE);
        onCreate(db);
    }


    public boolean insertData(String Uname, String pas) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Clm1, Uname);
        contentValues.put(Clm2, pas);
        long res=db.insert(TABLE, null, contentValues);
        if(res==-1){
            return false;
        }
        return true;
    }

    public boolean insertData1(String roll, String name, String city, String marks) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Clmm1, roll);
        contentValues.put(Clmm2, name);
        contentValues.put(Clmm3, city);
        contentValues.put(Clmm4, marks);
        db.insert(STUDENT_TABLE, null, contentValues);
        return true;
    }

    public Cursor showData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM " + TABLE, null);
        return res;
    }

    public Cursor showData1() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res1 = db.rawQuery("SELECT * FROM " + STUDENT_TABLE, null);
        return res1;
    }


    public boolean Login(String username, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor Cursor = db.rawQuery("SELECT * FROM " + TABLE + " WHERE UserName=? AND Password=?", new String[]{username, password});
        if (Cursor != null) {
            if (Cursor.getCount() > 0) {
                return true;
            }
        }
        return false;
    }
    public Cursor search(String name,String Roll){
        SQLiteDatabase db = this.getWritableDatabase();
        res2 = db.rawQuery("SELECT * FROM " + STUDENT_TABLE+" WHERE Name=? OR Roll_No=? ",new String[]{name, Roll});
        return res2;
    }

}
