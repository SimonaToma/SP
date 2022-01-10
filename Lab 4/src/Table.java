import java.util.ArrayList;
import java.util.List;

public class Table implements Element{
    String text;
    List<Element> content;

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
}
