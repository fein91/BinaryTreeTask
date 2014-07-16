/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package btreetask;

/**
 *
 * @author otatarik
 */
public interface IBTree<T extends Comparable<T>> {
    
    public IBTree<T> getLeft();

    public void setLeft(IBTree<T> left);

    public IBTree<T> getRight();

    public void setRight(IBTree<T> right);

    public T getValue();

    public void setValue(T value);
    
    public void addNode(IBTree<T> node);
    
    public void addNode(T value);
    
    public void printChilds();
    
}
