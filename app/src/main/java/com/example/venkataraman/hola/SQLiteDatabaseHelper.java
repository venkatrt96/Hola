package com.example.venkataraman.hola;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Venkataraman on 17-04-2017.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by Venkataraman on 27-03-2017.
 */

public class SQLiteDatabaseHelper extends SQLiteOpenHelper {

    String date = "date";
    String calories = "calories";
    String tname = "work";

    String query = "create table work (date varchar(20), calories varchar(20))";

    public SQLiteDatabaseHelper(Context context) {
        super(context, "Hola.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean onInsert(String d, String c) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(date, d);
        cv.put(calories, c);

        long result = db.insert(tname, null, cv);

        if (result == -1) {
            return false;
        }
        else {
            return true;
        }
    }
}

