package model.rules;

import model.Card;
import model.Player;

public class SoftSeventeenStategy  implements IHitStrategy{
    private final int hitLimit = 17;
    @Override
    public boolean DoHit(Player a_dealer) {
        return true;
    }
}
