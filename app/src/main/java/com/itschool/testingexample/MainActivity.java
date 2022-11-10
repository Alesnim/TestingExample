package com.itschool.testingexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText et;
    TextView tv;
    Button bt;
    private final String TAG = this.getClass().getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);


        et = findViewById(R.id.ed_text);
        tv = findViewById(R.id.tw_text);
        bt = findViewById(R.id.bt_check);

        TextView tvExample = findViewById(R.id.tv_example);
        tvExample.setText(getResources().getString(R.string.interpolate_string, 42));

        setSomething();

    }


    private void setSomething() {
        bt.setOnClickListener(v -> {
            String text = String.valueOf(et.getText());
            tv.setText(text);
        });
    }


}