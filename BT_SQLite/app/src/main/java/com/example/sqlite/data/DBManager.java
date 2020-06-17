package com.example.sqlite.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.sqlite.model.Student;

import java.util.ArrayList;
import java.util.List;

public class DBManager extends SQLiteOpenHelper {
    private static final String DATABASE_NAME="Student Manager";
    private static final String TABLE_NAME="Students";
    private static final String STUDENT_ID="StudentID";
    private static final String NAME="Name";
    private static final String ADDRESS="Address";
    private static final String EMAIL="Email";
    private static final String DATE="Date";


    private String SQLiteQuery="CREATE TABLE "+ TABLE_NAME+" ( "+
                                STUDENT_ID  + " integer primary key, "+
                                NAME + " TEXT, "+
                                ADDRESS+ " TEXT, "+
                                EMAIL+ " TEXT, "+
                                DATE+ " TEXT)";


    public DBManager(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQLiteQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void addStudent(Student student){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(NAME,student.getName());
        contentValues.put(DATE, student.getDateOfBirth());
        contentValues.put(EMAIL, student.getEmail());
        contentValues.put(ADDRESS, student.getAddress());
        db.insert(TABLE_NAME, null,contentValues);
        db.close();
    }

    public List<Student> getListStudent(){
        List<Student> list=new ArrayList<>();
        String selectQuery="SELECT * FROM "+ TABLE_NAME;
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery(selectQuery, null);
        if(cursor.moveToFirst()){
            do{
                Student student=new Student();
                student.setStudentID(cursor.getInt(0));
                student.setName(cursor.getString(1));
                student.setDateOfBirth(cursor.getString(2));
                student.setEmail(cursor.getString(3));
                student.setAddress(cursor.getString(4));
                list.add(student);

            }while (cursor.moveToNext());
        }
        db.close();
        return list;
    }
}
