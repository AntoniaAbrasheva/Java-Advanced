package generics.customList;

import java.util.List;

public class Sorter {
    public static<T extends Comparable> void sort(CustomList<T> list){
        List<T> sortedCollection = list.getCollection();
        sortedCollection.sort(Comparable::compareTo);
        list.setCollection(sortedCollection);
    }
}
