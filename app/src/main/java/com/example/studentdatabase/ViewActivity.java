package com.example.studentdatabase;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ViewActivity extends AppCompatActivity {

    DataBaseHelper mydb;
    Button b8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        ListView listView=(ListView)findViewById(R.id.listView);
        b8=(Button)findViewById(R.id.button11);
        mydb=new DataBaseHelper(this);
        ArrayList<String> theList=new ArrayList<>();
        Cursor data =mydb.showData1();
        while (data.moveToNext()){
            theList.add(data.getString(0));
            theList.add(data.getString(1));
            theList.add(data.getString(2));
            theList.add(data.getString(3));
            ListAdapter listAdapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,theList);
            listView.setAdapter(listAdapter);
        }
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ViewActivity.this,HomeActivity.class));
            }
        });

    }
}



