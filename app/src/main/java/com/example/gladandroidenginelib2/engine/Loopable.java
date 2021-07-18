package com.example.gladandroidenginelib2.engine;


import com.example.gladandroidenginelib2.graphics.GamePaint;

public interface Loopable {

    void run(GamePaint gamePaint);

    void repaint();

    void repaint(double speed, double jumSpeed);
}
