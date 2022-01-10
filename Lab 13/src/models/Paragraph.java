package models;

import models.Context;
import models.Element;
import services.AlignStrategy;

import java.util.ArrayList;
import java.util.List;

public class Paragraph implements Element, Visitee, Observable {
    String text;
    List<Element> content;
    AlignStrategy align = null;
    Visitor visitor = null;
    String oldValue;
    List<Observer> observerList;

    public Paragraph(String s){
        this.text = s;
        this.content = new ArrayList<>();
        this.observerList = new ArrayList<>();
    }

    public void setAlignStrategy(AlignStrategy x){
        this.align = x;
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
        if(align!=null) {
            align.render(text, new Context());
        }
        else{
            System.out.println("Paragraph: "+ this.text);
        }
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

    public void accept(Visitor visitor) {
        this.visitor = visitor;
        visitor.visitParagraph(this);
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
