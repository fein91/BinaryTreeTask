package btreetask;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author otatarik
 */
public class BTreeFufiller {

    private static final int COUNT = 5;
    private static volatile IBTree rootNode = new BTree(null, null, new Integer(5000));

    public void fill() {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        CompletionService completion = new ExecutorCompletionService(executor);
        //List<Thread> threads = new ArrayList<Thread>();

        for (int i = 0; i < COUNT; i++) {

            Thread t = new Thread() {
                @Override
                public void run() {
                    Random rand = new Random();
                    rootNode.addNode(rand.nextInt(10000));
                }
            };
            completion.submit(t, null);
        }

        for (int i = 0; i < COUNT; i++) {
            try {
                completion.take();
            } catch (InterruptedException ex) {
                Logger.getLogger(BTreeFufiller.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        executor.shutdown();
        
        rootNode.printChilds();
    }
}
