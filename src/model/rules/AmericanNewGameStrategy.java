package model.rules;

import model.Deck;
import model.Dealer;
import model.Player;
import model.Card;

class AmericanNewGameStrategy implements INewGameStrategy {

  public boolean NewGame(Deck a_deck, Dealer a_dealer, Player a_player) {
    a_player.DealCard(a_deck.GetCard(), true);
    a_dealer.DealCard(a_deck.GetCard(), true);
    a_player.DealCard(a_deck.GetCard(), true);
    a_dealer.DealCard(a_deck.GetCard(), false);
    return true;
  }
}