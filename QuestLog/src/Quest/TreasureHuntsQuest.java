package Quest;

public class TreasureHuntsQuest extends ContractQuest{
    private final String place;
    public TreasureHuntsQuest(String n, int l, int r, String[] m, String p) {
        super(n, l, r, m);
        this.place = p;
    }

    public String getPlace() {
        return place;
    }
}
