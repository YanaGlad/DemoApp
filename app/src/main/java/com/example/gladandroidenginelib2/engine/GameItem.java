package com.example.gladandroidenginelib2.engine;

import android.graphics.Bitmap;
import android.graphics.Rect;

import com.example.gladandroidenginelib2.graphics.GamePaint;


//Абстрактный класс, описывающий все объекты для уровней на время
public class GameItem implements Loopable {
    protected int x, y;
    protected double speed, jumpingSpeed, collLength;
    protected Rect collisionRect;
    protected Bitmap bitmap, bitmapClicked;

    @Override
    public void run(GamePaint gamePaint) {
    }

    @Override
    public void repaint() {

    }

    @Override
    public void repaint(double speed, double jumSpeed) {

    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public Rect getCollisionRect() {
        return collisionRect;
    }

    public double getCollLength() {
        return collLength;
    }

    public double getJumpingSpeed() {
        return jumpingSpeed;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public Bitmap getBitmapClicked() {
        return bitmapClicked;
    }


    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public void setBitmapClicked(Bitmap bitmapClicked) {
        this.bitmapClicked = bitmapClicked;
    }
}
