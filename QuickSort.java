import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
public class QuickSort {
    public static void main(String[] args){
        List<Integer> list = new LinkedList<>();
        for(int i = 11;i >= 0;i--){
            list.add(i);
            Collections.shuffle(list);
        }
        System.out.println(list);
        sort(list);
        System.out.println(list);
    }
    public static <E extends Comparable<E>> void sort(List<E> list){
        quicksort(list,0,list.size());
    }
    public static <E extends Comparable<E>> void quicksort(List<E> list,int left, int right){// from 0 inclusive to size exclusive!
        if(right - left <= 1){ //finished if it only has 0 or 1 element or util it left 1 ot 0 element(recursion part).
            return;
        }
        int pivotIndex = partition(list,left,right-1);//right here is the size! should -1!
        quicksort(list, left, pivotIndex);//exclusive
        quicksort(list, pivotIndex + 1, right);
    }
    public static <E extends Comparable<E>> int partition(List<E> list,int left, int right){
        E pivot = list.get(right);//don't touch the pivot's position after the process finished!
        int p = left - 1;//any element before(inclusive) is smaller than or equal to the pivot.
        for(int i = left; i < right;i++){
            if(list.get(i).compareTo(pivot) <= 0){
                p++;//move the p to the (non-smaller or =) element and swap it with the (smaller or =) one.
                swap(list,i,p);
            }
        }
        swap(list,p+1,right);//finally swap the nearest (non-smaller or =) element with the pivot.
        return p+1;//return the pivot position.
    }
    public static <E> void swap(List<E> list, int a, int b){
        E e = list.get(b);
        list.set(b,list.get(a));
        list.set(a,e);
    }
}
