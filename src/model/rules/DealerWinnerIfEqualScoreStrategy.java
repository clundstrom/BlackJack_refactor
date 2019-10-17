package model.rules;

import model.Player;

public class DealerWinnerIfEqualScoreStrategy implements IWinnerIfEqualStrategy {


    @Override
    public boolean winnerIfEqual(Player a_player, Player a_dealer) {
        return a_player.CalcScore() == a_dealer.CalcScore();

    }
}
