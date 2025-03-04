package Mutation.Pozioni;

import Utility.Geraldo;

public class Tollerance implements Pozioni{
    private boolean isActive;
    private final int modifier = 2;
    public Tollerance(){
        this.isActive = false;
    }
    @Override
    public String toString(){
        return "Tol";
    }
    @Override
    public boolean isActive() {
        return isActive;
    }
    @Override
    public void applyMutation(Geraldo g) {
        if(isActive){
            remove(g);
        }else{
            apply(g);
        }
    }
    private void apply(Geraldo g){
        g.modifyTollerance(+modifier);
        changeActivity();
    }
    private void remove(Geraldo g){
        g.modifyTollerance(-modifier);
        changeActivity();
    }
    private void changeActivity(){
        this.isActive = !isActive;
    }
}
