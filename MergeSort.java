import java.util.List;
import java.util.Collections;
import java.util.LinkedList;
public class MergeSort {
    public static void main(String[] args){
        List<Integer> list = new LinkedList<>();
        for(int i = 11;i >= 0;i--){
            list.add(i);
            Collections.shuffle(list);
        }
        System.out.println(list);
        System.out.println(sort(list));

    }
    public static <E extends Comparable<E>> List<E> sort(List<E> list){
        int size = list.size();
        if(size <= 1){//finished util it has one or zero element left or initially only has that amount of element.
            return list;
        }
        int mid = size/2;//the mid point,since the menthod is exclusive for the second half.
        List<E> leftlist = sort(subList(list,0,mid));// each time it passes a new halfed list so the left is 0 is reasonalble, and the size and mid will be updated.
        List<E> rightlist = sort(subList(list,mid,size));//size is exclusive!
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
                toReturn.add(left.remove(0));//remember we removed the correct element so next time we get(0) for the next one!

            }else{
                toReturn.add(right.remove(0));

            }
        }
        toReturn.addAll(left);//since we removed the used element, we can just add the leftover!
        toReturn.addAll(right);
        return toReturn;
    }
}
