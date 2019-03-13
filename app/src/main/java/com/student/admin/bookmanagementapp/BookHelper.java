package com.student.admin.bookmanagementapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
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
    public static final String TableName1 = "Booksearch";
    public static final String col01 = "id";
    public static final String col02 = "bookid";
    public static final String col03 = "bookname";
    public static final String col04 = "bookauthor";
//    public static final String col05 = "bookstatus";

    public BookHelper(Context context) {
        super(context, Dbname, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "create table " + TableName + "(" + col1 + " integer primary key autoincrement," + col2 + " text," + col3 + " text," + col4 + " text," + col5 + " text," + col6 + " text," + col7 +" text)";
        sqLiteDatabase.execSQL(query);
        String query1 = "create table " + TableName1 + "(" + col01 + " integer primary key autoincrement," + col02 + " text," + col03 + " text," + col04 + " text)";
        sqLiteDatabase.execSQL(query1);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String query = "drop table if exists " + TableName;
        sqLiteDatabase.execSQL(query);
        onCreate(sqLiteDatabase);
        String query1 = "drop table if exists " + TableName1;
        sqLiteDatabase.execSQL(query1);
        onCreate(sqLiteDatabase);

    }
    public boolean insertData(String name,String rollno,String emailid,String username,String password,String department) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(col2, name);
        contentValues.put(col3, rollno);
        contentValues.put(col4, emailid);
        contentValues.put(col5, username);
        contentValues.put(col6, password);
        contentValues.put(col7, department);

        long status = sqLiteDatabase.insert(TableName, null, contentValues);
        if (status == -1) {
            return false;
        } else {
            return true;
        }
    }
    public boolean insertData1(String bookid,String bookname,String bookauthor){
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(col02,bookid);
        cv.put(col03,bookname);
        cv.put(col04,bookauthor);
//        cv.put(col05,bookstatus);

        long status=sqLiteDatabase.insert(TableName1,null,cv);
        if (status==-1)
        {
            return false;
        }
        else
        {
            return true;
        }

    }
    public Cursor SearchData(String bookname)
    {

        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery("SELECT * FROM "+TableName1+" WHERE "+col03+"='"+bookname+"'",null);
        return cursor;
    }
}

