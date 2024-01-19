package com.appdeveloperrakib.sqlitedatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edName, edNumber;
    Button btnInsert, btnShowData;

    DatabaseHelper dbhelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edName = findViewById(R.id.edName);
        edNumber = findViewById(R.id.edumber);
        btnInsert = findViewById(R.id.btn_insertData);
        btnShowData = findViewById(R.id.btn_showData);
        dbhelper = new DatabaseHelper(MainActivity.this);


        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //intert data to sqlite database
                dbhelper.insertData(edName.getText().toString(),edNumber.getText().toString());

                Toast.makeText(MainActivity.this, "Data has been inserted", Toast.LENGTH_SHORT).show();
            }
        });

        btnShowData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(MainActivity.this,ShowResult.class));

            }
        });


    }
}