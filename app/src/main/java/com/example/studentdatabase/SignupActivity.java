package com.example.studentdatabase;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentProviderClient;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.TestLooperManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignupActivity extends AppCompatActivity {
    private Button b3;
    private Button b4;
    private Button b7;
    private EditText t3;
    private EditText t4;
    DataBaseHelper mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        mydb = new DataBaseHelper(this);

        b3 = (Button) findViewById(R.id.button3);
        b4 = (Button) findViewById(R.id.button4);
        b7 = (Button) findViewById(R.id.button7);
        t3 = (EditText) findViewById(R.id.Text1);
        t4 = (EditText) findViewById(R.id.Text2);



        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(t3.getText().toString()) && TextUtils.isEmpty(t4.getText().toString())){
                    Toast.makeText(SignupActivity.this,"Enter Data ",Toast.LENGTH_LONG).show();
                }
                else {
                    boolean res= mydb.insertData(t3.getText().toString(), t4.getText().toString());
                    Toast.makeText(SignupActivity.this,"Data Inserted Succesfully",Toast.LENGTH_LONG).show();
                }
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor res = mydb.showData();
                if (res.getCount() == 0) {
                    showMessage("Error",null);
                }
                StringBuffer buff = new StringBuffer();
                while (res.moveToNext()) {
                    buff.append("Username:" + res.getString(0) + "\n");
                    buff.append("Password:" + res.getString(1)+ "\n");
                }
                showMessage("Username And Password List",buff.toString());
            }
        });

        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignupActivity.this,MainActivity.class));
            }
        });
    }

    public void showMessage(String Title,String Message){
        AlertDialog.Builder build=new AlertDialog.Builder(this);
        build.setCancelable(true);
        build.setTitle(Title);
        build.setMessage(Message);
        build.show();
    }


}