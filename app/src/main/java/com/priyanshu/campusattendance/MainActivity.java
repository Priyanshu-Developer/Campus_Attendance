package com.priyanshu.campusattendance;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.chaquo.python.Python;
import com.chaquo.python.android.AndroidPlatform;

public class MainActivity extends AppCompatActivity {
    String[] REQUEST_PERMISSIONS = {"android.permission.CAMERA",
            "android.permission.WRITE_EXTERNAL_STORAGE","android.permission.READ_EXTERNAL_STORAGE","android.permission.INTERNET",
            "android.permission.ACCESS_WIFI_STATE","android.permission.CHANGE_WIFI_STATE"};
    int REQUEST_CODE = 1001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        requestPermissions(this.REQUEST_PERMISSIONS,this.REQUEST_CODE);
        if (!Python.isStarted()){
            Python.start(new AndroidPlatform(this));
        }
        String path = getFilesDir().toString()+"faceData.xml";

        Toast.makeText(this,path,Toast.LENGTH_LONG).show();

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == this.REQUEST_CODE){
            Toast.makeText(this,"Starting Authentication",Toast.LENGTH_LONG).show();

        }
        else{
            Toast.makeText(this,"Permission are required",Toast.LENGTH_LONG).show();
            requestPermissions(this.REQUEST_PERMISSIONS,this.REQUEST_CODE);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}