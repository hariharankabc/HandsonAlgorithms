import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the activityNotifications function below.
    static int activityNotifications(int[] expenditure, int d) {
        int lengthOfArray = expenditure.length;
        int notificationCount = 0;
        if(d<lengthOfArray){
            int countingSort[] = new int[201];
            for(int j = 0; j < d ; j++){
                int currentValue = countingSort[expenditure[j]];
                countingSort[expenditure[j]] = currentValue + 1;
            }
            for(int i = d; i < lengthOfArray; i++){
                int medianOfArray = getMedian(countingSort, d);
                if( (medianOfArray) <= expenditure[i]){
                    notificationCount += 1;
                }
                countingSort[expenditure[i-d]] = countingSort[expenditure[i-d]] - 1;
                countingSort[expenditure[i]] = countingSort[expenditure[i]] + 1;

            }
        }
        return notificationCount;
    }

    static int getMedian(int[] countingSort, int d){
        if(d%2 == 0){
            int lowerIndex = d/2;
            int upperIndex = (d/2)+1;
            int lowerExp = 0;
            int upperExp = 0;
            boolean lowerFlag = true;
            int currentIndex = 0;
            for(int i=0; i < 201; i++){
                if(countingSort[i] != 0){
                    currentIndex += countingSort[i];
                }
                if(lowerFlag && currentIndex >= lowerIndex){
                    lowerFlag = false;
                    lowerExp = i;
                }
                if(currentIndex >= upperIndex){
                    upperExp = i;
                    break;
                }
            }
            return lowerExp + upperExp;
        }else{
            int index = ((d + 1)/2);
            int currentIndex = 0;
            int exp = 0;
            for(int i=0; i < 201; i++){
                if(countingSort[i] != 0){
                    currentIndex += countingSort[i];
                }
                if(currentIndex >= index){
                    exp = 2 * i;
                    break;
                }
            }
            return exp;
        }

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] expenditure = new int[n];

        String[] expenditureItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int expenditureItem = Integer.parseInt(expenditureItems[i]);
            expenditure[i] = expenditureItem;
        }

        int result = activityNotifications(expenditure, d);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
