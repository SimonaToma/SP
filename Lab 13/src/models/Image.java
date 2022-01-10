package models;

import services.ImageLoaderFactory;
import services.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public class Image implements Element, Picture, Visitee, Observable {
    String urll;
    List<Element> content;
    PictureContent picc;
    Dimension dimm;
    ImageLoaderFactory img = new ImageLoaderFactory();
    ImageLoader trueimg;
    Visitor visitor = null;
    List<Observer> observerList;
    String oldValue;

    public Image(String txt){
        this.urll = txt;
        this.dimm = new Dimension(1024);
        this.picc = new PictureContent(txt);
        this.content = new ArrayList<>();
        this.observerList = new ArrayList<>();
        try {
            this.trueimg = img.create(urll);
        } catch (Exception e) {
            e.printStackTrace();
        }
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

    public void print() {
        //System.out.println("models.Image with name: " + this.urll);
        System.out.println(trueimg.load(urll));
        for (Element e : content) {
            e.print();
        }
    }

    @Override
    public void setNewValue(String newValue) {
        this.oldValue = this.urll;
        this.urll = newValue;
        notifyObservers();
    }

    public String url(){
        return this.urll;
    }

    public Dimension dim(){
        return this.dimm;
    }

    public PictureContent content(){
        return this.picc;
    }

    public void accept(Visitor visitor) {
        this.visitor = visitor;
        visitor.visitImage(this);
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
            obs.update(this.urll, this.oldValue);
        }
    }
}
