package seeto.c2.artoria.us.myapplication.UI.QM;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "MEMO";
    private static final String TABLE_TEXT = "MEMO";
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE_MEMO =
                "CREATE TABLE " + TABLE_TEXT + "(" +
                        KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        KEY_NAME + " TEXT NOT NULL" +
                        ");";
        db.execSQL(CREATE_TABLE_MEMO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String DROP_TABLE_MEMO =
                "DROP TABLE IF EXISTS " + TABLE_TEXT;
        db.execSQL(DROP_TABLE_MEMO);

        onCreate(db);
    }

    public void add(String memo) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, memo);

        db.insert(TABLE_TEXT, null, values);
        db.close();
    }

    public void deleteRow(String memo) {
        SQLiteDatabase db = this.getWritableDatabase();
        Log.d("deleteRow", "");
        String[] selectionArg = {memo};
        db.delete(TABLE_TEXT, KEY_NAME + " LIKE?", selectionArg);
    }

    public void updateRow(String modifiedMemo, String oldMemo) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues content = new ContentValues();
        content.put(KEY_NAME, modifiedMemo);
        String[] oldMemoSelection = {oldMemo};
        Log.d("DEBUG", modifiedMemo);
        db.update(TABLE_TEXT, content, KEY_NAME + "=?",oldMemoSelection);
    }

    public ArrayList<Memo> getAll() {
        ArrayList<Memo> textList = new ArrayList<Memo>();
        String SELECT_ALL = "SELECT * FROM " + TABLE_TEXT;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(SELECT_ALL, null);

        if (cursor.moveToFirst()) {
            do {
                Memo memo = new Memo();
                memo.setId(Integer.parseInt(cursor.getString(0)));
                memo.setText(cursor.getString(1));
                textList.add(memo);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return textList;
    }
}