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
    public static <E extends Comparable<E>> void quicksort(List<E> list,int left, int right){
        if(right - left <= 1){
            return;
        }
        int pivotIndex = partition(list,left,right-1);//right here is the size! should -1!
        quicksort(list, left, pivotIndex);
        quicksort(list, pivotIndex + 1, right);
    }
    // 12,13,4,7,1,2,6,5
    public static <E extends Comparable<E>> int partition(List<E> list,int left, int right){
        E pivot = list.get(right);
        int p = left - 1;
        for(int i = left; i < right;i++){
            if(list.get(i).compareTo(pivot) <= 0){
                p++;
                swap(list,i,p);
            }
        }
        swap(list,p+1,right);
        return p+1;
    }
    public static <E> void swap(List<E> list, int a, int b){
        E e = list.get(b);
        list.set(b,list.get(a));
        list.set(a,e);
    }
}
