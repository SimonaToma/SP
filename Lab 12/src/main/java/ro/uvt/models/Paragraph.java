package ro.uvt.models;

import ro.uvt.models.Context;
import ro.uvt.models.Element;
import ro.uvt.services.AlignStrategy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Paragraph extends Element implements Visitee {
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
    AlignStrategy align = null;
    Visitor visitor = null;

    public Paragraph(String s){
        this.text = s;
        this.content = new ArrayList<>();
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

    public void accept(Visitor visitor) {
        this.visitor = visitor;
        visitor.visitParagraph(this);
    }
}
