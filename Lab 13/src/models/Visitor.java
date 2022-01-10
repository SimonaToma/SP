package models;

public interface Visitor<T>{
    public T visitBook(Book book);
    public T visitSection(Section section);
    public T visitTableOfContents(TableOfContents tableofcontents);
    public T visitParagraph(Paragraph paragraph);
    public T visitImageProxy(ImageProxy imageproxy);
    public T visitImage(Image image);
    public T visitTable(Table table);
}
