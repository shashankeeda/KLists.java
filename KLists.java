//Shashank Eeda
import java.util.Arrays;

public class KLists {
    /*
    The class mergeKLists take a double array of inner sorted arrays, puts them all into a single dimensional
    array of sorted values.
     */
    public double[] mergeKLists (double [][] outerArray){
        /*
        The if statements check if the outerArray is empty, if so it will return an empty array
         */
        double[] mh={};
        if(outerArray.length<=0)
            return mh;
        if(outerArray[0].length<=0)
            return mh;
        else {
            int x = 0;//number of items in the two dimensional array
            int y = 0;//keep track of how many items in the array
            int m = 0;//index of lowest value stores
            double low = outerArray[0][0];
            double t = low;
            for (int i = 0; i < outerArray.length; i++) {
                for (int j = 0; j < outerArray[i].length; j++) {
                    if (outerArray[i][j] > t)
                        t = outerArray[i][j];
                }
            }
            /*
            The double forlloop will give t the largest value in the two dimensional array, this is used
            so that it makes it easier to find the lowest value in the code below which will be
            explained below.
             */
            int[] index = new int[outerArray.length];
            for (int i = 0; i < outerArray.length; i++)
                index[i] = 0;
            //This array will be used to keep track of which indexes were used and which weren't
            for (int i = 0; i < outerArray.length; i++) {
                x += outerArray[i].length;
            }
            //x will recieve the value of how many items are in the array
            double[] arr = new double[x];
            /*
            The while loop will have an inner forloop that will keep on finding the lowest value and
            keep on adding it to the array arr which will eventually be returned.
             */
            while (y < x) {
                for (int i = 0; i < outerArray.length; i++) {
                    if (index[i] < outerArray[i].length && low > outerArray[i][index[i]]) {
                        low = outerArray[i][index[i]];
                        m = i;
                    }
                }
                arr[y] = low;
                index[m]++;
                low = t;
                y++;
            }
            return arr;
        }
    }
    public static void main(String[] args){
        /*
        The tester is the array that will be sent to the mergeKLists, it can be modified as you please,
        a KLists object is created to run the mergeKLists method and then it gets printed out by
        Arrays.toString().
         */
        double[][] tester={{9.7, 17.1}, {15.8}, {12.7, 18.5, 21.27}};
        KLists test=new KLists();
        double[] arr2=test.mergeKLists(tester);
        System.out.println(Arrays.toString(arr2));
    }
}
