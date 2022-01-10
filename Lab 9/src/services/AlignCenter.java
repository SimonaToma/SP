package services;

import models.Context;
import services.AlignStrategy;

public class AlignCenter implements AlignStrategy {

    public void render(String paragraph, Context c){
        System.out.println("+++++"+paragraph+"+++++");
    }
}
