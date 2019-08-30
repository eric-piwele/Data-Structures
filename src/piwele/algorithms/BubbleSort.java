package piwele.algorithms;

public class BubbleSort {
    public static void main(String args[]) {
        Integer[] arr = new Integer[]{1,3,4,11,9,0,23, 2};
        Integer[] arr2 = new Integer[]{52,5,4,11,9,0,23, 17};

        //bubble sort
        /*System.out.println("-- arr1");
        bubbleSort(arr);
        printArray(arr);
        System.out.println("-- arr2");
        bubbleSort(arr2);
        printArray(arr2);*/

        bubble(arr2, 7);
        printArray(arr2);

   }

    public static void swap(Integer[] arr, int i, int j){
        Integer tmp = arr[i];
        arr[i]=arr[j];
        arr[j] = tmp;
    }

    public static void bubbleSort(Integer[] arr){
        for(int i=0; i < arr.length; i++){
            Integer pivot = arr[i];
            for(int j=0; j < arr.length; j++){
                Integer el = arr[j];
                if(el > pivot){
                    swap(arr,i,j);
                    pivot = el;
                }
            }
        }
    }

    public static void bubble(Integer[] arr, int index){
        Integer pivot = arr[0];
        for(int i=0; i < arr.length ; i++){
            Integer el = arr[i];
            System.out.print(" i= "+i+" pivot= "+pivot+" el= "+el);
            if(el < pivot && i <= index){
                swap(arr, i, i-1);
                System.out.print(" arr[pivot]= "+arr[1]);
            }else{
                pivot = el;
            }
        }
        System.out.println("> index= "+index);
        index --;
        if(index > 0)
            bubble(arr,index);
    }

    public static void printArray(Integer[] arr){
        System.out.println();
        for(Integer el : arr){
            System.out.print(el+" ");
        }
        System.out.println();
    }
}
}
