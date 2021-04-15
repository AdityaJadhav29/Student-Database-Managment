package com.example.studentdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Activity;

import java.net.PasswordAuthentication;

public class MainActivity extends AppCompatActivity {

    private EditText e1;
    private EditText p1;
    private Button b1;
    private TextView t1;
    int counter=5;
    private Button b2;
    DataBaseHelper mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mydb=new DataBaseHelper(this);

        e1=(EditText)findViewById(R.id.txt);
        p1=(EditText)findViewById(R.id.pass);
        b1=(Button) findViewById(R.id.button);
        b2=(Button) findViewById(R.id.button2);
        t1=(TextView)findViewById(R.id.textView);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String username=e1.getText().toString();
                String password=p1.getText().toString();

                if(mydb.Login(username,password))
                {
                    Toast.makeText(MainActivity.this,"Processing",Toast.LENGTH_LONG).show();
                    startActivity(new Intent(MainActivity.this,HomeActivity.class));;
                }else{
                    Toast.makeText(MainActivity.this,"Wrong",Toast.LENGTH_LONG).show();
                    Toast.makeText(MainActivity.this,"Attemps Left "+counter,Toast.LENGTH_LONG).show();
                    counter--;
                }

                if(counter==0)
                {
                    b1.setEnabled(false);
                }
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,SignupActivity.class));
            }
        });
    }
}