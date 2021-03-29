package com.example.lan.tku_food_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Calorie extends AppCompatActivity {

    private Button boy,girl,btnno,btnone,btntwo,btnthree;
    private EditText height,weight,grade;
    private TextView txtView,txtView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calorie);
        initialWidgets();

        boy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double Height ;
                double Weight;
                double Grade;
                double Boybmr;

                Height=Double.parseDouble(height.getText().toString());
                Weight=Double.parseDouble(weight.getText().toString());
                Grade=Double.parseDouble(grade.getText().toString());

                Boybmr = ((13.7 * Weight) + (5.0 * Height) - (6.8 * Grade) + 66);
                txtView.setText(String.format("%.2f", Boybmr));
            }
        });
        girl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double Height ;
                double Weight;
                double Grade;
                double Girlbmr;

                Height=Double.parseDouble(height.getText().toString());
                Weight=Double.parseDouble(weight.getText().toString());
                Grade=Double.parseDouble(grade.getText().toString());

                Girlbmr = ((9.6 * Weight) + (1.8 * Height) - (4.7 * Grade) + 655);

                txtView.setText(String.format("%.2f", Girlbmr));
            }
        });
        btnno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double no;
                double Ans;

                Ans=Double.parseDouble(txtView.getText().toString());
                no =(Ans*1.2);
                txtView2.setText(String.format("%.2f", no));
            }
        });

        btnone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double no;
                double Ans;

                Ans=Double.parseDouble(txtView.getText().toString());
                no =(Ans*1.375);
                txtView2.setText(String.format("%.2f", no));            }
        });
        btntwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double no;
                double Ans;

                Ans=Double.parseDouble(txtView.getText().toString());
                no =(Ans*1.55);
                txtView2.setText(String.format("%.2f", no));            }
        });
        btnthree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double no;
                double Ans;

                Ans=Double.parseDouble(txtView.getText().toString());
                no =(Ans*1.725);
                txtView2.setText(String.format("%.2f", no));            }
        });



    }

    private void initialWidgets() {
        boy=(Button) findViewById(R.id.boy);
        girl=(Button) findViewById(R.id.girl);
        btnno=(Button) findViewById(R.id.btnno);
        btnone=(Button) findViewById(R.id.btnone);
        btntwo=(Button) findViewById(R.id.btntwo);
        btnthree=(Button) findViewById(R.id.btnthree);
        height=(EditText) findViewById(R.id.height);
        weight=(EditText) findViewById(R.id.weight);
        grade=(EditText) findViewById(R.id.grade);
        txtView=(TextView) findViewById(R.id.txtView);
        txtView2=(TextView) findViewById(R.id.txtView2);
    }

}

