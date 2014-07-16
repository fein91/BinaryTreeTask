/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package btreetask;

import java.util.Random;

/**
 *
 * @author otatarik
 */
public class BTreeFufiller {

    private static int count = 5000;
    private static IBTree rootNode = new BTree(null, null, new Integer(10000));

    public static void fill() {
        while (count != 0) {
            Thread t = new Thread() {
                @Override
                public void run() {
                    Random rand = new Random();
                    rootNode.addNode(rand.nextInt(10000));
                    count--;
                }
            };
            t.start();
        }
    }

}
