import java.util.List;
import java.util.Collections;
import java.util.LinkedList;
public class MergeSort<E extends Comparable<E>> {
    public static void main(String[] args){
        List<Integer> list = new LinkedList<>();
        for(int i = 11;i >= 0;i--){
            list.add(i);
            Collections.shuffle(list);
        }
        System.out.println(list);
        System.out.println(sort(list));

    }
    //0,1,2   ,3,4,5
    public static <E extends Comparable<E>> List<E> sort(List<E> list){
        int size = list.size();
        if(size <= 1){
            return list;
        }
        int mid = size/2;
        List<E> leftlist = sort(subList(list,0,mid));
        List<E> rightlist = sort(subList(list,mid,size));
        return merge(leftlist,rightlist);
    }
    private static <E extends Comparable<E>> List<E> subList(List<E> list, int left, int right){
        List<E> list2 = new LinkedList<>();
        for(int i = left; i < right;i++){
            list2.add(list.get(i));
        }
        return list2;
    }
    private static <E extends Comparable<E>> List<E> merge(List<E> left,List<E> right){
        List<E> toReturn = new LinkedList<>();

        while(!left.isEmpty() && !right.isEmpty()){
            if(left.get(0).compareTo(right.get(0))<= 0){
                toReturn.add(left.remove(0));

            }else{
                toReturn.add(right.remove(0));

            }
        }
        toReturn.addAll(left);
        toReturn.addAll(right);
        return toReturn;
    }
}
