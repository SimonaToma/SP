package com.company;
import java.util.ArrayList;
import java.util.List;

public class Chapter {
    private String name;
    private List<SubChapter> subChapterList;

    public Chapter(String txt){
        this.name = txt;
        this.subChapterList = new ArrayList<SubChapter>();
    }

    public int createSubChapter(String txt){
        SubChapter s = new SubChapter(txt);
        this.subChapterList.add(s);
        return subChapterList.indexOf(s);
    }

    public SubChapter getSubChapter(int x){
        return subChapterList.get(x);
    }

    public void print(){
        System.out.println("Chapter: " + this.name);
        for(SubChapter s : subChapterList){
            s.print();
        }
    }
}
