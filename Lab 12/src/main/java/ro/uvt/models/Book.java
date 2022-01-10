package ro.uvt.models;

import lombok.NoArgsConstructor;
import ro.uvt.models.Author;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Book implements Visitee {
    String title;

    @OneToMany
    List<Author> authorList;

    @OneToMany
    List<Element> content;

    Visitor visitor = null;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue
    private Long id;

    public Book(String text){
        this.title = text;
        this.authorList = new ArrayList<>();
        this.content = new ArrayList<>();
    }

    public void addAuthor(Author a){
        authorList.add(a);
    }



    public void addContent(Element e){
        content.add(e);
    }

    public void print(){
        System.out.println("Book: " + this.title);
        System.out.println("Authors:");
        for(Author x : authorList){
            x.print();
        }

        for(Element e : content){
            e.print();
        }
    }

    public void accept(Visitor visitor){
        this.visitor = visitor;
        visitor.visitBook(this);
    }

}
