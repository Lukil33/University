package Utility;

import java.util.Date;

public class Dati{
    private static int soldi;
    private static Date data;
    private static final long dayDuration = 100000000;
    Dati(){
        soldi = 30;
        data = new Date();
    }
    public static void subtractSoldi(int x){
        soldi -= x;
    }
    public static int getSoldi(){
        return soldi;
    }
    public static Date getDate(){
        return data;
    }
    public static long getDayDuration(){
        return dayDuration;
    }
}
