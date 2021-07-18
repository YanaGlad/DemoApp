package com.example.gladandroidenginelib2.engine;


import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

//TODO: Как использовать библиотеку?

//Класс, реализующий поток, в котором будет происходить работа игры
public class GameLoop extends SurfaceView implements Runnable {
    private boolean running = false; // работа потока
    Thread gameThread = null; // игровой поток
    MainRunActivity mainRunActivity;
    Bitmap mainBitmap; // Основной Bitmap, который будет привязан к canvas
    SurfaceHolder surfaceHolder; // Объект класса SurfaceHolder, который поможет получить canvas
    Canvas canvas; // "Холст", на котором будет отрисовываться игра
    Rect rect;


    public GameLoop(MainRunActivity mainRunActivity, Bitmap mainBitmap) {
        super(mainRunActivity);
        this.mainBitmap = mainBitmap;
        this.mainRunActivity = mainRunActivity;
        this.surfaceHolder = getHolder();
        rect = new Rect();
        canvas = new Canvas();
    }

    @Override
    public void run() {
        float beginTime = System.nanoTime(); // время на момент запуска run()
        float delta = 0; // эта переменная поможет отпредилить, сколько времени прошло после присваения beginTime значения
        while (running) { // пока поток запущен
            int UPDATE_TIME = 1000000000 / 60;  //90 раз в секунду
            delta += (System.nanoTime() - beginTime) / UPDATE_TIME; // увеличиваем дельту на прошедшее время
            beginTime = System.nanoTime(); // Обновляем время в переменной beginTime
            if (delta > 1) { // если дельта больше 1, в будет запущен метод runGame(), который отобразить кадр игры
                runGame();
                delta--; //уменьшим дельту до 0 и повторим процесс.
            }
        }
    }

    private void runGame() { // Этот метод отвечает за отрисовку игры на canvas
        if (surfaceHolder.getSurface().isValid()) { // Доступен ли surface
            canvas = surfaceHolder.lockCanvas(); // блокируем холст
            canvas.getClipBounds(rect); // отрезаем прямоугольник
            canvas.drawBitmap(mainBitmap, null, rect, null); // рисуем на canvas'e основной Bitmap
            mainRunActivity.getCurrentView().run(); // Запускаем текущий игровой кадр
            surfaceHolder.unlockCanvasAndPost(canvas); // разблокируем холст
        }
    }

    //Запускает GameLoop
    public void startGame() {
        if (running) return;
        running = true;
        gameThread = new Thread(this);
        gameThread.start();
    }

    public void stopGame() {
        if (!running) return;
        running = false;
    }

}
