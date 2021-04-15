package com.example.studentdatabase;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends AppCompatActivity {
    DataBaseHelper mydb;
    private Button b12;
    private Button b13;
    private EditText e2;
    private EditText e3;


    ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        mydb = new DataBaseHelper(this);
        b12 = (Button) findViewById(R.id.button12);
        b13 = (Button) findViewById(R.id.button13);
        mydb = new DataBaseHelper(this);
        e2 = (EditText) findViewById(R.id.txt3);
        e3 = (EditText) findViewById(R.id.txt4);

        final ArrayList<String> theList = new ArrayList<>();

        b13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                theList.clear();
                ListView listView = (ListView) findViewById(R.id.listView1);
                String a=e2.getText().toString();
                String b=e3.getText().toString();
                Cursor data = mydb.search(a,b);
                while (data.moveToNext()) {
                    theList.add(data.getString(0));
                    theList.add(data.getString(1));
                    theList.add(data.getString(2));
                    theList.add(data.getString(3));
                    ListAdapter listAdapter = new ArrayAdapter<>(SearchActivity.this, android.R.layout.simple_list_item_1, theList);
                    listView.setAdapter(listAdapter);
                    //theList.notifyDataSetChanged();
                }

            }
        });

        b12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SearchActivity.this,HomeActivity.class));
            }
        });


    }
}