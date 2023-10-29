package com.example.proyecto_nuevo;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;
import android.content.Context;

public class DataHelper extends SQLiteOpenHelper {
    public DataHelper (@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL("CREATE TABLE dispositivos (id INTEGER PRIMARY KEY, tipo TEXT, marca TEXT, modelo TEXT, usuario TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS dispositivos");

        db.execSQL("CREATE TABLE dispositivos (id INTEGER PRIMARY KEY, tipo TEXT, marca TEXT, modelo TEXT, usuario TEXT)");
    }
}
