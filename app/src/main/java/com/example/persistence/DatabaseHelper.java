package com.example.persistence;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1; // If this is incremented onUpgrade() will be executed

    private DatabaseTables databaseTables;

    DatabaseHelper(Context context, String databaseFileName) {
        super(context, databaseFileName + ".db", null, DATABASE_VERSION);
    }

    // This method is executed only if there is not already a database in the file `Mountain.db`
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(DatabaseTables.SQL_CREATE_TABLE_DATA);
    }

    // This method is executed only if the database version has changed, e.g. from 1 to 2
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL(DatabaseTables.SQL_DELETE_TABLE_DATA);
        onCreate(sqLiteDatabase);
    }

    public boolean addData(Data data)
    {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(DatabaseTables.COLUMN_ID, data.getID());
        cv.put(DatabaseTables.COLUMN_NAME, data.getName());


        long insert = database.insert(DatabaseTables.TABLE_NAME, null, cv);

        if (insert != -1)
        {
            return true;
        }
        else
        {
            return false;
        }

    }
}
