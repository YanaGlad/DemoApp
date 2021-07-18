package com.example.gladandroidenginelib2.graphics;

import android.graphics.Bitmap;

import androidx.annotation.NonNull;

import java.util.ArrayList;

//Cпрайтовая анимация
public class SpriteAnimation {
    private Bitmap sprite, sprite1, sprite2, sprite3, sprite4, sprite5, sprite6, sprite7, sprite8; //Спрайты (до 8)
    private byte control, savedControl;
    private short del;

    //Конструктор класса. Принимает 1 параметр - ArrayList Bitmap'ов
    public SpriteAnimation(@NonNull ArrayList<Bitmap> spriteList) {

        //Если размер ArrayList'a позволяет, записываем в соответствующую переменную движения спрайта.
        if (spriteList.size() >= 1) this.sprite1 = spriteList.get(0);
        if (spriteList.size() >= 2) this.sprite2 = spriteList.get(1);
        if (spriteList.size() >= 3) this.sprite3 = spriteList.get(2);
        if (spriteList.size() >= 4) this.sprite4 = spriteList.get(3);
        if (spriteList.size() >= 5) this.sprite5 = spriteList.get(4);
        if (spriteList.size() >= 6) this.sprite6 = spriteList.get(5);
        if (spriteList.size() >= 7) this.sprite7 = spriteList.get(6);
        if (spriteList.size() >= 8) this.sprite8 = spriteList.get(7);

        //  базовое значение основного спрайта
        this.sprite = sprite1;

        control = (byte) spriteList.size();
        savedControl = (byte) spriteList.size();
        del = 0;
    }

    //Изменение текущего спрайта в соответствии с индексом
    public void repaint(double delay) {
        del++;
        if (del > delay) {
            if (control == 1) sprite = sprite1;
            if (control == 2) sprite = sprite2;
            if (control == 3) sprite = sprite3;
            if (control == 4) sprite = sprite4;
            if (control == 5) sprite = sprite5;
            if (control == 6) sprite = sprite6;
            if (control == 7) sprite = sprite7;
            if (control == 8) sprite = sprite8;
            control--;
            del = 0;
        }
        if (control == 0) {
            control = savedControl;
        }
    }

    //Запуск анимации и её отображение
    public void run(GamePaint gamePaint, int x, int y, double delay) {
        repaint(delay);
        gamePaint.setVisibleBitmap(sprite, x, y);
    }

    public Bitmap getSprite() {
        return sprite;
    }

    public Bitmap getSprite1() {
        return sprite1;
    }

    public Bitmap getSprite2() {
        return sprite2;
    }

    public Bitmap getSprite3() {
        return sprite3;
    }

    public Bitmap getSprite4() {
        return sprite4;
    }

    public Bitmap getSprite5() {
        return sprite5;
    }

    public Bitmap getSprite6() {
        return sprite6;
    }

    public Bitmap getSprite7() {
        return sprite7;
    }

    public Bitmap getSprite8() {
        return sprite8;
    }
}