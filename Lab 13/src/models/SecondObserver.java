package models;

public class SecondObserver implements Observer{

    @Override
    public void update(String newValue, String oldValue) {
        System.out.println("SecondObserver => Old value: " + oldValue + "; New Value: " + newValue);
    }
}

