package com.student.admin.bookmanagementapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class BooksearchActivity extends AppCompatActivity {
    Button b,b1,b2;
    EditText ed1,ed2,ed3;
//    Spinner sp;
  String s1,s2,s3;
    BookHelper bookHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booksearch);
        ed1=(EditText)findViewById(R.id.bookid);
        ed2=(EditText)findViewById(R.id.bookname);
        ed3=(EditText)findViewById(R.id.bookauthor);
        bookHelper=new BookHelper(this);
        bookHelper.getWritableDatabase();
//        sp=(Spinner)findViewById(R.id.department);
        b=(Button)findViewById(R.id.submit);
        b1=(Button)findViewById(R.id.edit);
        b2=(Button)findViewById(R.id.delete);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s1=ed1.getText().toString();
                s2=ed2.getText().toString();
                s3=ed3.getText().toString();
//                s=sp.getSelectedItem().toString();
                Log.d("bookid",s1);
                Log.d("bookname",s2);
                Log.d("bookauthor",s3);
                boolean status=bookHelper.insertData1(s1,s2,s3);
                if (status == true) {

                    Toast.makeText(getApplicationContext(), "Successfully inserted", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "error", Toast.LENGTH_LONG).show();
                }


            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
