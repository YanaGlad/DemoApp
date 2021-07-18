package com.example.gladandroidenginelib2.graphics;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;

import java.io.IOException;
import java.io.InputStream;

//Класс для работы с графикой в игре
public class GamePaint {

    private AssetManager am; //AssetManager для взаимодействия с репозиторией assets
    private Bitmap mainBitmap; // Основной Bitmap
    private Canvas canvas; // холст
    private Paint paint; // ОбЪект класса Paint, который задает стиль текста

    public GamePaint(AssetManager am, Bitmap mainBitmap) {
        this.am = am;
        this.mainBitmap = mainBitmap;
        this.canvas = new Canvas(mainBitmap);
        this.paint = new Paint();
        // Игровой шрифт
        Typeface mainFont = Typeface.createFromAsset(am, "try3.otf"); // подключение шрифта из assets
        paint.setTypeface(mainFont); // подеключить шрифт к paint
        paint.setAntiAlias(true); // включить сглаживание текстур
    }

    public void write(String text, int x, int y, int color, int sizeText) { // метод, отвечающий за отображение текста
        paint.setColor(color); //цвет
        paint.setTextSize(sizeText);  //размер
        canvas.drawText(text, x, y, paint); //отрисовка на холсте по координатам x и y
    }

    public void setVisibleBitmap(Bitmap textureGame, int x, int y) { // отрисовка Bitmap'a(текстуры) на холсте
        canvas.drawBitmap(textureGame, x, y, null);
    }

    public Bitmap createNewGraphicsBitmap(String name) { //Загрузка изображения из assets
        InputStream inputStream;
        Bitmap bitmap;
        try {
            inputStream = am.open(name);
            bitmap = BitmapFactory.decodeStream(inputStream);
            if (bitmap == null) {
                throw new RuntimeException("Unable to load file " + name);
            }
        } catch (IOException e) {
            throw new RuntimeException("Unable to load file " + name);
        }
        try {
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bitmap;
    }

    public void createGreenRect(int left, int top, int right, int bottom) {
        paint.setColor(Color.GREEN);
        canvas.drawRect(left, top, right, bottom, paint);
    }

    public void createLine(int startX, int startY, int stopX, int stopY, int color) {
        paint.setColor(color);
        canvas.drawLine(startX, startY, stopX, stopY, paint);
    }

    public Bitmap getMainBitmap() {
        return mainBitmap;
    }
}
