package Utility;

import Blocks.*;

import java.util.Random;

public class Map{
    private Block[][] map;
    private final int DIM;
    private final int num_bombs;
    public Map(int d, int num, Coord c){
        this.DIM = d;
        this.num_bombs = num;
        initialize(c);
        try{
            discover(c);
        }catch(Explosive e){
            System.out.println("Non dovrebbe succedere");
        }
    }
    private void initialize(Coord c){
        insertBomb(c);
        setCellValue();
    }
    private void insertBomb(Coord c){
        map = new Block[DIM][DIM];
        Random rand = new Random();
        for(int i=0; i<num_bombs; i++){
            Coord posBomba = new Coord(rand.nextInt(DIM),rand.nextInt(DIM));
            if(freecell(c,posBomba)){
                map[posBomba.getX()][posBomba.getY()] = new Bomb();
            }else{
                i-=1;
            }
        }
    }
    private boolean freecell(Coord start, Coord bomba){
        if(map[bomba.getX()][bomba.getY()] == null){
            if(bomba.getX() == start.getX() && (bomba.getY() == start.getY()-1 || bomba.getY() == start.getY() || bomba.getY() == start.getY()+1)){
                return false;
            }else if(bomba.getX() == start.getX()-1 && (bomba.getY() == start.getY()-1 || bomba.getY() == start.getY() || bomba.getY() == start.getY()+1)){
                return false;
            }else if(bomba.getX() == start.getX()+1 && (bomba.getY() == start.getY() - 1 || bomba.getY() == start.getY() || bomba.getY() == start.getY() + 1)){
                return false;
            }else {
                return true;
            }
        }
        return false;
    }
    private void setCellValue(){
        for(int x=0; x<DIM; x++){
            for(int y=0; y<DIM;y++){
                if(map[x][y] == null){
                    map[x][y] = new Cell(calculateValue(new Coord(x,y)));
                }
            }
        }
    }
    private int calculateValue(Coord c){
        int res = 0;
        for(int x = c.getX()-1; x<c.getX()+2; x++){
            for(int y = c.getY()-1; y<c.getY()+2; y++){
                if(areinbound(new Coord(x,y)) && map[x][y] != null && map[x][y] instanceof Bomb){
                    res+=1;
                }
            }
        }
        return res;
    }
    private boolean areinbound(Coord c){
        return !(c.getX() < 0 || c.getY() < 0 || c.getX() >= DIM || c.getY() >= DIM);
    }
    public Block getElement(Coord c){
        return map[c.getX()][c.getY()];
    }
    public void discover(Coord c) throws Explosive{
        try{
            map[c.getX()][c.getY()].discover();
            if(map[c.getX()][c.getY()] instanceof Cell block && block.getVal() == 0){
                explodeAround(c);
            }
        }catch(Discovered d){
            Cell block = (Cell) map[c.getX()][c.getY()];
            if(block.getFlag() == block.getVal()){
                explodeAround(c);
            }
            //todo: aggiungere un try-catch di Explosive al controller
            //todo: inserire il controllo di quando sei vivo o comunque gestire quella possibilità
        }
    }
    private void explodeAround(Coord c) throws Explosive{
        for(int x = c.getX()-1; x<c.getX()+2; x++){
            for(int y = c.getY()-1; y<c.getY()+2;y++){
                Coord nc = new Coord(x,y);
                if(areinbound(nc) && !(map[x][y].isFlagged())){
                    try{
                        map[x][y].discover();
                        if(map[x][y] instanceof Cell block && block.getVal() == 0){
                            explodeAround(nc);
                        }
                    }catch(Discovered d){}
                }
            }
        }
    }
    protected void discoverAllBombs(){
        for(int x=0; x<DIM; x++){
            for(int y=0; y<DIM; y++){
                try{
                    try{
                        if(map[x][y] instanceof Bomb){
                            map[x][y].discover();
                        }
                    }catch(Explosive e){}
                }catch(Discovered d){}
            }
        }
    }
    public void insertFlag(Coord c, int var){
        for(int x = c.getX()-1; x<c.getX()+2; x++){
            for(int y = c.getY()-1; y<c.getY()+2;y++){
                Coord nc = new Coord(x,y);
                if(areinbound(nc)){
                    if(x == c.getX() && y == c.getY()){
                        map[x][y].changeFlag();
                    }else{
                        map[x][y].addFlag(var);
                    }
                }
            }
        }
    }
    protected boolean finalCheck(){
        boolean res = true;
        for(int x=0; x<DIM; x++){
            for(int y=0; y<DIM; y++){
                if(!(map[x][y].isExplosive()) && !(map[x][y].getDiscovered())){
                    res = false;
                }
            }
        }
        return res;
    }
}