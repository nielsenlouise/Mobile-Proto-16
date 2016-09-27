package nielsen.lesson5_homework;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by lnielsen on 9/26/16.
 */

public class ToDoSQLHelper extends SQLiteOpenHelper {
    private static final String TEXT_TYPE = " TEXT";
    private static final String COMMA_SEP = ",";
    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + ToDoSchema.FeedEntry.TABLE_NAME + " (" +
                    ToDoSchema.FeedEntry._ID + " INTEGER PRIMARY KEY," +
                    ToDoSchema.FeedEntry.COLUMN_NAME_TEXT + TEXT_TYPE + COMMA_SEP +
                    ToDoSchema.FeedEntry.COLUMN_NAME_COMPLETE + TEXT_TYPE + " )";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + ToDoSchema.FeedEntry.TABLE_NAME;

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "FeedReader.db";

    public ToDoSQLHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

    public void addToDo(String text, boolean isComplete) {
        // Gets the data repository in write mode
        SQLiteDatabase db = this.getWritableDatabase();

        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(ToDoSchema.FeedEntry.COLUMN_NAME_TEXT, text);
        values.put(ToDoSchema.FeedEntry.COLUMN_NAME_COMPLETE, isComplete);

        // Insert the new row, returning the primary key value of the new row
        long newRowId = db.insert(ToDoSchema.FeedEntry.TABLE_NAME, null, values);
    }

    // change this return type to ArrayList
    public void readDatabase() {}

    public void deleteToDo(String toDoText) {}

    public void updateToDo(String currentToDoText, String newToDoText, boolean changeComplete) {}
}

