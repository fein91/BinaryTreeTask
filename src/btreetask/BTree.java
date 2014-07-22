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
    private IBTree<T> parent;
    private final T value;
    private BTreeType type;

    public BTree(IBTree<T> left, IBTree<T> right, T value) {
        this.left = left;
        this.right = right;
        this.value = value;
    }

    public void setType(BTreeType type) {
        this.type = type;
    }

    public IBTree<T> getParent() {
        if (parent == null)
            return new BTree<T>(null,null,null);
        return parent;
    }

    public void setParent(IBTree<T> parent) {
        this.parent = parent;
    }
       
    public BTreeType getType() {
        return type;
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
            right.setType(BTreeType.RIGHT);
            right.setParent(this);
            this.right = right;
        } else {
            this.right.addNode(right);
        }
    }

    @Override
    public void setLeft(IBTree<T> left) {
        if (this.left == null) {
            left.setParent(this);
            left.setType(BTreeType.LEFT);
            this.left = left;
        } else {
            this.left.addNode(left);
        }
    }

    @Override
    public void addNode(IBTree<T> node) {
        if (node.getValue().compareTo(getValue()) < 0) {
            setLeft(node);
        } else {
            setRight(node);
        }
    }

    public synchronized void addNode(T value) {
        // addNode(node);
        if (value.compareTo(getValue()) < 0) {
            IBTree<T> node = new BTree<T>(null, null, value);
            setLeft(node);
        } else {
            IBTree<T> node = new BTree<T>(null, null, value);
            setRight(node);
        }
    }

    @Override
    public void printChilds() {
        System.out.println(getValue()+" "+getType()+" ("+getParent().getValue()+")");
        if (getLeft() != null) {
            getLeft().printChilds();
        }

        if (getRight() != null) {
            getRight().printChilds();
        }
    }

    // 10
    // 5 11
    // 4 6 7 12
    // 12
    //   <tab>   5 left   
    //   <tab><tab>       4 left left
    //   <tab><tab>       6 left right
    //   <tab>   11 right
    //   <tab><tab>       7 right left
    //   <tab><tab>       13 right right
    //   <tab><tab><tab>        15 right right right
}
