package Mutation.Magia;

import Utility.Geraldo;

public class Quen implements Magia{
    private boolean isActive;
    public Quen(){
        this.isActive = false;
    }
    @Override
    public String toString(){
        return "Quen";
    }
    @Override
    public boolean isActive() {
        return isActive;
    }
    @Override
    public void applyMutation(Geraldo g) {
        g.modSpell(this);
        changeActivity();
    }
    private void changeActivity(){
        this.isActive = !isActive;
    }
}
