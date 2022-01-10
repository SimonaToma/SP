package models;

public interface Element {
    public void add(Element e);
    public void remove(Element e);
    public int get(Element e);
    public void print();
    public void setNewValue(String newValue);
}
