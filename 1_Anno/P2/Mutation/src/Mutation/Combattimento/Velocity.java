package Mutation.Combattimento;

import Utility.Geraldo;

public class Velocity implements Combattimento{
    private boolean isActive;
    private final int modifier = 2;
    public Velocity(){
        this.isActive = false;
    }
    @Override
    public String toString(){
        return "Vel";
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
        g.modifyVelocity(+modifier);
        changeActivity();
    }
    private void remove(Geraldo g) {
        g.modifyVelocity(-modifier);
        changeActivity();
    }
    private void changeActivity(){
        this.isActive = !isActive;
    }
}
