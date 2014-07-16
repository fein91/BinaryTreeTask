package btreetask;

import java.util.Random;

/**
 *
 * @author otatarik
 */
public class BTreeFufiller {

    private static int count = 3;
    private static IBTree rootNode = new BTree(null, null, new Integer(5000));

    public static void fill() {
        while (count > 0) {
            Thread t = new Thread() {
                @Override
                public void run() {
                    Random rand = new Random();
                    rootNode.addNode(rand.nextInt(10000));
                    decrement();
                }
                
                public void decrement(){
                    synchronized() {
                   count--;
                    }
                }
            };
            t.start();
        }
        rootNode.printChilds();
    }
}
