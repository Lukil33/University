package InterfacciaUtente.Comparator;

import Blocchi.Interfacce.Block;
import java.util.Comparator;

public class BlockComparator implements Comparator<Block> {
    public int compare(Block b1, Block b2) {
        return Integer.compare(b1.getNum(),b2.getNum());
    }
}