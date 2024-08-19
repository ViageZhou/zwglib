package com.zwg.xfj.db;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


/**
 * Created by ZhouWengong on 2017/1/11.
 */

public class DBHelper extends SQLiteOpenHelper {
    public static final String TAG = DBHelper.class.getSimpleName();

    private static final String NAME = "ConsumeRecord.db";
    private static final int VERSION = 1;
    private final ConsumeTable mConsumeTable;

    private static DBHelper helper;
    private SQLiteDatabase mDB;

    public static void init(Context context) {
        if (helper == null) {
            helper = new DBHelper(context);
            Log.e(TAG, "zwg----[init]:  ");
            ThreadPool.execute(() -> {
                helper.getReadableDatabase();
            });
        }
    }

    public static DBHelper getInstance() {
        return helper;
    }

    private DBHelper(Context context) {
        super(context, NAME, null, VERSION);
        mConsumeTable = new ConsumeTable(this);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        mDB = db;
        ThreadPool.execute(() -> {
            mConsumeTable.onCreate(db);
        });

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.e(TAG, "onUpgrade: ");
    }

    public void onClose() {
        Log.e(TAG, "onClose: ");
        mDB.close();
    }

    public ConsumeTable getChatListTable() {
        return mConsumeTable;
    }


}
