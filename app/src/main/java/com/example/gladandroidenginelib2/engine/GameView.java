package com.example.gladandroidenginelib2.engine;



import com.example.gladandroidenginelib2.graphics.GamePaint;

//Абстрактный класс GameView представляет текущий игровой кадр
public abstract class GameView {

    private MainRunActivity mainRunActivity;
    private GamePaint gamePaint;
    public static int screenWidth;
    public static int screenHeight;
    protected int stars;

    public GameView(MainRunActivity mainRunActivity) {
        this.mainRunActivity = mainRunActivity;
        screenWidth = mainRunActivity.getGamePaint().getMainBitmap().getWidth();
        screenHeight = mainRunActivity.getGamePaint().getMainBitmap().getHeight();
        gamePaint = mainRunActivity.getGamePaint();
    }

    public abstract void run(); //Обновляет отображение элементов

    public abstract void repaint(); //изменяет данные объектов, работает с логикой игры. Как правило, вызывается внутри run()

    public int getStars() {
        return stars;
    }

    public MainRunActivity getMainRunActivity() {
        return mainRunActivity;
    }

    public GamePaint getGamePaint() {
        return gamePaint;
    }
}
