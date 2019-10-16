package model.rules;

import model.Card;
import model.Player;

import java.util.Iterator;

public class SoftSeventeenStrategy implements IHitStrategy{
    private final int hitLimit = 17;

    @Override
    public boolean DoHit(Player a_dealer) {
        boolean hasAce = false;
        Iterator it = a_dealer.GetHand().iterator();
        int score = a_dealer.CalcScore();

        while(it.hasNext()){
            if(it.next().equals(Card.Value.Ace)){
                hasAce = true;
            }
        }

        if(score < hitLimit){
            return true;
        }
        else if(score == hitLimit && hasAce){
            return true;
        }
        return false;
    }
}
