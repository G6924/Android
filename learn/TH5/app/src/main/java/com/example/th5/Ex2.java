package com.example.th5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.inputmethod.InputMethodManager;
import android.content.Context;
public class Ex2 extends AppCompatActivity {

    Button btn;
    TextView show;
    EditText numa, numb, numc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex2);

        btn = findViewById(R.id.btn);
        show =findViewById(R.id.show);
        numa = findViewById(R.id.numa);
        numb = findViewById(R.id.numb);
        numc = findViewById(R.id.numc);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(btn.getWindowToken(), 0);

                int a = Integer.parseInt(numa.getText().toString().trim());
                int b = Integer.parseInt(numb.getText().toString().trim());
                int c = Integer.parseInt(numc.getText().toString().trim());

                double delTa = (b*b) - (4*a*c);
                String valueNgh = "";
                if (delTa < 0) {
                    valueNgh = String.format("Phuong trinh tren Vo Nghiem ");
                }
                else if (delTa > 0) {
                    double nghiem1 = ((-b) + Math.sqrt(delTa))/(2*a);
                    double nghiem2 = ((-b) - Math.sqrt(delTa))/(2*a);
                    valueNgh = String.format("Phuong trinh co 2 nghiem la : \n x1 = %s ,\n x2 = %s",nghiem1, nghiem2);
                }
                else if (delTa == 0) {
                    double nghiem = -(b/(2*a));
                    valueNgh = String.format("Phuong trinh co 2 nghiem la : \n 	x1 = x2 = %d",nghiem);
                }

                String PT = String.format("PT : (%sx^2) + (%sx) + (%s) = 0\n -> Delta = %s\n", a, b, c,delTa);

                String strings = String.format("+/ %s \n+/ %s", PT, valueNgh);
                show.setText(strings);

            }
        });
    }
}