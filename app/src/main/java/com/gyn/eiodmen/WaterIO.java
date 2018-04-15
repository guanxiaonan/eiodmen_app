package com.gyn.eiodmen;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class WaterIO extends AppCompatActivity {
    Button water_io_tijiao;
    EditText technology;
    RadioGroup waterIn,waterOut,exterior,odor;
    String data_technology,data_waterIO,data_waterOut,data_exterior,data_odor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.water_io);

        water_io_tijiao = (Button) findViewById(R.id.water_io_tijiao);  //提交按钮
        technology = (EditText)findViewById(R.id.technology);   //处理工艺

        waterIn = (RadioGroup)findViewById(R.id.waterIn);  //进水量
        waterOut = (RadioGroup)findViewById(R.id.waterOut);  //出水量
        exterior = (RadioGroup)findViewById(R.id.exterior);  //外观
        odor = (RadioGroup)findViewById(R.id.odor);  //臭气

        water_io_tijiao.setOnClickListener(new View.OnClickListener() {  //点击按钮事件
            @Override
            public void onClick(View v) {
                data_technology = String.valueOf(technology.getText());
                //进水水量单选框
                for (int i = 0; i < waterIn.getChildCount(); i++) {
                    RadioButton radioButton = (RadioButton) waterIn.getChildAt(i);
                    if (radioButton.isChecked()) {
                        //                        dx.append(radioButton.getText().toString() + " ");
//                        Log.i("tag", "lsn 单选按钮，您的天气是：" + radioButton.getText());
                        data_waterIO = radioButton.getText().toString();
                    }
                }

                //出水水量单选框
                for (int i = 0; i < waterOut.getChildCount(); i++) {
                    RadioButton radioButton = (RadioButton) waterOut.getChildAt(i);
                    if (radioButton.isChecked()) {
                        //                        dx.append(radioButton.getText().toString() + " ");
//                        Log.i("tag", "lsn 单选按钮，您的天气是：" + radioButton.getText());
                        data_waterOut = radioButton.getText().toString();
                    }
                }

                //外观单选框
                for (int i = 0; i < exterior.getChildCount(); i++) {
                    RadioButton radioButton = (RadioButton) exterior.getChildAt(i);
                    if (radioButton.isChecked()) {
                        //                        dx.append(radioButton.getText().toString() + " ");
//                        Log.i("tag", "lsn 单选按钮，您的天气是：" + radioButton.getText());
                        data_exterior = radioButton.getText().toString();
                    }
                }

                //臭气单选框
                for (int i = 0; i < odor.getChildCount(); i++) {
                    RadioButton radioButton = (RadioButton) odor.getChildAt(i);
                    if (radioButton.isChecked()) {
                        //                        dx.append(radioButton.getText().toString() + " ");
//                        Log.i("tag", "lsn 单选按钮，您的天气是：" + radioButton.getText());
                        data_odor = radioButton.getText().toString();
                    }
                }
                String result = postDataDiaocha(v);
                Toast.makeText(WaterIO.this,result,Toast.LENGTH_SHORT).show();
            }

        });


    }


    private String postDataDiaocha(View view) {
//        final String[] s = new String[1];
        OkHttpClient client = new OkHttpClient();//创建OkHttpClient对象。
        MediaType JSON = MediaType.parse("application/json; charset=utf-8");//数据类型为json格式，
//        Log.d("shuchu","处理工艺："+data_technology);
//        Log.d("shuchu","进水水量："+data_waterIO);
//        Log.d("shuchu","出水水量："+data_waterOut);
//        Log.d("shuchu","外观："+data_exterior);
//        Log.d("shuchu","臭气："+data_odor);
//        Log.d("shuchu","巡查、检查人员："+data_people);
        String jsonStr = "{\"处理工艺\":"+"\""+data_technology+"\",\"进水水量\":"+"\""+data_waterIO+"\"," +
                "\"出水水量\":"+"\""+data_waterOut+"\",\"外观\":"+"\""+data_exterior+"\"," +
                "\"臭气\":"+"\""+data_odor+"\"}";//json数据.\
//        String jsonStr = "{\"username\":\"lisi\",\"nickname\":\"李四\"}";//json数据.\
        Log.e("11","==============jsonStr="+jsonStr);
        RequestBody body = RequestBody.create(JSON,jsonStr);
        Request request = new Request.Builder()
                .url("http://192.168.1.110:1803/waterio_tijiao")
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