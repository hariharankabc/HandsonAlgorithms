import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the countingSort function below.
    static int[] countingSort(int[] arr) {
        int[] sortArr = new int[100];
        for(int i=0 ; i<arr.length; i++){
            int index = arr[i];
            int curValue = sortArr[index];
            if(0 != curValue){
                curValue = curValue + 1;
                sortArr[index] = curValue;
            }else{
                sortArr[index] = 1;
            }
        }
        int count = 0;
        for(int i=0; i<sortArr.length; i++){
            int lengthArr = sortArr[i];
            if(lengthArr != 0){
                for(int j=0; j<lengthArr; j++){
                    arr[count]=i;
                    count += 1;
                }
            }
        }
        return arr;

    }
    
}
