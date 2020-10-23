package com.example.listviewexample;


import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//import io.bloco.faker.Faker;

public  class MainActivity extends AppCompatActivity {
    public static HashMap<String, Double> hashMap;
    String[] items={
            "EUR","JPY","GBP","CHF","AUD","CAD","SEK","NOK","DKK","RUB","VND"
    };

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hashMap = new HashMap<String, Double>();
        hashMap.put("EUR", 24100.88);
        hashMap.put("JPY", 206.59);
        hashMap.put("GBP", 28638.26);
        hashMap.put("CHF", 22194.28);
        hashMap.put("AUD", 16431.32);
        hashMap.put("CAD", 16804.61);
        hashMap.put("SEK", 2539.86);
        hashMap.put("NOK", 2575.66);
        hashMap.put("DKK", 3240.51);
        hashMap.put("RUB", 344.49);
        hashMap.put("VND", 1.0);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        Spinner spinner1=findViewById(R.id.spinner1);
        Spinner spinner2=findViewById(R.id.spinner2);
        EditText edit_number=findViewById(R.id.edit_number);
        TextView result=findViewById(R.id.result);
        spinner1.setAdapter(adapter);
        spinner2.setAdapter(adapter);
        spinner1.setSelection(1);
        spinner2.setSelection(1);

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                edit_number.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                        try{
                            String a=spinner1.getSelectedItem().toString();
                            double a1=hashMap.get(a);
                            String b=spinner2.getSelectedItem().toString();
                            double b1=hashMap.get(b);
                            int i=Integer.parseInt(edit_number.getText().toString());
                            double ketqua=(a1/b1*i);
                            result.setText(String.valueOf(ketqua));
                        }
                        catch(Exception e){
                            result.setText("Loi 1");
                        }
                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                        try{
                            String a=spinner1.getSelectedItem().toString();
                            double a1=hashMap.get(a);
                            String b=spinner2.getSelectedItem().toString();
                            double b1=hashMap.get(b);
                            int i=Integer.parseInt(edit_number.getText().toString());
                            double ketqua=(a1/b1*i);
                            result.setText(String.valueOf(ketqua));
                        }
                        catch(Exception e){
                            result.setText("Loi 2");
                        }
                    }

                    @Override
                    public void afterTextChanged(Editable editable) {
                        Log.v("TAG", "afterTextChanged: " + editable.toString());
                    }
                });
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                edit_number.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                        try{
                            String a=spinner1.getSelectedItem().toString();
                            double a1=hashMap.get(a);
                            String b=spinner2.getSelectedItem().toString();
                            double b1=hashMap.get(b);
                            int i=Integer.parseInt(edit_number.getText().toString());
                            int ketqua=(int)(a1/b1*i);
                            result.setText(String.valueOf(ketqua));
                        }
                        catch(Exception e){
                            result.setText("Loi 1");
                        }
                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                        try{
                            String a=spinner1.getSelectedItem().toString();
                            double a1=hashMap.get(a);
                            String b=spinner2.getSelectedItem().toString();
                            double b1=hashMap.get(b);
                            int i=Integer.parseInt(edit_number.getText().toString());
                            int ketqua=(int)(a1/b1*i);
                            result.setText(String.valueOf(ketqua));
                        }
                        catch(Exception e){
                            result.setText("Loi 2");
                        }
                    }

                    @Override
                    public void afterTextChanged(Editable editable) {
                        Log.v("TAG", "afterTextChanged: " + editable.toString());
                    }
                });
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });




    }


}
