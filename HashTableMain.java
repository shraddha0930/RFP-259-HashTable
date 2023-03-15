public class HashTableMain {


    public static void main(String[] args) {
        HashTable<String, Integer> hashTable = new HashTable<>(10);
        String paragraph = "Paranoids are not paranoid because they are paranoid but because they keep putting themselves deliberately into paranoid avoidable situations";        String[] array = paragraph.split(" ");
        for (String str:array) {
            Integer frequencyValue = hashTable.findFrequency(str);
            if (frequencyValue==null){
                frequencyValue=1;
            }else {
                frequencyValue+=1;
            }
            hashTable.add(str,frequencyValue);
        }
        System.out.println(hashTable);

    }
}