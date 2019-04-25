package com.example.zhexiantu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.zhexiantu.view.LinView;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private EditText editX,editY;
    private LinView lineView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button =(Button) findViewById(R.id.button_add);
        editX = findViewById(R.id.editX);
        editY=findViewById(R.id.editY);
        lineView = findViewById(R.id.lineView);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int x = Integer.parseInt(editX.getText().toString());
                int y = Integer.parseInt(editY.getText().toString());
                lineView.addPoi(x,y);
            }
        });


    }
}
