package com.student.admin.bookmanagementapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class Studentlogin extends AppCompatActivity {
    Button b,b1;
EditText ed1,ed2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studentlogin);
        ed1=(EditText)findViewById(R.id.username);
        ed2=(EditText)findViewById(R.id.password);
        b=(Button)findViewById(R.id.login);
        b1=(Button)findViewById(R.id.register);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),BooksearchstdActivity.class);
                startActivity(i);

            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),StudentregisterActivity.class);
                startActivity(i);

            }
        });

    }
}
