package com.example.gladandroidenginelib2;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.gladandroidenginelib2.engine.MainRunActivity;
import com.example.gladandroidenginelib2.game.MainView;
import com.example.gladandroidenginelib2.media.BitmapLoader;

import java.io.IOException;
import java.util.ArrayList;

//Библиотека для создания игр
public class MainActivity extends MainRunActivity {

    /*
    Здесь так же можно быстро объявить таблицу базы данных

    public static SQLiteDatabase someDB;
    public static Cursor cursor ;
    public static String DB_PATH ;
    public static ArrayList<SomeData> someData;

     */


    Context context;

    public MainView getNewView() {
        context = this;

        try {
            BitmapLoader.init(this, this.getGamePaint());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new MainView(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        /*
        Пример создания базы данных и получения из неё информации в вспомогательные классы
        !!! Подразумевается, что вся базовая информация добавлена в бд изначально, в дальнейшем производится только её получение/преобразование
        !!! Добавьте свои функции в BasicGameSupport, чтобы создать возможность добавления полей в бд во время игрового процесса

        someData = new ArrayList<>();
        DB_PATH = this.getFilesDir().getPath() + "some.db";
        someDB = getBaseContext().openOrCreateDatabase("some.db", MODE_PRIVATE, null);

        someDB.execSQL("CREATE TABLE IF NOT EXISTS some (_id INTEGER, name TEXT)");
        someDB.execSQL("INSERT into time (_id, stars, ach) VALUES (1, 'Yana')");

        for (int i = 0; i < BasicGameSupport.someDataCout; i++) {
            cursor = timeDB.rawQuery("SELECT * from some WHERE _id = " + (i + 1), null);
            if (cursor != null && cursor.moveToFirst()) {
                someData.add(new SomeData(cursor.getInt(0), cursor.getString(1)));
            }
        }

         */
    }
}