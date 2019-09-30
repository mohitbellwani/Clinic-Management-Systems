package com.example.projver2.Databse;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context) {
        super(context, Constants.DB_NAME, null, Constants.VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try{
            db.execSQL(Constants.CREATETABLE1);
            db.execSQL(Constants.CREATETABLE2);
        }
        catch (SQLException e){
            e.printStackTrace();
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        try{
            db.execSQL(Constants.DROPTABLE1);
            db.execSQL(Constants.DROPTABLE2);
            onCreate(db);
        }
        catch (SQLException e){
            e.printStackTrace();
        }

    }
}
