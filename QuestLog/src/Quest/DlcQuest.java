package Quest;

import Utility.PlayerStats;
import com.sun.tools.javac.Main;

public class DlcQuest extends MainQuest{
    private final String dependency;
    public DlcQuest(String n, int l, String loc, String p, String d) {
        super(n, l, loc, p);
        this.dependency = d;
    }

    public void setCheck(MainQuest q){
        this.setPrec(q);
    }
    public String getDependency(){
        return this.dependency;
    }
}
