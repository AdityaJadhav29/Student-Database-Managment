package com.example.studentdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddStudentActivity extends AppCompatActivity {
    private EditText e4;
    private EditText e5;
    private EditText e6;
    private EditText e7;
    private Button b8;
    private Button b9;

    DataBaseHelper mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);

        e4=findViewById(R.id.txt5);
        e5= findViewById(R.id.txt6);
        e6=findViewById(R.id.txt7);
        e7=findViewById(R.id.txt8);
        b8=findViewById(R.id.button9);
        b9=findViewById(R.id.button10);

        mydb=new DataBaseHelper(this);

        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AddStudentActivity.this,HomeActivity.class));
            }
        });

        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mydb.insertData1(e4.getText().toString(),e5.getText().toString(),e6.getText().toString(),e7.getText().toString());
            }
        });

    }
}