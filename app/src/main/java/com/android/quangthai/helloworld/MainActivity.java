package com.android.quangthai.helloworld;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MainActivity extends AppCompatActivity {
    //Các thuộc tính của Activity main
    Button btnDangNhap;
    TextView txtTaiKhoan;
    TextView txtMatKhau;
    EditText editTaiKhoan;
    EditText editMatKhau;
    Map<String, String> myMap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvents();
    }
    //Inject các thuộc tính của activity này
    private void addControls() {
        btnDangNhap = (Button) findViewById(R.id.btnDangNhap);
        txtTaiKhoan = (TextView) findViewById(R.id.txtTaiKhoan);
        txtMatKhau = (TextView) findViewById(R.id.txtMatKhau);
        editTaiKhoan = (EditText) findViewById(R.id.editTaiKhoan);
        editMatKhau = (EditText) findViewById(R.id.editMatKhau);
        myMap = new HashMap<>();
        myMap.put("bob", "b");
        myMap.put("alice", "a");
        myMap.put("carl", "c");
    }
    //Thêm event handler cho nút đăng nhập
    private void addEvents() {
        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txtTK;
                String txtMK;
                txtTK = editTaiKhoan.getText().toString();
                txtMK = editMatKhau.getText().toString();
                //Sẽ check login nếu đã tồn tại trong db.
                if(txtMK.equals(myMap.get(txtTK)) && myMap.containsKey(txtTK))
                {
                    Intent i = new Intent(MainActivity.this, SecondActivity.class);
                    i.putExtra("txtTaiKhoan", txtTK);
                    startActivity(i);
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Đăng nhập thất bại", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
