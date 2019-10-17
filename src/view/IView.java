package view;

import model.Card;
import model.Player;

public interface IView
{
  void DisplayWelcomeMessage();
  int GetInput();
  void DisplayCard(Card a_card);
  void DisplayPlayerHand(Iterable<Card> a_hand, int a_score);
  void DisplayDealerHand(Iterable<Card> a_hand, int a_score);
  void DisplayGameOver(boolean a_dealerIsWinner);
  void onDealerCardDealt();
  void onPlayerCardDealt();


  boolean WantsToPlay(int input);
  boolean WantsAHit(int input);
  boolean WantsToStand(int input);
  boolean WantsToQuit(int input);
}