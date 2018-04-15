package com.gyn.eiodmen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //跳转到准备
        Button myready = (Button) findViewById(R.id.myready);
        myready.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(MainActivity.this,Myready.class);
                startActivity(a);
            }
        });

        //跳转到其他设备
        Button other_device= (Button) findViewById(R.id.other_device);
        other_device.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent b = new Intent(MainActivity.this,OtherDevice.class);
                startActivity(b);
            }
        });
        //跳转到设备管理
        Button terminal_device = (Button) findViewById(R.id.terminal_device);
        terminal_device.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent c = new Intent(MainActivity.this,TerminalDevice.class);
                startActivity(c);
            }
        });
        //跳转到准备
        Button waterIO = (Button) findViewById(R.id.waterIO);
        waterIO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent d = new Intent(MainActivity.this,WaterIO.class);
                startActivity(d);
            }
        });

    }
}

