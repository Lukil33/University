package InterfacciaUtente;

import Blocchi.Error.WrongCoordinatesException;

public class Coordinate{
    private int X;
    private int Y;
    public Coordinate(int x, int y){
        X = x;
        Y = y;
        try{
            check();
        }catch(WrongCoordinatesException e){
            X=0;
            Y=0;
        }
    }
    private void check() throws WrongCoordinatesException{
        if(X >= Map.rows || X < 0 || Y>= Map.columns || Y < 0){
            if(X >= Map.rows || X < 0){
                System.out.println("X value is out of bound");
            }
            if(Y >= Map.columns|| Y < 0){
                System.out.println("Y value is out of bound");
            }
            throw new WrongCoordinatesException();
        }
    }
    public int getX(){
        return X;
    }
    public int getY(){
        return Y;
    }
}
