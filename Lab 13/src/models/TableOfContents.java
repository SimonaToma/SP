package models;


import java.util.ArrayList;
import java.util.List;

public class TableOfContents implements Element, Visitee, Observable {
    String title;
    List<Element> content;
    Visitor visitor;
    String oldValue;
    List<Observer> observerList;

    public TableOfContents(String txt){
        this.title = txt;
        content = new ArrayList<>();
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

    public void accept(Visitor visitor){
        this.visitor = visitor;
        visitor.visitTableOfContents(this);
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
            obs.update(this.title, this.oldValue);
        }
    }
}
