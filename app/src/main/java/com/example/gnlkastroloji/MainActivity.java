package com.example.gnlkastroloji;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    String day,burc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("myLog","nothing selected");
        Spinner burcSpinner=findViewById(R.id.my_spinnerBurç);
        Resources res=getResources();
        String []burcArray=res.getStringArray(R.array.burcs);

        ArrayAdapter<String>burcAdapter=new ArrayAdapter<>(
                this,R.layout.textview_for_spinner_background,burcArray);
        burcSpinner.setAdapter(burcAdapter);

        Spinner daySpinner=findViewById(R.id.my_spinnerDays);

        String []dayArray=res.getStringArray(R.array.days);

        ArrayAdapter<String> dayAdapter=new ArrayAdapter<>(
                this,R.layout.textview_for_spinner_background,dayArray
        );
        daySpinner.setAdapter(dayAdapter);

        burcSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                burc=burcArray[position];

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Log.d("myLog","nothing selected");
            }
        });

        daySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                day=dayArray[position];

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Button btn_Go=findViewById(R.id.btn_go);

        btn_Go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getDataAndSartActivity(burc,day);

            }
        });
    }

    private void getDataAndSartActivity(String sign,String day) {
        ProgressDialog progressDialog=new ProgressDialog(this);
        progressDialog.show();
        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        String json="{}";
        OkHttpClient okHttpClient=new OkHttpClient();
        HttpUrl.Builder urlBuilder =HttpUrl.parse("https://sameer-kumar-aztro-v1.p.rapidapi.com/").newBuilder();

        urlBuilder.addQueryParameter("sign",sign);
        urlBuilder.addQueryParameter("day",day);

        String url=urlBuilder.build().toString();

        RequestBody requestBody=RequestBody.create(JSON,json);

        Request request=new Request.Builder()
                .url(url)
                .post(requestBody)
                .addHeader("X-RapidAPI-Key", "YOUR-RAPİD-APİ-KEY")
                .addHeader("X-RapidAPI-Host", "sameer-kumar-aztro-v1.p.rapidapi.com")
                .build();

        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                Log.d("myLog",e.toString());
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {

                MainActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        String result= null;
                        try {
                            result = response.body().string();
                            Intent intent=new Intent(getApplicationContext(),ResultActivity.class);
                            intent.putExtra("result",result);
                            startActivity(intent);

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        progressDialog.dismiss();
                    }
                });

            }
        });


    }
}
