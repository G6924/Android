package com.example.th5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.inputmethod.InputMethodManager;
import android.content.Context;
public class Ex1 extends AppCompatActivity {

    Button btn;
    TextView show;
    EditText numa, numb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex1);

        btn = findViewById(R.id.btn);
        show =findViewById(R.id.show);
        numa = findViewById(R.id.numa);
        numb = findViewById(R.id.numb);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(btn.getWindowToken(), 0);

                int a = Integer.parseInt(numa.getText().toString().trim());
                int b = Integer.parseInt(numb.getText().toString().trim());

                if ( a > b) {
                    show.setText("Số lớn nhất là : "+a);
                }
                else if ( a < b) {
                    show.setText("Số lớn nhất là : "+b);
                }
            }
        });
    }
}