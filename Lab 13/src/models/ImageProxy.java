package models;



import java.util.ArrayList;
import java.util.List;

public class ImageProxy implements Element, Picture, Visitee, Observable {
    String urll;
    Image realImage;
    List<Element> content;
    Dimension dimm;
    PictureContent picc;
    Visitor visitor = null;
    String oldValue;
    List<Observer> observerList;


    public ImageProxy(String txt){
        this.urll = txt;
        this.content = new ArrayList<>();
        this.dimm = new Dimension(1024);
        this.picc = new PictureContent(urll);
        this.observerList = new ArrayList<>();
    }

    Image loadImage(){
        if(realImage == null){
            realImage = new Image(urll);
        }
        return realImage;
    }

    public void print(){
        loadImage().print();
    }

    @Override
    public void setNewValue(String newValue) {
        this.oldValue = this.urll;
        this.urll = newValue;
        notifyObservers();
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
        visitor.visitImageProxy(this);
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
