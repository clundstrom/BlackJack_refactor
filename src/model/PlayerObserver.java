package model;

public interface PlayerObserver {
    void onDealerCardDealt(Iterable<Card> a_hand, int a_score);
    void onPlayerCardDealt(Iterable<Card> a_hand, int a_score);
}
