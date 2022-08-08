package com.example.gnlkastroloji;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Intent intent=getIntent();
        String result=intent.getStringExtra("result");

        try {
            parseDataToUI(result);
        } catch (JSONException e) {
            Log.d("myLog",e.toString());
        }


    }
    public void parseDataToUI(String result) throws JSONException {

        JSONObject jsonObject=new JSONObject(result);

        TextView tv_title=findViewById(R.id.tv_title);
        TextView tv_body=findViewById(R.id.tv_body);
        TextView tv_details=findViewById(R.id.tv_details);

        String date=jsonObject.getString("date_range");

        String description= jsonObject.getString("description");

        String compability=jsonObject.getString("compatibility");
        String color=jsonObject.getString("color");
        String mood=jsonObject.getString("mood");
        String luckNumber=jsonObject.getString("lucky_number");
        String luckTime=jsonObject.getString("lucky_time");

        tv_title.setText(date);

        tv_body.setText(description);

        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append("Compatibility: "+compability+"\n");
        stringBuilder.append("Mood: "+mood+"\n");
        stringBuilder.append("Color: "+color+"\n");
        stringBuilder.append("Luck Number: "+luckNumber+"\n");
        stringBuilder.append("Luck Time: "+luckTime);
        tv_details.setText(stringBuilder.toString());


    }
}