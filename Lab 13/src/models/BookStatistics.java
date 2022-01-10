package models;

import java.util.HashMap;
import java.util.Map;

public class BookStatistics implements Visitor<Element> {
    Map<String, Integer> stats = new HashMap<>();

    public BookStatistics(){
        stats.put("Section", 0);
        stats.put("Image", 0);
        stats.put("Paragraph",0);
        stats.put("TableOfContents",0);
        stats.put("Table",0);
        //int section = 0;
    }

    public Element visitBook(Book book) {
        Visitee v;
        for(Element e : book.content){
            v = (Visitee) e;
            v.accept(this);
            if(e instanceof Section){
                stats.put("Section", stats.get("Section")+1);
            }
            if(e instanceof Image || e instanceof ImageProxy){
                stats.put("Image", stats.get("Image")+1);
            }
            if(e instanceof Paragraph){
                stats.put("Paragraph", stats.get("Paragraph")+1);
            }
            if(e instanceof TableOfContents){
                stats.put("TableOfContents", stats.get("TableOfContents")+1);
            }
            if(e instanceof Table){
                stats.put("Table", stats.get("Table")+1);
            }
        }
        return null;
    }

    public Element visitSection(Section section) {
        Visitee v;
        for(Element e : section.content){
            v = (Visitee) e;
            v.accept(this);
            if(e instanceof Section){
                stats.put("Section", stats.get("Section")+1);
            }
            if(e instanceof Image || e instanceof ImageProxy){
                stats.put("Image", stats.get("Image")+1);
            }
            if(e instanceof Paragraph){
                stats.put("Paragraph", stats.get("Paragraph")+1);
            }
            if(e instanceof TableOfContents){
                stats.put("TableOfContents", stats.get("TableOfContents")+1);
            }
            if(e instanceof Table){
                stats.put("Table", stats.get("Table")+1);
            }
        }
        return null;
    }

    public Element visitTableOfContents(TableOfContents tableofcontents) {
        Visitee v;
        for(Element e : tableofcontents.content){
            v = (Visitee) e;
            v.accept(this);
            if(e instanceof Section){
                stats.put("Section", stats.get("Section")+1);
            }
            if(e instanceof Image || e instanceof ImageProxy){
                stats.put("Image", stats.get("Image")+1);
            }
            if(e instanceof Paragraph){
                stats.put("Paragraph", stats.get("Paragraph")+1);
            }
            if(e instanceof TableOfContents){
                stats.put("TableOfContents", stats.get("TableOfContents")+1);
            }
            if(e instanceof Table){
                stats.put("Table", stats.get("Table")+1);
            }
        }
        return null;
    }

    public Element visitParagraph(Paragraph paragraph) {
        Visitee v;
        for(Element e : paragraph.content){
            v = (Visitee) e;
            v.accept(this);
            if(e instanceof Section){
                stats.put("Section", stats.get("Section")+1);
            }
            if(e instanceof Image || e instanceof ImageProxy){
                stats.put("Image", stats.get("Image")+1);
            }
            if(e instanceof Paragraph){
                stats.put("Paragraph", stats.get("Paragraph")+1);
            }
            if(e instanceof TableOfContents){
                stats.put("TableOfContents", stats.get("TableOfContents")+1);
            }
            if(e instanceof Table){
                stats.put("Table", stats.get("Table")+1);
            }
        }
        return null;
    }

    public Element visitImageProxy(ImageProxy imageproxy) {
        Visitee v;
        for(Element e : imageproxy.content){
            v = (Visitee) e;
            v.accept(this);
            if(e instanceof Section){
                stats.put("Section", stats.get("Section")+1);
            }
            if(e instanceof Image || e instanceof ImageProxy){
                stats.put("Image", stats.get("Image")+1);
            }
            if(e instanceof Paragraph){
                stats.put("Paragraph", stats.get("Paragraph")+1);
            }
            if(e instanceof TableOfContents){
                stats.put("TableOfContents", stats.get("TableOfContents")+1);
            }
            if(e instanceof Table){
                stats.put("Table", stats.get("Table")+1);
            }
        }
        return null;
    }

    public Element visitImage(Image image) {
        Visitee v;
        for(Element e : image.content){
            v = (Visitee) e;
            v.accept(this);
            if(e instanceof Section){
                stats.put("Section", stats.get("Section")+1);
            }
            if(e instanceof Image || e instanceof ImageProxy){
                stats.put("Image", stats.get("Image")+1);
            }
            if(e instanceof Paragraph){
                stats.put("Paragraph", stats.get("Paragraph")+1);
            }
            if(e instanceof TableOfContents){
                stats.put("TableOfContents", stats.get("TableOfContents")+1);
            }
            if(e instanceof Table){
                stats.put("Table", stats.get("Table")+1);
            }
        }
        return null;
    }

    public Element visitTable(Table table) {
        Visitee v;
        for(Element e : table.content){
            v = (Visitee) e;
            v.accept(this);
            if(e instanceof Section){
                stats.put("Section", stats.get("Section")+1);
            }
            if(e instanceof Image || e instanceof ImageProxy){
                stats.put("Image", stats.get("Image")+1);
            }
            if(e instanceof Paragraph){
                stats.put("Paragraph", stats.get("Paragraph")+1);
            }
            if(e instanceof TableOfContents){
                stats.put("TableOfContents", stats.get("TableOfContents")+1);
            }
            if(e instanceof Table){
                stats.put("Table", stats.get("Table")+1);
            }
        }
        return null;
    }


    public void printStatistics(){
        for(String s : stats.keySet()){
            if(stats.get(s) !=0 ){
                System.out.println("*** Number of " + s + ": " + stats.get(s));
            }
        }
    }
}
