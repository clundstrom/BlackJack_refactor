package controller;

import view.IView;
import model.Game;

public class PlayGame {

  public boolean Play(Game a_game, IView a_view) {


    a_view.DisplayWelcomeMessage();
    a_view.DisplayDealerHand(a_game.GetDealerHand(), a_game.GetDealerScore());
    a_view.DisplayPlayerHand(a_game.GetPlayerHand(), a_game.GetPlayerScore());

    if (a_game.IsGameOver())
    {
      a_view.DisplayGameOver(a_game.IsDealerWinner());
    }

    a_view.PromptInput();

    if (a_view.WantsToPlay(a_view.GetInput()))
    {
        a_view.DisplayWelcomeMessage();
        a_game.NewGame();
    }
    else if (a_view.WantsAHit(a_view.GetInput()))
    {
        a_game.Hit();

    }
    else if (a_view.WantsToStand(a_view.GetInput()))
    {
        a_game.Stand();
    }

    return !a_view.WantsToQuit(a_view.GetInput());
  }
}