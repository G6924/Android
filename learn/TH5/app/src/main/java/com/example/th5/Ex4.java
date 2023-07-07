package com.example.th5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.inputmethod.InputMethodManager;
import android.content.Context;
public class Ex4 extends AppCompatActivity {

    Button btn;
    TextView show;
    EditText intN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex4);

        btn = findViewById(R.id.btn);
        show =findViewById(R.id.show);
        intN = findViewById(R.id.intN);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(btn.getWindowToken(), 0);

                int n = Integer.parseInt(intN.getText().toString().trim());
                int sum = 0;
                String string = String.format("Tổng từ 1 -> %s :\n>> ",n);
                for (int i = 1;i <= n; i++) {
                    sum += i;
                    if ( i == n) {
                        string += i;
                    }
                    else if ( i <n) {
                        string += i +" + ";
                    }
                }
                string += " = " + sum;
                show.setText(string);
            }
        });
    }
}