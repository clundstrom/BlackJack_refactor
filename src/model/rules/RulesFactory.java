package model.rules;

public class RulesFactory {

  public IHitStrategy GetHitRule() { return new SoftSeventeenStrategy();
  }

  public IWinnerIfEqualStrategy GetIfEqualRule() { return new DealerWinnerIfEqualScoreStrategy();
  }

  public INewGameStrategy GetNewGameRule() {
    return new AmericanNewGameStrategy();
  }
}