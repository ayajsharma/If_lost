package com.android.ajaysharma.iflost;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by AJAYSHARMA on 7/4/2017.
 */

public class myDatabase extends SQLiteOpenHelper
{
    Context context;
    public myDatabase(Context context)

    {
        super(context,"iflostdb",null,1);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query="create table user_detail(name text,username text,cno integer,password text)";
        sqLiteDatabase.execSQL(query);
        Toast.makeText(context,"table created",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
