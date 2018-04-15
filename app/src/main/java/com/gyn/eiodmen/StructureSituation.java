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

public class StructureSituation extends AppCompatActivity {
    private List<CheckBox> checkBoxList0 = new ArrayList<CheckBox>();
    private List<CheckBox> checkBoxList1 = new ArrayList<CheckBox>();
    private List<CheckBox> checkBoxList2 = new ArrayList<CheckBox>();
    private List<CheckBox> checkBoxList3 = new ArrayList<CheckBox>();
    private List<CheckBox> checkBoxList4 = new ArrayList<CheckBox>();
    private List<CheckBox> checkBoxList5 = new ArrayList<CheckBox>();
    private List<CheckBox> checkBoxList6 = new ArrayList<CheckBox>();
    private List<CheckBox> checkBoxList7 = new ArrayList<CheckBox>();
    private List<CheckBox> checkBoxList8= new ArrayList<CheckBox>();
    private List<CheckBox> checkBoxList9= new ArrayList<CheckBox>();
    private List<CheckBox> checkBoxList10 = new ArrayList<CheckBox>();
    String a,b,jishui_radio,data_jinshui,chuchen_radio,data_chuchen,yanjiang_radio,data_yanjiang,
    haoyang_radio,data_haoyang,chendian_radio,data_chendian,shidi_radio,data_shidi,chushui_radio,
    data_chushui,site_radio,data_site,fence_radio,data_fence,wellhead_radio,data_wellhead,famen_radio,
    data_famen,mbr_radio,data_mbr,manshui_radio,data_manshui,dusai_radio,data_dusai,plant_radio,data_plant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.structure_situation);
        Button structure_situation_tijiao= findViewById(R.id.structure_situation_tijiao);
        final EditText other_sheshi    = (EditText) findViewById(R.id.other_sheshi);
        final EditText other_quest_shidi    = (EditText) findViewById(R.id.other_quest_shidi);
        final CheckBox jishui_good      = (CheckBox) findViewById(R.id.jishui_good);
        final CheckBox jishui_silt     = (CheckBox) findViewById(R.id.jishui_silt);
        final CheckBox piaofu          = (CheckBox) findViewById(R.id.piaofu);
        final CheckBox jishui_leaking  = (CheckBox) findViewById(R.id.jishui_leaking);//1
        final CheckBox chuchen_good    = (CheckBox) findViewById(R.id.chuchen_good);
        final CheckBox chuchen_silt    = (CheckBox) findViewById(R.id.chuchen_silt);
        final CheckBox chuchen_piaofu  = (CheckBox) findViewById(R.id.chuchen_piaofu);
        final CheckBox chuchen_leaking = (CheckBox) findViewById(R.id.chuchen_leaking);
        final CheckBox chushen_water_io = (CheckBox) findViewById(R.id. chuchen_water_io);
        final CheckBox other_chuchen    = (CheckBox) findViewById(R.id.other_chuchen);//2
        final CheckBox yanjian_good      = (CheckBox) findViewById(R.id.yanjian_good);
        final CheckBox yanjian_silt      = (CheckBox) findViewById(R.id.yanjian_silt);
        final CheckBox yanjian_piaofu     = (CheckBox) findViewById(R.id.yanjian_piaofu);
        final CheckBox yanjian_leaking    = (CheckBox) findViewById(R.id.yanjian_leaking);
        final CheckBox tianliao           = (CheckBox) findViewById(R.id.tianliao);
        final CheckBox yanjian_water_io  = (CheckBox) findViewById(R.id.yanjian_water_io);
        final CheckBox other_yanjian    =(CheckBox)findViewById(R.id.other_yanjian);//3
        final CheckBox haoyang_good     = (CheckBox) findViewById(R.id.haoyang_good);
        final CheckBox haoyang_silt      = (CheckBox) findViewById(R.id.haoyang_silt);
        final CheckBox haoyang_piaofu     = (CheckBox) findViewById(R.id.haoyang_piaofu);
        final CheckBox haoyang_leaking     = (CheckBox) findViewById(R.id.haoyang_leaking);
        final CheckBox haoyang_baoqi       = (CheckBox) findViewById(R.id.haoyang_baoqi);
        final CheckBox haoyang_water_io    = (CheckBox) findViewById(R.id.haoyang_water_io);
        final CheckBox other_haoyang      =(CheckBox)findViewById(R.id.other_haoyang);//4
        final CheckBox chendian_good       = (CheckBox) findViewById(R.id.chendian_good);
        final CheckBox chendian_silt      = (CheckBox) findViewById(R.id.chendian_silt);
        final CheckBox chendian_piaofu     = (CheckBox) findViewById(R.id.chendian_piaofu);
        final CheckBox chendian_leaking    = (CheckBox) findViewById(R.id.chendian_leaking);
        final CheckBox chendian_water_io     = (CheckBox) findViewById(R.id.chendian_water_io);
        final CheckBox other_chendian      = (CheckBox) findViewById(R.id.other_chendian);//5
        final CheckBox chushui_good        = (CheckBox) findViewById(R.id.chushui_good);
        final CheckBox chushui_silt        = (CheckBox) findViewById(R.id.chushui_silt);
        final CheckBox chushui_piaofu      = (CheckBox) findViewById(R.id.chushui_piaofu);
        final CheckBox chushui_leaking      = (CheckBox) findViewById(R.id.chushui_leaking);
        final CheckBox chushui_water_io    = (CheckBox) findViewById(R.id.chushui_water_io);
        final CheckBox other_chushui       = (CheckBox) findViewById(R.id.other_chushui);//6
        final CheckBox site_good           = (CheckBox) findViewById(R.id.site_good);
        final CheckBox site_general        = (CheckBox) findViewById(R.id.site_general);
        final CheckBox site_bad            = (CheckBox) findViewById(R.id.site_bad);
        final CheckBox site_lvhua          = (CheckBox) findViewById(R.id.site_lvhua);//7
        final CheckBox fence_good           = (CheckBox) findViewById(R.id.fence_good);
        final CheckBox fence_bad            = (CheckBox) findViewById(R.id.fence_bad);
        final CheckBox fence_conservation     = (CheckBox) findViewById(R.id.fence_conservation);
        final CheckBox other_fence            = (CheckBox) findViewById(R.id.other_fence);//8
        final CheckBox wellhead_good          = (CheckBox) findViewById(R.id.wellhead_good);
        final CheckBox wellhead_bad           = (CheckBox) findViewById(R.id.wellhead_bad);
        final CheckBox wellhead_change         = (CheckBox) findViewById(R.id.wellhead_change);
        final CheckBox  other_wellhead        = (CheckBox) findViewById(R.id. other_wellhead);//9
        final CheckBox famen_well_good        = (CheckBox) findViewById(R.id.famen_well_good);
        final CheckBox famen_well_bad        = (CheckBox) findViewById(R.id.famen_well_bad);
        final CheckBox well_debris            = (CheckBox) findViewById(R.id.well_debris);
        final CheckBox other_famen_well        = (CheckBox) findViewById(R.id.other_famen_well);//10
        final CheckBox mbr_fan_good            = (CheckBox) findViewById(R.id.mbr_fan_good);
        final CheckBox mbr_fan_weixiu         = (CheckBox) findViewById(R.id.mbr_fan_weixiu);
        final CheckBox mbr_fan_bad           = (CheckBox) findViewById(R.id.mbr_fan_bad);
        final CheckBox mbr_fan_change       = (CheckBox) findViewById(R.id.mbr_fan_change);
        final CheckBox other_mbr_fan        = (CheckBox) findViewById(R.id.other_mbr_fan);//11
        checkBoxList0.add(jishui_good);
        checkBoxList0.add(jishui_silt )    ;
        checkBoxList0.add(piaofu         );
        checkBoxList0.add(jishui_leaking );
        checkBoxList1.add(chuchen_good    );
        checkBoxList1.add(chuchen_silt    );
        checkBoxList1.add(chuchen_piaofu  );
        checkBoxList1.add(chuchen_leaking );
        checkBoxList1.add(chushen_water_io);
        checkBoxList1.add(other_chuchen   );

        checkBoxList2.add(yanjian_good     );
        checkBoxList2.add(yanjian_silt     );
        checkBoxList2.add(yanjian_piaofu   );
        checkBoxList2.add(yanjian_leaking  );
        checkBoxList2.add(tianliao         );
        checkBoxList2.add(yanjian_water_io );
        checkBoxList2.add(other_yanjian    );

        checkBoxList3.add(haoyang_good    );
        checkBoxList3.add(haoyang_silt    );
        checkBoxList3.add(haoyang_piaofu  );
        checkBoxList3.add(haoyang_leaking );
        checkBoxList3.add(haoyang_baoqi   );
        checkBoxList3.add(haoyang_water_io);
        checkBoxList3.add(other_haoyang   );

        checkBoxList4.add(chendian_good    );
        checkBoxList4.add(chendian_silt    );
        checkBoxList4.add(chendian_piaofu  );
        checkBoxList4.add(chendian_leaking );
        checkBoxList4.add(chendian_water_io);
        checkBoxList4.add(other_chendian   );

        checkBoxList5.add(chushui_good     );
        checkBoxList5.add(chushui_silt     );
        checkBoxList5.add(chushui_piaofu   );
        checkBoxList5.add(chushui_leaking  );
        checkBoxList5.add(chushui_water_io );
        checkBoxList5.add(other_chushui    );

        checkBoxList6.add(site_good    );
        checkBoxList6.add(site_general );
        checkBoxList6.add(site_bad     );
        checkBoxList6.add(site_lvhua   );

        checkBoxList7.add(fence_good        );
        checkBoxList7.add(fence_bad         );
        checkBoxList7.add(fence_conservation);
        checkBoxList7.add(other_fence       );

        checkBoxList8.add(wellhead_good     );
        checkBoxList8.add(wellhead_bad      );
        checkBoxList8.add(wellhead_change   );
        checkBoxList8.add( other_wellhead   );

        checkBoxList9.add(famen_well_good    );
        checkBoxList9.add(famen_well_bad     );
        checkBoxList9.add(well_debris        );
        checkBoxList9.add(other_famen_well   );

        checkBoxList10.add(mbr_fan_good   );
        checkBoxList10.add(mbr_fan_weixiu );
        checkBoxList10.add(mbr_fan_bad    );
        checkBoxList10.add(mbr_fan_change );
        checkBoxList10.add(other_mbr_fan  );
        final RadioGroup RadioGroup1 = (RadioGroup) findViewById(R.id.radio_jishui);
        final RadioGroup RadioGroup2 = (RadioGroup) findViewById(R.id.radio_chuchen);
        final RadioGroup RadioGroup3 = (RadioGroup) findViewById(R.id.radio_yanjian);
        final RadioGroup RadioGroup4 = (RadioGroup) findViewById(R.id.radio_haoyang);
        final RadioGroup RadioGroup5= (RadioGroup) findViewById(R.id.radio_chendian);
        final RadioGroup RadioGroup6 = (RadioGroup) findViewById(R.id.radio_shidi);
        final RadioGroup RadioGroup7 = (RadioGroup) findViewById(R.id.radio_chushui);
        final RadioGroup RadioGroup8 = (RadioGroup) findViewById(R.id.radio_site_environment);
        final RadioGroup RadioGroup9= (RadioGroup) findViewById(R.id.radio_fence);
        final RadioGroup RadioGroup10 = (RadioGroup) findViewById(R.id.radio_wellhead);
        final RadioGroup RadioGroup11 = (RadioGroup) findViewById(R.id.radio_famen_well);
        final RadioGroup RadioGroup12 = (RadioGroup) findViewById(R.id.radio_mbr_fan);
        final RadioGroup RadioGroup13 = (RadioGroup) findViewById(R.id.radio_manshui);
        final RadioGroup RadioGroup14 = (RadioGroup) findViewById(R.id.radio_blocking);
        final RadioGroup RadioGroup15= (RadioGroup) findViewById(R.id.radio_plant);
        structure_situation_tijiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               a= String.valueOf(other_sheshi.getText());
                b= String.valueOf(other_quest_shidi.getText());
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




                //集水井/调节池项
                for (int i = 0; i < RadioGroup1.getChildCount(); i++) {
                    RadioButton radioButton = (RadioButton) RadioGroup1.getChildAt(i);
                    if (radioButton.isChecked()) {
                        //                        dx.append(radioButton.getText().toString() + " ");
//                        Log.i("tag", "lsn 单选按钮，您的天气是：" + radioButton.getText());
                        jishui_radio = radioButton.getText().toString();
                    }
                }
                Log.d("==gyn==",jishui_radio);
                    if (jishui_radio.equals("有")){
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
                            Toast.makeText(getApplicationContext(), "集水井/调节池请至少选择一个", Toast.LENGTH_SHORT).show();
                        }else{
//                    Toast.makeText(getApplicationContext(), sb_pipe.toString(), Toast.LENGTH_SHORT).show();
                        }
                    }else if(jishui_radio.equals("无")){
                        gl0.append("无");
                    }

                data_jinshui = gl0.toString();
                Log.d("==gyn==",data_jinshui);

                //2

                for (int i = 0; i < RadioGroup2.getChildCount(); i++) {
                    RadioButton radioButton = (RadioButton) RadioGroup2.getChildAt(i);
                    if (radioButton.isChecked()) {
                        //                        dx.append(radioButton.getText().toString() + " ");
//                        Log.i("tag", "lsn 单选按钮，您的天气是：" + radioButton.getText());
                  chuchen_radio = radioButton.getText().toString();
                    }
                }
                Log.d("==gyn==",chuchen_radio);
                if (chuchen_radio.equals("有")){
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
                        Toast.makeText(getApplicationContext(), "初沉池请至少选择一个", Toast.LENGTH_SHORT).show();
                    }else{
//                    Toast.makeText(getApplicationContext(), sb_pipe.toString(), Toast.LENGTH_SHORT).show();
                    }
                }else if(chuchen_radio.equals("无")){
                    gl1.append("无");
                }

                data_chuchen = gl1.toString();
                Log.d("==gyn==",data_chuchen);

                //3

                for (int i = 0; i < RadioGroup3.getChildCount(); i++) {
                    RadioButton radioButton = (RadioButton) RadioGroup3.getChildAt(i);
                    if (radioButton.isChecked()) {
                        //                        dx.append(radioButton.getText().toString() + " ");
//                        Log.i("tag", "lsn 单选按钮，您的天气是：" + radioButton.getText());
                       yanjiang_radio = radioButton.getText().toString();
                    }
                }
                Log.d("==gyn==",yanjiang_radio);
                if (yanjiang_radio.equals("有")){
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
                        Toast.makeText(getApplicationContext(), "厌氧池请至少选择一个", Toast.LENGTH_SHORT).show();
                    }else{
//                    Toast.makeText(getApplicationContext(), sb_pipe.toString(), Toast.LENGTH_SHORT).show();
                    }
                }else if(yanjiang_radio.equals("无")){
                    gl2.append("无");
                }

                data_yanjiang = gl2.toString();
                Log.d("==gyn==",data_yanjiang);

                //4

                for (int i = 0; i < RadioGroup4.getChildCount(); i++) {
                    RadioButton radioButton = (RadioButton) RadioGroup4.getChildAt(i);
                    if (radioButton.isChecked()) {
                        //                        dx.append(radioButton.getText().toString() + " ");
//                        Log.i("tag", "lsn 单选按钮，您的天气是：" + radioButton.getText());
                        haoyang_radio = radioButton.getText().toString();
                    }
                }
                Log.d("==gyn==",haoyang_radio);
                if (haoyang_radio.equals("有")){
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
                        Toast.makeText(getApplicationContext(), "好氧池请至少选择一个", Toast.LENGTH_SHORT).show();
                    }else{
//                    Toast.makeText(getApplicationContext(), sb_pipe.toString(), Toast.LENGTH_SHORT).show();
                    }
                }else if(haoyang_radio.equals("无")){
                    gl3.append("无");
                }

                data_haoyang = gl3.toString();
                Log.d("==gyn==",data_haoyang);

                //5

                for (int i = 0; i < RadioGroup5.getChildCount(); i++) {
                    RadioButton radioButton = (RadioButton) RadioGroup5.getChildAt(i);
                    if (radioButton.isChecked()) {
                        //                        dx.append(radioButton.getText().toString() + " ");
//                        Log.i("tag", "lsn 单选按钮，您的天气是：" + radioButton.getText());
                        chendian_radio = radioButton.getText().toString();
                    }
                }
                Log.d("==gyn==",chendian_radio);
                if (chendian_radio.equals("有")){
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
                        Toast.makeText(getApplicationContext(), "沉淀池请至少选择一个", Toast.LENGTH_SHORT).show();
                    }else{
//                    Toast.makeText(getApplicationContext(), sb_pipe.toString(), Toast.LENGTH_SHORT).show();
                    }
                }else if(chendian_radio.equals("无")){
                    gl4.append("无");
                }

                data_chendian= gl4.toString();
                Log.d("==gyn==",data_chendian);

                //6

                for (int i = 0; i < RadioGroup6.getChildCount(); i++) {
                    RadioButton radioButton = (RadioButton) RadioGroup6.getChildAt(i);
                    if (radioButton.isChecked()) {
                        //                        dx.append(radioButton.getText().toString() + " ");
//                        Log.i("tag", "lsn 单选按钮，您的天气是：" + radioButton.getText());
                        shidi_radio = radioButton.getText().toString();
                    }
                }
                Log.d("==gyn==",shidi_radio);
                if (shidi_radio.equals("有")){
//                        Log.d("==gyn==","输入有后运行");
                    for (int i = 0; i < RadioGroup13.getChildCount(); i++) {
                        RadioButton radioButton = (RadioButton) RadioGroup13.getChildAt(i);
                        if (radioButton.isChecked()) {
                            //                        dx.append(radioButton.getText().toString() + " ");
                            Log.i("tag", "：" + radioButton.getText());
                          data_manshui = radioButton.getText().toString();
                        }

                    }
                    for (int i = 0; i < RadioGroup14.getChildCount(); i++) {
                        RadioButton radioButton = (RadioButton) RadioGroup14.getChildAt(i);
                        if (radioButton.isChecked()) {
                            //                        dx.append(radioButton.getText().toString() + " ");
                            Log.i("tag", "：" + radioButton.getText());
                            data_dusai = radioButton.getText().toString();
                        }
                    }
                    for (int i = 0; i < RadioGroup15.getChildCount(); i++) {
                        RadioButton radioButton = (RadioButton) RadioGroup15.getChildAt(i);
                        if (radioButton.isChecked()) {
                            //                        dx.append(radioButton.getText().toString() + " ");
                            Log.i("tag", "：" + radioButton.getText());
                            data_plant = radioButton.getText().toString();
                        }
                    }
//                Log.d("gyn","sb=======:"+sb.toString());
                }else if(shidi_radio.equals("无")){
                    gl5.append("无");
                }

                data_shidi = gl5.toString();
                Log.d("==gyn==",data_shidi);

                //7
                for (int i = 0; i < RadioGroup8.getChildCount(); i++) {
                    RadioButton radioButton = (RadioButton) RadioGroup8.getChildAt(i);
                    if (radioButton.isChecked()) {
                        //                        dx.append(radioButton.getText().toString() + " ");
//                        Log.i("tag", "lsn 单选按钮，您的天气是：" + radioButton.getText());
                       site_radio = radioButton.getText().toString();
                    }
                }
                Log.d("==gyn==",site_radio);
                if (site_radio.equals("有")){
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
                        Toast.makeText(getApplicationContext(), "终端场地请至少选择一个", Toast.LENGTH_SHORT).show();
                    }else{
//                    Toast.makeText(getApplicationContext(), sb_pipe.toString(), Toast.LENGTH_SHORT).show();
                    }
                }else if(site_radio.equals("无")){
                    gl6.append("无");
                }

                data_site = gl6.toString();
                Log.d("==gyn==",data_site);

                //8

                for (int i = 0; i < RadioGroup9.getChildCount(); i++) {
                    RadioButton radioButton = (RadioButton) RadioGroup9.getChildAt(i);
                    if (radioButton.isChecked()) {
                        //                        dx.append(radioButton.getText().toString() + " ");
//                        Log.i("tag", "lsn 单选按钮，您的天气是：" + radioButton.getText());
                        fence_radio = radioButton.getText().toString();
                    }
                }
                Log.d("==gyn==",fence_radio);
                if (fence_radio.equals("有")){
//                        Log.d("==gyn==","输入有后运行");
                    for (CheckBox checkbox : checkBoxList7) {
                        if (checkbox.isChecked()){
//                        Log.d("gyn","sb:"+checkbox.getText().toString());
                            gl7.append(checkbox.getText().toString() + " ");
//                        Toast.makeText(OtherDevice.this,"提交成功",Toast.LENGTH_LONG).show();
                        }
                    }
//                Log.d("gyn","sb=======:"+sb.toString());
                    if (gl7!=null && "".equals(gl7.toString())){
                        Toast.makeText(getApplicationContext(), "终端围栏请至少选择一个", Toast.LENGTH_SHORT).show();
                    }else{
//                    Toast.makeText(getApplicationContext(), sb_pipe.toString(), Toast.LENGTH_SHORT).show();
                    }
                }else if(fence_radio.equals("无")){
                    gl7.append("无");
                }

                data_fence = gl7.toString();
                Log.d("==gyn==",data_fence);

                //9

                for (int i = 0; i < RadioGroup10.getChildCount(); i++) {
                    RadioButton radioButton = (RadioButton) RadioGroup10.getChildAt(i);
                    if (radioButton.isChecked()) {
                        //                        dx.append(radioButton.getText().toString() + " ");
//                        Log.i("tag", "lsn 单选按钮，您的天气是：" + radioButton.getText());
                        wellhead_radio = radioButton.getText().toString();
                    }
                }
                Log.d("==gyn==",wellhead_radio);
                if (wellhead_radio.equals("有")){
//                        Log.d("==gyn==","输入有后运行");
                    for (CheckBox checkbox : checkBoxList8) {
                        if (checkbox.isChecked()){
//                        Log.d("gyn","sb:"+checkbox.getText().toString());
                            gl8.append(checkbox.getText().toString() + " ");
//                        Toast.makeText(OtherDevice.this,"提交成功",Toast.LENGTH_LONG).show();
                        }
                    }
//                Log.d("gyn","sb=======:"+sb.toString());
                    if (gl8!=null && "".equals(gl8.toString())){
                        Toast.makeText(getApplicationContext(), "各类井口请至少选择一个", Toast.LENGTH_SHORT).show();
                    }
                }else if(wellhead_radio.equals("无")){
                    gl8.append("无");
                }

                data_wellhead = gl8.toString();
                Log.d("==gyn==",data_wellhead);

                //10

                for (int i = 0; i < RadioGroup11.getChildCount(); i++) {
                    RadioButton radioButton = (RadioButton) RadioGroup11.getChildAt(i);
                    if (radioButton.isChecked()) {
                        //                        dx.append(radioButton.getText().toString() + " ");
//                        Log.i("tag", "lsn 单选按钮，您的天气是：" + radioButton.getText());
                        famen_radio = radioButton.getText().toString();
                    }
                }
                Log.d("==gyn==",famen_radio);
                if (famen_radio.equals("有")){
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
                        Toast.makeText(getApplicationContext(), "阀门井请至少选择一个", Toast.LENGTH_SHORT).show();
                    }else{
//                    Toast.makeText(getApplicationContext(), sb_pipe.toString(), Toast.LENGTH_SHORT).show();
                    }
                }else if(famen_radio.equals("无")){
                    gl9.append("无");
                }

                data_famen = gl9.toString();
                Log.d("==gyn==",data_famen);

                //11

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
                    for (CheckBox checkbox : checkBoxList10) {
                        if (checkbox.isChecked()){
//                        Log.d("gyn","sb:"+checkbox.getText().toString());
                            gl10.append(checkbox.getText().toString() + " ");
//                        Toast.makeText(OtherDevice.this,"提交成功",Toast.LENGTH_LONG).show();
                        }
                    }
//                Log.d("gyn","sb=======:"+sb.toString());
                    if (gl10!=null && "".equals(gl10.toString())){
                        Toast.makeText(getApplicationContext(), "MBR请至少选择一个", Toast.LENGTH_SHORT).show();
                    }
                }else if(mbr_radio.equals("无")){
                    gl10.append("无");
                }

                data_mbr= gl10.toString();
                Log.d("==gyn==",data_mbr);

                //12
                for (int i = 0; i < RadioGroup7.getChildCount(); i++) {
                    RadioButton radioButton = (RadioButton) RadioGroup7.getChildAt(i);
                    if (radioButton.isChecked()) {
                        //                        dx.append(radioButton.getText().toString() + " ");
//                        Log.i("tag", "lsn 单选按钮，您的天气是：" + radioButton.getText());
                        chushui_radio = radioButton.getText().toString();
                    }
                }
                Log.d("==gyn==",chushui_radio);
                if (chushui_radio.equals("有")){
//                        Log.d("==gyn==","输入有后运行");
                    for (CheckBox checkbox : checkBoxList6) {
                        if (checkbox.isChecked()){
//                        Log.d("gyn","sb:"+checkbox.getText().toString());
                            gl11.append(checkbox.getText().toString() + " ");
//                        Toast.makeText(OtherDevice.this,"提交成功",Toast.LENGTH_LONG).show();
                        }
                    }
//                Log.d("gyn","sb=======:"+sb.toString());
                    if (gl11!=null && "".equals(gl11.toString())){
                        Toast.makeText(getApplicationContext(), "出水池请至少选择一个", Toast.LENGTH_SHORT).show();
                    }
                }else if(chushui_radio.equals("无")){
                    gl11.append("无");
                }

                data_chushui = gl11.toString();
                Log.d("==gyn==",data_chushui);

                postDataDiaocha(view);

            }
        });

    }
    private void postDataDiaocha(View view) {
        OkHttpClient client = new OkHttpClient();//创建OkHttpClient对象。
        MediaType JSON = MediaType.parse("application/json; charset=utf-8");//数据类型为json格式，
        String jsonStr = "{\"集水井/调节池\":" + "\"" +data_jinshui+ "\",\"初沉池\":\"" +data_chuchen+ "\"," +
                "\"厌氧池\":" + "\"" +data_yanjiang+ "\",\"好氧池\":"
                + "\"" + data_haoyang + "\",\"沉淀池\":\"" + data_chendian + "\",\"人工湿地\":\"" + data_shidi+ "\"," +
                "\"漫水情况\":\"" + data_manshui + "\",\"是否堵塞\":\"" +data_dusai + "\",\"植物生长情况\":\"" +data_plant + "\"," +
                "\"其他问题\":\"" + b + "\"," +
                "\"出水井\":\"" + data_chushui + "\",\"终端场地环境\":\"" + data_site + "\",\"终端围栏\":\"" + data_fence+ "\"," +
                "\"各类井口及井盖\":\"" +data_wellhead + "\",\"阀门井\":\"" +data_famen + "\"," +
                "\"MBR反冲洗系统\":\"" + data_mbr + "\",\"其他设施\":\"" + a + "\"}";//json数据.\
        Log.e("11", "==============jsonStr=" + jsonStr);
        RequestBody body = RequestBody.create(JSON, jsonStr);
        Request request = new Request.Builder()
                .url("http://192.168.1.110:1803/structure_tijiao")
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
