package ro.uvt.services;

import ro.uvt.services.ImageLoader;

public class JPGImageLoader implements ImageLoader {
    String imgContent;

    public JPGImageLoader(String txt){
        this.imgContent = txt;
    }
    public String load(String txt){
        return "JPG Image with content "+ txt;
    }
}
