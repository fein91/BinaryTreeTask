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

    public enum BTreeType {

        LEFT, RIGHT, ROOT
    }

    public IBTree<T> getLeft();

    public void setLeft(IBTree<T> left);
    
    public IBTree<T> getParent();
    
    public void setParent(IBTree<T> parent);

    public IBTree<T> getRight();

    public void setRight(IBTree<T> right);

    public T getValue();

    public BTreeType getType();

    public void setType(BTreeType type);

    public void addNode(IBTree<T> node);

    public void addNode(T value);

    public void printChilds();

}
