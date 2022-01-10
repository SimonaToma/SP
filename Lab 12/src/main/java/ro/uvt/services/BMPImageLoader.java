package ro.uvt.services;

public class BMPImageLoader implements ImageLoader {
    String imgContent;

    public BMPImageLoader(String txt){
        this.imgContent = txt;
    }
    public String load(String txt){
        return "BMP Image with content "+ txt;
    }
}
