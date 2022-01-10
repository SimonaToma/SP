package models;


import java.util.ArrayList;
import java.util.List;

public class TableOfContents implements Element, Visitee {
    String title;
    List<Element> content;
    Visitor visitor;

    public TableOfContents(String txt){
        this.title = txt;
        content = new ArrayList<>();
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

    public void accept(Visitor visitor){
        this.visitor = visitor;
        visitor.visitTableOfContents(this);
    }
}
