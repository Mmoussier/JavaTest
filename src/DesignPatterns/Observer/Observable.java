package DesignPatterns.Observer;

public interface Observable {
    void addObserver(Observer obs);
    void updateObserver();
    void removeObserver();
}
