package com.company;

import java.util.ArrayList;
import java.util.List;

public class SubChapter {
    private String name;
    /*private List<Image> img;
    private List<Paragraph> prg;
    private List<Table> tbl;*/
    List<Element> content;

    public SubChapter(String name) {
        this.name = name;
        /*this.img = new ArrayList<Image>();
        this.prg = new ArrayList<Paragraph>();
        this.tbl = new ArrayList<Table>();*/
        this.content = new ArrayList<>();
    }

    public void createNewParagraph(String txt){
        Paragraph paragraf = new Paragraph(txt);
        this.content.add(paragraf);
    }

    public void createNewImage(String txt){
        Image imagine = new Image(txt);
        this.content.add(imagine);
    }

    public void createNewTable(String txt){
        Table t = new Table(txt);
        this.content.add(t);
    }

    public void print(){
        System.out.println("Subchapter: " + this.name);
        for(Element e : content){
            e.print();
        }
    }
}
