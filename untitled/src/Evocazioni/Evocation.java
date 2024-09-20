package Evocazioni;

import Evocazioni.Energie.Energy;
import Exceptions.Die;
import javafx.scene.paint.Color;

public class Evocation {
    private final String name;
    private final int initialLifePoint;
    private int lifePoint;
    private final Energy tipo;
    private final Attack attacco;
    public Evocation(String n, int lp, Energy e, Attack a){
        this.name = n;
        this.initialLifePoint = lp;
        this.lifePoint = lp;
        this.tipo = e;
        this.attacco = a;
        this.attacco.setTipo(e);
    }
    public void addEnergy(){
        this.attacco.addEnergy();
    }
    public void applyDamage(Evocation e) throws Die{
        if(e.getType().isStrongAgainst(this.tipo)){
            this.lifePoint -= 2 * e.getAttackDanni();
        }else{
            this.lifePoint -= e.getAttackDanni();
        }
        if(lifePoint <= 0){
            throw new Die();
        }
    }

    public String getName(){
        return this.name;
    }
    public int getInitialLifePoint(){
        return this.initialLifePoint;
    }
    public int getLifePoint(){
        return this.lifePoint;
    }
    public Energy getType(){
        return this.tipo;
    }
    public Color getColor(){
        return this.tipo.getColor();
    }
    public String getAttackName(){
        return this.attacco.getName();
    }
    public int getAttackEnergie(){
        return this.attacco.getEnergie();
    }
    public int getAttackEnergieAttive(){
        return this.attacco.getEnergieAttive();
    }
    public int getAttackDanni(){
        return this.attacco.getDanni();
    }
}
