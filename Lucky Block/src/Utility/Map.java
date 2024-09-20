package Utility;

import Blocks.*;
import java.util.Random;

public class Map{
    private Block[][] map;
    public static int DIM = 10;
    public Map(){
        generateMap();
    }
    private void generateMap(){
        this.map = new Block[DIM][DIM];
        for(int x=0; x<DIM; x++){
            for(int y=0; y<DIM; y++){
                map[x][y] = randomBlock();
            }
        }
    }
    private Block randomBlock(){
        Random r = new Random();
        return switch (r.nextInt(6)){
            case 0 -> new Bomb();
            case 1 -> new Division();
            case 2 -> new Multiply();
            default -> new Points();
        };
    }
    public Block getBlock(int x, int y){
        return map[x][y];
    }
    public int discover(int x, int y, int score) throws Discovered{
        if(!map[x][y].getDiscovered()){
            if(map[x][y] instanceof Bomb){
                score = map[x][y].discover(score);
                for(int i=0;i<DIM;i++){
                    try{
                        score = discover(x,i,score);
                    }catch(Discovered d){}
                }
                for(int i=0; i<DIM;i++){
                    try{
                        score = discover(i,y,score);
                    }catch(Discovered d){}
                }
            }else{
                score = map[x][y].discover(score);
            }
            return score;
        }else{
            throw new Discovered();
        }
    }
    public boolean allDiscovered(){
        boolean check = true;
        for(int x=0; x<DIM; x++){
            for(int y=0; y<DIM; y++){
                if(!map[x][y].getDiscovered()){
                    check =false;
                }
            }
        }
        return check;
    }
}