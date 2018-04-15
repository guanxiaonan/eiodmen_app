package com.gyn.eiodmen;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by apple on 2018/4/11.
 */

public class DeviceSituation extends AppCompatActivity {
    private List<CheckBox> checkBoxList0 = new ArrayList<CheckBox>();
    private List<CheckBox> checkBoxList1 = new ArrayList<CheckBox>();
    private List<CheckBox> checkBoxList2 = new ArrayList<CheckBox>();
    private List<CheckBox> checkBoxList3 = new ArrayList<CheckBox>();
    private List<CheckBox> checkBoxList4 = new ArrayList<CheckBox>();
    private List<CheckBox> checkBoxList5 = new ArrayList<CheckBox>();
    private List<CheckBox> checkBoxList6 = new ArrayList<CheckBox>();

    private List<CheckBox> checkBoxList9= new ArrayList<CheckBox>();
    private List<CheckBox> checkBoxList10 = new ArrayList<CheckBox>();
    private List<CheckBox> checkBoxList11 = new ArrayList<CheckBox>();
    String a,b,c,grille_radio,data_grille,cabinet_radio,data_cabinet,graught_radio,data_graught,pump_radio,data_pump,huiliu_radio,data_huiliu,
    flow_radio,data_flow,famen2_radio,data_famen2,house_radio,data_house,liquid_radio,data_liquid,billboard_radio,data_billboard,monitor_radio,data_monitor,
    mbr_radio,data_mbr;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.device_situation);
        Button device_situation_tijiao=findViewById(R.id.device_situation_tijiao);
        final EditText other_device_situation = (EditText)findViewById(R.id.other_device_situation);
        final EditText leiji_flow    = (EditText) findViewById(R.id.leiji_flow);
        final EditText shunshi_flow    = (EditText) findViewById(R.id.shunshi_flow);
        final CheckBox appearance_good      = (CheckBox) findViewById(R.id.appearance_good);
        final CheckBox appearance_bad     = (CheckBox) findViewById(R.id.appearance_bad);
        final CheckBox cleaning          = (CheckBox) findViewById(R.id.cleaning);
        final CheckBox other_grille     = (CheckBox) findViewById(R.id.other_grille);//1
        final CheckBox normal_cabinet    = (CheckBox) findViewById(R.id.normal_cabinet);
        final CheckBox appearance_bad1    = (CheckBox) findViewById(R.id.appearance_bad1);
        final CheckBox no_button         = (CheckBox) findViewById(R.id.no_button);
        final CheckBox no_obvious        = (CheckBox) findViewById(R.id.no_obvious);
        final CheckBox yuanjian_abnormal = (CheckBox) findViewById(R.id. yuanjian_abnormal);
        final CheckBox irregular          = (CheckBox) findViewById(R.id.irregular);
        final CheckBox other_cabinet     = (CheckBox) findViewById(R.id.other_cabinet);//2
        final CheckBox normal_graught     = (CheckBox) findViewById(R.id.normal_graught);
        final CheckBox abnormal        = (CheckBox) findViewById(R.id.abnormal);
        final CheckBox not_steady     = (CheckBox) findViewById(R.id.not_steady);
        final CheckBox fan_abnormal          = (CheckBox) findViewById(R.id.fan_abnormal);
        final CheckBox over_hot       = (CheckBox) findViewById(R.id.over_hot);
        final CheckBox pipe_break    =(CheckBox)findViewById(R.id.pipe_break);
        final CheckBox no_work        = (CheckBox) findViewById(R.id.no_work);
        final CheckBox other_graught      = (CheckBox) findViewById(R.id.other_graught);//3
        final CheckBox normal__pump     = (CheckBox) findViewById(R.id.normal_pump);
        final CheckBox no_steady     = (CheckBox) findViewById(R.id.no_steady);
        final CheckBox block_noise       = (CheckBox) findViewById(R.id.block_noise);
        final CheckBox dirty          = (CheckBox) findViewById(R.id.dirty);
        final CheckBox no_work_pump      =(CheckBox)findViewById(R.id.no_work_pump);
        final CheckBox other_pump       = (CheckBox) findViewById(R.id.other_pump);//4
        final CheckBox normal_huiliu      = (CheckBox) findViewById(R.id.normal_huiliu);
        final CheckBox no_steay_huiliu     = (CheckBox) findViewById(R.id.no_steady_huiliu);
        final CheckBox block_noise_huiliu    = (CheckBox) findViewById(R.id.block_noise_huiliu);
        final CheckBox dirty_danger_huiliu     = (CheckBox) findViewById(R.id.dirty_danger_huiliu);
        final CheckBox no_work_huiliu      = (CheckBox) findViewById(R.id.no_work_huiliu);
        final CheckBox other_huiliu        = (CheckBox) findViewById(R.id.other_huiliu);//5
        final CheckBox normal_flowmeter        = (CheckBox) findViewById(R.id.normal_flowmeter);
        final CheckBox no_steady2       = (CheckBox) findViewById(R.id.no_steady2);
        final CheckBox obnormal2        = (CheckBox) findViewById(R.id.obnormal2);
        final CheckBox dirty2             = (CheckBox) findViewById(R.id.dirty2);
        final CheckBox other4              = (CheckBox) findViewById(R.id.other4);//6
        final CheckBox pump_famen_good           = (CheckBox) findViewById(R.id.pump_famen_good);
        final CheckBox pump_famen_posun        = (CheckBox) findViewById(R.id.pump_famen_posun);
        final CheckBox no_whirl            = (CheckBox) findViewById(R.id.no_whirl);
        final CheckBox other_pump_famen          = (CheckBox) findViewById(R.id.other_pump_famen);//7
        final CheckBox billboard_good         = (CheckBox) findViewById(R.id.billboard_good);
        final CheckBox word_not_claer            = (CheckBox) findViewById(R.id.word_not_claer);
        final CheckBox not_solid     = (CheckBox) findViewById(R.id.not_solid);
        final CheckBox tilt            = (CheckBox) findViewById(R.id.tilt);
        final CheckBox change          = (CheckBox) findViewById(R.id.change);//10
        final CheckBox monitor_good           = (CheckBox) findViewById(R.id.monitor_good);
        final CheckBox monitor_bad         = (CheckBox) findViewById(R.id.monitor_bad);
        final CheckBox  silt_serious        = (CheckBox) findViewById(R.id. silt_serious);//11
        final CheckBox mbr_good        = (CheckBox) findViewById(R.id.mbr_good);
        final CheckBox mbr_blocking        = (CheckBox) findViewById(R.id.mbr_blocking);
        final CheckBox need_replace            = (CheckBox) findViewById(R.id.need_replace);
        final CheckBox other_mbr        = (CheckBox) findViewById(R.id.other_mbr);//12

        checkBoxList0.add(appearance_good  );
        checkBoxList0.add(appearance_bad    )    ;
        checkBoxList0.add(cleaning             );
        checkBoxList0.add(other_grille );

        checkBoxList1.add(normal_cabinet   );
        checkBoxList1.add(appearance_bad1  );
        checkBoxList1.add(no_button        );
        checkBoxList1.add(no_obvious       );
        checkBoxList1.add(yuanjian_abnormal);
        checkBoxList1.add(irregular        );
        checkBoxList1.add(other_cabinet     );


        checkBoxList2.add(normal_graught );
        checkBoxList2.add(abnormal       );
        checkBoxList2.add(not_steady     );
        checkBoxList2.add(fan_abnormal   );
        checkBoxList2.add(over_hot       );
        checkBoxList2.add(pipe_break     );
        checkBoxList2.add(no_work       );
        checkBoxList2.add(other_graught );

        checkBoxList3.add(normal__pump  );
        checkBoxList3.add(no_steady     );
        checkBoxList3.add(block_noise   );
        checkBoxList3.add(dirty         );
        checkBoxList3.add(no_work_pump  );
        checkBoxList3.add(other_pump     );

        checkBoxList4.add(normal_huiliu      );
        checkBoxList4.add(no_steay_huiliu    );
        checkBoxList4.add(block_noise_huiliu );
        checkBoxList4.add(dirty_danger_huiliu);
        checkBoxList4.add(no_work_huiliu     );
        checkBoxList4.add(other_huiliu       );

        checkBoxList5.add(normal_flowmeter );
        checkBoxList5.add(no_steady2       );
        checkBoxList5.add(obnormal2        );
        checkBoxList5.add(dirty2           );
        checkBoxList5.add(other4           );

        checkBoxList6.add( pump_famen_good   );
        checkBoxList6.add( pump_famen_posun  );
        checkBoxList6.add( no_whirl          );
        checkBoxList6.add( other_pump_famen  );

        checkBoxList9.add(billboard_good);
        checkBoxList9.add(word_not_claer);
        checkBoxList9.add(not_solid     );
        checkBoxList9.add(tilt          );
        checkBoxList9.add(change        );

        checkBoxList10.add(monitor_good   );
        checkBoxList10.add(monitor_bad    );
        checkBoxList10.add( silt_serious  );

        checkBoxList11.add(mbr_good         );
        checkBoxList11.add(mbr_blocking     );
        checkBoxList11.add(need_replace     );
        checkBoxList11.add(other_mbr        );


        final RadioGroup RadioGroup1 = (RadioGroup) findViewById(R.id.radio_grille);
        final RadioGroup RadioGroup2 = (RadioGroup) findViewById(R.id.radio_cabinet);
        final RadioGroup RadioGroup3 = (RadioGroup) findViewById(R.id.radio_graught);
        final RadioGroup RadioGroup4 = (RadioGroup) findViewById(R.id.radio_pump);
        final RadioGroup RadioGroup5= (RadioGroup) findViewById(R.id.radio_huiliu);
        final RadioGroup RadioGroup6 = (RadioGroup) findViewById(R.id.radio_flowmeter);
        final RadioGroup RadioGroup7 = (RadioGroup) findViewById(R.id.radio_pump_famen);
        final RadioGroup RadioGroup8 = (RadioGroup) findViewById(R.id.radio_control_house);
        final RadioGroup RadioGroup9= (RadioGroup) findViewById(R.id.radio_liquid);
        final RadioGroup RadioGroup10 = (RadioGroup) findViewById(R.id.radio_billboard);
        final RadioGroup RadioGroup11 = (RadioGroup) findViewById(R.id.radio_monitor);
        final RadioGroup RadioGroup12 = (RadioGroup) findViewById(R.id.radio_mbr);
        final RadioGroup RadioGroup13 = (RadioGroup) findViewById(R.id.radio_house);
        final RadioGroup RadioGroup14 = (RadioGroup) findViewById(R.id.radio_abormal);
        device_situation_tijiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a= String.valueOf(other_device_situation.getText());
                b= String.valueOf(leiji_flow .getText());
                c=String.valueOf(shunshi_flow .getText());
                StringBuffer gl0 = new StringBuffer();
                StringBuffer gl1 = new StringBuffer();
                StringBuffer gl2 = new StringBuffer();
                StringBuffer gl3 = new StringBuffer();
                StringBuffer gl4 = new StringBuffer();
                StringBuffer gl5 = new StringBuffer();
                StringBuffer gl6 = new StringBuffer();
                StringBuffer gl7 = new StringBuffer();
                StringBuffer gl8 = new StringBuffer();
                StringBuffer gl9= new StringBuffer();
                StringBuffer gl10 = new StringBuffer();
                StringBuffer gl11= new StringBuffer();
                StringBuffer gl12 = new StringBuffer();
                StringBuffer gl13 = new StringBuffer();
                //格栅
                for (int i = 0; i < RadioGroup1.getChildCount(); i++) {
                    RadioButton radioButton = (RadioButton) RadioGroup1.getChildAt(i);
                    if (radioButton.isChecked()) {
                        //                        dx.append(radioButton.getText().toString() + " ");
//                        Log.i("tag", "lsn 单选按钮，您的天气是：" + radioButton.getText());
                        grille_radio = radioButton.getText().toString();
                    }
                }
                Log.d("==gyn==",grille_radio);
                if (grille_radio.equals("有")){
//                        Log.d("==gyn==","输入有后运行");
                    for (CheckBox checkbox : checkBoxList0) {
                        if (checkbox.isChecked()){
//                        Log.d("gyn","sb:"+checkbox.getText().toString());
                            gl0.append(checkbox.getText().toString() + " ");
//                        Toast.makeText(OtherDevice.this,"提交成功",Toast.LENGTH_LONG).show();
                        }
                    }
//                Log.d("gyn","sb=======:"+sb.toString());
                    if (gl0!=null && "".equals(gl0.toString())){
                        Toast.makeText(getApplicationContext(), "格栅请至少选择一个", Toast.LENGTH_SHORT).show();
                    }else{
//                    Toast.makeText(getApplicationContext(), sb_pipe.toString(), Toast.LENGTH_SHORT).show();
                    }
                }else if(grille_radio.equals("无")){
                    gl0.append("无");
                }

                data_grille = gl0.toString();
                Log.d("==gyn==",data_grille);

                //控制柜
                for (int i = 0; i < RadioGroup2.getChildCount(); i++) {
                    RadioButton radioButton = (RadioButton) RadioGroup2.getChildAt(i);
                    if (radioButton.isChecked()) {
                        //                        dx.append(radioButton.getText().toString() + " ");
//                        Log.i("tag", "lsn 单选按钮，您的天气是：" + radioButton.getText());
                        cabinet_radio = radioButton.getText().toString();
                    }
                }
                Log.d("==gyn==",cabinet_radio);
                if (cabinet_radio.equals("有")){
//                        Log.d("==gyn==","输入有后运行");
                    for (CheckBox checkbox : checkBoxList1) {
                        if (checkbox.isChecked()){
//                        Log.d("gyn","sb:"+checkbox.getText().toString());
                            gl1.append(checkbox.getText().toString() + " ");
//                        Toast.makeText(OtherDevice.this,"提交成功",Toast.LENGTH_LONG).show();
                        }
                    }
//                Log.d("gyn","sb=======:"+sb.toString());
                    if (gl1!=null && "".equals(gl1.toString())){
                        Toast.makeText(getApplicationContext(), "控制柜请至少选择一个", Toast.LENGTH_SHORT).show();
                    }else{
//                    Toast.makeText(getApplicationContext(), sb_pipe.toString(), Toast.LENGTH_SHORT).show();
                    }
                }else if(cabinet_radio.equals("无")){
                    gl1.append("无");
                }

                data_cabinet = gl1.toString();
                Log.d("==gyn==",data_cabinet);

                //风机
                for (int i = 0; i < RadioGroup3.getChildCount(); i++) {
                    RadioButton radioButton = (RadioButton) RadioGroup3.getChildAt(i);
                    if (radioButton.isChecked()) {
                        //                        dx.append(radioButton.getText().toString() + " ");
//                        Log.i("tag", "lsn 单选按钮，您的天气是：" + radioButton.getText());
                        graught_radio = radioButton.getText().toString();
                    }
                }
                Log.d("==gyn==",graught_radio);
                if (graught_radio.equals("有")){
//                        Log.d("==gyn==","输入有后运行");
                    for (CheckBox checkbox : checkBoxList2) {
                        if (checkbox.isChecked()){
//                        Log.d("gyn","sb:"+checkbox.getText().toString());
                            gl2.append(checkbox.getText().toString() + " ");
//                        Toast.makeText(OtherDevice.this,"提交成功",Toast.LENGTH_LONG).show();
                        }
                    }
//                Log.d("gyn","sb=======:"+sb.toString());
                    if (gl2!=null && "".equals(gl2.toString())){
                        Toast.makeText(getApplicationContext(), "风机请至少选择一个", Toast.LENGTH_SHORT).show();
                    }else{
//                    Toast.makeText(getApplicationContext(), sb_pipe.toString(), Toast.LENGTH_SHORT).show();
                    }
                }else if(graught_radio.equals("无")){
                    gl2.append("无");
                }

                data_graught = gl2.toString();
                Log.d("==gyn==",data_graught);


                //提升泵

                for (int i = 0; i < RadioGroup4.getChildCount(); i++) {
                    RadioButton radioButton = (RadioButton) RadioGroup4.getChildAt(i);
                    if (radioButton.isChecked()) {
                        //                        dx.append(radioButton.getText().toString() + " ");
//                        Log.i("tag", "lsn 单选按钮，您的天气是：" + radioButton.getText());
                        pump_radio = radioButton.getText().toString();
                    }
                }
                Log.d("==gyn==",pump_radio);
                if (pump_radio.equals("有")){
//                        Log.d("==gyn==","输入有后运行");
                    for (CheckBox checkbox : checkBoxList3) {
                        if (checkbox.isChecked()){
//                        Log.d("gyn","sb:"+checkbox.getText().toString());
                            gl3.append(checkbox.getText().toString() + " ");
//                        Toast.makeText(OtherDevice.this,"提交成功",Toast.LENGTH_LONG).show();
                        }
                    }
//                Log.d("gyn","sb=======:"+sb.toString());
                    if (gl3!=null && "".equals(gl3.toString())){
                        Toast.makeText(getApplicationContext(), "提升泵请至少选择一个", Toast.LENGTH_SHORT).show();
                    }else{
//                    Toast.makeText(getApplicationContext(), sb_pipe.toString(), Toast.LENGTH_SHORT).show();
                    }
                }else if(pump_radio.equals("无")){
                    gl3.append("无");
                }

                data_pump = gl3.toString();
                Log.d("==gyn==",data_pump);

                //回流泵
                for (int i = 0; i < RadioGroup5.getChildCount(); i++) {
                    RadioButton radioButton = (RadioButton) RadioGroup5.getChildAt(i);
                    if (radioButton.isChecked()) {
                        //                        dx.append(radioButton.getText().toString() + " ");
//                        Log.i("tag", "lsn 单选按钮，您的天气是：" + radioButton.getText());
                        huiliu_radio = radioButton.getText().toString();
                    }
                }
                Log.d("==gyn==",huiliu_radio);
                if (huiliu_radio.equals("有")){
//                        Log.d("==gyn==","输入有后运行");
                    for (CheckBox checkbox : checkBoxList4) {
                        if (checkbox.isChecked()){
//                        Log.d("gyn","sb:"+checkbox.getText().toString());
                            gl4.append(checkbox.getText().toString() + " ");
//                        Toast.makeText(OtherDevice.this,"提交成功",Toast.LENGTH_LONG).show();
                        }
                    }
//                Log.d("gyn","sb=======:"+sb.toString());
                    if (gl4!=null && "".equals(gl4.toString())){
                        Toast.makeText(getApplicationContext(), "回流泵请至少选择一个", Toast.LENGTH_SHORT).show();
                    }else{
//                    Toast.makeText(getApplicationContext(), sb_pipe.toString(), Toast.LENGTH_SHORT).show();
                    }
                }else if(huiliu_radio.equals("无")){
                    gl4.append("无");
                }

                data_huiliu= gl4.toString();
                Log.d("==gyn==",data_huiliu);

                //流量计
                for (int i = 0; i < RadioGroup6.getChildCount(); i++) {
                    RadioButton radioButton = (RadioButton) RadioGroup6.getChildAt(i);
                    if (radioButton.isChecked()) {
                        //                        dx.append(radioButton.getText().toString() + " ");
//                        Log.i("tag", "lsn 单选按钮，您的天气是：" + radioButton.getText());
                       flow_radio = radioButton.getText().toString();
                    }
                }
                Log.d("==gyn==",flow_radio);
                if (flow_radio.equals("有")){
//                        Log.d("==gyn==","输入有后运行");
                    for (CheckBox checkbox : checkBoxList5) {
                        if (checkbox.isChecked()){
//                        Log.d("gyn","sb:"+checkbox.getText().toString());
                            gl5.append(checkbox.getText().toString() + " ");
//                        Toast.makeText(OtherDevice.this,"提交成功",Toast.LENGTH_LONG).show();
                        }
                    }
//                Log.d("gyn","sb=======:"+sb.toString());
                    if (gl5!=null && "".equals(gl5.toString())){
                        Toast.makeText(getApplicationContext(), "流量计请至少选择一个", Toast.LENGTH_SHORT).show();
                    }else{
//                    Toast.makeText(getApplicationContext(), sb_pipe.toString(), Toast.LENGTH_SHORT).show();
                    }
                }else if(flow_radio.equals("无")){
                    gl5.append("无");
                }

                data_flow= gl5.toString();
                Log.d("==gyn==",data_flow);

                //管道及阀门

                for (int i = 0; i < RadioGroup7.getChildCount(); i++) {
                    RadioButton radioButton = (RadioButton) RadioGroup7.getChildAt(i);
                    if (radioButton.isChecked()) {
                        //                        dx.append(radioButton.getText().toString() + " ");
//                        Log.i("tag", "lsn 单选按钮，您的天气是：" + radioButton.getText());
                        famen2_radio = radioButton.getText().toString();
                    }
                }
                Log.d("==gyn==",famen2_radio);
                if (famen2_radio.equals("有")){
//                        Log.d("==gyn==","输入有后运行");
                    for (CheckBox checkbox : checkBoxList6) {
                        if (checkbox.isChecked()){
//                        Log.d("gyn","sb:"+checkbox.getText().toString());
                            gl6.append(checkbox.getText().toString() + " ");
//                        Toast.makeText(OtherDevice.this,"提交成功",Toast.LENGTH_LONG).show();
                        }
                    }
//                Log.d("gyn","sb=======:"+sb.toString());
                    if (gl6!=null && "".equals(gl6.toString())){
                        Toast.makeText(getApplicationContext(), "管道及阀门请至少选择一个", Toast.LENGTH_SHORT).show();
                    }else{
//                    Toast.makeText(getApplicationContext(), sb_pipe.toString(), Toast.LENGTH_SHORT).show();
                    }
                }else if(famen2_radio.equals("无")){
                    gl6.append("无");
                }

                data_famen2= gl6.toString();
                Log.d("==gyn==",data_famen2);

                //控制房

                for (int i = 0; i < RadioGroup8.getChildCount(); i++) {
                    RadioButton radioButton = (RadioButton) RadioGroup8.getChildAt(i);
                    if (radioButton.isChecked()) {
                        //                        dx.append(radioButton.getText().toString() + " ");
//                        Log.i("tag", "lsn 单选按钮，您的天气是：" + radioButton.getText());
                        house_radio = radioButton.getText().toString();
                    }
                }
                Log.d("==gyn==",house_radio);
                if (famen2_radio.equals("有")){
//                        Log.d("==gyn==","输入有后运行");
                    for (int i = 0; i < RadioGroup13.getChildCount(); i++) {
                        RadioButton radioButton = (RadioButton) RadioGroup13.getChildAt(i);
                        if (radioButton.isChecked()) {
                            //                        dx.append(radioButton.getText().toString() + " ");
                            Log.i("tag", "：" + radioButton.getText());
                            data_house = radioButton.getText().toString();
                        }

                    }
//                Log.d("gyn","sb=======:"+sb.toString());
                }else if(house_radio.equals("无")){
                    gl7.append("无");
                }

                data_house= gl7.toString();
                Log.d("==gyn==",data_house);

                //液位控制系统
                for (int i = 0; i < RadioGroup9.getChildCount(); i++) {
                    RadioButton radioButton = (RadioButton) RadioGroup9.getChildAt(i);
                    if (radioButton.isChecked()) {
                        //                        dx.append(radioButton.getText().toString() + " ");
//                        Log.i("tag", "lsn 单选按钮，您的天气是：" + radioButton.getText());
                        liquid_radio = radioButton.getText().toString();
                    }
                }
                Log.d("==gyn==",liquid_radio);
                if (liquid_radio.equals("有")){
//                        Log.d("==gyn==","输入有后运行");
                    for (int i = 0; i < RadioGroup14.getChildCount(); i++) {
                        RadioButton radioButton = (RadioButton) RadioGroup14.getChildAt(i);
                        if (radioButton.isChecked()) {
                            //                        dx.append(radioButton.getText().toString() + " ");
                            Log.i("tag", "：" + radioButton.getText());
                            data_liquid = radioButton.getText().toString();
                        }

                    }
//                Log.d("gyn","sb=======:"+sb.toString());
                }else if(liquid_radio.equals("无")){
                    gl8.append("无");
                }

                data_liquid= gl8.toString();
                Log.d("==gyn==",data_liquid);

                //告示牌

                for (int i = 0; i < RadioGroup10.getChildCount(); i++) {
                    RadioButton radioButton = (RadioButton) RadioGroup10.getChildAt(i);
                    if (radioButton.isChecked()) {
                        //                        dx.append(radioButton.getText().toString() + " ");
//                        Log.i("tag", "lsn 单选按钮，您的天气是：" + radioButton.getText());
                        billboard_radio = radioButton.getText().toString();
                    }
                }
                Log.d("==gyn==",billboard_radio);
                if (billboard_radio.equals("有")){
//                        Log.d("==gyn==","输入有后运行");
                    for (CheckBox checkbox : checkBoxList9) {
                        if (checkbox.isChecked()){
//                        Log.d("gyn","sb:"+checkbox.getText().toString());
                            gl9.append(checkbox.getText().toString() + " ");
//                        Toast.makeText(OtherDevice.this,"提交成功",Toast.LENGTH_LONG).show();
                        }
                    }
//                Log.d("gyn","sb=======:"+sb.toString());
                    if (gl9!=null && "".equals(gl9.toString())){
                        Toast.makeText(getApplicationContext(), "告示牌请至少选择一个", Toast.LENGTH_SHORT).show();
                    }else{
//                    Toast.makeText(getApplicationContext(), sb_pipe.toString(), Toast.LENGTH_SHORT).show();
                    }
                }else if(billboard_radio.equals("无")){
                    gl9.append("无");
                }

                data_billboard= gl9.toString();
                Log.d("==gyn==",data_billboard);

                //在线监控设备
                for (int i = 0; i < RadioGroup11.getChildCount(); i++) {
                    RadioButton radioButton = (RadioButton) RadioGroup11.getChildAt(i);
                    if (radioButton.isChecked()) {
                        //                        dx.append(radioButton.getText().toString() + " ");
//                        Log.i("tag", "lsn 单选按钮，您的天气是：" + radioButton.getText());
                        monitor_radio = radioButton.getText().toString();
                    }
                }
                Log.d("==gyn==",monitor_radio);
                if (monitor_radio.equals("有")){
//                        Log.d("==gyn==","输入有后运行");
                    for (CheckBox checkbox : checkBoxList10) {
                        if (checkbox.isChecked()){
//                        Log.d("gyn","sb:"+checkbox.getText().toString());
                            gl10.append(checkbox.getText().toString() + " ");
//                        Toast.makeText(OtherDevice.this,"提交成功",Toast.LENGTH_LONG).show();
                        }
                    }
//                Log.d("gyn","sb=======:"+sb.toString());
                    if (gl10!=null && "".equals(gl10.toString())){
                        Toast.makeText(getApplicationContext(), "在线监控设备请至少选择一个", Toast.LENGTH_SHORT).show();
                    }else{
//                    Toast.makeText(getApplicationContext(), sb_pipe.toString(), Toast.LENGTH_SHORT).show();
                    }
                }else if(monitor_radio.equals("无")){
                    gl10.append("无");
                }

                data_monitor= gl10.toString();
                Log.d("==gyn==",data_monitor);

                //MBR膜

                for (int i = 0; i < RadioGroup12.getChildCount(); i++) {
                    RadioButton radioButton = (RadioButton) RadioGroup12.getChildAt(i);
                    if (radioButton.isChecked()) {
                        //                        dx.append(radioButton.getText().toString() + " ");
//                        Log.i("tag", "lsn 单选按钮，您的天气是：" + radioButton.getText());
                        mbr_radio = radioButton.getText().toString();
                    }
                }
                Log.d("==gyn==",mbr_radio);
                if (mbr_radio.equals("有")){
//                        Log.d("==gyn==","输入有后运行");
                    for (CheckBox checkbox : checkBoxList11) {
                        if (checkbox.isChecked()){
//                        Log.d("gyn","sb:"+checkbox.getText().toString());
                            gl11.append(checkbox.getText().toString() + " ");
//                        Toast.makeText(OtherDevice.this,"提交成功",Toast.LENGTH_LONG).show();
                        }
                    }
//                Log.d("gyn","sb=======:"+sb.toString());
                    if (gl11!=null && "".equals(gl11.toString())){
                        Toast.makeText(getApplicationContext(), "MBR膜请至少选择一个", Toast.LENGTH_SHORT).show();
                    }else{
//                    Toast.makeText(getApplicationContext(), sb_pipe.toString(), Toast.LENGTH_SHORT).show();
                    }
                }else if(mbr_radio.equals("无")){
                    gl11.append("无");
                }

                data_mbr= gl11.toString();
                Log.d("==gyn==",data_mbr);
                postDataDiaocha(v);


            }

        });


    }
    private void postDataDiaocha(View v) {
        OkHttpClient client = new OkHttpClient();//创建OkHttpClient对象。
        MediaType JSON = MediaType.parse("application/json; charset=utf-8");//数据类型为json格式，
        String jsonStr = "{\"格栅\":" + "\"" +data_grille+ "\",\"控制柜\":\"" +data_cabinet+ "\"," +
                "\"风机\":" + "\"" +data_graught+ "\",\"提升泵\":" + "\"" + data_pump + "\",\"回流泵\":\"" + data_huiliu + "\"," +
                "\"流量计\":\"" + data_flow+ "\"," + "\"累计流量读数\":\""+b+"\",\"瞬时流量读数\":\""+c+"\",\"管道及阀门\":\"" + data_famen2 + "\"," +
                "\"控制房\":\"" +famen2_radio + "\"," + "\"好或坏\":\"" +data_house + "\"," + "\"液位控制系统\":\"" +liquid_radio + "\"," +
                "\"是否正常\":\"" + data_liquid + "\"," + "\"告示牌\":\"" +data_billboard+ "\",\"在线监控设备\":\"" + data_monitor+ "\"," +
                "\"MBR膜\":\"" +data_mbr + "\"," + "\"其他设备\":\"" +a+ "\"}";//json数据.\
        Log.e("11", "==============jsonStr=" + jsonStr);
        RequestBody body = RequestBody.create(JSON, jsonStr);
        Request request = new Request.Builder()
                .url("http://192.168.1.110:1803/device_tijiao")
                .post(body)
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.e("==", "==========response=" + response.toString());
                if (response.isSuccessful()) {//回调的方法执行在子线程。
                    Log.d("kwwl", "获取数据成功了");
                    Log.d("kwwl", "response.code()==" + response.code());
                    Log.d("kwwl", "response.body().string()==" + response.body().string());
                } else {
                    Log.d("kwwl", "========false==========");
                }
            }
        });
    }
}
