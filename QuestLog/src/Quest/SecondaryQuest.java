package Quest;

import Utility.PlayerStats;

public class SecondaryQuest extends AbsQuest{
    private final String npcName;
    public SecondaryQuest(String n, int l, int r, String npc) {
        super(n, l, r);
        this.npcName = npc;
    }
    @Override
    protected void changeStats(PlayerStats ps) {
        ps.addLevel(2);
        ps.addMoney(ricompensa);
    }

    public String getNpcName() {
        return npcName;
    }
}
