package com.example.zhenglianfu.demo;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    protected Dialog defaultDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.asyncInit();
    }

    private Context asyncInit() {
        final MainActivity activity = this;
        Button button = (Button) findViewById(R.id.button_1);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                activity.showDialog();
            }
        });
        Button midButton = (Button)findViewById(R.id.button_2);
        midButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                activity.showDialog("this is from middle button");
            }
        });
        Button lastButton = (Button)findViewById(R.id.button_3);
        return this;
    }

    private Dialog showDialog(){
        Dialog dialog = this.defaultDialog == null ? this.createDialog(this) : this.defaultDialog;
        return dialog;
    }

    private Dialog showDialog(String message){
        return null;
    }

    private Dialog createDialog(Context context, boolean force){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        return builder.create();
    }

    private Dialog createDialog(Context context){
        return this.createDialog(context, false);
    }
}
