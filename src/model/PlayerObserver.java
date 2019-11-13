package model;

public interface PlayerObserver {
    void onDealerCardDealt(Iterable<Card> currentHand, int currentScore);
    void onPlayerCardDealt(Iterable<Card> currentHand, int currentScore);
}
