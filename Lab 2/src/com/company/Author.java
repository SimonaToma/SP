package com.company;

public class Author {
    private String name;

    public Author(String nume){
        this.name = nume;
    }

    public void print(){
        System.out.println("Autorul este " + this.name);
    }
}
