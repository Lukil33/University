package Quest;

import Utility.PlayerStats;
import com.sun.tools.javac.Main;

public class MainQuest extends AbsQuest{
    private static final int RICOMPENSA = 10;
    private final String location;
    private final String prossima;
    private MainQuest prec;
    public MainQuest(String n, int l, String loc, String p) {
        super(n, l, RICOMPENSA);
        this.location = loc;
        this.prossima = p;
    }
    @Override
    protected void changeStats(PlayerStats ps) {
        ps.addLevel(1);
        ps.addMoney(ricompensa);
    }

    public void setPrec(MainQuest p){
        this.prec = p;
    }
    public String getLocation(){
        return this.location;
    }
    public String getProssima(){
        return this.prossima;
    }
    public MainQuest getPrec(){
        return this.prec;
    }
}
