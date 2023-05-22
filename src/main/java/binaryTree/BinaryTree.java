package binaryTree;

public class BinaryTree {
    private int size;

    private Node head;

    public BinaryTree() {
        this.size = 0;
        this.head = null;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    public void insert(int data) {
        Node newNode = new Node(data);
        Node current = head;
        if (isEmpty()) {
            head = newNode;
            size++;
        } else {
            while (true) {
                if (data < current.data) {
                    if (current.left == null) {
                        current.left = newNode;
                        newNode.top = current;
                        size++;
                        break;
                    } else {
                        current = current.left;
                    }
                } else {
                    if (current.right == null) {
                        current.right = newNode;
                        newNode.top = current;
                        size++;
                        break;
                    } else {
                        current = current.right;
                    }
                }
            }
        }
    }

    public Node find(int data) {
        Node current = head;
        if (data == head.data) {
            return head;
        } else {
            while (current != null) {
                if (data < current.data) {
                    current = current.left;
                } else {
                    if (data == current.data) {
                        return current;
                    }
                    current = current.right;
                }
            }
        }
        return null;
    }

    public void delete(int data) {
        if (find(data) != null) {
            Node nodeToDelete = find(data);
            Node parrentNode = nodeToDelete.top;
            if (nodeToDelete.left == null && nodeToDelete.right == null) {
                if (parrentNode != null) {
                    if (parrentNode.left == nodeToDelete) {
                        parrentNode.left = null;
                        size--;
                    } else {
                        parrentNode.right = null;
                        size--;
                    }
                } else {
                    head = null;
                    size--;
                }
            } else if (nodeToDelete.left == null) {
                if (parrentNode != null) {
                    if (parrentNode.left == nodeToDelete) {
                        parrentNode.left = nodeToDelete.right;
                        nodeToDelete.right.top = parrentNode;
                        size--;
                    } else {
                        parrentNode.right = nodeToDelete.right;
                        nodeToDelete.right.top = parrentNode;
                        size--;
                    }
                } else {
                    head = nodeToDelete.right;
                    head.top = null;
                    size--;
                }
            } else if (nodeToDelete.right == null) {
                if (parrentNode != null) {
                    if (parrentNode.left == nodeToDelete) {
                        parrentNode.left = nodeToDelete.left;
                        nodeToDelete.left.top = parrentNode;
                        size--;
                    } else {
                        parrentNode.right = nodeToDelete.left;
                        nodeToDelete.left.top = parrentNode;
                        size--;
                    }
                } else {
                    head = nodeToDelete.left;
                    head.top = null;
                    size--;
                }
            } else {
                Node current = nodeToDelete.left;
                if (parrentNode != null) {
                    if (current.right == null) {
                        if (parrentNode.left == nodeToDelete) {
                            parrentNode.left = current;
                            current.top = parrentNode;
                            current.right = nodeToDelete.right;
                            size--;
                        } else {
                            parrentNode.right = current;
                            current.top = parrentNode;
                            current.right = nodeToDelete.right;
                            size--;
                        }
                    } else {
                        while (current.right != null) {
                            current = current.right;
                        }
                        if (parrentNode.left == nodeToDelete) {
                            parrentNode.left = current;
                            current.top = parrentNode;
                            current.left = nodeToDelete.left;
                            current.right = nodeToDelete.right;
                            size--;
                        } else {
                            parrentNode.right = current;
                            current.top = parrentNode;
                            current.left = nodeToDelete.left;
                            current.right = nodeToDelete.right;
                            size--;
                        }
                    }
                } else {
                    if (current.right == null) {
                        head = current;
                        head.top = null;
                        head.right = nodeToDelete.right;
                        nodeToDelete.right.top = head;
                        size--;
                    } else {
                        while (current.right != null) {
                            current = current.right;
                        }
                        head = current;
                        current.top = null;
                        head.left = nodeToDelete.left;
                        head.right = nodeToDelete.right;
                        size--;
                    }
                }
            }
        }
    }

    public void display() {

    }

}