package model;

import model.rules.RulesFactory;

public class Game {

  private Dealer m_dealer;
  private Player m_player;

  public Game()
  {
    m_dealer = new Dealer(new RulesFactory());
    m_player = new Player();
  }

  public void addSubscriber(PlayerObserver observer){
    m_player.attach(observer);
    m_dealer.attach(observer);
  }
    
  public boolean IsGameOver() {
    if(m_player.CalcScore() > m_player.g_maxScore){
      m_dealer.SetGameOver();
      return true;
    } else
      return m_dealer.IsGameOver();
  }
  
  public boolean IsDealerWinner()
  {
    return m_dealer.IsDealerWinner(m_player);
  }
  
  public boolean NewGame()
  {
    return m_dealer.NewGame(m_player);
  }
  
  public boolean Hit()
  {
    if (m_dealer.Hit(m_player)){
      return true;
    }
    return false;
  }


  public boolean Stand() {
   return m_dealer.Stand();
  }
  
  public Iterable<Card> GetDealerHand()
  {
    return m_dealer.GetHand();
  }
  
  public Iterable<Card> GetPlayerHand()
  {
    return m_player.GetHand();
  }
  
  public int GetDealerScore()
  {
    return m_dealer.CalcScore();
  }
  
  public int GetPlayerScore()
  {
    return m_player.CalcScore();
  }

}