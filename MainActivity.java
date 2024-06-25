package com.example.calculatorbmi;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView txtResult;
        EditText edtHeightFt,edtHeightIn,edtWeight;
        Button btnCalculate;
        edtWeight=findViewById(R.id.edtWeight);
        edtHeightIn=findViewById(R.id.edtHeightIn );
        edtHeightFt=findViewById(R.id.edtHeightFt);
        txtResult=findViewById(R.id.txtResult);
        btnCalculate=findViewById(R.id.btnCalculate);
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 int wt=Integer.parseInt(edtWeight.getText().toString());
                 int in=Integer.parseInt(edtHeightIn.getText().toString());
                 int ft=Integer.parseInt(edtHeightFt.getText().toString());
                 int totalIn=ft*12+in;
                 double totalCm=totalIn*2.53;
                 double totalMt=totalCm/100;
                 double bmi=wt/(totalMt*totalMt);
                 String formattedNumber = String.format("%.2f",bmi);
                 if(bmi>25){
                     txtResult.setText("You are Overweight "+formattedNumber);
                 } else if (bmi<18) {
                     txtResult.setText("You are Underweight "+formattedNumber);
                 }else{
                     txtResult.setText("You are Healthy "+formattedNumber);
                 }
            }
        });

    }
}