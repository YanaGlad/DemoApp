package com.example.gladandroidenginelib2.media;

import android.graphics.Bitmap;


import com.example.gladandroidenginelib2.engine.GameView;
import com.example.gladandroidenginelib2.engine.MainRunActivity;
import com.example.gladandroidenginelib2.graphics.GamePaint;
import com.example.gladandroidenginelib2.graphics.SpriteAnimation;

import static com.example.gladandroidenginelib2.media.BitmapLoader.*;

//В данном классе хранятся статические функции и переменные для поддержки работы игры
public class BasicGameSupport {
    //Статическая константа для преобразования наносекунд в секунды.
    public static final double SECOND = 1000000000;

    //Быстрая сортировка
    public static void quickSort(int[] array, int low, int high) {

        int i = low;
        int j = high;
        int pivot = array[(i + j) / 2];
        int temp;

        while (i <= j) {
            while (array[i] < pivot)
                i++;
            while (array[j] > pivot)
                j--;
            if (i <= j) {
                temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }
        if (j > low)
            quickSort(array, low, j);
        if (i < high)
            quickSort(array, i, high);

    }

    //Нарисовать сетку размером M x N с отступом step, длиной линий lenX/Y
    public static void drawGrid(GamePaint gamePaint, Bitmap background, int color, int N, int M, int step, int lenX, int lenY) {
        gamePaint.setVisibleBitmap(background, 0, 0);

        int y = step;
        for (int i = 0; i < N; i++) {
            gamePaint.createLine(0, y, lenX, y, color);
            y += step;
        }
        int x = step;
        for (int i = 0; i < M; i++) {
            gamePaint.createLine(x, 0, x, lenY, color);
            x += step;
        }
    }

    //Инициализация анимаций всех котов в качестве статических переменных
    public static SpriteAnimation
            asteroidItem = new SpriteAnimation(asteroidSprite);

}
