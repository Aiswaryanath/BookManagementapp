package com.student.admin.bookmanagementapp;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AdminsearchActivity extends AppCompatActivity {
    EditText ed1,ed2,ed3;
    Button b1,b2,b3,b4;
    String s1,s2,s3,getid,getbookid,getbookauthor;
    BookHelper bookHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminsearch);
        setContentView(R.layout.activity_booksearch);
        ed1=(EditText)findViewById(R.id.bookid);
        ed2=(EditText)findViewById(R.id.bookname);
        ed3=(EditText)findViewById(R.id.bookauthor);
        bookHelper=new BookHelper(this);
        bookHelper.getWritableDatabase();
        b1=(Button)findViewById(R.id.search);
        b2=(Button)findViewById(R.id.edit);
        b3=(Button)findViewById(R.id.delete);
        b4=(Button)findViewById(R.id.back);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s1 = ed1.getText().toString();
                s2 = ed2.getText().toString();
                s3 = ed3.getText().toString();
                Log.d("bookname", s1);

                Cursor cursor = bookHelper.SearchData(s1);
                if (cursor.getCount() == 0) {
                    Toast.makeText(getApplicationContext(), "No Name Found", Toast.LENGTH_LONG).show();
                } else {
                    while (cursor.moveToNext()) {
//                        s1 = cursor.getString(2);
                        s2 = cursor.getString(0);
                        s3 = cursor.getString(3);

//                        Toast.makeText(getApplicationContext(), s1, Toast.LENGTH_LONG).show();
                        Toast.makeText(getApplicationContext(), s2, Toast.LENGTH_LONG).show();
                        Toast.makeText(getApplicationContext(), s3, Toast.LENGTH_LONG).show();

                        ed2.setText(s2);
                        ed3.setText(s3);



                        getid=cursor.getString(0);
                        Toast.makeText(getApplicationContext(),getid,Toast.LENGTH_LONG).show();

                    }

                }
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getbookid = ed1.getText().toString();
                getbookauthor = ed3.getText().toString();
                boolean status=bookHelper.UpdateData(getid,getbookid,getbookauthor);
                if (status == true) {

                    Toast.makeText(getApplicationContext(), "Successfully Updated", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "error", Toast.LENGTH_LONG).show();
                }
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),BooksearchActivity.class);
                startActivity(i);
            }
        });
    }
}
