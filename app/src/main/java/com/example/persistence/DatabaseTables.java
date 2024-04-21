package com.example.persistence;

public class DatabaseTables {
    public static String TABLE_NAME = "Hello";
    public static String[] COLUMN_VALUES;

    public static final String COLUMN_ID = "ID";
    public static final String COLUMN_NAME = "Name";
    public static final String COLUMN_VALUE = "Value";

    /*
    public DatabaseTables(String tableName, String[] totalValues)
    {
        TABLE_NAME = tableName;
        COLUMN_VALUES = new String[totalValues.length];
    }

     */

    static final String SQL_CREATE_TABLE_DATA = Table();

    // "DROP TABLE IF EXISTS mountain"
    static final String SQL_DELETE_TABLE_DATA = "DROP TABLE IF EXISTS " + TABLE_NAME;

    private static String Table()
    {
        String table =
                "CREATE TABLE " + TABLE_NAME +
                " (" + COLUMN_ID + " INTEGER PRIMARY KEY, " +
                        COLUMN_NAME + " TEXT ";
        /*
        if (COLUMN_VALUES != null)
        {
            for (int i = 0; i < COLUMN_VALUES.length; i++)
            {
                table += COLUMN_VALUE + " TEXT, ";
            }
        }
        else
        {
            table += "NULL" + " TEXT, ";
        }

         */

        //table = table.substring(0, table.length() - 2);

        table += ");";

        return table;
    }
}
