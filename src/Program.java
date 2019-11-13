import controller.PlayGame;
import model.Game;
import model.PlayerObserver;
import view.*;

public class Program
{

  public static void main(String[] a_args)
  {
  
    Game g = new Game();
    IView v = new SimpleView(); //new SwedishView();
    PlayGame ctrl = new PlayGame();
    g.addSubscriber((PlayerObserver)v);

    while (ctrl.Play(g, v));
  }
}