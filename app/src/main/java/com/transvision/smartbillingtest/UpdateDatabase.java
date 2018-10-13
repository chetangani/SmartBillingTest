package com.transvision.smartbillingtest;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.File;

class UpdateDatabase {
    private MyHelper mh;
    private SQLiteDatabase sdb;

    UpdateDatabase(Context context, Database database){
        String dbname = database.filepath("CollectionData") + File.separator + "mydb.db";
        mh = new MyHelper(context, dbname, null, 1);
    }

    void open() {
        sdb = mh.getWritableDatabase();
    }

    void close() {
        sdb.close();
    }

    public class MyHelper extends SQLiteOpenHelper {
        MyHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        }
    }

    void insert_data(String value) {
        Cursor data;
        data = sdb.rawQuery(value, null);
        data.moveToNext();
        data.close();
    }
}
