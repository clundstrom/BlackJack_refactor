package view;

import model.Player;

public abstract class BaseView implements IView {

    protected char play = 'p';
    protected char hit = 'h';
    protected char stand = 's';
    protected char quit = 'q';


    protected void ClearConsole(){
        for(int i = 0; i < 50; i++) {System.out.print("\n");};  // Repetition in two views?
    }


    public int GetInput()
    {
        try {
            int c = System.in.read();
            while (c == '\r' || c =='\n') {
                c = System.in.read();
            }
            return c;
        } catch (java.io.IOException e) {
            System.out.println("" + e);
            return 0;
        }
    }

    @Override
    public boolean WantsToPlay(int input){
        return input == play;
    }

    @Override
    public boolean WantsAHit(int input) {
        return input == hit;
    }

    @Override
    public boolean WantsToStand(int input) {
        return input == stand;
    }

    @Override
    public boolean WantsToQuit(int input) {
        return input == quit;
    }


}
