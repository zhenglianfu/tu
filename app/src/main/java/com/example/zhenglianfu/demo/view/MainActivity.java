package com.example.zhenglianfu.demo.view;

import android.app.Dialog;
import android.app.LauncherActivity;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ScrollView;

import com.example.zhenglianfu.demo.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    protected Dialog defaultDialog;

    protected ListView listView;

    protected ScrollView scrollView;

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
        // scrollView listView
        this.listView = (ListView)findViewById(R.id.main_list);
        this.fillList(null);
        return this;
    }

    private Dialog showDialog(){
        Dialog dialog = this.defaultDialog == null ? this.createDialog(this) : this.defaultDialog;
        return this.showDialog(null);
    }

    private Dialog showDialog(String message){
        message = message == null ? "" : message;
        AlertDialog dialog = (AlertDialog)this.createDialog(this);
        dialog.setTitle("提示");
        dialog.setMessage(message);
        dialog.setButton(DialogInterface.BUTTON_POSITIVE, "YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                
            }
        });
        dialog.show();
        return dialog;
    }

    private Dialog createDialog(Context context, boolean force){
        if (this.defaultDialog != null && force == false) {
            return this.defaultDialog;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        this.defaultDialog = builder.create();
        return this.defaultDialog;
    }

    private Dialog createDialog(Context context){
        return this.createDialog(context, false);
    }

    private ListView fillList(List<Object> list){
        // 测试
        List<String> testList = new ArrayList<String>(20);
        for (int i = 0; i < 20; i+=1) {
            testList.add("item" + (i + 1));
        }
        this.listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, testList));
        return this.listView;
    }
}
