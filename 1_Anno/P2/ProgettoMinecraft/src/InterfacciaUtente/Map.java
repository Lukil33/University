package InterfacciaUtente;
import Blocchi.Block.WaterBlock;
import Blocchi.Error.BlockErrorException;
import Blocchi.Interfacce.Block;
import Blocchi.Interfacce.SmeltableBlock;
import Blocchi.Block.Factory;

import java.io.PrintStream;
import java.util.Random;

public class Map{
    public Block[][] mappa;
    protected static int rows=9;
    protected static int columns=(int)(rows*1.5);

    public Map(){
        this.mappa = new Block[rows][columns];
        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++){
                this.mappa[i][j] = Factory.airBlock();
            }
        }
        this.addRiver();
        this.randomMap();
    }
    public static int getRows(){
        return rows;
    }
    public static int getColumns(){
        return columns;
    }
    private void randomMap(){
        for (int i = 0 ; i < (rows*columns)/8; i++){
            insert_random_block();
        }
    }
    public void insert_random_block(){
        Random rand = new Random();
        int row = rand.nextInt(rows);
        int col = rand.nextInt(columns);
        while(row >= 0 && (this.mappa[row][col] instanceof WaterBlock || !(this.mappa[row][col].getFalltrough()))){
            row-=1;
        }
        if(row >= 0) {
            switch (rand.nextInt(7)) {
                case 0:
                case 1:
                case 2:
                    this.mappa[row][col] = Factory.sandBlock();
                    break;
                case 3:
                case 4:
                    this.mappa[row][col] = Factory.rawIronBlock();
                    break;
                case 5:
                    this.mappa[row][col] = Factory.torchBlock();
                    break;
                case 6:
                    this.mappa[row][col] = Factory.glassBlock();
                    break;
            }
            gravity(new Coordinate(row, col));
        }
    }
    public void display_on_out(){
        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++){
                System.out.print(this.mappa[i][j].display());
            }
            System.out.print("\n");
        }
    }
    private void swap(int x, int y){
        if((x>=0 && x<rows-1) && (y>=0 && y<columns)){
            Block temp = mappa[x][y];
            mappa[x][y] = mappa[x+1][y];
            mappa[x+1][y] = temp;
        }
    }
    private void gravity(Coordinate c){
        int x = c.getX();
        int y = c.getY();
        while((x+1 < rows) && (mappa[x+1][y].getFalltrough()) && (mappa[x][y].getFallswithgravity())){
            swap(x, y);
            x+=1;
        }
        if((x+1 < rows) && (mappa[x][y].isDestroyable_falling_block()) && (mappa[x+1][y].isDestroy_falling_block())){
            mappa[x][y] = Factory.airBlock();
            applyGravityToTop(new Coordinate(x-1,y));
        }
    }
    public void applyGravityToTop(Coordinate c){
        int x = c.getX();
        while(x > 0){
            gravity(new Coordinate(x,c.getY()));
            x-=1;
        }
    }
    private void addRowsOfWater(){
        for(int i=0; i<columns; i++){
            this.mappa[0][i] = Factory.waterBlock();
            gravity(new Coordinate(0, i));
        }
    }
    private boolean isSmeltable(Coordinate c){
        return get_cell(c) instanceof SmeltableBlock;
    }
    public SmeltableBlock smeltable(Coordinate c){
        if(isSmeltable(c)){
            return (SmeltableBlock) get_cell(c);
        }else{
            return Factory.nullBlock();
        }
    }
    public void addRiver(){
        addRowsOfWater();
    }
    public void addSea(){
        for(int i=0; i<3; i++){
            addRowsOfWater();
        }
    }
    private boolean isPickable(Coordinate c){
        return get_cell(c).is_pickable();
    }
    public Block gimme_pickable(Coordinate c) throws BlockErrorException{
        if(isPickable(c)){
            Block b = get_cell(c);
            this.mappa[c.getX()][c.getY()] = Factory.airBlock();
            return b;
        }else{
            throw new BlockErrorException();
        }
    }
    public Block get_cell(Coordinate c){
        return this.mappa[c.getX()][c.getY()];
    }
}