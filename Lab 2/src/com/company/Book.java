package com.company;

import java.util.ArrayList;
import java.util.List;

public class Book {
    private String title;
    private List<Author> ath;
    private List<Chapter> chapterList;
    private TableOfContents tbl;

    public Book(String txt){
        this.title = txt;
        this.chapterList = new ArrayList<Chapter>();
        this.ath = new ArrayList<>();
    }

    public void addAuthor(Author a){
        this.ath.add(a);
    }

    public int createChapter(String txt){
        Chapter c = new Chapter(txt);
        this.chapterList.add(c);
        return chapterList.indexOf(c);
    }

    public Chapter getChapter(int chapterIndex){
        return this.chapterList.get(chapterIndex);
    }

    public void addTOC(TableOfContents t){
            this.tbl = t;
    }

    public void print(){
        System.out.println("Titlu: " + this.title);
        for(Author a : ath){
            a.print();
        }
        for(Chapter c : chapterList){
            c.print();
        }
        tbl.print();
    }
}
