package view;

import model.PlayerObserver;

public abstract class BaseView implements IView, PlayerObserver {

    protected char play = 'p';
    protected char hit = 'h';
    protected char stand = 's';
    protected char quit = 'q';
    protected int input = 0;

    protected void ClearConsole() {
        for (int i = 0; i < 50; i++) {
            System.out.print("\n");
        }
    }


    public void PromptInput() {
        try {
            int c = System.in.read();
            while (c == '\r' || c == '\n') {
                c = System.in.read();
            }
            this.input = c;
        } catch (java.io.IOException e) {
            System.out.println("" + e);
        }
    }

    public int GetInput() {
        return input;
    }

    @Override
    public boolean WantsToPlay(int input) {
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

    public void wait(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
