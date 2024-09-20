package Utility;

import Exceptions.NoMoney;

public class DatiPersonali{
    private static int capitale = 100;
    private static int spesamesile = 0;
    private static int numMese = 0;
    static void changeMonth() throws NoMoney{
        numMese += 1;
        if(capitale-spesamesile < 0){
            throw new NoMoney();
        }else{
            capitale -= spesamesile;
        }
    }
    static void addCapitale(){
        capitale += 100;
    }
    static void modifySpesa(int x){
        spesamesile += x;
    }
    public static int getCapitale(){
        return capitale;
    }
    public static int getSpesa(){
        return spesamesile;
    }
    public static int getMese(){
        return numMese;
    }
}
