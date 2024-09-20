package Mutation.Combattimento;

import Utility.Geraldo;

public class Strenght implements Combattimento{
    private boolean isActive;
    private static final int modifier = 2;
    public Strenght(){
        this.isActive = false;
    }
    @Override
    public String toString(){
        return "Str";
    }
    @Override
    public boolean isActive() {
        return isActive;
    }
    @Override
    public void applyMutation(Geraldo g){
        if(isActive){
            remove(g);
        }else{
            apply(g);
        }
    }
    private void apply(Geraldo g){
        g.modifyStrenght(+modifier);
        changeActivity();
    }
    private void remove(Geraldo g) {
        g.modifyStrenght(-modifier);
        changeActivity();
    }
    private void changeActivity(){
        this.isActive = !isActive;
    }
}
