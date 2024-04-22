package com.example.persistence;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    // If this is incremented onUpgrade() will be executed
    private static final int DATABASE_VERSION = 1;

    DatabaseHelper(Context context) {
        super(context, "database.db", null, DATABASE_VERSION);
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

    public boolean DropTable()
    {
        SQLiteDatabase database = this.getWritableDatabase();
        return database.delete(DatabaseTables.TABLE_NAME, null, null) > 0;
    }

    /* add table properties and data an example:
       TABLE
       |   ID  |   NAME    |   LOCATION    |

       |   23  |   K2      |   Karakoram     |
    */
    public boolean AddData(Data data)
    {
        // make SQLiteDatabase WritableDatabase
        SQLiteDatabase database = this.getWritableDatabase();

        // can add table properties and data
        ContentValues cv = new ContentValues();
        cv.put(DatabaseTables.COLUMN_ID, data.getID());
        cv.put(DatabaseTables.COLUMN_NAME, data.getName());
        cv.put(DatabaseTables.COLUMN_LOCATION, data.getLocation());

        // then insert all table properties and data to table name
        long insertData = database.insert(DatabaseTables.TABLE_NAME, null, cv);

        // checking if insertData successful or not.
        if (insertData != -1)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public List<Data> SelectAllData()
    {
        // list of data
        List<Data> returnListData = new ArrayList<>();

        // grab data from the table database
        String queryString = "SELECT * FROM " + DatabaseTables.TABLE_NAME;

        // SQLiteDatabase can only read on database
        SQLiteDatabase database = this.getReadableDatabase();

        // return a cursor for grabbing rows of data (like an array) on columns from database
        Cursor cursor = database.rawQuery(queryString, null);

        // move cursor to first result and find result data. if cursor find data then read data else don't add anything on the returnListData
        if (cursor.moveToFirst())
        {
            // keep looking through the next line and find cursor result data, Grab data and add in returnListData
            do {
                String id = cursor.getString(0);
                String name = cursor.getString(1);
                String location = cursor.getString(2);

                Data newData = new Data(id, name, location);
                returnListData.add(newData);
            }while (cursor.moveToNext());
        }
        else
        {
            // don't add anything on the returnListData
        }

        // close both so that the database is done when looking through data.
        cursor.close();
        database.close();

        return returnListData;
    }
}
