package ro.uvt.models;

public abstract class Element {
    public abstract void add(Element e);
    public abstract void remove(Element e);
    public abstract int get(Element e);
    public abstract void print();
}
