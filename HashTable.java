import java.util.ArrayList;
import java.util.List;

public class HashTable<K,V> {
    List<MyLinkedList> myBucketArray;
    int bucketSize;

    public HashTable(int bucketSize) {
        this.bucketSize = bucketSize;
        myBucketArray = new ArrayList<>(bucketSize);
        for (int i = 0; i < 11; i++) {
            myBucketArray.add(i, null);
        }
    }

    public int getIndex(K key) {
        int index = Math.abs(key.hashCode() % bucketSize);
        return index;
    }

    public void add(K key, V value) {
        int indexValue = getIndex(key);
        MyLinkedList<K> myLinkedList1 = myBucketArray.get(indexValue);
        if (myLinkedList1 == null) {
            MyLinkedList<K> myLinkedList = new MyLinkedList<>();
            INode<K> newNode = new MyMapNode<>(key, value);
            myLinkedList.add(newNode);
            myBucketArray.set(indexValue, myLinkedList);
        }
        else {
            MyMapNode<K,V> searchNode = (MyMapNode<K, V>) myLinkedList1.search(key);
            if(searchNode != null){
                searchNode.setValue(value);
            }
            else {
                INode<K> newNode = new MyMapNode<>(key,value);
                myLinkedList1.add(newNode);
            }
        }

    }

    public V findFrequency(K key){
        int indexValue = getIndex(key);
        MyLinkedList<K> myLinkedList1 = myBucketArray.get(indexValue);
        if (myLinkedList1==null){
            return  null;
        }else {
            MyMapNode<K,V> searchNode = (MyMapNode<K, V>) myLinkedList1.search(key);
            if (searchNode==null){
                return null;
            }else {
                return searchNode.getValue();
            }

        }
    }

    @Override
    public String toString() {
        return  ""+ myBucketArray ;

    }
}
