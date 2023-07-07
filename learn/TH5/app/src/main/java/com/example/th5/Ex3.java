package com.example.th5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.inputmethod.InputMethodManager;
import android.content.Context;
public class Ex3 extends AppCompatActivity {

    Button btn;
    TextView show;
    EditText birth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex3);

        btn = findViewById(R.id.btn);
        show =findViewById(R.id.show);
        birth = findViewById(R.id.birth);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(btn.getWindowToken(), 0);

                int year = Integer.parseInt(birth.getText().toString().trim());
                String[] listCan = {"Canh", "Tân", "Nhâm", "Quý", "Giáp", "Ất", "Bính", "Đinh", "Mậu", "Kỷ"};
                String[] listChi = {"Thân", "Dậu", "Tuất", "Hợi", "Tý", "Sửu", "Dần", "Mẹo", "Thìn", "Tỵ","Ngọ", "Mùi"};

                String string = String.format("Tuổi âm lịch của năm %s :\n>> %s %s",year, listCan[year%10], listChi[year%12]);
                show.setText(string);
            }
        });
    }
}