package com.student.admin.bookmanagementapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

 public class AdminActivity extends AppCompatActivity {
String getS1,getS2,getS3,getid,bookstatus,getnewS2,getnewS3;
     Button b1,b2,b3,b4;
     EditText ed1,ed2,ed3,ed4;
     BookHelper bookHelper;
     AlertDialog.Builder builder;
     @Override
     protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_adminsearch);
         builder=new AlertDialog.Builder(this);
         builder.setTitle("conform");
         builder.setMessage("are you sure you want to delete");
         builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
             @Override
             public void onClick(DialogInterface dialogInterface, int i) {
                 boolean status=bookHelper.DeleteData(getid);
                 if (status==true)
                 {
                     Toast.makeText(getApplicationContext(),"deleted",Toast.LENGTH_LONG).show();
                 }
                 else
                 {
                     Toast.makeText(getApplicationContext(),"not deleted",Toast.LENGTH_LONG).show();
                 }
                 Toast.makeText(getApplicationContext(),"yes clicked",Toast.LENGTH_LONG).show();
                 dialogInterface.dismiss();
             }
         });
         builder.setNegativeButton("no", new DialogInterface.OnClickListener() {
             @Override
             public void onClick(DialogInterface dialogInterface, int i) {
                 Toast.makeText(getApplicationContext(),"no clicked",Toast.LENGTH_LONG).show();
                 dialogInterface.dismiss();
             }
         });

         ed1 = (EditText) findViewById(R.id.bookname);
         ed2= (EditText) findViewById(R.id.bookid);
         ed3 = (EditText) findViewById(R.id.bookauthor);
         ed4 = (EditText) findViewById(R.id.bookstatus);
         b1=(Button)findViewById(R.id.edit1);
         b2=(Button)findViewById(R.id.delete);
         b4=(Button)findViewById(R.id.back);
         bookHelper=new BookHelper(this);
         bookHelper.getWritableDatabase();
         b3 = (Button) findViewById(R.id.search);
         b3.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 getS1 = ed1.getText().toString();
                 getS2 = ed2.getText().toString();
                 getS3 = ed3.getText().toString();
                 bookstatus=ed4.getText().toString();
                 Log.d("s1", getS1);
                 Cursor cursor = bookHelper.SearchData(getS1);
                 if (cursor.getCount() == 0) {
                     Toast.makeText(getApplicationContext(), "No Name Found", Toast.LENGTH_LONG).show();
                 } else {
                     while (cursor.moveToNext()) {
                         getS2 = cursor.getString(1);
                         getS3 = cursor.getString(3);
                         bookstatus=cursor.getString(4);
                         Toast.makeText(getApplicationContext(), getS2, Toast.LENGTH_LONG).show();
                         Toast.makeText(getApplicationContext(), getS3, Toast.LENGTH_LONG).show();
                         Toast.makeText(getApplicationContext(), bookstatus, Toast.LENGTH_LONG).show();
                         ed2.setText(getS2);
                         ed3.setText(getS3);
                         ed4.setText(bookstatus);
                         getid = cursor.getString(0);
                         Toast.makeText(getApplicationContext(), getid, Toast.LENGTH_LONG).show();
                     }
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
         b1.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 getnewS2 = ed2.getText().toString();
                 getnewS3= ed3.getText().toString();
                 bookstatus=ed4.getText().toString();
                 boolean status = bookHelper.UpdateData(getid,getnewS2,getnewS3,bookstatus);
                 if (status==true)
                 {
                     Toast.makeText(getApplicationContext(),"Success",Toast.LENGTH_LONG).show();
                 }
                 else {
                     Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_LONG).show();
                 }
             }
         });
         b2.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 AlertDialog alertDialog=builder.create();
                 alertDialog.show();

             }
         });
     }
 }


