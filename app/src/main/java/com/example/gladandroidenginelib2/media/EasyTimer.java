package com.example.gladandroidenginelib2.media;

//Класс, отвечающий за работу со временем
public class EasyTimer {
    private double startTime;
    private double passedTime;
    private boolean stop = false;

    public void startTimer() {
        stop = false;
        startTime = System.nanoTime() / BasicGameSupport.SECOND;
    }

    public boolean timerDelay(double second) {
       if(!stop) passedTime = System.nanoTime() / BasicGameSupport.SECOND - startTime;
        return passedTime > second;
    }

    public void stopTimer(){
        stop = true;
    }

    public double getPassedTime() {
        return passedTime;
    }
}
