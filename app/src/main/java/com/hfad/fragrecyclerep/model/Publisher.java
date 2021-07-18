package com.hfad.fragrecyclerep.model;

import com.hfad.fragrecyclerep.Observer;

import java.util.ArrayList;
import java.util.List;

public class Publisher {
    private List<Observer> observers;

    public Publisher() {
        this.observers = new ArrayList<>();
    }
    public void subscribe(Observer observer){
        observers.add(observer);
    }
    public void unsubscribe(Observer observer){
        observers.remove(observer);
    }
    public void notifySingle(Notes notes){
        for (Observer observer : observers){
            observer.update(notes);
            unsubscribe(observer);
        }
    }
}
