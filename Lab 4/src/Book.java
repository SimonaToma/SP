import java.util.ArrayList;
import java.util.List;

public class Book {
    String title;
    List<Author> authorList;
    List<Element> content;

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

}
