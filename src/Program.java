import controller.PlayGame;
import model.Game;
import view.*;

public class Program
{

  public static void main(String[] a_args)
  {
  
    Game g = new Game();
    IView v = new SwedishView(); //new SwedishView();
    PlayGame ctrl = new PlayGame();
    
    while (ctrl.Play(g, v));
  }
}