import java.util.ArrayList;
import java.util.List;

public class Image implements Element{
    String url;
    List<Element> content;

    public Image(String url){
        this.url = url;
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
        System.out.println("Image with name: " + this.url);
        for(Element e : content){
            e.print();
        }
    }
}
