package com.zwg.xfj.db;

import android.database.sqlite.SQLiteDatabase;

/**
 * Created by ZhouWengong on 2017/1/11.
 */

public interface IBaseTable {
    void onCreate(SQLiteDatabase db);
}
