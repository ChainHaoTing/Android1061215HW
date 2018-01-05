package com.example.user.hw1061215;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    EditText et_Celsius;
    EditText et_Fahrenheit;
    Button button;
    String Celsius;
    String Fahrenheit;
    double c;
    double f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);     //顯示的畫面 頁面

        //重構後 可方便新增多組 或 方便檢視
        findViews();    //呼叫 findViewById 建構
        setListener();
    }

    private void findViews(){
        et_Celsius = (EditText)findViewById(R.id.Celsius);
        et_Fahrenheit = (EditText)findViewById(R.id.Fahrenheit);
        button = (Button)findViewById(R.id.button);
    }

    private void setListener(){
        button.setOnClickListener(change);    //Listener
    }

    View.OnClickListener change = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
                if((!((et_Fahrenheit.getText().toString()).equals("")))&&(!((et_Fahrenheit.getText().toString()).equals("")))){
                    et_Celsius.setText("");
                    et_Fahrenheit.setText("");
                    Toast.makeText(MainActivity.this,"請輸入欲轉換項目",Toast.LENGTH_SHORT).show();
                }
                else if(!((et_Celsius.getText().toString()).equals(""))) {
                    Celsius = et_Celsius.getText().toString(); //取得內容
                    c = Double.parseDouble(Celsius);
                    f=c*1.8+32;
                }
                else if(!((et_Fahrenheit.getText().toString()).equals(""))) {
                    Fahrenheit = et_Fahrenheit.getText().toString(); //取得內容
                    f = Double.parseDouble(Fahrenheit);
                    c=(f-32)/1.8;
                }
                else{
                    Toast.makeText(MainActivity.this,"請輸入其中一項",Toast.LENGTH_SHORT).show();
                    return;
                }

                DecimalFormat nf = new DecimalFormat("0.0");   //格式化物件 顯示小數點格式
                et_Celsius.setText(nf.format(c));
                et_Fahrenheit.setText(nf.format(f));
        }
    };
}
