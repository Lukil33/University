package Quest;

import Exceptions.AlreadyCompleted;
import Utility.PlayerStats;

public abstract class AbsQuest{
    private final String name;
    private final int levelReq;
    protected final int ricompensa;
    private boolean completed;
    AbsQuest(String n, int l, int r){
        this.name = n;
        this.levelReq = l;
        this.ricompensa = r;
        this.completed = false;
    }
    public void setAsCompleted(PlayerStats ps){
        this.completed = true;
        changeStats(ps);
    }
    protected abstract void changeStats(PlayerStats ps);

    public String getName() {
        return this.name;
    }
    public int getLevelReq() {
        return this.levelReq;
    }
    public int getRicompensa() {
        return this.ricompensa;
    }
    public boolean isCompleted(){
        return this.completed;
    }
}
