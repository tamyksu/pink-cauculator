package com.example.october;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.sax.TextElementListener;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity   {

   // EditText operand2 = findViewById(R.id.oprand2);
   EditText operand1;
   EditText operand2;
   TextView resultET;
   String operation;
   static String op1,op2,result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("rrr","Create");
        operand1 = findViewById(R.id.oprand1);
        operand2 = findViewById(R.id.oprand2);
        resultET = findViewById(R.id.result2);
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
        /*"""
        operand2.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            public void afterTextChanged(Editable s) {

                InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
            }



        });
        operand1.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            public void afterTextChanged(Editable s) {

                InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
            }});
            """*/
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.i("rrr","onRestoreInstanceState");
        operand1.setText(op1);
        operand2.setText(op2);
        resultET.setText(result);

    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i("rrr","onSaveInstanceState");
        op1 = operand1.getText().toString();
        op2 = operand2.getText().toString();
        result = resultET.getText().toString();


    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("rrr","onStart");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("rrr","onPause");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("rrr","onResume");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("rrr","onStop");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("rrr","onDestroy");

    }

    public void plus(View view){
        operation = "+";
        operand2.requestFocus();
    }
    public void minus(View view){
        operation = "-";
        operand2.requestFocus();
    }
    public void mul(View view){
        operation = "*";
        operand2.requestFocus();
    }
    public void div(View view){
        operation = "/";
        operand2.requestFocus();

    }
    public void equal(View view) {
        if(!checkvalues())return;
        Integer temp =0;

        if(operation.equals("+"))
        {
            temp = Integer.parseInt(op1)+Integer.parseInt(op2);
        }
        else if(operation.equals("-"))
        {
             temp = Integer.parseInt(op1)-Integer.parseInt(op2);
        }
        else if(operation.equals("/"))
        {
             temp = Integer.parseInt(op1)/Integer.parseInt(op2);
        }
        else if(operation.equals("*"))
        {
             temp = Integer.parseInt(op1)*Integer.parseInt(op2);
        }
        result = String.valueOf(temp);
        resultET.setText(result);
    }
    public boolean checkvalues(){
        op1 = operand1.getText().toString();
        op2 = operand2.getText().toString();

        if (op1.equals("") || op2.equals(""))
        {
            Toast.makeText(getApplicationContext(), "first put numbers", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }





}