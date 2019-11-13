package model;

public interface PlayerPublisher {
    void attach(PlayerObserver observer);
    void notifyObservers();
}
