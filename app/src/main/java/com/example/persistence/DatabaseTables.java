package com.example.persistence;

public class DatabaseTables {
    public static final String TABLE_NAME = "DATABASE_TABLE";
    public static final String COLUMN_ID = "ID";
    public static final String COLUMN_NAME = "NAME";
    public static final String COLUMN_LOCATION = "LOCATION";

    /* create a table like this:
        TABLE
        |   ID  |   NAME    |   LOCATION    |
     */

    static final String SQL_CREATE_TABLE_DATA = "CREATE TABLE " + TABLE_NAME +
                    " (" + COLUMN_ID + " INTEGER PRIMARY KEY, " +
                    COLUMN_NAME + " TEXT, " +
                    COLUMN_LOCATION + " TEXT " +
                    ")";

    // Remove/drop the table
    static final String SQL_DELETE_TABLE_DATA = "DROP TABLE IF EXISTS " + TABLE_NAME;
}
