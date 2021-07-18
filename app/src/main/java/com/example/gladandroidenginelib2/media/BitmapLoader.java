package com.example.gladandroidenginelib2.media;

import android.graphics.Bitmap;


import com.example.gladandroidenginelib2.engine.MainRunActivity;
import com.example.gladandroidenginelib2.graphics.GamePaint;

import java.io.IOException;
import java.util.ArrayList;

//Загрузчик изображений и прочих ресурсов из assets
public class BitmapLoader {

    //Лист из спрайтов объекта
    public static ArrayList<Bitmap> asteroidSprite;

    //Музыка
    public static Media.Music stayInsideMusic;

    //Кнопки
    public static Bitmap blueLevelButtonClicked, blueLevelButton;

    //Фоны
    public static Bitmap spaceBackground;

    //Объекты
    public static Bitmap asteroid;


    public static void init(MainRunActivity mainRunActivity, GamePaint gamePaint) throws IOException {
        loadBitmaps(gamePaint);
        loadSprites();
        loadAudio(mainRunActivity);
    }

    //Функция для подгрузки музыки
    private static void loadAudio(MainRunActivity mainRunActivity) throws IOException {
        stayInsideMusic = mainRunActivity.getMedia().setMusic("stayInside.mp3");
    }


    //В этой функции позводится заполнение списков спрайтами
    private static void loadSprites() {
        createSpiteAsteroidList(asteroidSprite, asteroid);
    }

    //функция для загрузки изображений из assets
    private static void loadBitmaps(GamePaint gamePaint) {

        asteroidSprite = new ArrayList<>();

        //Загрузка изображений кнопок
        blueLevelButton = gamePaint.createNewGraphicsBitmap("levelButton.png");
        blueLevelButtonClicked = gamePaint.createNewGraphicsBitmap("levelButtonClicked.png");

        //Загрузка фонов
        spaceBackground = gamePaint.createNewGraphicsBitmap("spaceBackground.png");

        //Загрузка изображений объектов
        asteroid = gamePaint.createNewGraphicsBitmap("asteroid.png");

    }

    //Динамичная загрузка спрайтов с общего битмапа в список.
    private static void createSpiteAsteroidList(ArrayList<Bitmap> asteroids, Bitmap bitmap) {
        int count = 0;
        for (int i = 0; i < 8; i++) {
            asteroids.add(Bitmap.createBitmap(bitmap, count, 0, 80, 94));

            count += 80;
        }
    }

    //Добавляйте свои функции для вырезки спрайтов по аналогии

}
