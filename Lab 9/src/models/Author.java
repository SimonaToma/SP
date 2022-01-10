package models;

public class Author {
    String name;


    public Author(String txt){
        this.name = txt;

    }


    public void print(){
        System.out.println("Author: " + this.name);
    }
}
