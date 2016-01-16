package com.example.zhenglianfu.demo.activity;

import android.app.Activity;
import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.zhenglianfu.demo.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.init();
    }

    private MainActivity init(){
        final Activity rootView = this;
        final MainActivity thisActivity = this;
        Button button = (Button)findViewById(R.id.alert_btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(rootView).setTitle("tip").setMessage("haha").setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        thisActivity.dial();
                    }
                }).setCancelable(false).setNegativeButton("No", null).create().show();
            }
        });

        Button mamiButton = (Button)findViewById(R.id.mami_btn);
        mamiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                thisActivity.startMami();
            }
        });
        return this;
    }

    private void dial(){
        // 判断是否存在[tel:] 这个内部协议
        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:15157121807"));
        ComponentName cn = intent.resolveActivity(getPackageManager());
        if (cn == null) {
            new AlertDialog.Builder(this).setTitle("提示").setMessage("无法启动电话程序").create().show();
        } else {
            startActivity(intent);
        }
    }

    private void startMami(){
        this.startActivity(new Intent(this, SecondActivity.class));
    }
}
