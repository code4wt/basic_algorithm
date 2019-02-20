package com.tianxiaobo.search;

import java.util.*;

/**
 * 红黑树实现，该实现核心逻辑由 TreeMap 源码修改而来
 *
 * @author code4wt
 * @date 2017-12-23 17:26:28
 */
public class RedBlackTree<T extends Comparable<T>> {

    private final static boolean RED = true;

    private final static boolean BLACK = false;

    private TreeNode<T> root;

    public boolean contains(T value) {
        return Objects.nonNull(getNode(value));
    }

    public void putAll(Collection<T> collection) {
        collection.forEach(this::put);
    }

    public void put(T value) {
        if (Objects.isNull(value)) {
            throw new NullPointerException();
        }

        TreeNode<T> t = root;
        if (Objects.isNull(t)) {
            root = new TreeNode<>(null, null, null, value);
            return;
        }

        int cmp;
        TreeNode<T> parent;
        do {
            parent = t;
            cmp = value.compareTo(t.value);
            if (cmp == 0) {
                return;
            } else if (cmp > 0) {
                t = t.right;
            } else {
                t = t.left;
            }
        } while (Objects.nonNull(t));

        TreeNode<T> e = new TreeNode<>(parent, null, null, value);
        if (cmp < 0) {
            parent.left = e;
        } else {
            parent.right = e;
        }
        fixAfterInsertion(e);
    }

    public void remove(T value) {
        TreeNode<T> p = getNode(value);
        if (Objects.nonNull(value)) {
            deleteNode(p);
        }
    }

    public void clear() {
        root = null;
    }

    private TreeNode<T> getNode(T value) {
        if (Objects.isNull(value)) {
            throw new NullPointerException();
        }
        TreeNode<T> p = root;
        while (Objects.nonNull(p)) {
            int cmp = value.compareTo(p.value);
            if (cmp < 0) {
                p = p.left;
            } else if (cmp > 0) {
                p = p.right;
            } else {
                return p;
            }
        }
        return null;
    }

    private void deleteNode(TreeNode<T> p) {
        // 节点 p 有两个孩子节点时，先找到 p 节点的后继节点
        if (p.left != null && p.right != null) {
            TreeNode<T> s = successor(p);
            p.value = s.value;
            p = s;
        }

        TreeNode<T> replacement = (p.left != null ? p.left : p.right);
        if (replacement != null) {
            replacement.parent = p.parent;
            if (p.parent == null) {
                root = replacement;
            } else if (p == p.parent.left) {
                p.parent.left = replacement;
            } else {
                p.parent.right = replacement;
            }

            p.left = p.right = p.parent = null;

            if (p.color == BLACK) {
                fixAfterDeletion(replacement);
            }
        } else if (p.parent == null) {
            root = null;
        } else {    // 待删除的节点没有孩子节点
            // 如果删除的节点是黑色，则需要先进行修复
            if (p.color == BLACK) {
                fixAfterDeletion(p);
            }

            // 将待删除节点从树中删除
            if (p.parent != null) {
                if (p == p.parent.left) {
                    p.parent.left = null;
                } else if (p == p.parent.right) {
                    p.parent.right = null;
                }
                p.parent = null;
            }
        }
    }

    private TreeNode<T> successor(TreeNode<T> t) {
        if (Objects.isNull(t)) {
            return null;
        }

        if (t.right != null) {
            TreeNode<T> p = t.right;
            while (p.left != null) {
                p = p.left;
            }
            return p;
        } else {
            TreeNode<T> p = t.parent;
            TreeNode<T> ch = t;
            while (p != null && ch == p.right) {
                ch = p;
                p = p.parent;
            }
            return p;
        }
    }

    private void rotateLeft(TreeNode<T> p) {
        if (Objects.nonNull(p)) {
            TreeNode<T> r = p.right;
            p.right = r.left;
            if (r.left != null) {
                r.left.parent = p;
            }
            r.parent = p.parent;
            if (p.parent == null) {
                root = r;
            } else if (p.parent.left == p) {
                p.parent.left = r;
            } else {
                p.parent.right = r;
            }
            r.left = p;
            p.parent = r;
        }
    }

    /** From CLR */
    private void rotateRight(TreeNode<T> p) {
        if (Objects.nonNull(p)) {
            TreeNode<T> l = p.left;
            p.left = l.right;
            if (l.right != null) {
                l.right.parent = p;
            }
            l.parent = p.parent;
            if (p.parent == null) {
                root = l;
            } else if (p.parent.right == p) {
                p.parent.right = l;
            } else {
                p.parent.left = l;
            }
            l.right = p;
            p.parent = l;
        }
    }

    /** From CLR */
    private void fixAfterInsertion(TreeNode<T> x) {
        x.color = RED;

        while (x != null && x != root && x.parent.color == RED) {
            if (parentOf(x) == leftOf(parentOf(parentOf(x)))) {
                TreeNode<T> y = rightOf(parentOf(parentOf(x)));
                if (colorOf(y) == RED) {
                    setColor(parentOf(x), BLACK);
                    setColor(y, BLACK);
                    setColor(parentOf(parentOf(x)), RED);
                    x = parentOf(parentOf(x));
                } else {
                    if (x == rightOf(parentOf(x))) {
                        x = parentOf(x);
                        rotateLeft(x);
                    }
                    setColor(parentOf(x), BLACK);
                    setColor(parentOf(parentOf(x)), RED);
                    rotateRight(parentOf(parentOf(x)));
                }
            } else {
                TreeNode<T> y = leftOf(parentOf(parentOf(x)));
                if (colorOf(y) == RED) {
                    setColor(parentOf(x), BLACK);
                    setColor(y, BLACK);
                    setColor(parentOf(parentOf(x)), RED);
                    x = parentOf(parentOf(x));
                } else {
                    if (x == leftOf(parentOf(x))) {
                        x = parentOf(x);
                        rotateRight(x);
                    }
                    setColor(parentOf(x), BLACK);
                    setColor(parentOf(parentOf(x)), RED);
                    rotateLeft(parentOf(parentOf(x)));
                }
            }
        }
        root.color = BLACK;
    }

    private void fixAfterDeletion(TreeNode<T> x) {
        while (x != root && colorOf(x) == BLACK) {
            if (x == leftOf(parentOf(x))) {
                TreeNode<T> sib = rightOf(parentOf(x));

                if (colorOf(sib) == RED) {
                    setColor(sib, BLACK);
                    setColor(parentOf(x), RED);
                    rotateLeft(parentOf(x));
                    sib = rightOf(parentOf(x));
                }

                if (colorOf(leftOf(sib))  == BLACK &&
                        colorOf(rightOf(sib)) == BLACK) {
                    setColor(sib, RED);
                    x = parentOf(x);
                } else {
                    if (colorOf(rightOf(sib)) == BLACK) {
                        setColor(leftOf(sib), BLACK);
                        setColor(sib, RED);
                        rotateRight(sib);
                        sib = rightOf(parentOf(x));
                    }
                    setColor(sib, colorOf(parentOf(x)));
                    setColor(parentOf(x), BLACK);
                    setColor(rightOf(sib), BLACK);
                    rotateLeft(parentOf(x));
                    x = root;
                }
            } else { // symmetric
                TreeNode<T> sib = leftOf(parentOf(x));

                if (colorOf(sib) == RED) {
                    setColor(sib, BLACK);
                    setColor(parentOf(x), RED);
                    rotateRight(parentOf(x));
                    sib = leftOf(parentOf(x));
                }

                if (colorOf(rightOf(sib)) == BLACK &&
                        colorOf(leftOf(sib)) == BLACK) {
                    setColor(sib, RED);
                    x = parentOf(x);
                } else {
                    if (colorOf(leftOf(sib)) == BLACK) {
                        setColor(rightOf(sib), BLACK);
                        setColor(sib, RED);
                        rotateLeft(sib);
                        sib = leftOf(parentOf(x));
                    }
                    setColor(sib, colorOf(parentOf(x)));
                    setColor(parentOf(x), BLACK);
                    setColor(leftOf(sib), BLACK);
                    rotateRight(parentOf(x));
                    x = root;
                }
            }
        }

        setColor(x, BLACK);
    }

    private boolean colorOf(TreeNode<T> p) {
        return (p == null ? BLACK : p.color);
    }

    private TreeNode<T> parentOf(TreeNode<T> p) {
        return (p == null ? null: p.parent);
    }

    private void setColor(TreeNode<T> p, boolean c) {
        if (p != null) {
            p.color = c;
        }
    }

    private TreeNode<T> leftOf(TreeNode<T> p) {
        return (p == null) ? null: p.left;
    }

    private TreeNode<T> rightOf(TreeNode<T> p) {
        return (p == null) ? null: p.right;
    }

    private class TreeNode<T> {

        TreeNode<T> parent;

        TreeNode<T> left;

        TreeNode<T> right;

        T value;

        boolean color;

        public TreeNode(TreeNode<T> parent, TreeNode<T> left, TreeNode<T> right, T value) {
            this.parent = parent;
            this.left = left;
            this.right = right;
            this.value = value;
            this.color = RED;
        }

        @Override
        public String toString() {
            return value + "," + (color == RED ? "r" : "b");
        }
    }
}
