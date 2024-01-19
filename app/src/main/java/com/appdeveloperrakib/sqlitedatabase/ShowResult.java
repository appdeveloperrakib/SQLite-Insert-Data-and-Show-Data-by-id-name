package com.appdeveloperrakib.sqlitedatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class ShowResult extends AppCompatActivity {

    TextView tvResult;

    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_result);

        tvResult = findViewById(R.id.tvResult);
        databaseHelper = new DatabaseHelper(ShowResult.this);

        Cursor cursor = databaseHelper.searchDatabyName("XYZ");
        tvResult.setText("Total Data:  "+cursor.getCount());
        
        
        if(cursor!=null && cursor.getCount()>0){

            while (cursor.moveToNext()){

                int id = cursor.getInt(0);
                String name = cursor.getString(1);
                String mobile = cursor.getString(2);
                tvResult.append("\nID: "+id+" Name: "+name+" Mobile: "+mobile);

            }  
            
        }else {
            Toast.makeText(this, "No Data Found", Toast.LENGTH_SHORT).show();
            tvResult.setText("NO DATA");
        }
        

    

    }
}