package btreetask;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author otatarik
 */
public class BTreeFufiller {

    private static final int COUNT = 3;
    private static IBTree rootNode = new BTree(null, null, new Integer(5000), BTree.BTreeType.ROOT);

    public void fill() {
        List<Thread> threads = new ArrayList<Thread>();

        for (int i = 0; i < COUNT; i++) {
            Thread t = new Thread() {
                @Override
                public void run() {
                    Random rand = new Random();
                    rootNode.addNode(rand.nextInt(10000));
                }
            };
            threads.add(t);
        }

        for (Thread t : threads) {
            t.start();
        }
        
        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException ex) {
                Logger.getLogger(BTreeFufiller.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        rootNode.printChilds();
    }
}
