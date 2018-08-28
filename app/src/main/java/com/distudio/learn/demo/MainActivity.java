package com.distudio.learn.demo;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.distudio.learn.demo.touch.ScaleWith2Fingers;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void GoDrag(View view){
        Intent intent = new Intent(this, ScaleWith2FingersActivity.class);
        startActivity(intent);
    }

    public void GoScaleWith2Fingers(View view){
        Intent intent = new Intent(this, ScaleWith2FingersActivity.class);
        startActivity(intent);
    }


    public void GoRotateWith2Fingers(View view){
        Intent intent = new Intent(this, RotateWith2FingersActivity.class);
        startActivity(intent);
    }
}
