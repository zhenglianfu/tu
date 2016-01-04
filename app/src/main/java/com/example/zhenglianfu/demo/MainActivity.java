package com.example.zhenglianfu.demo;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.asyncInit();
    }

    private Context asyncInit(){
        final MainActivity activity = this;
        Button button = (Button)findViewById(R.id.button_1);
        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                activity.showDialog();
            }
        });
        return this;
    }

    private Dialog showDialog(){
        return null;
    }
}
