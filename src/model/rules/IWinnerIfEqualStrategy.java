package model.rules;

import model.Player;

public interface IWinnerIfEqualStrategy {
    boolean winnerIfEqual(Player a_player, Player a_dealer);
}
