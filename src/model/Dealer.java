package model;

import model.rules.*;
import view.IView;

import java.util.ArrayList;
import java.util.List;

public class Dealer extends Player {

  private Deck m_deck;
  private INewGameStrategy m_newGameRule;
  private IHitStrategy m_hitRule;
  private IWinnerIfEqualStrategy m_ruleIfEqual;
  private List<IView> mSubscribers;

  public Dealer(RulesFactory a_rulesFactory) {
  
    m_newGameRule = a_rulesFactory.GetNewGameRule();
    m_hitRule = a_rulesFactory.GetHitRule();
    m_ruleIfEqual = a_rulesFactory.GetIfEqualRule();
    mSubscribers = new ArrayList<>();
  }
  
  
  public boolean NewGame(Player a_player) {
    if (m_deck == null || IsGameOver()) {
      m_deck = new Deck();
      ClearHand();
      a_player.ClearHand();
      return m_newGameRule.NewGame(m_deck, this, a_player);   
    }
    return false;
  }

  public boolean Hit(Player a_player) {
    if (m_deck != null && a_player.CalcScore() < g_maxScore && !IsGameOver()) {
      Card c;
      c = m_deck.GetCard();
      c.Show(true);
      a_player.DealCard(c);
      a_player.notifyCardDealt();
      return true;
    }
    return false;
  }

  public boolean Stand() {
    if(m_deck != null) {
      ShowHand();
      while (m_hitRule.DoHit(this)) { // while strategy allows, deal card.
        Card c;
        c = m_deck.GetCard();
        c.Show(true);
        this.DealCard(c);
        this.notifyCardDealt();
      }
      return true;
    }
    return false;
  }

  public boolean IsDealerWinner(Player a_player) {
    return m_ruleIfEqual.winnerIfEqual(a_player, this);
  }

  public boolean IsGameOver() {
    if (m_deck != null && m_hitRule.DoHit(this) != true) {
        return true;
    }
    return false;
  }

  @Override
  public void notifyCardDealt() {
    for (IView view : mSubscribers) {
      view.onDealerCardDealt();
    }

  }

  @Override
  public void subscribe(IView view) {
    mSubscribers.add(view);
  }
}