package models;

public class FirstObserver implements Observer{

    @Override
    public void update(String newValue, String oldValue) {
        System.out.println("FirstObserver => Old value: " + oldValue + "; New Value: " + newValue);
    }
}
