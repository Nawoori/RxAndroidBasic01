package com.nawoori.android.rxandroidbasic01;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

/**
 * 옵저버 패턴 이해하기
 */

public class Subject extends Thread {

    List<Observer> observers = new ArrayList<>();
    boolean run = true;

    @Override
    public void run() {
        while (run){
        try {
            Thread.sleep(1000);
            for (Observer observer : observers) {
                observer.notification("Hello");
            }catch(Exception e){
                e.printStackTrace();

            }
        }
    }

    public void addObserver(Observer observer){
        observer.add(observer);
    }

    public interface Observer {
        public void notification(String msg);
    }


}
