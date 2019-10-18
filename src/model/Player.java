package model;


import model.rules.Role;
import view.IView;

import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;

public class Player {

    private List<Card> m_hand;
    protected final int g_maxScore = 21;
    private List<IView> mSubscribers;


    public Player() {
        m_hand = new LinkedList<Card>();
        mSubscribers = new ArrayList<>();
    }


    public void DealCard(Card a_addToHand) {
        m_hand.add(a_addToHand);
    }

    public Iterable<Card> GetHand() {
        return m_hand;
    }

    public void ClearHand() {
        m_hand.clear();
    }

    public void ShowHand() {
        for (Card c : GetHand()) {
            c.Show(true);
        }
    }

    public int CalcScore() {
        int cardScores[] = {
                2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 11
        };
        assert (cardScores.length == Card.Value.Count.ordinal()) : "Card Scores array size does not match number of card values";


        int score = 0;

        for (Card c : GetHand()) {
            if (c.GetValue() != Card.Value.Hidden) {
                score += cardScores[c.GetValue().ordinal()];
            }
        }

        if (score > g_maxScore) {
            for (Card c : GetHand()) {
                if (c.GetValue() == Card.Value.Ace && score > g_maxScore) {
                    score -= 10;
                }
            }
        }
        return score;
    }

    public void subscribe(IView view) {
        mSubscribers.add(view);
    }

    public void notifyCardDealt(Role role){
        switch (role){
            case Dealer:
                for(IView view : mSubscribers){
                    view.onDealerCardDealt();
                }
                break;
            case Player:
                for(IView view : mSubscribers){
                    view.onPlayerCardDealt();
                }
                break;
        }
    }
}
