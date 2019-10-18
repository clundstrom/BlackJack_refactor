package model.rules;

import model.Player;

public class PlayerWinnerIfEqualScoreStrategy implements IWinnerIfEqualStrategy {
    private int g_maxScore = 21;

    @Override
    public boolean winnerIfEqual(Player a_player, Player a_dealer) {
        if (a_player.CalcScore() > g_maxScore)
            return true;
        else if (a_dealer.CalcScore() > g_maxScore)
            return false;
        else if(a_dealer.CalcScore() == a_player.CalcScore())
            return false;

        return a_dealer.CalcScore() >= a_player.CalcScore();
    }
}
