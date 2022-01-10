package com.company;

public class Table implements Element{
    private String title;

    public Table(String txt){
        this.title = txt;
    }

    public void print(){
        System.out.println("Table with title: " + title);
    }
}
