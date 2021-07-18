package com.example.gladandroidenginelib2.media;

//Класс, отвечающий за работу со временем
public class EasyTimer {
    private double startTime;
    private double passedTime;
    private boolean stop = false;

    //Запустить таймер
    public void startTimer() {
        stop = false;
        startTime = System.nanoTime() / BasicGameSupport.SECOND;
    }

    //Проверить, проработал ли таймер заданное время
    public boolean timerDelay(double second) {
       if(!stop) passedTime = System.nanoTime() / BasicGameSupport.SECOND - startTime;
        return passedTime > second;
    }

    //Остановить таймер
    public void stopTimer(){
        stop = true;
    }

    //Узнать, сколько времени прошло с начала работы таймера
    public double getPassedTime() {
        return passedTime;
    }
}
