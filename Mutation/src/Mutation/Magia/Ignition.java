package Mutation.Magia;

import Utility.Geraldo;

public class Ignition implements Magia{
    private boolean isActive;
    public Ignition(){
        this.isActive = false;
    }
    @Override
    public String toString(){
        return "Igni";
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
