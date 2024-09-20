package Utility;

public class Dati {
    private static int vite;
    private static int punteggio;
    Dati(){
        vite = 3;
        punteggio = 0;
    }
    public static int getVite(){
        return vite;
    }
    public static int getPunteggio(){
        return punteggio;
    }
    public void addPunteggio(int x){
        punteggio += 100;
    }
    public static void removePunteggio(int x){
        punteggio -= x;
    }
    public static void removeVite(int x){
        vite -= x;
    }
}
