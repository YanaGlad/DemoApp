package com.example.gladandroidenginelib2.collision;

import com.example.gladandroidenginelib2.engine.GameItem;

import static com.example.gladandroidenginelib2.collision.Collisions.checkGameItemCollision;

public class CollisionDetectors {

    //Пример : Коллизия 2х GameItem'ов
    public static boolean checkTwoItemCollision(GameItem gameItem, GameItem gameItem2) {
        return checkGameItemCollision(gameItem, gameItem2);
    }

    //По аналогии можно добавлять коллизии для собственных объектов, писать собственную обработку
}