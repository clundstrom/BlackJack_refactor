package model.rules;

import model.Card;
import model.Player;

public class SoftSeventeenStategy  implements IHitStrategy{
    private final int hitLimit = 17;
    @Override
    public boolean DoHit(Player a_dealer) {
        if(a_dealer.CalcScore() == hitLimit && a_dealer.GetHand().equals(Card.Value.Ace))
            return true;
        else if(a_dealer.CalcScore() < hitLimit)
            return true;
        else
            return false;
    }
}
