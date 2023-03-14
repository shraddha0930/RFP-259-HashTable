public class MyLinkedList<K> {

    INode<K> head;
    INode<K> tail;

    public MyLinkedList() {
    }

    public void add(INode<K> newNode) {
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            INode<K> tempNode = head;
            head = newNode;
            head.setNext(tempNode);
        }
    }

    INode<K> search(K searchData) {
        INode<K> temp = head;
        while (temp != null) {
            if (temp.getKey().equals(searchData)) {
                return temp;
            }
            temp = temp.getNext();
        }
        return null;
    }

    @Override
    public String toString() {
        return " \n{" + head + "}";
    }

}