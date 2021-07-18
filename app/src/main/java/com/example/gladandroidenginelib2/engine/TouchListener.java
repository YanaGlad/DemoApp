package com.example.gladandroidenginelib2.engine;

import android.view.MotionEvent;
import android.view.View;

public class TouchListener implements View.OnTouchListener {

    private float touchX, touchY; // координаты прикосновений
    private boolean touchDown, touchUp;
    private boolean swipe, swipeUp, swipeDown;
    private float downX, downY; //координаты касаний при удержании пальца
    private int swipeDistance; // размер свайпа
    private float screenWidth = 1, screenHeight = 1, k = 1; // отношения ширины и длины, коэффициент подобия

    TouchListener(View view, float screenWidth, float screenHeight) { //Конструктор, который используется если экраны не подобны
        view.setOnTouchListener(this);
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        swipeDistance = 50;
    }

    TouchListener(View view, float k) { //Конструктор, который используется если экраны подобны
        view.setOnTouchListener(this);
        this.k = k;
        swipeDistance = 50;
    }

    @Override
    public boolean onTouch(View view, MotionEvent event) {
        view.performClick();

        synchronized (this) {
            touchDown = false;
            touchUp = false;

            switch (event.getAction()) { //Получим действие, которое произвел пользователь над экраном
                case MotionEvent.ACTION_DOWN: //Если удержание пальца на экране
                    touchX = event.getX() * screenWidth * k;
                    touchY = event.getY() * screenHeight * k;
                    touchDown = true;
                    touchUp = false;
                    swipe = false;

                    downX = event.getX();
                    downY = event.getY();
                    break;

                case MotionEvent.ACTION_UP://Если отрыв пальца от экрана
                    touchX = event.getX() * screenWidth * k;
                    touchY = event.getY() * screenHeight * k;

                    touchDown = false;
                    touchUp = true;
                    swipe = false;

                    float upX = event.getX();
                    float upY = event.getY();

                    float deltaX = downX - upX; //рассчёт свайпа по горизонтали
                    float deltaYUp = downY - upY; // рассчёт свайпа по вертикали
                    float deltaYDown = upY - downY;

                    if (Math.abs(deltaYUp) > swipeDistance) { //если свайп достигает заданное значение
                        if (deltaYUp > 0) swipe = true;
                    }

                    if (deltaYUp > swipeDistance){
                        swipeUp = true;
                        swipeDown = false;
                    }
                    if(deltaYDown>swipeDistance){
                        swipeDown = true;
                        swipeUp = false;
                    }

                    break;
            }
        }
        return true;
    }

    public boolean up(int x, int y, int touchWidth, int touchHeight) {
        if (touchUp) {
            if (touchLimits(x, y, touchWidth, touchHeight)) {
                touchUp = false;
                return true;
            }
        }
        return false;
    }

    public boolean down(int x, int y, int touchWidth, int touchHeight) {
        if (touchDown)
            if (touchLimits(x, y, touchWidth, touchHeight)) {
                touchDown = false;
                return true;
            }
        return false;
    }

    private boolean touchLimits(int x, int y, int touchWidth, int touchHeight) { //Задать рамки касания
        return touchX >= x && touchX <= x + touchWidth && touchY <= y && touchY >= y - touchHeight;
    }

    public boolean isSwipe() {
        return swipe;
    }

    public float getTouchX() { // получить току касания по оси абсцисс
        return touchX;
    }

    public float getTouchY() {// получить току касания по оси ординат
        return touchY;
    }

    public boolean isSwipeUp() {
        return swipeUp;
    }

    public boolean isSwipeDown() {
        return swipeDown;
    }

    public void setSwipeUp(boolean swipeUp) {
        this.swipeUp = swipeUp;
    }

    public void setSwipeDown(boolean swipeDown) {
        this.swipeDown = swipeDown;
    }
}
