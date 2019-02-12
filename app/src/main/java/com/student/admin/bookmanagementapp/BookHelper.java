package com.student.admin.bookmanagementapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 2/12/2019.
 */
public class BookHelper extends SQLiteOpenHelper {
    public static final String Dbname = "Book.db";
    public static final String TableName = "Book";
    public static final String col1 = "id";
    public static final String col2 = "name";
    public static final String col3 = "rollno";
    public static final String col4 = "emailid";
    public static final String col5 = "username";
    public static final String col6 = "password";
    public static final String col7 = "department";
    public BookHelper(Context context) {
        super(context, Dbname, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "create table " + TableName + "(" + col1 + " integer primary key autoincrement," + col2 + " text," + col3 + " text," + col4 + " text," + col5 + " text," + col6 + " text," + col7 +" text)";
        sqLiteDatabase.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String query = "drop table if exists " + TableName;
        sqLiteDatabase.execSQL(query);
        onCreate(sqLiteDatabase);

    }
    public boolean insertData(String name,String rollno,String emailid,String username,String password,String department){
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(col2,name);
        contentValues.put(col3,rollno);
        contentValues.put(col4,emailid);
        contentValues.put(col5,username);
        contentValues.put(col6,password);
        contentValues.put(col7,department);

        long status=sqLiteDatabase.insert(TableName,null,contentValues);
        if (status==-1)
        {
            return false;
        }
        else
        {
            return true;
        }

    }
}

