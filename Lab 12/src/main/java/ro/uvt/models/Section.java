package ro.uvt.models;

import ro.uvt.models.Element;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Section extends Element implements Visitee {
    String title;

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
    Visitor visitor = null;

    public Section(String txt){
        this.title = txt;
        content = new ArrayList<>();
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

    public void accept(Visitor visitor) {
        this.visitor = visitor;
        visitor.visitSection(this);
    }
}
