package Utility;

public class PlayerStats{
    private final String name;
    private int level;
    private int money;
    PlayerStats(String n){
        this.name = n;
        this.level = 2;
        this.money = 0;
    }

    public void addLevel(int x){
        this.level += x;
    }
    public void addMoney(int x){
        this.money += x;
    }
    public String getName(){
        return this.name;
    }
    public int getLevel(){
        return this.level;
    }
    public int getMoney(){
        return this.money;
    }
}
