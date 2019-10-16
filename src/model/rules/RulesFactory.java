package model.rules;

public class RulesFactory {

  public IHitStrategy GetHitRule() { return new SoftSeventeenStategy();
  }

  public IWinnerIfEqualStrategy GetIfEqualRule() { return new PlayerWinnerIfEqualScoreStrategy();
  }

  public INewGameStrategy GetNewGameRule() {
    return new AmericanNewGameStrategy();
  }
}