package com.gyn.eiodmen;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
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

public class OtherDevice extends AppCompatActivity {
    Button other_device_tijiao;
    EditText number_manhole,number_cover,other_question;
    String data_pipe;
    String data_roadMian;
    String data_pipedoor;
    String data_jingdoor;
    String data_tank;
    String data_yinjing;
    String data_cover;
    String data_chufang;
    String data_road;
    String data_number_manhole,data_number_cover,data_other_question;
    CheckBox pipe_network_hao,pipe_network_huai,pipe_network_blocking,yinjing_hao,yinjing_huai,road_good,road_break,road_set,
    yinjing_verybad,manhole_cover_hao,manhole_cover_huai,manhole_cover_damaged, road_hao,road_huai,pipedoor_good,pipedoor_break;
    CheckBox pipedoor_blocking,jingdoor_good,jingdoor_break,jingdoor_verybad,tank_good,tank_break,tank_blocking,tank_full,
            kitchen_jing_good, kitchen_jing_break,kitchen_jing_verybad;
    private List<CheckBox> pipe_network = new ArrayList<CheckBox>();  //定义管网多选框
    private List<CheckBox> yinjing_box = new ArrayList<CheckBox>();  //定义窨井多选框

    private List<CheckBox> roadMian_box = new ArrayList<CheckBox>();  //定义管网多选框
    private List<CheckBox> cover_box = new ArrayList<CheckBox>();  //定义窨井盖多选框
    private List<CheckBox> pipe_door = new ArrayList<CheckBox>();  //定义管网多选框
    private List<CheckBox> jing_doorBox = new ArrayList<CheckBox>();  //定义管网多选框
    private List<CheckBox> septic_tankBox = new ArrayList<CheckBox>();  //定义管网多选框
    private List<CheckBox> chufang_box= new ArrayList<CheckBox>();  //定义管网多选框
    private List<CheckBox> road_box = new ArrayList<CheckBox>();  //定义管网多选框
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.other_device);

        other_device_tijiao = (Button) findViewById(R.id.other_device_tijiao); //提交按钮
        number_manhole = (EditText)findViewById(R.id.number_manhole); //窨井编号
        number_cover= (EditText)findViewById(R.id.number_cover); //窨井盖编号
        other_question= (EditText)findViewById(R.id.other_question); //窨井盖编号
        //获取多选框，并且给予多选框值，此处获取管网多选框
        pipe_network_hao=(CheckBox)findViewById(R.id.pipe_network_hao);
        pipe_network_huai=(CheckBox)findViewById(R.id.pipe_network_huai);
        pipe_network_blocking=(CheckBox)findViewById(R.id.pipe_network_blocking);
        pipe_network.add(pipe_network_hao);
        pipe_network.add(pipe_network_huai);
        pipe_network.add(pipe_network_blocking);
        //窨井
       yinjing_hao=(CheckBox)findViewById(R.id.     yinjing_hao     );
       yinjing_huai=(CheckBox)findViewById(R.id.    yinjing_huai    ) ;
        yinjing_verybad=(CheckBox)findViewById(R.id.yinjing_verybad);
        yinjing_box.add(yinjing_hao    );
        yinjing_box.add(yinjing_huai   );
        yinjing_box.add(yinjing_verybad);
        //路面
        road_hao=(CheckBox)findViewById(R.id.road_hao);
        road_huai=(CheckBox)findViewById(R.id.road_huai);
        roadMian_box.add(road_hao);
        roadMian_box.add(road_huai);

        //窨井盖
        manhole_cover_hao     =(CheckBox)findViewById(R.id.manhole_cover_hao);
        manhole_cover_huai    =(CheckBox)findViewById(R.id.manhole_cover_huai);
        manhole_cover_damaged=(CheckBox)findViewById(R.id.manhole_cover_damaged);
       cover_box.add( manhole_cover_hao    );
       cover_box.add( manhole_cover_huai   );
       cover_box.add( manhole_cover_damaged);


        //接户管
        pipedoor_good=(CheckBox)findViewById(R.id.pipedoor_good);
        pipedoor_break=(CheckBox)findViewById(R.id.pipedoor_break);
        pipedoor_blocking=(CheckBox)findViewById(R.id.pipedoor_blocking);
        pipe_door.add(pipedoor_good);
        pipe_door.add(pipedoor_break);
        pipe_door.add(pipedoor_blocking);
        //接户井
        jingdoor_good=(CheckBox)findViewById(R.id.jingdoor_good);
        jingdoor_break=(CheckBox)findViewById(R.id.jingdoor_break);
        jingdoor_verybad=(CheckBox)findViewById(R.id.jingdoor_verybad);
        jing_doorBox.add(jingdoor_good);
        jing_doorBox.add(jingdoor_break);
        jing_doorBox.add(jingdoor_verybad);
        //户用化粪池或隔油池
        tank_good    =(CheckBox)findViewById(R.id.tank_good);
        tank_break   =(CheckBox)findViewById(R.id.tank_break);
        tank_blocking=(CheckBox)findViewById(R.id.tank_blocking);
        tank_full    =(CheckBox)findViewById(R.id.tank_full);
        septic_tankBox.add( tank_good    );
        septic_tankBox.add( tank_break   );
        septic_tankBox.add( tank_blocking);
        septic_tankBox.add( tank_full    );

        //厨房清扫井
        kitchen_jing_good   =(CheckBox)findViewById(R.id.kitchen_jing_good);
        kitchen_jing_break  =(CheckBox)findViewById(R.id.kitchen_jing_break);
        kitchen_jing_verybad=(CheckBox)findViewById(R.id.kitchen_jing_verybad);
        chufang_box.add( kitchen_jing_good   );
        chufang_box.add( kitchen_jing_break  );
        chufang_box.add( kitchen_jing_verybad);

        //道路
        road_good =(CheckBox)findViewById(R.id.road_good);
        road_break=(CheckBox)findViewById(R.id.road_break);
        road_set  =(CheckBox)findViewById(R.id.road_set);
        road_box.add( road_good );
        road_box.add( road_break);
        road_box.add( road_set  );

        //给予多选框值


        other_device_tijiao.setOnClickListener(new View.OnClickListener() { //点击按钮提交
            @Override
            public void onClick(View v) {
//                data_pipe_hao= String.valueOf(pipe_network_hao.getText());
//                data_pipe_huai= String.valueOf(pipe_network_huai.getText());
//                data_pipe_blocking= String.valueOf(pipe_network_blocking.getText());
                data_number_manhole= String.valueOf(number_manhole .getText());
                data_number_cover=String.valueOf(number_cover .getText());
                data_other_question=String.valueOf(other_question .getText());

                StringBuffer sb_pipe = new StringBuffer();
                StringBuffer sb_yinjing = new StringBuffer();

                StringBuffer sb_roadMian = new StringBuffer();
                StringBuffer sb_cover = new StringBuffer();

                StringBuffer sb_pipedoor = new StringBuffer();
                StringBuffer sb_jingdoor = new StringBuffer();
                StringBuffer sb_tankBox = new StringBuffer();
                StringBuffer sb_chufang = new StringBuffer();
                StringBuffer sb_road = new StringBuffer();


                //遍历集合中的checkBox,判断是否选择，获取选中的文本
                for (CheckBox checkbox : pipe_network) {
                    if (checkbox.isChecked()){
//                        Log.d("gyn","sb:"+checkbox.getText().toString());
                        sb_pipe.append(checkbox.getText().toString() + " ");
//                        Toast.makeText(OtherDevice.this,"提交成功",Toast.LENGTH_LONG).show();
                    }
                }
//                Log.d("gyn","sb=======:"+sb.toString());
                if (sb_pipe!=null && "".equals(sb_pipe.toString())){
                    Toast.makeText(getApplicationContext(), "管网请至少选择一个", Toast.LENGTH_SHORT).show();
                }else{
//                    Toast.makeText(getApplicationContext(), sb_pipe.toString(), Toast.LENGTH_SHORT).show();
                }
                //窨井
                for (CheckBox checkbox : yinjing_box) {
                    if (checkbox.isChecked()){
//                        Log.d("gyn","sb:"+checkbox.getText().toString());
                        sb_yinjing.append(checkbox.getText().toString() + " ");
//                        Toast.makeText(OtherDevice.this,"提交成功",Toast.LENGTH_LONG).show();
                    }
                }
//                Log.d("gyn","sb=======:"+sb.toString());
                if (sb_yinjing!=null && "".equals(sb_yinjing.toString())){
                    Toast.makeText(getApplicationContext(), "窨井请至少选择一个", Toast.LENGTH_SHORT).show();
                }else{
//                    Toast.makeText(getApplicationContext(), sb_pipe.toString(), Toast.LENGTH_SHORT).show();
                }
                //路面
                for (CheckBox checkbox : roadMian_box) {
                    if (checkbox.isChecked()){
//                        Log.d("gyn","sb:"+checkbox.getText().toString());
                        sb_roadMian.append(checkbox.getText().toString() + " ");
//                        Toast.makeText(OtherDevice.this,"提交成功",Toast.LENGTH_LONG).show();
                    }
                }
//                Log.d("gyn","sb=======:"+sb.toString());
                if (sb_roadMian!=null && "".equals(sb_roadMian.toString())){
                    Toast.makeText(getApplicationContext(), "路面请至少选择一个", Toast.LENGTH_SHORT).show();
                }else{
//                    Toast.makeText(getApplicationContext(), sb_roadMian.toString(), Toast.LENGTH_SHORT).show();
                }
                //窨井盖
                for (CheckBox checkbox : cover_box) {
                    if (checkbox.isChecked()){
//                        Log.d("gyn","sb:"+checkbox.getText().toString());
                        sb_cover.append(checkbox.getText().toString() + " ");
//                        Toast.makeText(OtherDevice.this,"提交成功",Toast.LENGTH_LONG).show();
                    }
                }
//                Log.d("gyn","sb=======:"+sb.toString());
                if (sb_cover!=null && "".equals(sb_cover.toString())){
                    Toast.makeText(getApplicationContext(), "路面请至少选择一个", Toast.LENGTH_SHORT).show();
                }else{
//                    Toast.makeText(getApplicationContext(), sb_roadMian.toString(), Toast.LENGTH_SHORT).show();
                }
                //接户管
                for (CheckBox checkbox : pipe_door) {
                    if (checkbox.isChecked()){
//                        Log.d("gyn","sb:"+checkbox.getText().toString());
                        sb_pipedoor.append(checkbox.getText().toString() + " ");
//                        Toast.makeText(OtherDevice.this,"提交成功",Toast.LENGTH_LONG).show();
                    }
                }
//                Log.d("gyn","sb=======:"+sb.toString());
                if (sb_pipedoor!=null && "".equals(sb_pipedoor.toString())){
                    Toast.makeText(getApplicationContext(), "接户管请至少选择一个", Toast.LENGTH_SHORT).show();
                }else{
//                    Toast.makeText(getApplicationContext(), sb_pipedoor.toString(), Toast.LENGTH_SHORT).show();
                }

                //接户井
                for (CheckBox checkbox : jing_doorBox) {
                    if (checkbox.isChecked()){
//                        Log.d("gyn","sb:"+checkbox.getText().toString());
                        sb_jingdoor.append(checkbox.getText().toString() + " ");
                        Toast.makeText(OtherDevice.this,"提交成功",Toast.LENGTH_LONG).show();
                    }
                }
//                Log.d("gyn","sb=======:"+sb.toString());
                if (sb_jingdoor!=null && "".equals(sb_jingdoor.toString())){
                    Toast.makeText(getApplicationContext(), "接户井请至少选择一个", Toast.LENGTH_SHORT).show();
                }else{
//                    Toast.makeText(getApplicationContext(), sb_jingdoor.toString(), Toast.LENGTH_SHORT).show();
                }
                //化粪池
                for (CheckBox checkbox : septic_tankBox) {
                    if (checkbox.isChecked()){
//                        Log.d("gyn","sb:"+checkbox.getText().toString());
                        sb_tankBox.append(checkbox.getText().toString() + " ");
                        Toast.makeText(OtherDevice.this,"提交成功",Toast.LENGTH_LONG).show();
                    }
                }
//                Log.d("gyn","sb=======:"+sb.toString());
                if (sb_tankBox!=null && "".equals(sb_tankBox.toString())){
                    Toast.makeText(getApplicationContext(), "化粪池请至少选择一个", Toast.LENGTH_SHORT).show();
                }else{
//                    Toast.makeText(getApplicationContext(), sb_tankBox.toString(), Toast.LENGTH_SHORT).show();
                }
                //厨房
                for (CheckBox checkbox : chufang_box) {
                    if (checkbox.isChecked()){
//                        Log.d("gyn","sb:"+checkbox.getText().toString());
                        sb_chufang.append(checkbox.getText().toString() + " ");
                        Toast.makeText(OtherDevice.this,"提交成功",Toast.LENGTH_LONG).show();
                    }
                }
//                Log.d("gyn","sb=======:"+sb.toString());
                if (sb_chufang!=null && "".equals(sb_chufang.toString())){
                    Toast.makeText(getApplicationContext(), "化粪池请至少选择一个", Toast.LENGTH_SHORT).show();
                }else{
//                    Toast.makeText(getApplicationContext(), sb_tankBox.toString(), Toast.LENGTH_SHORT).show();
                }

                //道路
                for (CheckBox checkbox : road_box) {
                    if (checkbox.isChecked()){
//                        Log.d("gyn","sb:"+checkbox.getText().toString());
                        sb_road.append(checkbox.getText().toString() + " ");
                        Toast.makeText(OtherDevice.this,"提交成功",Toast.LENGTH_LONG).show();
                    }
                }
//                Log.d("gyn","sb=======:"+sb.toString());
                if (sb_road!=null && "".equals(sb_road.toString())){
                    Toast.makeText(getApplicationContext(), "化粪池请至少选择一个", Toast.LENGTH_SHORT).show();
                }else{
//                    Toast.makeText(getApplicationContext(), sb_tankBox.toString(), Toast.LENGTH_SHORT).show();
                }

                data_pipe= sb_pipe.toString();
                data_yinjing=sb_yinjing.toString();
                data_roadMian = sb_roadMian.toString();
                data_cover=sb_cover.toString();
                data_pipedoor = sb_pipedoor.toString();
                data_jingdoor = sb_jingdoor.toString();
                data_tank = sb_tankBox.toString();
                data_chufang=sb_chufang.toString();
                data_road=sb_road.toString();
                Log.d("gynnnn","==========路面============"+data_pipedoor);
                Log.d("gynnnn","==========路面============"+data_tank);

                postDataDiaocha(v);

            }//点击事件结束

        });





    }
    private void postDataDiaocha(View v) {
        OkHttpClient client = new OkHttpClient();//创建OkHttpClient对象。
        MediaType JSON = MediaType.parse("application/json; charset=utf-8");//数据类型为json格式，
        String jsonStr = "{\"管网\":" + "\"" +data_pipe+ "\",\"窨井\":\"" +data_yinjing+ "\"," +
                "\"井编号\":" + "\"" +data_number_manhole+ "\",\"路面\":" + "\"" + data_roadMian+ "\",\"窨井盖\":\"" + data_cover + "\"," +
                "\"破损，井编号\":\"" + data_number_cover+ "\"," + "\"接户管\":\""+data_pipedoor+"\",\"接户井\":\""+data_jingdoor+"\",\"用户化粪池或隔油池\":\"" + data_tank  + "\"," +
                "\"厨房清扫井\":\"" +data_chufang + "\"," + "\"道路\":\"" +data_road + "\"," + "\"其他问题\":\"" +data_other_question + "\"}";//json数据.\
        Log.e("11", "==============jsonStr=" + jsonStr);
        RequestBody body = RequestBody.create(JSON, jsonStr);
        Request request = new Request.Builder()
                .url("http://192.168.1.110:1803/otherdevice_tijiao")
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