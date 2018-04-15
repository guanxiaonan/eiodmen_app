package com.gyn.eiodmen;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import java.util.ArrayList;
import java.util.List;

public class TerminalDevice extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.terminal_device);
        Button terminal_situation=(Button)findViewById(R.id.terminal_situation);
        terminal_situation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a=new Intent(TerminalDevice.this,DeviceSituation.class);
                startActivity(a);

            }
        });

        Button structure_situation = (Button) findViewById(R.id.structure_situation);
       structure_situation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent b = new Intent(TerminalDevice.this,StructureSituation.class);
                startActivity(b);
            }
        });


    }
}