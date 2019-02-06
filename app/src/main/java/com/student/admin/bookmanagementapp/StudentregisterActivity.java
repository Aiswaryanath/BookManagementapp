package com.student.admin.bookmanagementapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class StudentregisterActivity extends AppCompatActivity {
    Button b,b1;
    EditText ed1,ed2,ed3,ed4,ed5;
    Spinner sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studentregister);
        ed1=(EditText)findViewById(R.id.name);
        ed2=(EditText)findViewById(R.id.rollno);
        ed3=(EditText)findViewById(R.id.emailid);
        ed4=(EditText)findViewById(R.id.username);
        ed5=(EditText)findViewById(R.id.password);
        sp=(Spinner)findViewById(R.id.department);
        b=(Button)findViewById(R.id.register);
        b1=(Button)findViewById(R.id.backtologin);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
