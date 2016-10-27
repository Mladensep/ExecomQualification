package com.ftn.timkodzo.execomqualification.dataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.ftn.timkodzo.execomqualification.model.TaskModel;

/**
 * Created by Mladen on 10/26/2016.
 */
public class DatabaseHelper extends SQLiteOpenHelper {


    public static final String DATABASE_NAME = "Tasks.db";
    public static final String TABLE_NAME = "tasks_table";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "TITLE";
    public static final String COL_3 = "TASK";
    public static final String COL_4 = "DONE";


    public DatabaseHelper(Context context) {

        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getReadableDatabase();

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table " + TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, TITLE TEXT, TASK TEXT, DONE INT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }

    public boolean insertData (String title, String task, int done) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(COL_2, title);
        contentValues.put(COL_3, task);
        contentValues.put(COL_4, done);

        long result = db.insert(TABLE_NAME, null, contentValues);

        if (result == -1)
            return false;

        else
            return true;

    }

    public Cursor getAll() {

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor result = db.rawQuery("select * from " + TABLE_NAME, null);

        return result;

    }

    public Cursor getTaskById(int taskId) {

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor result = db.rawQuery("select * from " + TABLE_NAME + " where " + COL_1 + " = " + taskId, null);

        return result;

    }

    public void deleteTask(TaskModel task) {
        long id = task.getId();
        this.getReadableDatabase().delete(DatabaseHelper.TABLE_NAME, DatabaseHelper.COL_1
                + " = " + id, null);
    }

    public void updataTask(int taskId, boolean isDone) {

        String where = "ID=?";
        String[] whereArgs = new String[]{String.valueOf(taskId)};

        ContentValues dataToInsert = new ContentValues();
        dataToInsert.put("DONE", isDone ? 1 : 0);

        this.getReadableDatabase().update(TABLE_NAME, dataToInsert, where, whereArgs);

    }

}
