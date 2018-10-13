package com.transvision.smartbillingtest;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.util.Arrays;
import java.util.List;

class Database {
    private MyHelper mh;
    private SQLiteDatabase sdb;

    Database(Context context){
        String dbname = filepath("databases") + File.separator + "mydb.db";
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

    private String Appfoldername() {
        return "TRM_Smart_Billing" + File.separator + "data" + File.separator + "files";
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    String filepath(String value) {
        File dir = new File(android.os.Environment.getExternalStorageDirectory(), Appfoldername()
                + File.separator + value);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        return dir.toString();
    }

    void logStatus(String message) {
        Log.d("debug", message);
    }

    private String getJSONArray(Cursor cursor) {
        JSONArray resultSet = new JSONArray();
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            int totalColumn = cursor.getColumnCount();
            JSONObject rowObject = new JSONObject();
            for (int i = 0; i < totalColumn; i++) {
                if (cursor.getColumnName(i) != null) {
                    try {
                        if (cursor.getString(i) != null)
                            rowObject.put(cursor.getColumnName(i), cursor.getString(i));
                        else rowObject.put(cursor.getColumnName(i), "");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            resultSet.put(rowObject);
            cursor.moveToNext();
        }
        logStatus(resultSet.toString());
        return resultSet.toString();
    }

    private String getMastOut() {
        return getJSONArray(sdb.rawQuery("select * from MAST_OUT", null));
    }

    List<MastOut> getMastOutDetails() {
        return Arrays.asList(new Gson().fromJson(getMastOut(), MastOut[].class));
    }
}
