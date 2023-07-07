package com.example.th5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.inputmethod.InputMethodManager;
import android.content.Context;
public class Ex5 extends AppCompatActivity {

    Button btn;
    TextView show;
    EditText numa, numb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex5);

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

                int ucln = findUCLN(a,b);
                int bcnn = findBCNN(a,b);

                String string = String.format("+/ UCLN : %s\n+/ BCNN : %s", ucln, bcnn);
                show.setText(string);
            }
        });
    }
    public static int findUCLN(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    public static int findBCNN(int a, int b) {
        return a * b / findUCLN(a,b);
    }
}