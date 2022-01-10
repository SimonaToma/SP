package models;

import models.Element;

import java.util.ArrayList;
import java.util.List;


public class Section implements Element, Visitee, Observable {
    String title;
    String oldValue;
    List<Element> content;
    Visitor visitor = null;
    List<Observer> observerList;

    public Section(String txt){
        this.title = txt;
        content = new ArrayList<>();
        observerList = new ArrayList<>();
    }

    public void add(Element e){
        Element temp = e;
        content.add(temp);
    }

    public void remove(Element e){
        content.remove(get(e));
    }

    public int get(Element e){
        return content.indexOf(e);
    }

    public void print(){
        System.out.println(this.title);
        for(Element e : content){
            e.print();
        }
    }

    @Override
    public void setNewValue(String newValue) {
        this.oldValue = this.title;
        this.title = newValue;
        notifyObservers();
    }

    public void accept(Visitor visitor) {
        this.visitor = visitor;
        visitor.visitSection(this);
    }

    @Override
    public void addObserver(Observer obs) {
        observerList.add(obs);
    }

    @Override
    public void removeObserver(Observer obs) {
        observerList.remove(observerList.indexOf(obs));
    }

    @Override
    public void notifyObservers() {
        for(Observer obs : observerList){
            obs.update(this.title, this.oldValue);
        }
    }
}
