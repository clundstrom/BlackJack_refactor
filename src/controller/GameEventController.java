package controller;

import model.rules.Role;
import view.IView;

import java.util.ArrayList;
import java.util.List;

public class GameEventController {

    private static List<IView> mViews = new ArrayList<>();


    public static void addSubscriber(IView view){
        mViews.add(view);
    }

    public static List<IView> getSubscribers(){
        return mViews;
    }


    public static void notifyCardDealt(Role role){
        switch (role){
            case Dealer:
                for(IView view : mViews){
                    view.onDealerCardDealt();
                }
                break;
            case Player:
                for(IView view : mViews){
                    view.onPlayerCardDealt();
                }
                break;
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
