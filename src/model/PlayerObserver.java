package model;

public interface PlayerObserver {
    void onCardDealt(Iterable<Card> currentHand, int currentScore, Role role);
}
