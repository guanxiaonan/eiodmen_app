package com.gyn.eiodmen;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.io.IOException;
import java.util.Calendar;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class Myready extends AppCompatActivity{
    Button input_date,ready_tijiao;
    EditText village,terminal,people,stree_township,admin_village;
    int mYear, mMonth, mDay;
    String data_village,data_terminal,data_people,weather,shijian,data_date,data_stree,data_admin_village;
    RadioGroup data_ready_weather,data_ready_shijian;
    final int DATE_DIALOG = 1;
//    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myready);
        input_date= (Button) findViewById(R.id.input_date);
        ready_tijiao= (Button) findViewById(R.id.ready_tijiao);
        village=(EditText)findViewById(R.id.village);
        terminal=(EditText)findViewById(R.id.terminal);
        people=(EditText)findViewById(R.id.people);
        stree_township=(EditText)findViewById(R.id.stree_township);
        admin_village=(EditText)findViewById(R.id.admin_village);
        data_ready_weather = (RadioGroup) findViewById(R.id.ready_weather);
        data_ready_shijian = (RadioGroup) findViewById(R.id.ready_shijian);

        //日期选择
        input_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showDialog(DATE_DIALOG);
            }
        });
        final Calendar ca = Calendar.getInstance();
        mYear = ca.get(Calendar.YEAR);
        mMonth = ca.get(Calendar.MONTH);
        mDay = ca.get(Calendar.DAY_OF_MONTH);

        //提交按钮的方法
        ready_tijiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data_stree = String.valueOf(stree_township.getText()); //乡镇
                data_admin_village = String.valueOf(admin_village.getText());  //行政村
                data_village = String.valueOf(village.getText());  //自然村
                data_terminal = String.valueOf(terminal.getText()); //终端名称
                data_people = String.valueOf(people.getText());    //巡查、检查人员
                data_date = String.valueOf(input_date.getText());  //巡查检查时间
                //天气选择单选按钮
                for (int i = 0; i < data_ready_weather.getChildCount(); i++) {
                    RadioButton radioButton = (RadioButton) data_ready_weather.getChildAt(i);
                    if (radioButton.isChecked()) {
                        //                        dx.append(radioButton.getText().toString() + " ");
//                        Log.i("tag", "lsn 单选按钮，您的天气是：" + radioButton.getText());
                        weather = radioButton.getText().toString();
                    }
                }

                //时间选择单选按钮
                for (int i = 0; i < data_ready_shijian.getChildCount(); i++) {
                    RadioButton radioButton = (RadioButton) data_ready_shijian.getChildAt(i);
                    if (radioButton.isChecked()) {
                        //                        dx.append(radioButton.getText().toString() + " ");
//                        Log.i("tag", "lsn 单选按钮，您的时间是：" + radioButton.getText());
                        shijian = radioButton.getText().toString();
                    }
                }

                String result = postDataDiaocha(v);
                Toast.makeText(Myready.this,result,Toast.LENGTH_LONG).show();
            }
        });

    }


    protected Dialog onCreateDialog(int id){
        switch (id){
            case DATE_DIALOG:
                return new DatePickerDialog(this, mdateListener, mYear, mMonth, mDay);
        }
        return null;
    }
    public void display() {
        input_date.setText(new StringBuffer().append(mYear).append("-").append(mMonth + 1).append("-").append(mDay).append(" "));
    }

    private DatePickerDialog.OnDateSetListener mdateListener = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            mYear = year;
            mMonth = monthOfYear;
            mDay = dayOfMonth;
            display();
        }
    };

    private String postDataDiaocha(View view) {
//        final String[] s = new String[1];
        OkHttpClient client = new OkHttpClient();//创建OkHttpClient对象。
        MediaType JSON = MediaType.parse("application/json; charset=utf-8");//数据类型为json格式，
//        Log.d("shuchu","巡查检查日期："+data_date);
//        Log.d("shuchu","时间："+shijian);
//        Log.d("shuchu","天气："+weather);
//        Log.d("shuchu","自然村："+data_village);
//        Log.d("shuchu","终端名称："+data_terminal);
//        Log.d("shuchu","巡查、检查人员："+data_people);
        String jsonStr = "{\"街道（乡镇）\":"+"\""+data_stree+"\",\"行政村\":"+"\""+data_admin_village+"\",\"巡查检查日期\":"+"\""+data_date+"\",\"时间\":"+"\""+shijian+"\",\"天气\":"+"\""+weather+"\",\"自然村\":\""+data_village+"\",\"终端名称\":\""+data_terminal+"\"," +
                "\"巡查、检查人员\":\""+data_people+"\"}";//json数据.\
//        String jsonStr = "{\"username\":\"lisi\",\"nickname\":\"李四\"}";//json数据.\
        Log.e("11","==============jsonStr="+jsonStr);
        RequestBody body = RequestBody.create(JSON,jsonStr);
        Request request = new Request.Builder()
                .url("http://192.168.1.110:1803/ready_tijiao")
                .post(body)
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.e("==","==========response="+response.toString());
                if(response.isSuccessful()){//回调的方法执行在子线程。
                    Log.d("kwwl","获取数据成功了");
                    Log.d("kwwl","response.code()=="+response.code());
                    Log.d("kwwl","response.body().string()=="+response.body().string());
//
//                    s[0] = response.body().string();
                }else{
                    Log.d("kwwl","========false==========");
//                    Toast.makeText(Myready.this,"数据提交失败",Toast.LENGTH_LONG).show();

                }
            }
        });
//        Log.d("ggg",s[0]);
        return "数据插入成功";
    }


}