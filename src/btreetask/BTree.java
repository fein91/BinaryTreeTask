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
public class BTree<T extends Comparable<T>> implements IBTree<T> {

    private IBTree<T> left;
    private IBTree<T> right;
    private T value;

    public BTree(IBTree<T> left, IBTree<T> right, T value) {
        this.left = left;
        this.right = right;
        this.value = value;
    }

    @Override
    public IBTree<T> getLeft() {
        return left;
    }

    @Override
    public IBTree<T> getRight() {
        return right;
    }

    @Override
    public T getValue() {
        return value;
    }

    @Override
    public void setRight(IBTree<T> right) {
        if (this.right == null) {
            this.right = right;
        } else {
            this.right.addNode(right);
        }
    }

    @Override
    public void setLeft(IBTree<T> left) {
        if (this.left == null) {
            this.left = left;
        } else {
            this.left.addNode(left);
        }
    }

    @Override
    public void setValue(T value) {
        this.value = value;
    }

    @Override
    public void addNode(IBTree<T> node) {
        if (node.getValue().compareTo(getValue()) < 0) {
            setLeft(node);
        } else {
            setRight(node);
        }
    }

    public void addNode(T value) {
        IBTree<T> node = new BTree<T>(null, null, value);
        addNode(node);
    }

    @Override
    public void printChilds() {
        System.out.println(this.left.getValue());
        System.out.println(this.right.getValue());
    }
    
    
}
