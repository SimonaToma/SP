package ro.uvt.models;

import ro.uvt.models.Element;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Table extends Element implements Visitee{
    String text;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue
    private Long id;

    @OneToMany
    List<Element> content;
    Visitor visitor=null;

    public Table(String text){
        this.text = text;
        this.content = new ArrayList<>();
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

    public void accept(Visitor visitor){
        this.visitor = visitor;
        visitor.visitTable(this);
    }
}
