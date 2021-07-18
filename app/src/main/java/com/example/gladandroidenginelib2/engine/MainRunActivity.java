package com.example.gladandroidenginelib2.engine;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Bundle;
import android.view.WindowManager;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.gladandroidenginelib2.graphics.GamePaint;
import com.example.gladandroidenginelib2.media.Media;


public class MainRunActivity extends AppCompatActivity {

    private GamePaint gamePaint;
    private TouchListener touchListener;
    private GameView gameView;
    private Media media;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        Point point = new Point();
        getWindowManager().getDefaultDisplay().getSize(point);

        Bitmap bmp = Bitmap.createBitmap(800, 600, Bitmap.Config.ARGB_8888);

        float w = (float) 800 / point.x;
        float h = (float) 600 / point.y;

        media = new Media(this);

        GameLoop gameLoop = new GameLoop(this, bmp);
        gamePaint = new GamePaint(getAssets(), bmp);

        if (w == h) touchListener = new TouchListener(gameLoop, w);
        else touchListener = new TouchListener(gameLoop, w, h);

        gameView = getNewView();

        setContentView(gameLoop);
        gameLoop.startGame();
    }

    public GamePaint getGamePaint() {
        return gamePaint;
    }

    public TouchListener getTouchListener() {
        return touchListener;
    }

    public void setView(GameView gameView) {
        if (gameView == null) {
            throw new IllegalArgumentException("Something went wrong, gameView is null :(");
        }
        this.gameView = gameView;
    }

    /*
    Пример функции для перехода между активностями.
    Нужно остановаить gameLoop и переключиться на необходимую активность

    public void aboutGame() {
        Intent intent = new Intent(this, GameDescriptionActivity.class);
        startActivity(intent);
        gameLoop.stopGame();
    }
     */

    private String[] descriptions =  {
        "This is cool achievement", "This is amazing achievement"
    };


    public GameView getCurrentView() {
        return gameView;
    }

    public GameView getNewView() {
        return gameView;
    }

    public Media getMedia() {
        return media;
    }


}