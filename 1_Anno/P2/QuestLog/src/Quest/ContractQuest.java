package Quest;

import Utility.PlayerStats;

public class ContractQuest extends AbsQuest{
    private final String[] monster;
    public ContractQuest(String n, int l, int r, String[] m) {
        super(n, l, r);
        this.monster = m;
    }
    @Override
    protected void changeStats(PlayerStats ps) {
        ps.addLevel(1);
        ps.addMoney((int)(ricompensa * 1.2));
    }

    public String getMonster(){
        String res = "[";
        for(int i=0; i<monster.length; i++){
            res += monster[i];
            if(i != monster.length-1){
                res += ", ";
            }
        }
        return res + "]";
    }
}
