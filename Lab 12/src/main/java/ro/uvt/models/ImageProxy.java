package ro.uvt.models;
import java.util.ArrayList;
import java.util.List;



public class ImageProxy extends Element implements Picture, Visitee {
    String urll;
    Image realImage;
    List<Element> content;
    Dimension dimm;
    PictureContent picc;
    Visitor visitor = null;


    public ImageProxy(String txt){
        this.urll = txt;
        this.content = new ArrayList<>();
        this.dimm = new Dimension(1024);
        this.picc = new PictureContent(urll);
    }

    Image loadImage(){
        if(realImage == null){
            realImage = new Image(urll);
        }
        return realImage;
    }

    public void print(){
        loadImage().print();
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

    public String url(){
        return this.urll;
    }
    public Dimension dim(){
        return this.dimm;
    }
    public PictureContent content(){
        return this.picc;
    }

    public void accept(Visitor visitor) {
        this.visitor = visitor;
        visitor.visitImageProxy(this);
    }
}
