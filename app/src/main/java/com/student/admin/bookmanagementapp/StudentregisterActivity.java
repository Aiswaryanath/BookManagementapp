package com.student.admin.bookmanagementapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class StudentregisterActivity extends AppCompatActivity {
    Button b,b1;
    EditText ed1,ed2,ed3,ed4,ed5;
    Spinner sp;
    String s1,s2,s3,s4,s5,s;
    BookHelper bookHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studentregister);
        ed1=(EditText)findViewById(R.id.name);
        ed2=(EditText)findViewById(R.id.rollno);
        ed3=(EditText)findViewById(R.id.emailid);
        ed4=(EditText)findViewById(R.id.username);
        ed5=(EditText)findViewById(R.id.password);
        bookHelper=new BookHelper(this);
        bookHelper.getWritableDatabase();
        sp=(Spinner)findViewById(R.id.department);
        b=(Button)findViewById(R.id.register);
        b1=(Button)findViewById(R.id.backtologin);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s1=ed1.getText().toString();
                s2=ed2.getText().toString();
                s3=ed3.getText().toString();
                s4=ed4.getText().toString();
                s5=ed5.getText().toString();
s=sp.getSelectedItem().toString();

                Log.d("name",s1);
                Log.d("rollno",s2);
                Log.d("emailid",s3);
                Log.d("username",s4);
                Log.d("password",s5);
                boolean status=bookHelper.insertData(s1,s2,s3,s4,s5,s);
                if (status == true) {

                    Toast.makeText(getApplicationContext(), "Successfully registered", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "error in registration", Toast.LENGTH_LONG).show();
                }

            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
            }
        });
    }
}
