package com.android.quangthai.helloworld;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Nhận intent, lấy data ra và show lên
        super.onCreate(savedInstanceState);
        Intent i  = getIntent();
        String txtTaiKhoan = i.getStringExtra("txtTaiKhoan");
        TextView tv = new TextView(this);
        tv.setText("Hello" + " " + txtTaiKhoan);
        tv.setGravity(Gravity.CENTER);
        setContentView(tv);
    }
}
