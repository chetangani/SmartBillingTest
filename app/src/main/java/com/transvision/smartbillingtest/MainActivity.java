package com.transvision.smartbillingtest;

import android.annotation.TargetApi;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

public class MainActivity extends AppCompatActivity {
    private static final int RequestPermissionCode = 1;

    public static final int TEXT_INSERT_SUCCESS = 2;
    public static final int DB_INSERT_SUCCESS = 3;

    Button btn_generate, btn_insert;
    Database database;
    UpdateDatabase updateDatabase;
    List<MastOut> mastOutList;
    MastOutText mastOutText;

    Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            switch (msg.what) {
                case TEXT_INSERT_SUCCESS:
                    btn_insert.setEnabled(true);
                    btn_generate.setEnabled(false);
                    break;

                case DB_INSERT_SUCCESS:
                    btn_insert.setEnabled(false);
                    btn_generate.setEnabled(true);
                    break;
            }
            return false;
        }
    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_generate = findViewById(R.id.generate_btn);
        btn_insert = findViewById(R.id.insert_btn);
        mastOutList = new ArrayList<>();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                checkPermissionsMandAbove();
            }
        }, 500);

        btn_generate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mastOutList = database.getMastOutDetails();
                mastOutText.text_append(database, mastOutList, handler);
            }
        });

        btn_insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mastOutText.readFile(database, updateDatabase, handler);
            }
        });
    }

    private void startup() {
        btn_generate.setEnabled(true);
        database = new Database(MainActivity.this);
        database.open();
        updateDatabase = new UpdateDatabase(MainActivity.this, database);
        updateDatabase.open();
        mastOutText = new MastOutText();
    }

    @TargetApi(23)
    public void checkPermissionsMandAbove() {
        int currentapiVersion = android.os.Build.VERSION.SDK_INT;
        if (currentapiVersion >= 23) {
            if (checkPermission()) {
                startup();
            } else requestPermission();
        } else startup();
    }

    private void requestPermission() {
        ActivityCompat.requestPermissions(MainActivity.this, new String[]
                {
                        WRITE_EXTERNAL_STORAGE
                }, RequestPermissionCode);
    }

    private boolean checkPermission() {
        int FirstPermissionResult = ContextCompat.checkSelfPermission(getApplicationContext(), WRITE_EXTERNAL_STORAGE);
        return FirstPermissionResult == PackageManager.PERMISSION_GRANTED;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case RequestPermissionCode:
                if (grantResults.length > 0) {
                    boolean ReadStoragePermission = grantResults[0] == PackageManager.PERMISSION_GRANTED;
                    if (ReadStoragePermission) {
                        startup();
                    } else {
                        Toast.makeText(MainActivity.this, "Required All Permissions to granted", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                }
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        database.close();
        updateDatabase.close();
    }
}