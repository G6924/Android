package com.example.th5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btn;
    EditText ex;
    TextView nullEx;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.btn);
        ex = findViewById(R.id.ex);
        nullEx = findViewById(R.id.nullEx);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(btn.getWindowToken(), 0);

                int e = Integer.parseInt(ex.getText().toString().trim());
                intentEx(e);
            }
        });
    }
    public void intentEx(int e) {
        Intent intent;
        switch (e) {
            case 1:
                intent = new Intent(MainActivity.this, Ex1.class);
                startActivity(intent);
                break;
            case 2:
                intent = new Intent(MainActivity.this, Ex2.class);
                startActivity(intent);
                break;
            case 3:
                intent = new Intent(MainActivity.this, Ex3.class);
                startActivity(intent);
                break;
            case 4:
                intent = new Intent(MainActivity.this, Ex4.class);
                startActivity(intent);
                break;
            case 5:
                intent = new Intent(MainActivity.this, Ex5.class);
                startActivity(intent);
                break;
            default:
                nullEx.setText(String.format("Does not exits Ex%s",e));
                break;
        }
    }
}