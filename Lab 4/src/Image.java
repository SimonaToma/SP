import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Image implements Element, Picture{
    String urll;
    List<Element> content;
    PictureContent picc;
    Dimension dimm;

    public Image(String txt){
        this.urll = txt;
        this.dimm = new Dimension(1024);
        this.picc = new PictureContent(txt);
        this.content = new ArrayList<>();
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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

    public void print() {
        System.out.println("Image with name: " + this.urll);
        for (Element e : content) {
            e.print();
        }
    }

    public String url(){
        return this.urll;
    }

    public Dimension dim(){
        return this.dimm;
    }

    public PictureContent content(){
        return this.picc;
    }
}
