package com.example.gladandroidenginelib2.game;

import android.graphics.Bitmap;

import com.example.gladandroidenginelib2.engine.GameItem;
import com.example.gladandroidenginelib2.graphics.GamePaint;
import com.example.gladandroidenginelib2.graphics.SpriteAnimation;

//ПРИМЕР: Класс, представляющий собой анимированный объект, летящий по экрану справа на лево
public class FlyingObject extends GameItem {

    //Поля класса - скорость движения, анимация
    private int speed = 8;
    private SpriteAnimation spriteAnimation;


    public FlyingObject(int x, int y, SpriteAnimation spriteAnimation) {
        this.x = x;
        this.y = y;
        this.spriteAnimation = spriteAnimation;
        bitmap = null;
    }

    @Override
    public void run(GamePaint gamePaint) {
        repaint(); //Обновление данных

        //Отрисовка
        spriteAnimation.run(gamePaint, x, y, 9);
        System.out.println("X is " + x);
    }

    @Override
    public void repaint() {
        super.repaint();
        x -= this.speed;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }


    public int getSpeedTM() {
        return speed;
    }

    public void setSpriteAnimation(SpriteAnimation spriteAnimation) {
        this.spriteAnimation = spriteAnimation;
    }

    SpriteAnimation getSpriteAnimation() {
        return spriteAnimation;
    }

    @Override
    public int getX() {
        return super.getX();
    }

    @Override
    public void setX(int x) {
        super.setX(x);
    }

    @Override
    public int getY() {
        return super.getY();
    }

    @Override
    public void setY(int y) {
        super.setY(y);
    }
}