package models;

import models.Element;

import java.util.ArrayList;
import java.util.List;

public class Table implements Element, Visitee, Observable{
    String text;
    List<Element> content;
    Visitor visitor=null;
    String oldValue;
    List<Observer> observerList;

    public Table(String text){
        this.text = text;
        this.content = new ArrayList<>();
        this.observerList = new ArrayList<>();
    }

    public void add(Element e){
        content.add(e);
    }

    public void remove(Element e){
        content.remove(get(e));
    }

    public int get(Element e){
        return content.indexOf(e);
    }

    public void print(){
        System.out.println("Table: " + this.text);
        for(Element e : content){
            e.print();
        }
    }

    @Override
    public void setNewValue(String newValue) {
        this.oldValue = this.text;
        this.text = newValue;
        notifyObservers();
    }

    public void accept(Visitor visitor){
        this.visitor = visitor;
        visitor.visitTable(this);
    }

    @Override
    public void addObserver(Observer obs) {
        this.observerList.add(obs);
    }

    @Override
    public void removeObserver(Observer obs) {
        this.observerList.remove(observerList.indexOf(obs));
    }

    @Override
    public void notifyObservers() {
        for(Observer obs : observerList){
            obs.update(this.text, this.oldValue);
        }
    }
}
