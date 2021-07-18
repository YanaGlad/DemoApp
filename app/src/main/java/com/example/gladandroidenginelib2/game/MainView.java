package com.example.gladandroidenginelib2.game;

import com.example.gladandroidenginelib2.engine.GameItem;
import com.example.gladandroidenginelib2.media.BasicGameSupport;
import com.example.gladandroidenginelib2.media.BitmapLoader;
import com.example.gladandroidenginelib2.engine.GameView;
import com.example.gladandroidenginelib2.engine.MainRunActivity;

import java.util.ArrayList;

//ПРИМЕР : View для отображения игры. Отобразит фон и запустит экземпляр класса FlyingObject
public class MainView extends GameView {

    /*Если вы используете много различных объектов, нет необходимости запускать run() для каждого,
    создайте список из объектов типа GameItem 
    */
    private ArrayList<GameItem>gameItems;

    private FlyingObject flyingObject;

    public MainView(MainRunActivity mainRunActivity) {
        super(mainRunActivity);
        gameItems = new ArrayList<>();
        flyingObject = new FlyingObject(900, 200, BasicGameSupport.asteroidItem);

        gameItems.add(flyingObject);
    }

    @Override
    public void run() {
        repaint(); //Обновим информацию
        //Отрисовка фона и объекта
        getGamePaint().setVisibleBitmap(BitmapLoader.spaceBackground, 0, 0);
        flyingObject.run(getGamePaint());
    }

    @Override
    public void repaint() { //Обновление - если объект вышел за пределы экрана - вернем его в конец
        if (flyingObject.getX() < -10) flyingObject.setX(900);
    }
}
